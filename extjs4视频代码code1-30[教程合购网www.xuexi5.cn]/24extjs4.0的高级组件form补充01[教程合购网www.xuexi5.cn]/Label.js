Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create("Ext.form.Panel",{
		title:'本地Label实例',
		renderTo:'formDemo',
		bodyPadding:'5 5 5 5',
		height:100,
		width:270,
		frame:true,
		items:[{
			xtype:'label',
			name:'name',
			text:'展示',
			forId :'myname',
			overCls:'a'
		},{
			xtype:'textfield',
			name:'age',
			value:'1',
			inputId:'myname',
			hideLabel:true
		}]
	});	
})






