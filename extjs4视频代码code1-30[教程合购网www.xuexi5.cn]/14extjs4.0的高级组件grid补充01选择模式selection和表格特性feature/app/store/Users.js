//User��ݼ���
Ext.define('AM.store.Users', {
	extend: 'Ext.data.Store',
	model: 'AM.model.User',
	storeId: 's_user',
	groupField : 'sex',
	proxy:{
	    type:'ajax',
	    url:'/extjs/extjs!getUserList.action',
	    reader: {
	        type: 'json',
	        root: 'topics'
	    },writer:{
			type:'json'
		}
	},
	autoLoad: true //
});