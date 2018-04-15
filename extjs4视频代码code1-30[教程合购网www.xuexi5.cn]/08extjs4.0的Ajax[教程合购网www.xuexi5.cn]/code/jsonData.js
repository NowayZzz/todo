(function(){
	Ext.onReady(function(){
			var data = "{id:'01',name:'uspcat.com','age':26,email:'yunfengcheng2008@126.com'}";
			Ext.Ajax.request({
				url : 'person.jsp',
				method : 'POST',
				timeout :3000,
				jsonData:data,
				success :function(response , options){
					alert(eval(response.responseText)[0].name);
				},
				failure  :function(response , options){
					alert(response.responseText+" "+options)
				}
			});
	})
})()
