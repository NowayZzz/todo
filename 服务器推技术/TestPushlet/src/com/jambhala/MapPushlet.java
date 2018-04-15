package com.jambhala;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class MapPushlet implements Serializable {
	public void putMap(){
		
	}
	
	static public class MapCollectionPushlet extends EventPullSource {
		
		static Map map = new HashMap();
		
		protected long getSleepTime() {
			return 1000;
		}

		protected Event pullEvent() {
			Event event = Event.createDataEvent("/Jambhala/MapYu");
			event.setField("jMap", map.toString());
			return event;
		}
		
	}
}
