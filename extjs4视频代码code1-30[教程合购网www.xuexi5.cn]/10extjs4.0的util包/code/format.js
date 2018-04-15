Ext.onReady(function(){
	//1.ellipsis() : void
	var str = "www.uspcat.com";
		//alert(Ext.util.Format.ellipsis(str,10));
	//2.capitalize( ) : void
	 	//alert(Ext.util.Format.capitalize(str));
	//3.date( String/Date value, String format ) : String
		//alert(Ext.util.Format.date(new Date(),"YƒÍ-m‘¬-d»’"));
	//4.substr( String value, Number start, Number length ) : String
		//alert(Ext.util.Format.substr(str,0,5));
	//5.lowercase( String value ) : String
		//alert(Ext.util.Format.lowercase("USPCAT.COM"))
	//6.number( Number v, String format ) : String
		//alert(Ext.util.Format.number("12344556.7892","0,000.00"))
	//7.nl2br( String The ) : String
	alert(Ext.util.Format.nl2br("asd\n123"))
})