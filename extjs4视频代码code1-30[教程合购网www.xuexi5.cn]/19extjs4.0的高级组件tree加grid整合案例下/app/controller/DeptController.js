/**
 * ClassName 部门管理控制器
 */
Ext.define("AM.controller.DeptController",{
	extend:'Ext.app.Controller',
	GridDoActionUtil:Ext.create("AM.util.GridDoActionUtil"),
	init: function(){
		this.gerGridObj = function(buttion){
			return buttion.ownerCt.ownerCt;
		};
		this.getTreeObj = function(buttion){
			return  buttion.ownerCt.ownerCt.ownerCt.ownerCt
				    	.child('#west-tree').child("#dept-tree");
		};
		this.control({
			'deptlist button[id=delete]':{
				click:function(deleteButton){
					var grid  = this.gerGridObj(deleteButton);
					var tree = this.getTreeObj(deleteButton);
					this.GridDoActionUtil.doDelete(grid,tree);
				}
			},
			//第二讲中修改
			'deptlist button[id=save]':{
				click:function(saveButton){
					var grid  = this.gerGridObj(saveButton);
					var tree = this.getTreeObj(saveButton);
					this.GridDoActionUtil.doSave(grid,tree);
				}
			},
			//设定列表添加按钮的事件
			'deptlist button[id=add]':{
				click:function(addButton){
					//得到数据表格的对象
					var grid  = this.gerGridObj(addButton);
    				var modelObj = {
				        text: '',
		       			id: 'A01',
		       			info :'',
		       			orderIndex:0,
		       			manager:'',
		       			nodeType:'ROOT',
		       			leaf : true
				    };
				    //得到tree
				    var tree = this.getTreeObj(addButton);
					this.GridDoActionUtil.doInsert(grid,modelObj,tree);
					
				}
			}
		})
	},
	views:[
		'DeptTree',
		'DeptList',
		'MainLayout'
	],
	stores:[
		'DeptStore4Tree',
		'DeptStore'
	],
	models:[
		'DeptModel'
	]
});