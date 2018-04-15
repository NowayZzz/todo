<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>MyServer</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/ajax-pushlet-client.js"></script>
	<script type="text/javascript">
		PL.setDebug(false);

        function onEvent(event){
            var did = event.get("did");
            alert(did);
            var data = event.get("data");
            var dname = event.get("dname");
            document.getElementById("chartdiv").innerHTML = did;
        }

        function listen(){
            PL.joinListen("/${id}");   //这里监听的id是要唯一标识的，可以由后台传过来
        }

        function leave(){
            PL.leave();
        }
	</script>
  </head>
  
  <body onload="listen();return false;" onunload="leave();return false;">
    My Server JSP page. <br>
  </body>
</html>
