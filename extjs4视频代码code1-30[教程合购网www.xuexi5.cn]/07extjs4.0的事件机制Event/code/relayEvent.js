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
		//父亲类没有声明过任何监听事件
		Ext.define("father",{
			extend:'Ext.util.Observable',
			constructor:function(config){
				this.listeners = config.listeners;
				this.superclass.constructor.call(this,config);
			}
		});
		var father = Ext.create("father",{});
		father.relayEvents(children,['hungry']);
		father.on("hungry",function(){
			alert("送喝了三鹿的孩子去医院..");
		});
		//母亲调用孩子的接受牛奶的方法
		children.setMilk("三鹿牛奶");
		
	});
})();


