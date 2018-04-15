(function(){
	Ext.onReady(function(){
		var div01 = Ext.core.Element.fly("div01");
		//1.鼠标滑过的时候增加一个样式滑出的时候移除样式
		div01.addClsOnOver("divC");
		//2.得到el的方法是Ext.get()
		var input01 = Ext.get("input01");
		var fn1 = function(){
			alert("单击B按钮调用这个函数")
		}
		input01.addKeyMap({key:Ext.EventObject.B,ctrl:false,fn:fn1,stope:input01});
		
		input01.addKeyListener({key:Ext.EventObject.X,ctrl:true},function(){
			alert("单击ctrl+x")
		},input01);
		function createChild(){
			var el = document.createElement("h5");
			el.appendChild(document.createTextNode("我是被追加的"));
			return el;
		}
		Ext.get("div02").appendChild(createChild());
		
		Ext.getBody().createChild({
			tag:'li',
			id:'item1',
			html:'我是第一个个节点'
		});
	});
})();