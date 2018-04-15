Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',
	init:function(){
		this.control({
			'userlist':{
				itemclick:function(View,  record,  item,  index,  e,  options ){
					var sm = View.getSelectionModel();//.getSelection();		   			
		   			//alert(Ext.JSON.encode(sm.getCurrentPosition()));
					sm.selectByPosition({"row":1,"column":2});
				}
			},
			'userlist button[id=selection]':{
				click:function(o){
					var gird = o.ownerCt.ownerCt;
					var sm = gird.getSelectionModel();
					//sm.deselect(0);
					//alert(sm.getLastSelected().get('name'))
					//alert(sm.isSelected(0));
					//sm.selectRange(1,2,true);
					sm.selectByPosition({"row":2,"column":3});
				}
			},
			'userlist button[id=del]':{
				click:function(o){
					var gird = o.ownerCt.ownerCt;
						var data = gird.getSelectionModel().getSelection();
						if(data.length == 0){
							Ext.Msg.alert("提示","您最少要选择一条数据");
						}else{
							//1.先得到ID的数据(name)
							var st = gird.getStore();
							var ids = [];
							Ext.Array.each(data,function(record){
								ids.push(record.get('name'));
							})
							//2.后台操作(delet)
							Ext.Ajax.request({
								url:'/extjs/extjs!deleteData.action',
								params:{ids:ids.join(",")},
								method:'POST',
								timeout:2000,
								success:function(response,opts){
									Ext.Array.each(data,function(record){
										st.remove(record);
									})
								}
							})
							//3.前端操作DOM进行删除(ExtJs)
						}
				}
			},
			"userlist actioncolumn[id=delete]":{
				click : function(o,item,rowIndex,colIndex ,e){
					alert(rowIndex+" "+colIndex);
				}
			}
		});
	},
	views:[
		'List'
	],
	stores :[
		"Users"
	],
	models :[
		"User"
	] 
});