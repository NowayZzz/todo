/**
 * ClassName 部门实体数据集
 */
Ext.define("AM.store.DeptStore",{
	extend:'Ext.data.Store',
	//model:'AM.model.DeptModel',
	model : modelFactory.getModelByName("AM.model.DeptModel"),
	proxy:{
		api:{
			update:'/extjs/extjs!updateDeptList.action',
			remove:'/extjs/extjs!updateDeptList.action'
		},
		type:'ajax',
		url:'/extjs/extjs!readDeptForGrid.action',
		reader:{
			type:'json',
			root:'topics'
		},
		writer:{
			type:'json'
		}
	},
	autoLoad:true
});