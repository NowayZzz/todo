Ext.onReady(function(){

	var textFomr = Ext.create("Ext.form.Panel",{
		title : "form中文本框大文本的实例",
		bodyStyle :'padding:5 5 5 5',
		frame : true,
		height : 250,
		width : 400,
		id:'my_form',
		renderTo:'formDemo',
		defaultType:'textfield',
		defaults:{
			labelSeparator :": ",
			labelWidth : 50,
			width : 200,
			allowBlank: false,
			msgTarget : 'side',
			labelAlign:'left'
		},
		items:[{
			fieldLabel:'Name',
			name:'userName',
			id:'userName',
			selectOnFocus:true
		},{
			xtype:'textareafield',
			width:300,
			height:150,
			name:'info',
			fieldLabel:'Info'
		}],
		buttons: [
		  {text:'登陆系统',handler:function(b){
		  	var formObj = Ext.getCmp("my_form");
		  	var basic = formObj.getForm();
		  		console.log(basic.getValues());
		  }}]
	})
})


