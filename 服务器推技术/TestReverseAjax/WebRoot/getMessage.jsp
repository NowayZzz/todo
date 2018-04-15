<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>DWR Reverse Ajax</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script src="dwr/engine.js"></script>
	<script src="dwr/util.js"></script>
	<script src="dwr/interface/sendingMessage.js"></script>
	
	<script type="text/javascript">
		function sendMessage(){
			var message = $("message").value;
			sendingMessage.addMessage(message);
		}
		
		function receiveMessage(messages){
			var chatlog = "";
			for(var data in messages){
		    	chatlog += "<div>" + messages[data] + "</div>";
		 	}
		 	dwr.util.setValue("list", chatlog, {escapeHtml:false});
		}
	</script>
  </head>
  
  <body onload="dwr.engine.setActiveReverseAjax(true);">
  	<form method="get" action="getMessage.jsp">
  		input message:<input id="message" type="text" />
  		<input type="button" value="sendMessage" onclick="sendMessage()" />
  		<div id="list"></div>
 	</form>
  </body>
</html>
