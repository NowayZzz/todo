Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create("Ext.form.Panel",{
		title:'本地FieldSet实例',
		renderTo:'formDemo',
		bodyPadding:'5 5 5 5',
		height:300,
		width:270,
		frame:true,
		items:[{
			title:'组合',
			xtype:'fieldset',
			collapsible:true,//可以展示伸缩的按钮
			defaultType:'textfield',
			defaults:{
				anchor:'95%'
			},
			layout:'anchor',
			items:[{
				fieldLabel:'Name',
				name:'name'
			},{
				fieldLabel:'Email',
				name:'Email'
			}]
		},{
			title:'组合2',
			xtype:'fieldset',
			checkboxToggle:true,//启用复选框
			collapsible:true,//可以展示伸缩的按钮
			defaultType:'textfield',
			collapsed:true,//true默认set是收起的
			defaults:{
				anchor:'95%'
			},
			layout:'anchor',
			items:[{
				fieldLabel:'PASS',
				name:'PASS'
			},{
				fieldLabel:'INFO',
				name:'INFO'
			}]
		}],
		buttons:[{
			text:'提交',
			handler:function(){
				this.up("form").getForm().submit({
					params:{
						info:'age是隐藏字段'
					}
				});
			}
		}]
	});	
})






