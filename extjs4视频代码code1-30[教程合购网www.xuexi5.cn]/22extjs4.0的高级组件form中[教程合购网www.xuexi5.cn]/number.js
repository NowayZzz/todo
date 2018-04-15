Ext.onReady(function(){

	var textFomr = Ext.create("Ext.form.Panel",{
		title : "form中文本框数字框的实例",
		bodyStyle :'padding:5 5 5 5',
		frame : true,
		height : 250,
		width : 400,
		id:'my_form',
		renderTo:'formDemo',
		defaultType:'numberfield',
		defaults:{
			labelSeparator :": ",
			labelWidth : 80,
			width : 200,
			allowBlank: false,
			msgTarget : 'side',
			labelAlign:'left'
		},
		items:[{
			fieldLabel:'整数微调',
			allowDecimals:false,//叫你不能输入小数
			name:'num1',
			id:'num1'
		},{
			fieldLabel:'整数',
			allowDecimals:false,//叫你不能输入小数
			name:'num2',
			id:'num2',
			hideTrigger : true
		},{
			fieldLabel:'小数',
			name:'num3',
			id:'num3',
			emptyText :'请输入小数',
			hideTrigger : false,
			decimalPrecision:3
		},{
			fieldLabel:'定界小数',
			name:'num3',
			id:'num3',
			minValue:10,
			maxValue:100,
			emptyText :'请输入小数',
			hideTrigger : false,
			decimalPrecision:3
		},{
			fieldLabel:'输入限定',
			name:'num4',
			id:'num4',
			baseChars:'01',
			hideTrigger : true
		},{
			fieldLabel:'限定步长',
			name:'num5',
			id:'num5',
			step:0.8,
			hideTrigger : false,
			value:'20'
		},{
			fieldLabel:'只读字段',
			name:'num6',
			id:'num6',
			step:0.8,
			hideTrigger : false,
			value:'20',
			//readOnly:true
			disabled : true
		}],
		buttons: [
		  {text:'登陆系统',handler:function(b){
		  	var formObj = Ext.getCmp("my_form");
		  	var basic = formObj.getForm();
		  		console.log(basic.getValues());
		}}]
	})
})


