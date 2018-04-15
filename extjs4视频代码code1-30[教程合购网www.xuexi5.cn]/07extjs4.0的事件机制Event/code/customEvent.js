(function(){
	Ext.onReady(function(){
		Ext.define("children",{
			extend:'Ext.util.Observable',
			constructor:function(){
				this.state = "hungry",//目前所属的状态 full
				this.setMilk = function(milk){
					this.fireEvent('hungry',milk);
				},
				this.addEvents({'hungry':true}),
				this.addListener("hungry",function(milk){
					if(this.state == 'hungry'){
						this.drink(milk);
					}else{
						alert("我不饿");				
					}
				}),
				this.drink = function(milk){
					alert("我喝掉了一瓶牛奶: "+milk);
				}
			}
		});
		var children = Ext.create("children",{});//本对象是牛奶过敏的对象
		Ext.util.Observable.capture(children,function(eventName){
			if(eventName == "hungry"){
				alert('这个孩子牛奶过敏不能和牛奶...');
				return false;
			}else{
				return true;
			}
		})
		//母亲调用孩子的接受牛奶的方法
		children.setMilk("三鹿牛奶");
		
	});
	/***
	 * 为对象添加一个事件addEvents-->事件的监听方式注册这个事件addListener-->触发了这个事件的动作fireEvent
	 */
})();


