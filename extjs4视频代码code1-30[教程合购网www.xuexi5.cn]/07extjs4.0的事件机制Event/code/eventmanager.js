Ext.onReady(function(){
	Ext.EventManager.addListener("btn5",'click',function(){
		alert("通过事件管理器进行事件的监听注册");
	})
})