Ext.define("AM.view.List",{
	extend:'Ext.grid.Panel',
	title : 'Grid Demo',//标题
	alias: 'widget.userlist',
	frame : true,//面板渲染
	width : 1000,
	height: 280,
	columns : [ //列模式
				Ext.create("Ext.grid.RowNumberer",{}),
				{text:"Name",dataIndex:'name',width:100},
				{text:"age",dataIndex:'age',width:100},
				{text:"email",dataIndex:'email',width:200,
					field:{
						xtype:'textfield',
						allowBlank:false
					}
				},{
					text:'sex',
					dataIndex:'sex',
					width:50,
					DDName:'sy_sex',
					renderer:function(value){
						if(value){
							if(value == "女"){
								return "<font color='green'>"+value+"</font>"
							}else if(value == "男"){
								return "<font color='red'>"+value+"</font>"
							}
						}
					}
				},{
					text:'isIt',
					dataIndex:'isIt',
					xtype : "booleancolumn",
					width:50,
					trueText:'是',
					falseText:'不是'
				},{
					text:'birthday',
					dataIndex:'birthday',
					xtype : "datecolumn",
					width:150,
					format:'Y年m月d日'
				},{
					text:'deposit',
					dataIndex:'deposit',
					xtype:'numbercolumn',
					width:150,
					format:'0,000'
				},{
					text:'描述',xtype:'templatecolumn',
					tpl:'姓名是{name} 年龄是{age}',
					width:150
				},{
				 text:'Action',xtype:'actioncolumn',
				 id:'delete',
				 icon:'app/view/image/table_delete.png',
				 width:50//,
//				 items :[
//				 	{},{}
//				 ]
//				 handler:function(grid,row,col){
//				 	alert(row+" "+col);
//				 }
				}
	],
	tbar :[
				{xtype:'button',text:'添加',iconCls:'table_add'},
				{xtype:'button',id:'delete',text:'删除',iconCls:'table_remove'},
				{xtype:'button',text:'修改',iconCls:'table_edit'},
				{xtype:'button',text:'查看',iconCls:'table_comm'}
	],	
	dockedItems :[{
				xtype:'pagingtoolbar',
				store:'Users',
				dock:'bottom',
				displayInfo:true
	}],
	plugins:[
				Ext.create("Ext.grid.plugin.CellEditing",{
					clicksToEdit : 2
				})
	],
	selType:'checkboxmodel',//设定选择模式
	multiSelect:true,//运行多选
	store : 'Users',
	initComponent:function(){
		this.callParent(arguments);
	}
});


