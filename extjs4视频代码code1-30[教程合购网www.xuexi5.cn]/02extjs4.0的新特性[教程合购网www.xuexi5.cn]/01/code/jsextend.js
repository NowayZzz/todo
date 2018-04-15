/**
 * 1.javascript原生属性,函数
 * 		http://www.w3school.com.cn/js/jsref_obj_array.asp
 * 		常用的pop(),push(),sort()
 * 2.Extjs增强的功能 API中Utilities中找
 *  	every(),filter()
 * 3.Object
 */
Ext.onReady(function(){
	var myArray = [1,2,3,-3,-4,0,-5,9];
	/**
	//静态方法every()
	Ext.Array.every(myArray,function(itme){
		if(itme>=0){
			alert(itme);
			return true;
		}else{
			alert(itme+"false");
			return false;
		}
	},this);
	*/
	
	/**
	//filter()数组过滤
	var newArray = Ext.Array.filter(myArray,function(item){
		if(item>0){
			return true;
		}else{
			return false;
		}
	});
	alert(newArray.toSource());
	*/
	var Person = {name:'yfc',age:26};
	//alert(Person['name']);
	//extjs4.0提供getKey的函数
	//alert(Ext.Object.getKey(Person,'yfc'));
	Object.prototype.getValue = function(key,defValue){
		if(this[key]){
			return this[key];
		}else{
			return defValue;
		}
	}
	alert(Person.getValue("email","pcat@126.com"));
});







