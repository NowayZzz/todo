Ext.onReady(function(){
	var b = Ext.get("btn4");
	b.on("click",function(e){
		alert(e.getPageX())
	});
})