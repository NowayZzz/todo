Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.Loader.setPath('Ext.ux', '../../../extjs4/examples/ux');
	Ext.require([
	    'Ext.ux.data.PagingMemoryProxy',
	    'Ext.ux.SlidingPager',
	    'Ext.ux.grid.FiltersFeature'
	]);	
	Ext.application({
		name : 'AM',
		appFolder : "app",
		launch:function(){
	        Ext.create('Ext.container.Viewport', { 
	        	layout:'auto',
	            items:[{
	            	xtype: 'userlist',
	                title: 'Users'
	            },{
	            	xtype:'proList'
	            }]
	        });
		},
		controllers:[
			'Users'
		]
	});
})