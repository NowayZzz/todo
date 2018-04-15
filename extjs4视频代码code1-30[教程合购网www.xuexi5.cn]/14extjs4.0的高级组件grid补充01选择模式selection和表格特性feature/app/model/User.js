//User��
Ext.define('AM.model.User', {
    extend: 'Ext.data.Model',
	fields: [
		{name: 'name',  type: 'string',sortable : true},
	    {name: 'age',   type: 'int',sortable : true},
	    {name: 'email',   type: 'string',sortable : true},
	    {name: 'birthday',   type: 'string',sortable : true},
	    {name: 'deposit',   type: 'int',sortable : true},
	    {name: 'isIt',   type: 'string',sortable : true},
	    {name: 'sex',   type: 'string',sortable : true}
	]
});