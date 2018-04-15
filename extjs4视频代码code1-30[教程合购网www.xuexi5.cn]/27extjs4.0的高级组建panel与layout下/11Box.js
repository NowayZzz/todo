Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create('Ext.Panel', {
	    width: 400,
	    height: 230,
	    renderTo: Ext.getBody(),
	    title: "Vbox布局的面板",
		layout: {
		    type: 'vbox',
		    align : 'stretch',
		    pack  : 'start'
		},
		items: [
		    {html:'panel 1', flex:1},
		    {html:'panel 2', height:150},
		    {html:'panel 3', flex:2}
		]
	});
})