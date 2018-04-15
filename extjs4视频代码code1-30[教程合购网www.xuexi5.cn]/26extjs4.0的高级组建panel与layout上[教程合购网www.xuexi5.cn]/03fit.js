Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create('Ext.Panel', {
	    width: 500,
	    height: 280,
	    title: "AutoLayout布局的面板",
	    layout: 'fit',//设置布局
	    renderTo: 'demo',
	    items: [{
	        xtype: 'panel',
	        title: '第一个面板'
	    },{
	        xtype: 'panel',
	        title: '第二个面板'
	    }]
	});
})