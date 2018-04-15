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
			xtype:'datefield',
			fieldLabel:'工作日',
			minValue:'01/01/2011',
			maxValue:'31/12/2011',
			disabledDays :[0,6],
			disabledDates:['11年11月08日'],
			disabledDatesText:'这个日期你不能选择'
		}]
	});
});














