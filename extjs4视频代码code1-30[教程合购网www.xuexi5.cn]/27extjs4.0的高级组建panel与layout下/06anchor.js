Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create('Ext.Panel', {
	    width: 500,
	    height: 500,
	    title: "Anchor布局的面板",
	    layout: 'anchor',//设置布局
	    renderTo: 'demo',
	    items: [{
	        xtype: 'panel',
	        title: '75% 宽 and 20% 高',
	        anchor: '75% 20%'
	    },{
	        xtype: 'panel',
	        title: '偏移量 -300 宽 & -200 高',
	        anchor: '-300 -200'     
	    },{
	        xtype: 'panel',
	        title: '综合使用 -250 宽   20% 高',
	        anchor: '-250 20%'
	    }]
	});
})