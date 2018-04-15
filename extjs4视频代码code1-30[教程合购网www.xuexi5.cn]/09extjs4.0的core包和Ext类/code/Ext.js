var onl = function(){
	//alert("2 我是呗body的onload事件调用的")
}
Ext.onReady(function(){
	//1.onReady 这个个方法里面的第一个参数(funcion)他执行在页面文件按加载完毕之后和onload完成之后.
	//alert("3 extjs")
	
	//2.通过类似XML的选测方式来查询我们的节点
	var arr = Ext.query("TR TD");
	//alert(arr)
	
	//3.getCmp
	Ext.create("Ext.panel.Panel",{
		width:400,
		height:300,
		html:'<p>hello word</p>',
		id:'myp01',
		title:'my panel',
		renderTo:"myp"
	});
	var myp = Ext.getCmp("myp01");
	myp.setTitle("new title");
	//4.isEmpty
//	alert(Ext.isEmpty({}));
//	alert(Ext.isEmpty('',true));//flase
//	alert(Ext.isEmpty('',false));//true
	
	//5.namespace
	Ext.namespace("COM.PCAT.MODE","COM.PCAT.CORE");
	COM.PCAT.MODE.A = {
		name:'uspcat'
	};
	COM.PCAT.CORE.A = function(){
		alert("COM.PCAT.CORE.A");
	};
	//6.each
	var array = [-1,23,43543,4,6,7,8];
	Ext.each(array,function(i){
		//alert(i)
	})
	//7.apply
	var a = {
		name:'yfc'
	}
	Ext.apply(a,{getName:function(){
		alert(this.name);
	}});
	//a.getName();
	
	//8.encode( Mixed o ) : String
	//alert(Ext.encode(a));
	
	//9.htmlDecode
	//Ext.Msg.alert("hello",Ext.htmlDecode("<h1>hel&gtlo</h1>"));
	//10.select
	//var o1 = Ext.select("divC");
	//alert(o1)
	
	//11.typeOf( Mixed value ) : String
	alert(Ext.typeOf({}));//object
	alert(Ext.typeOf(""));//string
	alert(Ext.typeOf(function(){}));//function
})






