package com.jambhala;

import java.util.HashMap;
import java.util.Map;

public class EventManager {

	private static EventManager em = new EventManager();

	public EventManager() {
		
	}
	
	public static EventManager getInstance(){
        return em;
    }
	
	//eventList集合主要用来放所有的事件，为了防止重复所以使用map集合
    private Map<String, MyServerMain> eventList = new HashMap<String, MyServerMain>();

    public Map<String, MyServerMain> getEventList() {
        return eventList;
    }
    
    /**
     * 创建订阅
     */
    public void createEvent(long sleepTime, String eventName, Map<String, String> map){
        System.out.println("开启订阅:" + eventName);
        MyServerMain sm = new MyServerMain(sleepTime, eventName, map);
        eventList.put(eventName, sm);
        sm.activate();
    }
    
    /**
     * 停止订阅
     */
    public void removeEvent(String eventName){
        if(eventList.containsKey(eventName)){
            System.out.println("停用：" + eventName);
            MyServerMain sm = new MyServerMain();
            sm.stop();
            eventList.remove(eventName);
        }
    }
}
