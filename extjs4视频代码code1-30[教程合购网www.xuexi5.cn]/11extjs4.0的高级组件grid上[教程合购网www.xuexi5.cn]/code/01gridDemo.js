(function(){
	Ext.onReady(function(){
		Ext.QuickTips.init();
		//穿件表格时候要 用表格的面板
		var grid = Ext.create("Ext.grid.Panel",{
			title : 'Grid Demo',//标题
			frame : true,//面板渲染
			//forceFit : true,//自动填充panel空白处
			width : 600,
			height: 280,
			columns : [ //列模式
				{text:"Name",dataIndex:'name',width:100},
				{text:"age",dataIndex:'age',width:100},
				{text:"email",dataIndex:'email',width:350,
					field:{
						xtype:'textfield',
						allowBlank:false
					}
				}
			],
			tbar :[
				{xtype:'button',text:'添加',iconCls:'table_add'},
				{xtype:'button',text:'删除',iconCls:'table_remove',
					handler:function(o){
						//var gird = o.findParentByType("gridpanel");
						var gird = o.ownerCt.ownerCt;
						var data = gird.getSelectionModel().getSelection();
						if(data.length == 0){
							Ext.Msg.alert("提示","您最少要选择一条数据");
						}else{
							//1.先得到ID的数据(name)
							var st = gird.getStore();
							var ids = [];
							Ext.Array.each(data,function(record){
								ids.push(record.get('name'));
							})
							//2.后台操作(delet)
							Ext.Ajax.request({
								url:'/extjs/extjs!deleteData.action',
								params:{ids:ids.join(",")},
								method:'POST',
								timeout:2000,
								success:function(response,opts){
									Ext.Array.each(data,function(record){
										st.remove(record);
									})
								}
							})
							//3.前端操作DOM进行删除(ExtJs)
						}
					}
				  },
				{xtype:'button',text:'修改',iconCls:'table_edit'},
				{xtype:'button',text:'查看',iconCls:'table_comm'}
			],
			dockedItems :[{
				xtype:'pagingtoolbar',
				store:Ext.data.StoreManager.lookup('s_user'),
				dock:'bottom',
				displayInfo:true
			}],
			plugins:[
				Ext.create("Ext.grid.plugin.CellEditing",{
					clicksToEdit : 1
				})
			],
			selType:'checkboxmodel',//设定选择模式
			multiSelect:true,//运行多选
			renderTo :'gridDemo',
			store : Ext.data.StoreManager.lookup('s_user')
		});
	});
})();


