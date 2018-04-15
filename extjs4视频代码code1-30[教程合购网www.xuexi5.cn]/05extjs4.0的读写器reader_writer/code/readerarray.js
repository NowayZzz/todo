Ext.onReady(function(){
	Ext.regModel("person",{
		fields:[
			'name','age'
//			{name:'name'},
//			{name:'age'}
		],
		proxy :{
			type:'ajax',
			url:'person.jsp',
			reader:{
				type:'array'
			}
		}
	});
		var person = Ext.ModelManager.getModel('person');
		person.load(1,{
			success:function(model){
				alert(model.get('name'))
			}
		})
});