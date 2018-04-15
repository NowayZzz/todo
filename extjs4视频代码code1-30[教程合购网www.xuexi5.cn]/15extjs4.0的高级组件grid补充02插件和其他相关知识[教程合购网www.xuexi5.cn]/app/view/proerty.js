Ext.define("AM.view.proerty",{
	extend:'Ext.grid.property.Grid',
	title: 'Properties Grid',
	alias: 'widget.proList',
    width: 300,
    //自定义渲染的函数
    customRenderers :{
    	'boy':function(value){
    		return value?'是':'否'
    	},
    	'emial-width':function(value){
    		return value;
    	}
    },
    source: {
        'boy':false,
        'emial-width':'100'
    }	
})