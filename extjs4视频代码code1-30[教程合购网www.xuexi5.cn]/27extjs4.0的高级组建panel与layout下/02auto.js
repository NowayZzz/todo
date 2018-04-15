Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create('Ext.Panel', {
	    width: 800,
	    height: 280,
	    title: "AutoLayout布局的面板",
	    layout: 'auto',//设置布局
	    renderTo: 'demo',
	    items: [{
	        xtype: 'panel',
	        title: '第一个面板',
	        width: '75%', //站总体宽度的75%
	        height: 90
	    },{
	        xtype: 'panel',
	        title: '第二个面板',
	        width: '75%',
	        height: 90
	    },{
	        xtype: 'panel',
	        title: '第三个面板',
	        width: '99%',
	        height: 90
	    }]
	});
})