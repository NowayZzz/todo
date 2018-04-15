/**
 * 工厂类
 */
Ext.define("AM.model.modelFactory",{
	//数据类模型的集合
	models:new Ext.util.MixedCollection(),
	//字段集合
	fields:new Ext.util.MixedCollection(),
	getModelByName:function(modelName){
		//1.声明类,返回类的ClassName
		if(this.models.containsKey(modelName)){
			return modelName;
		}else{
			//ajax拿到我们的字段集合
			var fields = [];
			if(this.fields.containsKey(modelName)){
				fields = this.fields.containsKey(modelName)
			}else{
				Ext.Ajax.request({
					url:'/extjs/extjs!getModelFields.action?modelName='+modelName,
					method:'POST',
					timeout:4000,
					async:false,//跟关键 我不需要异步操作
					success:function(response,opts){
						fields = eval(response.responseText);
					}
				});
			}
			this.fields.add(modelName,fields);
			
			var newModel = Ext.define(modelName,{
				extend:'Ext.data.Model',
				fields:fields
			});
			this.models.add(modelName,newModel);
			return modelName;
		}
	}
});
var modelFactory = Ext.create('AM.model.modelFactory',{});







