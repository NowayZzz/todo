--资费信息表
create table cost(
  	cost_id   int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  	name varchar(50)  not null,
  	base_duration int ,
  	base_cost double(7,2),
  	unit_cost double(7,4),
  	status char(1),
  	descr varchar(100),
  	creatime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  	startime date,
	cost_type char(1)
  );



INSERT INTO cost VALUES (null,'5.9元套餐',20,5.9,0.4,0,'5.9元20小时/月,超出部分0.4元/时',DEFAULT,DEFAULT,'2');
INSERT INTO cost VALUES (null,'6.9元套餐',40,6.9,0.3,0,'6.9元40小时/月,超出部分0.3元/时',DEFAULT,DEFAULT,'2');
INSERT INTO cost VALUES (null,'8.5元套餐',100,8.5,0.2,0,'8.5元100小时/月,超出部分0.2元/时',DEFAULT,DEFAULT,'2');
INSERT INTO cost VALUES (null,'10.5元套餐',200,10.5,0.1,0,'10.5元200小时/月,超出部分0.1元/时',DEFAULT,DEFAULT,'2');
INSERT INTO cost VALUES (null,'计时收费',null,null,0.5,0,'0.5元/时,不使用不收费',DEFAULT,DEFAULT,'3');
INSERT INTO cost VALUES (null,'包月',null,20,null,0,'每月20元,不限制使用时间',DEFAULT,DEFAULT,'1');

--管理员表
create table admin_info(
   	admin_id 	int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
   	admin_code 	varchar(30) not null,
   	password 	varchar(30) not null,
   	name 		varchar(30) not null,
   	telephone 	varchar(15),
   	email 		varchar(50),
   	enrolldate 	timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);








--管理员表
insert into admin_info values(2000,'admin','123','ADMIN','123456789','admin@tarena.com.cn',sysdate());
insert into admin_info values(3000,'zhangfei','123','ZhangFei','123456789','zhangfei@tarena.com.cn',sysdate());
insert into admin_info values(4000,'liubei','123','LiuBei','123456789','liubei@tarena.com.cn',sysdate());
insert into admin_info values(5000,'caocao','123','CaoCao','123456789','caocao@tarena.com.cn',sysdate());
insert into admin_info values(6000,'aaa','123','AAA','123456789','aaa@tarena.com.cn',sysdate());
insert into admin_info values(7000,'bbb','123','BBB','123456789','bbb@tarena.com.cn',sysdate());


