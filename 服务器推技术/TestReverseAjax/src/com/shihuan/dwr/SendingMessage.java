package com.shihuan.dwr;

import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkLoopException;  

import org.directwebremoting.Browser;  
import org.directwebremoting.ScriptSession;  
import org.directwebremoting.ScriptSessions;

public class SendingMessage {

	private List<String> messages = new LinkedList<String>();
	
	public void addMessage(String message){
		messages.add(message);
		System.out.println("有客户请求消息: " + message);
		Browser.withCurrentPage(new Runnable(){

			public void run() {
				ScriptSessions.addFunctionCall("receiveMessage", messages);
			}
			
		});
	}
}