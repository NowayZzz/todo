Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create('Ext.Panel', {
	    width: 200,
	    height: 200,
	    title: "absolute布局的面板",
	    layout: 'absolute',//设置布局
	    renderTo: 'demo',
	    items:[{
		    title: '子面板',
		    x: 50,
		    y: 50,
		    width: 100,
		    height: 100,
		    html: '定位在 x:50, y:40'
		}]
	});
})