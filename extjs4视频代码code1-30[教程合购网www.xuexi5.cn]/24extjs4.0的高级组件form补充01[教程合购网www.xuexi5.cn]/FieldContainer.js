Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.create("Ext.form.Panel",{
		title:'本地FieldContainer实例',
		renderTo:'formDemo',
		bodyPadding:'5 5 5 5',
		height:100,
		width:500,
		frame:true,
		defaults:{
			msgTarget:'side',
			labelAlign:'left'
		},
		items:[{
			xtype:'fieldcontainer',
			layout:{
				type:'hbox',
				align:'middle'
			},
			combineLabels:true,
			combineErrors:true,
			fieldDefaults:{
				hideLabel:true,//默认字段会隐藏lebel
				allowBlank:false
			},
			defaultType:'textfield',
			items:[{
				xtype:'label',
				forId:'name',
				text:'姓名'
			},{
				fieldLabel:'name',
				name:'name',
				inputId:'name'
			},{
				xtype:'label',
				forId:'phone',
				text:'电话'
			},{
				fieldLabel:'phone',
				name:'phone',
				inputId:'phone'
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






