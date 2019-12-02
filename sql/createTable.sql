--create DATABASE firstblood

CREATE TABLE `heros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
)

insert into heros VALUES (null,'妲己','N',now());
insert into heros VALUES (null,'亚瑟','M',now());
insert into heros VALUES (null,'鲁班七号','N',now());
insert into heros VALUES (null,'虞姬','F',now());