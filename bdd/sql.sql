CREATE DATABASE `jee` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE jee;

-- jee.clients definition

CREATE TABLE `clients` (
  `facture` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`facture`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;


INSERT INTO jee.clients (nom,prenom) VALUES
	 ('eponge','bob'),
	 ('bunny','bugs'),
	 ('ourson','winnie'),
	 ('BOB','Truc'),
	 ('fan','deroxk'),
	 ('epon','bo');