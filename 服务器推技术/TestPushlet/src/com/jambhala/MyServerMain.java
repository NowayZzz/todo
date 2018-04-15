package com.jambhala;

import java.util.Map;
import java.util.HashMap;

import com.vo.Dial;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventSource;
import nl.justobjects.pushlet.util.Log;

public class MyServerMain implements EventSource, Runnable {

	private volatile boolean alive = false;

    private volatile boolean active = false;

    private static int threadNum = 0;

    private Thread thread;

    private long sleepTime = 0;

    private String eventName;

    private Map<String, String> map = new HashMap<String, String>();    //同一个id的事件只能在集合中出现一次

	
	public MyServerMain() {
		
	}
	
	public MyServerMain(long sleepTime, String eventName, Map<String, String> map) {
		this.sleepTime = sleepTime;
        this.eventName = eventName;
        this.map = map;
    }
	
	public Event pullEvent(){
        Dial dial = new Dial();
        dial.setDid("123");
        dial.setData("10000");
        dial.setDname("dial");
        Event event = Event.createDataEvent(eventName);
        event.setField("did", dial.getDid());
        //event.setField("data", dial.getData());
        //event.setField("dname", dial.getDname());
        return event;
    }
	
	public void start() {
		thread = new Thread(this, "EventPullSource-" + (++threadNum));
        thread.setDaemon(true);
        thread.start();
	}
	
	public boolean isAlive() {
        return alive;
    }
	
	/**
     * Activate the event generator thread.------->激活事件构造器线程。
     */
	public void activate() {
		if (active) {
            return;
        }
        active = true;
        if (!alive) {
            start();
            return;
        }
        Log.debug(getClass().getName() + ": notifying...");
        notifyAll();
	}

	/**
     * Deactivate the event generator thread.--------->停用事件构造其线程。
     */
	public void passivate() {
		if (!active) {
            return;
        }
        active = false;
	}

	/**
     * Stop the event generator thread.----->停止事件构造器线程
     */
	public void stop() {
		alive = false;
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
	}

	/**
     * Main loop: sleep, generate event and publish.----->主循环：设置睡眠，事件构造器和进行发布
     */
	public void run() {
		Log.debug(getClass().getName() + ": starting...");
        alive = true;
        while (alive) {
            try {
                Thread.sleep(sleepTime);
                // Stopped during sleep: end loop.睡眠时间停止：结束循环。
                if (!alive) {
                    break;
                }
                // If passivated wait until we get
                // get notify()-ied. If there are no subscribers
                // it wasts CPU to remain producing events...
                /*直到我们得到通知才能不在等待，如果没有用户订阅我们要消耗cpu来维持活动*/
                synchronized (this) {
                    while (!active) {
                        Log.debug(getClass().getName() + ": waiting...");
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
            try {
                // Derived class should produce an event.
                //实现类产生一个事件。
                Event event = pullEvent();
                // Let the publisher push it to subscribers.
                //将订阅信息推到用户那里
                Dispatcher.getInstance().multicast(event);
            } catch (Throwable t) {
                Log.warn("EventPullSource exception while multicasting ", t);
                t.printStackTrace();
            }
        }
        Log.debug(getClass().getName() + ": stopped");
	}

}
