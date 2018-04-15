Ext.onReady(function(){
	var runner = new Ext.util.TaskRunner();
	var task = {
		run:function(){
			Ext.getDom("t1").value = Ext.util.Format.date(new Date(),"Y-m-d-s");
		},
		interval:1000
	}
	runner.start(task);
	Ext.get("b6").on("click",function(){
	
		runner.stop(task);
	})
})