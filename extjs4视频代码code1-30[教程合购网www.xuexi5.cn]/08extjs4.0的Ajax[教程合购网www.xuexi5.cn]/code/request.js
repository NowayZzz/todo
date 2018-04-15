(function(){
	Ext.onReady(function(){
		Ext.Ajax.request({
			url : 'person.jsp',
			params:{id:'01'},
			method : 'POST',
			timeout :3000,
			success :function(response , options){
				alert(eval(response.responseText)[0].name);
			},
			failure  :function(response , options){
				alert(response.responseText+" "+options)
			}
		});
	})
})()
