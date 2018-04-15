(function(){
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.onReady(function(){
//		Ext.define("person",{
//			extend:'Ext.data.Model',
//			fields:[
//				{name:'name'},
//				{name:'age'}
//			],
//			proxy:{
//				type:'memory'
//			}
//		})
		var s = new Ext.data.Store({
			fields:[
				{name:'name'},
				{name:'age'}
			],			
//			data:[
//				{name:'uspcat.com',age:1},
//				{name:'yfc',age:26}
//			],
			proxy:{
				type:'ajax',
				url:'person.jsp'
			}//,
			//model:'person',
			//autoLoad:true
		});
//		s.each(function(model){
//			alert(model.get('name'));
//		});
		s.load(function(records, operation, success){
			Ext.Array.each(records,function(model){
				//alert(model.get('name'));
			});
			s.filter('name',"yfc");
			s.each(function(model){
				alert(model.get('name'));
			});	
			var index = s.find('name','yfc',0,false,true,false);
			alert(index)
			
			alert(s.getName());
		});
	})
})();


