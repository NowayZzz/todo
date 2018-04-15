(function(){
	Ext.onReady(function(){
		var userData = {
			//total : 200,
			count:250,
			user:[{auditor:'yunfengcheng',info:{
				userID:'1',
				name:'uspcat.com',
				orders:[
					{id:'001',name:'pen'},
					{id:'002',name:'book'}
				]
			}}]
		};
		//model
		Ext.regModel("user",{
			fields:[
				{name:'userID',type:'string'},
				{name:'name',type:'string'}
			],
			hasMany: {model: 'order'}
		});
		Ext.regModel("order",{
			fields:[
				{name:'id',type:'string'},
				{name:'name',type:'string'}
			],
			belongsTo: {type: 'belongsTo', model: 'user'}
		});
		var mproxy = Ext.create("Ext.data.proxy.Memory",{
			model:'user',
			data:userData,
			reader:{
				type:'json',
				root:'user',
				implicitIncludes:true,
				totalProperty:'count',
				record : 'info'//服务器返回的数据可能很负载,用record可以删选出有用的数据信息,装在带Model中
			}
		});
		mproxy.read(new Ext.data.Operation(),function(result){
			var datas = result.resultSet.records;
			alert(result.resultSet.total);
			Ext.Array.each(datas,function(model){
				alert(model.get('name'));
			});
			var user = result.resultSet.records[0];
			var orders = user.orders();
			orders.each(function(order){
				alert(order.get('name'))
			});
			
		})
	});
})();



