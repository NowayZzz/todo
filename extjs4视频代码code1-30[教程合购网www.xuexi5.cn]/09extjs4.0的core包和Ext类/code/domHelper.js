Ext.onReady(function(){
	//append( Mixed el, Object/String o, [Boolean returnElement] ) :
	var p = Ext.create("Ext.panel.Panel",{
		width:400,
		height:300,
		html:"<p id='p1'>hello word</p>",
		id:'myp01',
		title:'my panel',
		renderTo:"myp"
	});
	Ext.core.DomHelper.append(Ext.get("p1"),"<br><div id='d'>wo sho bei zhuijia de </div>");
	
	//applyStyles
	Ext.core.DomHelper.applyStyles(Ext.get("p1"),"color:red");
	//下面两个是被当做兄弟追加的
	//insertAfter( Mixed el, Object o, [Boolean returnElement] ) : 
	//insertBefore( Mixed el, Object/String o, [Boolean returnElement] ) :
	
	// createDom( Object/String o ) : HTMLElement
	var html = Ext.core.DomHelper.createDom("<h1>hello</h1>");
	alert(html)
	
})