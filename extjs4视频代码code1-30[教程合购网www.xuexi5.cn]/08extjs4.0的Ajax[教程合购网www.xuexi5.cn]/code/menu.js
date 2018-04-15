(function(){
	function createChild(value,name){
		var el = document.createElement("option");
		el.setAttribute("value",value);
		el.appendChild(document.createTextNode(name));
		return el;
	}
	var data = {};
	
	Ext.onReady(function(){
		//1.得到city这个dom对象
		var cityObj = Ext.get("city");
		//2.我们为这个city对象注册一个change
		cityObj.on("change",function(e,select){
			//3.得到改变后的数值
			var ids =  select.options[select.selectedIndex].value;
			//3.1 他先去前台的缓存变量中差数据,当没有的时候在去后台拿
			if(data["city"]){
				//直接操作
			}else{
				//做ajax
			}
			//4.ajax请求把后台数据拿过来
			Ext.Ajax.request({
				url:'/extjs/extjs!menu.action',
				params:{ids:ids},
				method:'post',
				timeout:4000,
				success:function(response,opts){
					var obj = eval(response.responseText);
					//5.得到地区的哪个对象area DOM
					var oldObj = Ext.get("area").dom;
					//6.清除里面项
					while(oldObj.length>0){
						oldObj.options.remove(oldObj.length-1);
					}
					//7.加入新的项
					Ext.Array.each(obj,function(o){
						Ext.get('area').dom.appendChild(createChild(o.valueOf(),o.name));
					})
					//8.把从数据库拿到的数据进行前台页面缓存
				}
			});
		});
	});
})()