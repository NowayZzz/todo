(function(){
	Ext.onReady(function(){
		var tbar = Ext.create('Ext.toolbar.Toolbar',{
			renderTo:Ext.getBody(),
			width:500,
			items:[
				{xtype:'button',id:'create',text:'create'},
				{xtype:'button',id:'delete',text:'delete'},
				{xtype:'button',text:'销毁删除按钮',handler:function(){
					var c = Ext.getCmp("delete");
					if(c){
						c.destroy();
					}
				}}			
			]
		});
		var deleteB = Ext.getCmp("delete");
		deleteB.addManagedListener(Ext.getCmp("create"),'click',function(){
			alert('添加操作');
		});
		//Ext.getCmp("create").on("click",function(){});
	});
})();