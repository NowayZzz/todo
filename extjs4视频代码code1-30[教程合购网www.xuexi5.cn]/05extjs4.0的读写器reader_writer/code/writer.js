Ext.onReady(function(){
	Ext.regModel("person",{
		fields:[
			'name','age'
		],
		proxy :{
			type:'ajax',
			url:'person.jsp',
			writer:{
				//type:'json'
				type:'xml'
			}
		}
	});
	Ext.ModelMgr.create({
		name:'uspcat.con',
		age:1
	},'person').save();
		
})