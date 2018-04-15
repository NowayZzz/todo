Ext.onReady(function(){
	//控制元素在指定时间内被单击(乳钙元素没有数去焦点)
	var cl = new Ext.util.ClickRepeater(Ext.get("b4"),{
		delay:3000,//首次单击时候的间隔事件
		interval:4000,//发生首次重复事件调用之后每一次事件的相隔时间
		stopDefault:true,//停止这个el上得默认单击事件
		handler:function(){
			alert("单击我");
		}
	});
	//第一次单击马上会触发事件 如果不去点击其他的元素那么3秒或就会自定执行第二次
	//一或会以4秒的间隔执行相应的程序
	//用途 类似VS的挤房器,网络忙的时候请等待的功能
})