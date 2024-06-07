CREATE DATABASE `jee` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE jee;

-- jee.clients definition

CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- jee.orders definition

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO jee.clients (nom,prenom) VALUES
	 ('eponge','bob'),
	 ('bunny','bugs'),
	 ('ourson','winnie'),
	 ('BOB','Truc'),
	 ('fan','deroxk'),
	 ('epon','bo');


INSERT INTO jee.orders (numero,client_id) VALUES
	 (101,1),
	 (102,1),
	 (103,3),
	 (105,2),
	 (7589,1),
	 (7895,1);


