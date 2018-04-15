Ext.define("AM.view.dd",{
	extend:'Ext.grid.plugin.DragDrop',
	alias: 'widget.dd',
	ddGroup:'ddTree',
	dragGroup :'userlist',
	dropGroup :'userlist',
	initComponent:function(){
		this.callParent(arguments);
	}	
})