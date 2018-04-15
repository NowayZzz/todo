Ext.onReady(function(){
	Ext.get('b1').on("click",function(){
		var time = Ext.get("time").getLoader();
		time.load({
			url:'/extjs/extjs!getTime.action',
			renderer:function(loader,response,request){
				var time = response.responseText;
				Ext.getDom("time").value = time;
			}
		});
	})
	Ext.get('b2').on("click",function(){
		var i = Ext.get('i').getLoader();
		i.startAutoRefresh(1000,{
			url:'/extjs/extjs!getI.action',
			renderer:function(loader,response,request){
				var i = response.responseText;
				Ext.getDom("i").value = i;
			}			
		});
	})
})