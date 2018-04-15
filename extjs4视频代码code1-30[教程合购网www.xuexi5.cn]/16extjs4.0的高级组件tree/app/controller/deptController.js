Ext.define('AM.controller.deptController', {
    extend: 'Ext.app.Controller',
	init:function(){
		this.control({
			"deptTree button[id=allopen]":{
				click:function(b,e){
					var tree = b.ownerCt.ownerCt;
					tree.expandAll();
				}			
			},			
			"deptTree button[id=allclose]":{
				click:function(b,e){
					var tree = b.ownerCt.ownerCt;
					tree.collapseAll();
				}			
			},
			"deptTree button[id=add]":{
				click:function(b,e){
					var tree = b.ownerCt.ownerCt;
					var nodes = tree.getChecked();
					if(nodes.length == 1){
						var node = nodes[0];
						node.appendChild({
							checked:true,
							text:'技术架构组',
							id : '0103',
							leaf:true		
						});
					}else{
						alert("请您选择一个节点");
					}
				}
			},
			"deptTree":{
				itemclick:function(tree,record,item,index,e,options){
					alert(record.get('id'));
				}
			}
		});
	},
	views:[
		'deptView'
	],
	stores :[
		'deptStore'
	],
	models :[
	] 
});