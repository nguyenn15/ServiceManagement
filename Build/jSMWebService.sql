CREATE DATABASE  IF NOT EXISTS `jsmwebservice` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jsmwebservice`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jsmwebservice
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assigment`
--

DROP TABLE IF EXISTS `assigment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assigment` (
  `idAssigment` int(11) NOT NULL AUTO_INCREMENT,
  `Date` datetime DEFAULT NULL,
  `Status` int(11) DEFAULT '0',
  `idEmployee` int(11) NOT NULL,
  `idResponse` int(11) NOT NULL,
  PRIMARY KEY (`idAssigment`),
  KEY `fk_Assigment_User1_idx` (`idEmployee`),
  KEY `fk_Assigment_ResquestResponse1_idx` (`idResponse`),
  CONSTRAINT `fk_Assigment_ResquestResponse1` FOREIGN KEY (`idResponse`) REFERENCES `resquestresponse` (`idresponse`),
  CONSTRAINT `fk_Assigment_User1` FOREIGN KEY (`idEmployee`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigment`
--

LOCK TABLES `assigment` WRITE;
/*!40000 ALTER TABLE `assigment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assigment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestorder`
--

DROP TABLE IF EXISTS `requestorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requestorder` (
  `idRequest` int(11) NOT NULL AUTO_INCREMENT,
  `Date` datetime DEFAULT NULL,
  `Area` double DEFAULT NULL,
  `NoOfDoors` int(11) DEFAULT NULL,
  `Entry_Exit_Doors` int(11) DEFAULT NULL,
  `OpenWindows` int(11) DEFAULT NULL,
  `OpenAreas` double DEFAULT NULL,
  `DoorBell` int(11) DEFAULT NULL,
  `LocationOfService` varchar(2000) DEFAULT NULL,
  `Status` int(11) DEFAULT '0',
  `idCustomer` int(11) DEFAULT NULL,
  `idManager` int(11) DEFAULT NULL,
  `idAdmin` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRequest`),
  KEY `fk_RequestOrder_User1_idx` (`idCustomer`),
  KEY `fk_RequestOrder_User2_idx` (`idManager`),
  KEY `fk_RequestOrder_User3_idx` (`idAdmin`),
  CONSTRAINT `fk_RequestOrder_User1` FOREIGN KEY (`idCustomer`) REFERENCES `user` (`iduser`),
  CONSTRAINT `fk_RequestOrder_User2` FOREIGN KEY (`idManager`) REFERENCES `user` (`iduser`),
  CONSTRAINT `fk_RequestOrder_User3` FOREIGN KEY (`idAdmin`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestorder`
--

LOCK TABLES `requestorder` WRITE;
/*!40000 ALTER TABLE `requestorder` DISABLE KEYS */;
INSERT INTO `requestorder` VALUES (1,'2010-01-03 04:30:43',1000,2,3,4,56,6,'7',1,1,1,1),(2,'2010-01-03 04:30:43',200,1,1,200,100,2,'123 12th street',1,1,NULL,NULL),(8,'2018-07-09 19:43:23',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(9,'2018-07-09 19:58:08',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(10,'2018-07-10 00:21:44',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(11,'2018-07-10 07:30:21',10000,5,2,9,5000,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(12,'2018-07-10 07:35:02',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(13,'2018-07-10 07:35:59',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(14,'2018-07-10 07:36:04',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(15,'2018-07-10 07:36:14',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(16,'2018-07-10 07:36:18',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(17,'2018-07-10 07:36:38',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(18,'2018-07-10 07:37:24',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(19,'2018-07-10 07:37:36',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(20,'2018-07-10 07:39:05',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(21,'2018-07-10 07:40:10',1000,5,4,5,500,3,'123 12st',0,2,NULL,NULL),(22,'2018-07-10 07:45:11',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(23,'2018-07-10 07:48:23',1000,5,2,9,500,2,'123 3Ave v3m3z4',0,4,NULL,NULL),(24,'2018-07-10 17:30:00',5000,4,2,6,2,1,'9498, 127A Street, Surrey, BC',0,4,NULL,NULL),(25,'2018-07-10 18:26:01',3000,2,2,2,2,2,'sdsaf',0,4,NULL,NULL);
/*!40000 ALTER TABLE `requestorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resquestresponse`
--

DROP TABLE IF EXISTS `resquestresponse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resquestresponse` (
  `idResponse` int(11) NOT NULL AUTO_INCREMENT,
  `NoOfAlarmPanel` int(11) DEFAULT NULL,
  `MotionDetector` int(11) DEFAULT NULL,
  `CableBundle` int(11) DEFAULT NULL,
  `DoorBell` int(11) DEFAULT NULL,
  `TotalCost` decimal(10,0) DEFAULT NULL,
  `ResquestResponsecol` varchar(45) DEFAULT NULL,
  `Status` int(11) DEFAULT '0',
  `idRequest` int(11) NOT NULL,
  PRIMARY KEY (`idResponse`),
  KEY `fk_ResquestResponse_RequestOrder1_idx` (`idRequest`),
  CONSTRAINT `fk_ResquestResponse_RequestOrder1` FOREIGN KEY (`idRequest`) REFERENCES `requestorder` (`idrequest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resquestresponse`
--

LOCK TABLES `resquestresponse` WRITE;
/*!40000 ALTER TABLE `resquestresponse` DISABLE KEYS */;
/*!40000 ALTER TABLE `resquestresponse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Fone` varchar(20) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `idUserType` int(11) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `fk_User_UserType_idx` (`idUserType`),
  CONSTRAINT `fk_User_UserType` FOREIGN KEY (`idUserType`) REFERENCES `usertype` (`idusertype`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','604123456','33 12th Street New West BC','Male',1,'admin@abc.com','1234'),(2,'Manager','604123654','22 12th Vancouver BC','Female',2,'manager@abc.com','1234'),(3,'Tony Nguyen','604456789','10 Kingsway Burnaby BC','Male',3,'employee@abc.com','1234'),(4,'Kate Jams','604147852','77 Leaf Ave BC','Female',4,'customer@abc.com','1234'),(5,'nouser','123123211',' ',' ',4,'nouser@abc.com','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usertype` (
  `idUserType` int(11) NOT NULL AUTO_INCREMENT,
  `UserType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUserType`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Admin'),(2,'Manager'),(3,'Employee'),(4,'Customer');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-10 20:28:44
