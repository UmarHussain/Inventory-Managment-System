--
-- Table structure for table `inventory_type`
--
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `inventory_type`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_type` (
  `id` INTEGER(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `quantity` INTEGER(11) DEFAULT NULL,
  `created_time` timestamp(2) NULL DEFAULT NULL,
  `updated_time` timestamp(2) NULL DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `inventory_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`inventory_type_id`),
  KEY `fk_inventory_inventory_type_idx` (`inventory_type_id`),
  CONSTRAINT `fk_inventory_inventory_type` FOREIGN KEY (`inventory_type_id`) REFERENCES `inventory_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

