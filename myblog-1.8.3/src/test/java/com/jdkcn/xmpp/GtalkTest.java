/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		GtalkTest.java
 * Class:			GtalkTest
 * Date:			Aug 29, 2007 11:30:21 AM
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Aug 29, 2007   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.xmpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Aug 29, 2007 11:30:21 AM
 * @version $Id GtalkTest.java$
 */
public class GtalkTest {
	
	private List<RosterEntry> entries = new ArrayList<RosterEntry>();
	
	public List<RosterEntry> getEntries() {
		return entries;
	}
	
    public static class MessageParrot implements MessageListener {
        
    	private List<RosterEntry> entries;
    	
    	private XMPPConnection connection;
    	
    	public MessageParrot(List<RosterEntry> entries){
    		this.entries = entries;
    	}
    	
    	public void setConnection(XMPPConnection connection){
    		this.connection = connection;
    	}
        // gtalk seems to refuse non-chat messages
        // messages without bodies seem to be caused by things like typing
        public void processMessage(Chat chat, Message message) {
        	System.out.println("chat with:" + chat.getParticipant());
        	System.out.println("ThreadID:" + chat.getThreadID());
        	String msgBody = message.getBody();
            if(message.getType().equals(Message.Type.chat) && StringUtils.isNotBlank(msgBody)) {
                System.out.println("Received: [" + chat.getParticipant() + "]" + msgBody);
                try {
                	for (RosterEntry entry:entries) {
                		if (!entry.getUser().equalsIgnoreCase(chat.getParticipant())) {
                			Message msg = new Message(entry.getUser(), Message.Type.chat);
                			msg.setBody(chat.getParticipant() + " said:" + msgBody);
                			//chat.sendMessage(msg);
                			connection.getChatManager().createChat(entry.getUser(), new MessageListener(){
								public void processMessage(Chat chat,
										Message msg) {
									// do something..?
								}}).sendMessage(msg);
                		}
                	}
                } catch (XMPPException ex) {
                    //ex.printStackTrace();
                    System.out.println("Failed to send message");
                }
            } else {
                System.out.println("I got a message I didn''t understand");
            }
        }
    }
    
    public static void main( String[] args ) {
        
//    	Integer.parseInt("2543453245546");
    	System.out.println(Integer.MAX_VALUE);
        System.out.println("Starting IM client");
        GtalkTest gtalkTest = new GtalkTest();
        // gtalk requires this or your messages bounce back as errors
        ConnectionConfiguration connConfig = new ConnectionConfiguration("gmail.com", 5222, "gmail.com");
        XMPPConnection connection = new XMPPConnection(connConfig);
        try {
            connection.connect();
            System.out.println("Connected to " + connection.getHost());
        } catch (XMPPException ex) {
            //ex.printStackTrace();
            System.out.println("Failed to connect to " + connection.getHost());
            System.exit(1);
        }
        try {
            connection.login("jdkcn.ing", "java@ing");
            System.out.println("Logged in as " + connection.getUser());
            
            Presence presence = new Presence(Presence.Type.available);
            connection.sendPacket(presence);
            connection.getRoster().setSubscriptionMode(Roster.SubscriptionMode.accept_all);
            gtalkTest.getEntries().addAll(connection.getRoster().getEntries());
        } catch (XMPPException ex) {
            //ex.printStackTrace();
            System.out.println("Failed to log in as " + connection.getUser());
            System.exit(1);
        }
        
        ChatManager chatmanager = connection.getChatManager();
        final List<RosterEntry> entries = gtalkTest.getEntries();
        chatmanager.addChatListener(new ChatManagerListener(){
			public void chatCreated(Chat chat, boolean createdLocally) {
				chat.addMessageListener(new MessageParrot(entries));
			}});
        
        System.out.println("Press enter to disconnect");
        try {
            System.in.read();
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
        connection.disconnect();  
    }



}
