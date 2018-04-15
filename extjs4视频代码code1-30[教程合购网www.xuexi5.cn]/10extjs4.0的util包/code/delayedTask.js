Ext.onReady(function(){
	var dt = new Ext.util.DelayedTask(function(){
		alert("-----");
	});
	Ext.get("b5").on("click",function(){
		dt.delay(4000);
		dt.cancel();
	});
	//dt.cancel();
})