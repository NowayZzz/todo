(function(){
	Ext.onReady(function(){
//Ext.util.CSS
//1.createStyleSheet( String cssText, String id ) : StyleSheet
		Ext.util.CSS.createStyleSheet(".c{color:red}","red");
		Ext.get("d1").addClsOnOver("c");
//2.getRule( String/Array selector, Boolean refreshCache ) : CSSRule
		var cssobj = Ext.util.CSS.getRule(".c",true);
		//alert(cssobj.style.color)
//3.swapStyleSheet( String id, String url ) : void
		var i = 1;
		Ext.get("b1").on("click",function(){
			if(i%2==0){
				Ext.util.CSS.swapStyleSheet("one","one.css");
				Ext.get("d2").addClsOnOver("col")
				i++;
			}else{
				Ext.util.CSS.swapStyleSheet("two","two.css");
				Ext.get("d2").addClsOnOver("col")				
				i++;
			}			
		})
//4.removeStyleSheet( String id ) : void	
		Ext.get("b2").on("click",function(){
			Ext.util.CSS.removeStyleSheet("red");
		});
//5.updateRule( String/Array selector, String property, String value ) : Boolean
		Ext.get("b3").on("click",function(){
			Ext.util.CSS.updateRule(".c","color","#990055");
		});
	})
})()