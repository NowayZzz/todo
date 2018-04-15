<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Ajax Http Polling</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/ajax-pushlet-client.js"></script>
	<script type="text/javascript">
		PL._init();
		PL.joinListen("/Jambhala/YuShiBo");
		function onData(event){
			alert(event.get("shihuan"));	
		}
	</script>
  </head>
  
  <body>
    <h1>My First Pushlet!</h1>
  </body>
</html>
