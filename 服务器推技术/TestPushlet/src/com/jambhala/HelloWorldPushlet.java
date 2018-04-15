package com.jambhala;

import java.io.Serializable;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class HelloWorldPushlet implements Serializable {
	static public class HwPushlet extends EventPullSource{
		//设置休眠时间
		protected long getSleepTime() {
			return 1000;
		}
		//业务方法，这个方法会被定时调用
		protected Event pullEvent() {
			Event event = Event.createDataEvent("/Jambhala/YuShiBo");
			event.setField("shihuan", "Hello World!");
			return event;
		}
		
	}
}
