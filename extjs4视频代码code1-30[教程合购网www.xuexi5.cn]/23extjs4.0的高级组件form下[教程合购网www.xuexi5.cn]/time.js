Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create("Ext.form.Panel",{
		title:'本地combobox实例',
		renderTo:'formDemo',
		bodyPadding:'5 5 5 5',
		height:100,
		width:270,
		frame:true,
		defaults:{
			labelSeparator :": ",
			labelWidth : 70,
			width : 200,
			allowBlank: false,
			msgTarget : 'side',
			labelAlign:'left'
		},
		items:[{
			xtype:'timefield',
			fieldLabel:'上班时间',
			minValue:'9:00',
			maxValue:'18:00',
			minText:'时间要大于{0}',
			maxText:'时间要小于{0}',
			format:'G时',
			increment:60,
			invalidText:'时间格式错误',
			pickerMaxHeight :100 
		}]
	});
});














