Ext.define("AM.view.deptView",{
	extend:'Ext.tree.Panel',
	alias: 'widget.deptTree',
	title : '部门树形',
	width : 350,
	height: 300,
	padding : '5 3 3 10',
	rootVisible : false,//控制显隐的属性
	config:{
		copyNodes:''//他充当剪切板的作用
	},
	columns:[
		{
			xtype:'treecolumn',
			text:'text',
			writh:150,
			dataIndex:'text'
		},{
			text:'info',
			dataIndex:'id'
		}
	],
	viewConfig:{
		plugins :{
			ptype:'treeviewdragdrop',
			appendOnly : true
		},
		listeners:{
			drop:function( node,  data,  overModel,  dropPosition,  options){
				//ajax的操作把数据同步到后台数据库
				alert("把: "+data.records[0].get('text')+" 移动到: "+overModel.get('text'));			
			},
			beforedrop:function( node,  data,  overModel,  dropPosition,  dropFunction,  options){
//				if(overModel.get("leaf")){
//					overModel.set('leaf',false)
//				}
			}
		}
	},	
	dockedItems:[{
		xtype:'toolbar',
		dock:'left',
		items:[
			{xtype:'button',text:'add',id:'add'},
			{xtype:'button',text:'copy',id:'copy'},
			{xtype:'button',text:'delete',id:'delete'},
			{xtype:'button',text:'paste',id:'paste'}
		]
	},{
		xtype:'toolbar',
		items:[{
			xtype:'button',
			id:'allopen',
			text:'展开全部'
		},{
			xtype:'button',
			id:'allclose',
			text:'收起全部'
		}]
	}],
	store:'deptStore'
});



