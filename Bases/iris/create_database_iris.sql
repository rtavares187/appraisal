-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jb_iris_mcar_sepalwidth_20
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `jb_iris_mcar_sepalwidth_20`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepalwidth_20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepalwidth_20`;

--
-- Table structure for table `iris_mcar_sepalwidth_20`
--

DROP TABLE IF EXISTS `iris_mcar_sepalwidth_20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepalwidth_20` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepalwidth_20`
--

LOCK TABLES `iris_mcar_sepalwidth_20` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_20` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepalwidth_20` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,NULL,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,NULL,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,NULL,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,NULL,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,NULL,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,NULL,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,NULL,1.5,0.4,'Iris-setosa'),(33,5.2,NULL,1.5,0.1,'Iris-setosa'),(34,5.5,NULL,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,NULL,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,NULL,1.6,0.2,'Iris-setosa'),(48,4.6,NULL,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,NULL,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,NULL,4,1.3,'Iris-versicolor'),(55,6.5,NULL,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,NULL,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,NULL,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,NULL,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,NULL,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,NULL,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,NULL,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,NULL,5.6,1.8,'Iris-virginica'),(105,6.5,NULL,5.8,2.2,'Iris-virginica'),(106,7.6,NULL,6.6,2.1,'Iris-virginica'),(107,4.9,NULL,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,NULL,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,NULL,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,NULL,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,NULL,6.1,1.9,'Iris-virginica'),(132,7.9,NULL,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepalwidth_30`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepalwidth_30` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepalwidth_30`;

--
-- Table structure for table `iris_mcar_sepalwidth_30`
--

DROP TABLE IF EXISTS `iris_mcar_sepalwidth_30`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepalwidth_30` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepalwidth_30`
--

LOCK TABLES `iris_mcar_sepalwidth_30` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_30` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepalwidth_30` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,NULL,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,NULL,1.7,0.4,'Iris-setosa'),(7,4.6,NULL,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,NULL,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,NULL,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,NULL,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,NULL,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,NULL,1.5,0.2,'Iris-setosa'),(29,5.2,NULL,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,NULL,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,NULL,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,NULL,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,NULL,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,NULL,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,NULL,1.4,0.2,'Iris-setosa'),(51,7,NULL,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,NULL,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,NULL,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,NULL,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,NULL,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,NULL,4.5,1.5,'Iris-versicolor'),(80,5.7,NULL,3.5,1,'Iris-versicolor'),(81,5.5,NULL,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,NULL,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,NULL,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,NULL,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,NULL,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,NULL,6,2.5,'Iris-virginica'),(102,5.8,NULL,5.1,1.9,'Iris-virginica'),(103,7.1,NULL,5.9,2.1,'Iris-virginica'),(104,6.3,NULL,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,NULL,5.1,2,'Iris-virginica'),(112,6.4,NULL,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,NULL,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,NULL,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,NULL,4.9,1.8,'Iris-virginica'),(125,6.7,NULL,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,NULL,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,NULL,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,NULL,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,NULL,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,NULL,5.7,2.5,'Iris-virginica'),(146,6.7,NULL,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,NULL,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,NULL,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_30` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepalwidth_10`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepalwidth_10` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepalwidth_10`;

--
-- Table structure for table `iris_mcar_sepalwidth_10`
--

DROP TABLE IF EXISTS `iris_mcar_sepalwidth_10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepalwidth_10` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepalwidth_10`
--

LOCK TABLES `iris_mcar_sepalwidth_10` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_10` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepalwidth_10` VALUES (1,5.1,NULL,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,NULL,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,NULL,1.3,0.4,'Iris-setosa'),(18,5.1,NULL,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,NULL,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,NULL,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,NULL,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,NULL,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,NULL,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,NULL,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,NULL,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,NULL,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,NULL,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,NULL,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,NULL,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepallength_20`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepallength_20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepallength_20`;

--
-- Table structure for table `iris_mcar_sepallength_20`
--

DROP TABLE IF EXISTS `iris_mcar_sepallength_20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepallength_20` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepallength_20`
--

LOCK TABLES `iris_mcar_sepallength_20` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepallength_20` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepallength_20` VALUES (1,NULL,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,NULL,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,NULL,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,NULL,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,NULL,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,NULL,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,NULL,3.2,4.5,1.5,'Iris-versicolor'),(53,NULL,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,NULL,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,NULL,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,NULL,2,3.5,1,'Iris-versicolor'),(62,NULL,3,4.2,1.5,'Iris-versicolor'),(63,NULL,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,NULL,2.5,3.9,1.1,'Iris-versicolor'),(71,NULL,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,NULL,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,NULL,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,NULL,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,NULL,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,NULL,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,NULL,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,NULL,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,NULL,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,NULL,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,NULL,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,NULL,3.3,5.7,2.1,'Iris-virginica'),(126,NULL,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,NULL,3,4.9,1.8,'Iris-virginica'),(129,NULL,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,NULL,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepallength_20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petallength_20`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petallength_20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petallength_20`;

--
-- Table structure for table `iris_mcar_petallength_20`
--

DROP TABLE IF EXISTS `iris_mcar_petallength_20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petallength_20` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petallength_20`
--

LOCK TABLES `iris_mcar_petallength_20` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petallength_20` DISABLE KEYS */;
INSERT INTO `iris_mcar_petallength_20` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,NULL,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,NULL,0.4,'Iris-setosa'),(18,5.1,3.5,NULL,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,NULL,0.5,'Iris-setosa'),(25,4.8,3.4,NULL,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,NULL,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,NULL,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,NULL,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,NULL,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,NULL,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,NULL,1.5,'Iris-versicolor'),(63,6,2.2,NULL,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,NULL,1.5,'Iris-versicolor'),(80,5.7,2.6,NULL,1,'Iris-versicolor'),(81,5.5,2.4,NULL,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,NULL,1.6,'Iris-versicolor'),(85,5.4,3,NULL,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,NULL,1.3,'Iris-versicolor'),(89,5.6,3,NULL,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,NULL,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,NULL,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,NULL,1.3,'Iris-versicolor'),(101,6.3,3.3,NULL,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,NULL,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,NULL,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,NULL,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,NULL,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,NULL,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,NULL,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,NULL,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petallength_20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepallength_30`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepallength_30` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepallength_30`;

--
-- Table structure for table `iris_mcar_sepallength_30`
--

DROP TABLE IF EXISTS `iris_mcar_sepallength_30`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepallength_30` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepallength_30`
--

LOCK TABLES `iris_mcar_sepallength_30` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepallength_30` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepallength_30` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,NULL,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,NULL,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,NULL,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,NULL,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,NULL,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,NULL,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,NULL,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,NULL,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,NULL,3.2,1.3,0.2,'Iris-setosa'),(44,NULL,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,NULL,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,NULL,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,NULL,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,NULL,2.9,4.6,1.3,'Iris-versicolor'),(60,NULL,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,NULL,3,4.2,1.5,'Iris-versicolor'),(63,NULL,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,NULL,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,NULL,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,NULL,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,NULL,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,NULL,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,NULL,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,NULL,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,NULL,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,NULL,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,NULL,2.3,3.3,1,'Iris-versicolor'),(95,NULL,2.7,4.2,1.3,'Iris-versicolor'),(96,NULL,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,NULL,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,NULL,2.9,5.6,1.8,'Iris-virginica'),(105,NULL,3,5.8,2.2,'Iris-virginica'),(106,NULL,3,6.6,2.1,'Iris-virginica'),(107,NULL,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,NULL,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,NULL,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,NULL,2.8,4.9,2,'Iris-virginica'),(123,NULL,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,NULL,2.8,4.8,1.8,'Iris-virginica'),(128,NULL,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,NULL,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,NULL,3,4.8,1.8,'Iris-virginica'),(140,NULL,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,NULL,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,NULL,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepallength_30` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepallength_10`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepallength_10` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepallength_10`;

--
-- Table structure for table `iris_mcar_sepallength_10`
--

DROP TABLE IF EXISTS `iris_mcar_sepallength_10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepallength_10` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepallength_10`
--

LOCK TABLES `iris_mcar_sepallength_10` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepallength_10` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepallength_10` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,NULL,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,NULL,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,NULL,3.2,4.7,1.4,'Iris-versicolor'),(52,NULL,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,NULL,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,NULL,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,NULL,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,NULL,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,NULL,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,NULL,3,4.6,1.4,'Iris-versicolor'),(93,NULL,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,NULL,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,NULL,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,NULL,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,NULL,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepallength_10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petallength_30`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petallength_30` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petallength_30`;

--
-- Table structure for table `iris_mcar_petallength_30`
--

DROP TABLE IF EXISTS `iris_mcar_petallength_30`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petallength_30` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petallength_30`
--

LOCK TABLES `iris_mcar_petallength_30` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petallength_30` DISABLE KEYS */;
INSERT INTO `iris_mcar_petallength_30` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,NULL,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,NULL,0.2,'Iris-setosa'),(10,4.9,3.1,NULL,0.1,'Iris-setosa'),(11,5.4,3.7,NULL,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,NULL,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,NULL,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,NULL,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,NULL,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,NULL,0.3,'Iris-setosa'),(43,4.4,3.2,NULL,0.2,'Iris-setosa'),(44,5,3.5,NULL,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,NULL,0.2,'Iris-setosa'),(50,5,3.3,NULL,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,NULL,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,NULL,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,NULL,1,'Iris-versicolor'),(69,6.2,2.2,NULL,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,NULL,1.2,'Iris-versicolor'),(75,6.4,2.9,NULL,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,NULL,1.4,'Iris-versicolor'),(78,6.7,3,NULL,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,NULL,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,NULL,1.3,'Iris-versicolor'),(89,5.6,3,NULL,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,NULL,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,NULL,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,NULL,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,NULL,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,NULL,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,NULL,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,NULL,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,NULL,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,NULL,1.8,'Iris-virginica'),(128,6.1,3,NULL,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,NULL,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,NULL,2,'Iris-virginica'),(133,6.4,2.8,NULL,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,NULL,2.3,'Iris-virginica'),(137,6.3,3.4,NULL,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,NULL,2.1,'Iris-virginica'),(141,6.7,3.1,NULL,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,NULL,1.9,'Iris-virginica'),(144,6.8,3.2,NULL,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,NULL,2.3,'Iris-virginica'),(147,6.3,2.5,NULL,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petallength_30` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petalwidth_10`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petalwidth_10` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petalwidth_10`;

--
-- Table structure for table `iris_mcar_petalwidth_10`
--

DROP TABLE IF EXISTS `iris_mcar_petalwidth_10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petalwidth_10` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petalwidth_10`
--

LOCK TABLES `iris_mcar_petalwidth_10` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petalwidth_10` DISABLE KEYS */;
INSERT INTO `iris_mcar_petalwidth_10` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,NULL,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,NULL,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,NULL,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,NULL,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,NULL,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,NULL,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,NULL,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,NULL,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,NULL,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,NULL,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,NULL,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,NULL,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,NULL,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,NULL,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,NULL,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petalwidth_10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepalwidth_50`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepalwidth_50` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepalwidth_50`;

--
-- Table structure for table `iris_mcar_sepalwidth_50`
--

DROP TABLE IF EXISTS `iris_mcar_sepalwidth_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepalwidth_50` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepalwidth_50`
--

LOCK TABLES `iris_mcar_sepalwidth_50` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_50` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepalwidth_50` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,NULL,1.4,0.2,'Iris-setosa'),(3,4.7,NULL,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,NULL,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,NULL,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,NULL,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,NULL,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,NULL,1.3,0.4,'Iris-setosa'),(18,5.1,NULL,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,NULL,1.6,0.2,'Iris-setosa'),(27,5,NULL,1.6,0.4,'Iris-setosa'),(28,5.2,NULL,1.5,0.2,'Iris-setosa'),(29,5.2,NULL,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,NULL,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,NULL,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,NULL,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,NULL,1.5,0.1,'Iris-setosa'),(39,4.4,NULL,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,NULL,1.3,0.3,'Iris-setosa'),(43,4.4,NULL,1.3,0.2,'Iris-setosa'),(44,5,NULL,1.6,0.6,'Iris-setosa'),(45,5.1,NULL,1.9,0.4,'Iris-setosa'),(46,4.8,NULL,1.4,0.3,'Iris-setosa'),(47,5.1,NULL,1.6,0.2,'Iris-setosa'),(48,4.6,NULL,1.4,0.2,'Iris-setosa'),(49,5.3,NULL,1.5,0.2,'Iris-setosa'),(50,5,NULL,1.4,0.2,'Iris-setosa'),(51,7,NULL,4.7,1.4,'Iris-versicolor'),(52,6.4,NULL,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,NULL,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,NULL,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,NULL,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,NULL,3.9,1.1,'Iris-versicolor'),(71,5.9,NULL,4.8,1.8,'Iris-versicolor'),(72,6.1,NULL,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,NULL,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,NULL,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,NULL,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,NULL,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,NULL,4.5,1.5,'Iris-versicolor'),(86,6,NULL,4.5,1.6,'Iris-versicolor'),(87,6.7,NULL,4.7,1.5,'Iris-versicolor'),(88,6.3,NULL,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,NULL,4.4,1.2,'Iris-versicolor'),(92,6.1,NULL,4.6,1.4,'Iris-versicolor'),(93,5.8,NULL,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,NULL,4.2,1.3,'Iris-versicolor'),(96,5.7,NULL,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,NULL,3,1.1,'Iris-versicolor'),(100,5.7,NULL,4.1,1.3,'Iris-versicolor'),(101,6.3,NULL,6,2.5,'Iris-virginica'),(102,5.8,NULL,5.1,1.9,'Iris-virginica'),(103,7.1,NULL,5.9,2.1,'Iris-virginica'),(104,6.3,NULL,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,NULL,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,NULL,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,NULL,5.5,1.8,'Iris-virginica'),(118,7.7,NULL,6.7,2.2,'Iris-virginica'),(119,7.7,NULL,6.9,2.3,'Iris-virginica'),(120,6,NULL,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,NULL,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,NULL,4.9,1.8,'Iris-virginica'),(125,6.7,NULL,5.7,2.1,'Iris-virginica'),(126,7.2,NULL,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,NULL,5.6,2.1,'Iris-virginica'),(130,7.2,NULL,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,NULL,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,NULL,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,NULL,5.5,1.8,'Iris-virginica'),(139,6,NULL,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,NULL,5.1,2.3,'Iris-virginica'),(143,5.8,NULL,5.1,1.9,'Iris-virginica'),(144,6.8,NULL,5.9,2.3,'Iris-virginica'),(145,6.7,NULL,5.7,2.5,'Iris-virginica'),(146,6.7,NULL,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,NULL,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_plants`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_plants` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_plants`;

--
-- Table structure for table `iris_plants`
--

DROP TABLE IF EXISTS `iris_plants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_plants` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_plants`
--

LOCK TABLES `iris_plants` WRITE;
/*!40000 ALTER TABLE `iris_plants` DISABLE KEYS */;
INSERT INTO `iris_plants` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_plants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepalwidth_40`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepalwidth_40` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepalwidth_40`;

--
-- Table structure for table `iris_mcar_sepalwidth_40`
--

DROP TABLE IF EXISTS `iris_mcar_sepalwidth_40`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepalwidth_40` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepalwidth_40`
--

LOCK TABLES `iris_mcar_sepalwidth_40` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_40` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepalwidth_40` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,NULL,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,NULL,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,NULL,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,NULL,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,NULL,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,NULL,1.1,0.1,'Iris-setosa'),(15,5.8,NULL,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,NULL,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,NULL,1.5,0.3,'Iris-setosa'),(21,5.4,NULL,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,NULL,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,NULL,1.5,0.1,'Iris-setosa'),(34,5.5,NULL,1.4,0.2,'Iris-setosa'),(35,4.9,NULL,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,NULL,1.5,0.1,'Iris-setosa'),(39,4.4,NULL,1.3,0.2,'Iris-setosa'),(40,5.1,NULL,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,NULL,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,NULL,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,NULL,4.5,1.3,'Iris-versicolor'),(57,6.3,NULL,4.7,1.6,'Iris-versicolor'),(58,4.9,NULL,3.3,1,'Iris-versicolor'),(59,6.6,NULL,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,NULL,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,NULL,4.5,1.5,'Iris-versicolor'),(68,5.8,NULL,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,NULL,4.8,1.8,'Iris-versicolor'),(72,6.1,NULL,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,NULL,4.7,1.2,'Iris-versicolor'),(75,6.4,NULL,4.3,1.3,'Iris-versicolor'),(76,6.6,NULL,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,NULL,3.5,1,'Iris-versicolor'),(81,5.5,NULL,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,NULL,3.9,1.2,'Iris-versicolor'),(84,6,NULL,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,NULL,4.4,1.3,'Iris-versicolor'),(89,5.6,NULL,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,NULL,4.4,1.2,'Iris-versicolor'),(92,6.1,NULL,4.6,1.4,'Iris-versicolor'),(93,5.8,NULL,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,NULL,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,NULL,4.3,1.3,'Iris-versicolor'),(99,5.1,NULL,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,NULL,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,NULL,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,NULL,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,NULL,5.3,1.9,'Iris-virginica'),(113,6.8,NULL,5.5,2.1,'Iris-virginica'),(114,5.7,NULL,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,NULL,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,NULL,6,1.8,'Iris-virginica'),(127,6.2,NULL,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,NULL,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,NULL,5.6,2.4,'Iris-virginica'),(138,6.4,NULL,5.5,1.8,'Iris-virginica'),(139,6,NULL,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,NULL,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,NULL,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,NULL,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,NULL,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepalwidth_40` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepallength_50`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepallength_50` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepallength_50`;

--
-- Table structure for table `iris_mcar_sepallength_50`
--

DROP TABLE IF EXISTS `iris_mcar_sepallength_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepallength_50` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepallength_50`
--

LOCK TABLES `iris_mcar_sepallength_50` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepallength_50` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepallength_50` VALUES (1,NULL,3.5,1.4,0.2,'Iris-setosa'),(2,NULL,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,NULL,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,NULL,3.1,1.5,0.1,'Iris-setosa'),(11,NULL,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,NULL,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,NULL,3.8,1.7,0.3,'Iris-setosa'),(20,NULL,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,NULL,3.7,1.5,0.4,'Iris-setosa'),(23,NULL,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,NULL,3.4,1.9,0.2,'Iris-setosa'),(26,NULL,3,1.6,0.2,'Iris-setosa'),(27,NULL,3.4,1.6,0.4,'Iris-setosa'),(28,NULL,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,NULL,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,NULL,4.1,1.5,0.1,'Iris-setosa'),(34,NULL,4.2,1.4,0.2,'Iris-setosa'),(35,NULL,3.1,1.5,0.1,'Iris-setosa'),(36,NULL,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,NULL,3.1,1.5,0.1,'Iris-setosa'),(39,NULL,3,1.3,0.2,'Iris-setosa'),(40,NULL,3.4,1.5,0.2,'Iris-setosa'),(41,NULL,3.5,1.3,0.3,'Iris-setosa'),(42,NULL,2.3,1.3,0.3,'Iris-setosa'),(43,NULL,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,NULL,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,NULL,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,NULL,2.8,4.5,1.3,'Iris-versicolor'),(57,NULL,3.3,4.7,1.6,'Iris-versicolor'),(58,NULL,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,NULL,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,NULL,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,NULL,2.7,4.1,1,'Iris-versicolor'),(69,NULL,2.2,4.5,1.5,'Iris-versicolor'),(70,NULL,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,NULL,3,4.4,1.4,'Iris-versicolor'),(77,NULL,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,NULL,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,NULL,3,4.5,1.5,'Iris-versicolor'),(86,NULL,3.4,4.5,1.6,'Iris-versicolor'),(87,NULL,3.1,4.7,1.5,'Iris-versicolor'),(88,NULL,2.3,4.4,1.3,'Iris-versicolor'),(89,NULL,3,4.1,1.3,'Iris-versicolor'),(90,NULL,2.5,4,1.3,'Iris-versicolor'),(91,NULL,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,NULL,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,NULL,3.3,6,2.5,'Iris-virginica'),(102,NULL,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,NULL,2.9,5.6,1.8,'Iris-virginica'),(105,NULL,3,5.8,2.2,'Iris-virginica'),(106,NULL,3,6.6,2.1,'Iris-virginica'),(107,NULL,2.5,4.5,1.7,'Iris-virginica'),(108,NULL,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,NULL,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,NULL,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,NULL,3.8,6.7,2.2,'Iris-virginica'),(119,NULL,2.6,6.9,2.3,'Iris-virginica'),(120,NULL,2.2,5,1.5,'Iris-virginica'),(121,NULL,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,NULL,2.8,6.7,2,'Iris-virginica'),(124,NULL,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,NULL,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,NULL,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,NULL,2.8,5.1,1.5,'Iris-virginica'),(135,NULL,2.6,5.6,1.4,'Iris-virginica'),(136,NULL,3,6.1,2.3,'Iris-virginica'),(137,NULL,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,NULL,3,4.8,1.8,'Iris-virginica'),(140,NULL,3.1,5.4,2.1,'Iris-virginica'),(141,NULL,3.1,5.6,2.4,'Iris-virginica'),(142,NULL,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,NULL,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,NULL,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,NULL,3.4,5.4,2.3,'Iris-virginica'),(150,NULL,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepallength_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_sepallength_40`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_sepallength_40` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_sepallength_40`;

--
-- Table structure for table `iris_mcar_sepallength_40`
--

DROP TABLE IF EXISTS `iris_mcar_sepallength_40`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_sepallength_40` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_sepallength_40`
--

LOCK TABLES `iris_mcar_sepallength_40` WRITE;
/*!40000 ALTER TABLE `iris_mcar_sepallength_40` DISABLE KEYS */;
INSERT INTO `iris_mcar_sepallength_40` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,NULL,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,NULL,2.9,1.4,0.2,'Iris-setosa'),(10,NULL,3.1,1.5,0.1,'Iris-setosa'),(11,NULL,3.7,1.5,0.2,'Iris-setosa'),(12,NULL,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,NULL,3,1.1,0.1,'Iris-setosa'),(15,NULL,4,1.2,0.2,'Iris-setosa'),(16,NULL,4.4,1.5,0.4,'Iris-setosa'),(17,NULL,3.9,1.3,0.4,'Iris-setosa'),(18,NULL,3.5,1.4,0.3,'Iris-setosa'),(19,NULL,3.8,1.7,0.3,'Iris-setosa'),(20,NULL,3.8,1.5,0.3,'Iris-setosa'),(21,NULL,3.4,1.7,0.2,'Iris-setosa'),(22,NULL,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,NULL,3,1.6,0.2,'Iris-setosa'),(27,NULL,3.4,1.6,0.4,'Iris-setosa'),(28,NULL,3.5,1.5,0.2,'Iris-setosa'),(29,NULL,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,NULL,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,NULL,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,NULL,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,NULL,3,1.3,0.2,'Iris-setosa'),(40,NULL,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,NULL,3.2,1.4,0.2,'Iris-setosa'),(49,NULL,3.7,1.5,0.2,'Iris-setosa'),(50,NULL,3.3,1.4,0.2,'Iris-setosa'),(51,NULL,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,NULL,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,NULL,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,NULL,2,3.5,1,'Iris-versicolor'),(62,NULL,3,4.2,1.5,'Iris-versicolor'),(63,NULL,2.2,4,1,'Iris-versicolor'),(64,NULL,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,NULL,2.5,4.9,1.5,'Iris-versicolor'),(74,NULL,2.8,4.7,1.2,'Iris-versicolor'),(75,NULL,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,NULL,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,NULL,3.4,4.5,1.6,'Iris-versicolor'),(87,NULL,3.1,4.7,1.5,'Iris-versicolor'),(88,NULL,2.3,4.4,1.3,'Iris-versicolor'),(89,NULL,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,NULL,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,NULL,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,NULL,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,NULL,3,5.9,2.1,'Iris-virginica'),(104,NULL,2.9,5.6,1.8,'Iris-virginica'),(105,NULL,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,NULL,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,NULL,2.8,5.1,2.4,'Iris-virginica'),(116,NULL,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,NULL,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,NULL,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,NULL,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,NULL,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,NULL,3.8,6.4,2,'Iris-virginica'),(133,NULL,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,NULL,3.1,5.5,1.8,'Iris-virginica'),(139,NULL,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,NULL,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,NULL,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_sepallength_40` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petalwidth_50`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petalwidth_50` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petalwidth_50`;

--
-- Table structure for table `iris_mcar_petalwidth_50`
--

DROP TABLE IF EXISTS `iris_mcar_petalwidth_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petalwidth_50` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petalwidth_50`
--

LOCK TABLES `iris_mcar_petalwidth_50` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petalwidth_50` DISABLE KEYS */;
INSERT INTO `iris_mcar_petalwidth_50` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,NULL,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,NULL,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,NULL,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,NULL,'Iris-setosa'),(13,4.8,3,1.4,NULL,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,NULL,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,NULL,'Iris-setosa'),(19,5.7,3.8,1.7,NULL,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,NULL,'Iris-setosa'),(22,5.1,3.7,1.5,NULL,'Iris-setosa'),(23,4.6,3.6,1,NULL,'Iris-setosa'),(24,5.1,3.3,1.7,NULL,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,NULL,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,NULL,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,NULL,'Iris-setosa'),(34,5.5,4.2,1.4,NULL,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,NULL,'Iris-setosa'),(38,4.9,3.1,1.5,NULL,'Iris-setosa'),(39,4.4,3,1.3,NULL,'Iris-setosa'),(40,5.1,3.4,1.5,NULL,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,NULL,'Iris-setosa'),(45,5.1,3.8,1.9,NULL,'Iris-setosa'),(46,4.8,3,1.4,NULL,'Iris-setosa'),(47,5.1,3.8,1.6,NULL,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,NULL,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,NULL,'Iris-versicolor'),(56,5.7,2.8,4.5,NULL,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,NULL,'Iris-versicolor'),(59,6.6,2.9,4.6,NULL,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,NULL,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,NULL,'Iris-versicolor'),(66,6.7,3.1,4.4,NULL,'Iris-versicolor'),(67,5.6,3,4.5,NULL,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,NULL,'Iris-versicolor'),(72,6.1,2.8,4,NULL,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,NULL,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,NULL,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,NULL,'Iris-versicolor'),(82,5.5,2.4,3.7,NULL,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,NULL,'Iris-versicolor'),(86,6,3.4,4.5,NULL,'Iris-versicolor'),(87,6.7,3.1,4.7,NULL,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,NULL,'Iris-versicolor'),(92,6.1,3,4.6,NULL,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,NULL,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,NULL,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,NULL,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,NULL,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,NULL,'Iris-virginica'),(106,7.6,3,6.6,NULL,'Iris-virginica'),(107,4.9,2.5,4.5,NULL,'Iris-virginica'),(108,7.3,2.9,6.3,NULL,'Iris-virginica'),(109,6.7,2.5,5.8,NULL,'Iris-virginica'),(110,7.2,3.6,6.1,NULL,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,NULL,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,NULL,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,NULL,'Iris-virginica'),(117,6.5,3,5.5,NULL,'Iris-virginica'),(118,7.7,3.8,6.7,NULL,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,NULL,'Iris-virginica'),(122,5.6,2.8,4.9,NULL,'Iris-virginica'),(123,7.7,2.8,6.7,NULL,'Iris-virginica'),(124,6.3,2.7,4.9,NULL,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,NULL,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,NULL,'Iris-virginica'),(134,6.3,2.8,5.1,NULL,'Iris-virginica'),(135,6.1,2.6,5.6,NULL,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,NULL,'Iris-virginica'),(138,6.4,3.1,5.5,NULL,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,NULL,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,NULL,'Iris-virginica'),(145,6.7,3.3,5.7,NULL,'Iris-virginica'),(146,6.7,3,5.2,NULL,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,NULL,'Iris-virginica'),(150,5.9,3,5.1,NULL,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petalwidth_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petallength_10`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petallength_10` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petallength_10`;

--
-- Table structure for table `iris_mcar_petallength_10`
--

DROP TABLE IF EXISTS `iris_mcar_petallength_10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petallength_10` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petallength_10`
--

LOCK TABLES `iris_mcar_petallength_10` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petallength_10` DISABLE KEYS */;
INSERT INTO `iris_mcar_petallength_10` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,NULL,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,NULL,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,NULL,0.2,'Iris-setosa'),(30,4.7,3.2,NULL,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,NULL,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,NULL,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,NULL,0.2,'Iris-setosa'),(48,4.6,3.2,NULL,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,NULL,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,NULL,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,NULL,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,NULL,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,NULL,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,NULL,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,NULL,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petallength_10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petalwidth_30`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petalwidth_30` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petalwidth_30`;

--
-- Table structure for table `iris_mcar_petalwidth_30`
--

DROP TABLE IF EXISTS `iris_mcar_petalwidth_30`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petalwidth_30` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petalwidth_30`
--

LOCK TABLES `iris_mcar_petalwidth_30` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petalwidth_30` DISABLE KEYS */;
INSERT INTO `iris_mcar_petalwidth_30` VALUES (1,5.1,3.5,1.4,NULL,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,NULL,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,NULL,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,NULL,'Iris-setosa'),(24,5.1,3.3,1.7,NULL,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,NULL,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,NULL,'Iris-setosa'),(39,4.4,3,1.3,NULL,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,NULL,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,NULL,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,NULL,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,NULL,'Iris-setosa'),(51,7,3.2,4.7,NULL,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,NULL,'Iris-versicolor'),(55,6.5,2.8,4.6,NULL,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,NULL,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,NULL,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,NULL,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,NULL,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,NULL,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,NULL,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,NULL,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,NULL,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,4,NULL,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,NULL,'Iris-versicolor'),(96,5.7,3,4.2,NULL,'Iris-versicolor'),(97,5.7,2.9,4.2,NULL,'Iris-versicolor'),(98,6.2,2.9,4.3,NULL,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,NULL,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,NULL,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,NULL,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,NULL,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,NULL,'Iris-virginica'),(119,7.7,2.6,6.9,NULL,'Iris-virginica'),(120,6,2.2,5,NULL,'Iris-virginica'),(121,6.9,3.2,5.7,NULL,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,NULL,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,NULL,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,NULL,'Iris-virginica'),(136,7.7,3,6.1,NULL,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,NULL,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,NULL,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,NULL,'Iris-virginica'),(147,6.3,2.5,5,NULL,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,NULL,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petalwidth_30` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petalwidth_20`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petalwidth_20` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petalwidth_20`;

--
-- Table structure for table `iris_mcar_petalwidth_20`
--

DROP TABLE IF EXISTS `iris_mcar_petalwidth_20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petalwidth_20` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petalwidth_20`
--

LOCK TABLES `iris_mcar_petalwidth_20` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petalwidth_20` DISABLE KEYS */;
INSERT INTO `iris_mcar_petalwidth_20` VALUES (1,5.1,3.5,1.4,0.2,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,NULL,'Iris-setosa'),(17,5.4,3.9,1.3,NULL,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,NULL,'Iris-setosa'),(21,5.4,3.4,1.7,NULL,'Iris-setosa'),(22,5.1,3.7,1.5,NULL,'Iris-setosa'),(23,4.6,3.6,1,NULL,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,0.1,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,NULL,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,1.6,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,NULL,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,NULL,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,NULL,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,NULL,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,1.5,'Iris-versicolor'),(63,6,2.2,4,NULL,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,NULL,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,NULL,'Iris-versicolor'),(84,6,2.7,5.1,NULL,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,NULL,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,NULL,'Iris-versicolor'),(101,6.3,3.3,6,NULL,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,NULL,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,NULL,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,NULL,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,NULL,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,NULL,'Iris-virginica'),(126,7.2,3.2,6,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,NULL,'Iris-virginica'),(128,6.1,3,4.9,NULL,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,NULL,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,5.6,NULL,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,NULL,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,NULL,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,NULL,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petalwidth_20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petallength_50`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petallength_50` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petallength_50`;

--
-- Table structure for table `iris_mcar_petallength_50`
--

DROP TABLE IF EXISTS `iris_mcar_petallength_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petallength_50` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petallength_50`
--

LOCK TABLES `iris_mcar_petallength_50` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petallength_50` DISABLE KEYS */;
INSERT INTO `iris_mcar_petallength_50` VALUES (1,5.1,3.5,NULL,0.2,'Iris-setosa'),(2,4.9,3,NULL,0.2,'Iris-setosa'),(3,4.7,3.2,NULL,0.2,'Iris-setosa'),(4,4.6,3.1,NULL,0.2,'Iris-setosa'),(5,5,3.6,NULL,0.2,'Iris-setosa'),(6,5.4,3.9,NULL,0.4,'Iris-setosa'),(7,4.6,3.4,1.4,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,NULL,0.2,'Iris-setosa'),(16,5.7,4.4,NULL,0.4,'Iris-setosa'),(17,5.4,3.9,NULL,0.4,'Iris-setosa'),(18,5.1,3.5,NULL,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,NULL,0.2,'Iris-setosa'),(22,5.1,3.7,NULL,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,NULL,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,NULL,0.2,'Iris-setosa'),(27,5,3.4,1.6,0.4,'Iris-setosa'),(28,5.2,3.5,NULL,0.2,'Iris-setosa'),(29,5.2,3.4,NULL,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,NULL,0.1,'Iris-setosa'),(34,5.5,4.2,NULL,0.2,'Iris-setosa'),(35,4.9,3.1,NULL,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,NULL,0.2,'Iris-setosa'),(38,4.9,3.1,1.5,0.1,'Iris-setosa'),(39,4.4,3,NULL,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,0.3,'Iris-setosa'),(43,4.4,3.2,NULL,0.2,'Iris-setosa'),(44,5,3.5,NULL,0.6,'Iris-setosa'),(45,5.1,3.8,NULL,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,NULL,1.5,'Iris-versicolor'),(54,5.5,2.3,NULL,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,NULL,1.3,'Iris-versicolor'),(57,6.3,3.3,NULL,1.6,'Iris-versicolor'),(58,4.9,2.4,NULL,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,NULL,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,NULL,1.5,'Iris-versicolor'),(63,6,2.2,NULL,1,'Iris-versicolor'),(64,6.1,2.9,NULL,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,NULL,1.4,'Iris-versicolor'),(67,5.6,3,NULL,1.5,'Iris-versicolor'),(68,5.8,2.7,NULL,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,NULL,1.1,'Iris-versicolor'),(71,5.9,3.2,NULL,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,NULL,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,NULL,1.5,'Iris-versicolor'),(80,5.7,2.6,NULL,1,'Iris-versicolor'),(81,5.5,2.4,NULL,1.1,'Iris-versicolor'),(82,5.5,2.4,NULL,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,NULL,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,NULL,1.6,'Iris-versicolor'),(87,6.7,3.1,4.7,1.5,'Iris-versicolor'),(88,6.3,2.3,NULL,1.3,'Iris-versicolor'),(89,5.6,3,4.1,1.3,'Iris-versicolor'),(90,5.5,2.5,NULL,1.3,'Iris-versicolor'),(91,5.5,2.6,NULL,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,NULL,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,NULL,1.3,'Iris-versicolor'),(98,6.2,2.9,NULL,1.3,'Iris-versicolor'),(99,5.1,2.5,3,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,NULL,2.1,'Iris-virginica'),(107,4.9,2.5,NULL,1.7,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,NULL,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,NULL,2,'Iris-virginica'),(112,6.4,2.7,NULL,1.9,'Iris-virginica'),(113,6.8,3,5.5,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,NULL,2.3,'Iris-virginica'),(117,6.5,3,NULL,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,NULL,1.5,'Iris-virginica'),(121,6.9,3.2,NULL,2.3,'Iris-virginica'),(122,5.6,2.8,NULL,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,NULL,1.8,'Iris-virginica'),(127,6.2,2.8,4.8,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,5.6,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,NULL,1.9,'Iris-virginica'),(132,7.9,3.8,NULL,2,'Iris-virginica'),(133,6.4,2.8,NULL,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,NULL,2.3,'Iris-virginica'),(137,6.3,3.4,NULL,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,NULL,1.8,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,NULL,2.3,'Iris-virginica'),(143,5.8,2.7,NULL,1.9,'Iris-virginica'),(144,6.8,3.2,NULL,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,NULL,2.3,'Iris-virginica'),(147,6.3,2.5,NULL,1.9,'Iris-virginica'),(148,6.5,3,NULL,2,'Iris-virginica'),(149,6.2,3.4,NULL,2.3,'Iris-virginica'),(150,5.9,3,5.1,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petallength_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petallength_40`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petallength_40` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petallength_40`;

--
-- Table structure for table `iris_mcar_petallength_40`
--

DROP TABLE IF EXISTS `iris_mcar_petallength_40`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petallength_40` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petallength_40`
--

LOCK TABLES `iris_mcar_petallength_40` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petallength_40` DISABLE KEYS */;
INSERT INTO `iris_mcar_petallength_40` VALUES (1,5.1,3.5,NULL,0.2,'Iris-setosa'),(2,4.9,3,NULL,0.2,'Iris-setosa'),(3,4.7,3.2,NULL,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,0.2,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,0.4,'Iris-setosa'),(7,4.6,3.4,NULL,0.3,'Iris-setosa'),(8,5,3.4,1.5,0.2,'Iris-setosa'),(9,4.4,2.9,NULL,0.2,'Iris-setosa'),(10,4.9,3.1,NULL,0.1,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,NULL,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,NULL,0.4,'Iris-setosa'),(17,5.4,3.9,1.3,0.4,'Iris-setosa'),(18,5.1,3.5,NULL,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,0.2,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,0.2,'Iris-setosa'),(24,5.1,3.3,1.7,0.5,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,NULL,0.2,'Iris-setosa'),(27,5,3.4,NULL,0.4,'Iris-setosa'),(28,5.2,3.5,NULL,0.2,'Iris-setosa'),(29,5.2,3.4,NULL,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,0.2,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,NULL,0.1,'Iris-setosa'),(34,5.5,4.2,NULL,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,NULL,0.2,'Iris-setosa'),(37,5.5,3.5,NULL,0.2,'Iris-setosa'),(38,4.9,3.1,NULL,0.1,'Iris-setosa'),(39,4.4,3,1.3,0.2,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,NULL,0.3,'Iris-setosa'),(43,4.4,3.2,1.3,0.2,'Iris-setosa'),(44,5,3.5,NULL,0.6,'Iris-setosa'),(45,5.1,3.8,1.9,0.4,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,0.2,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,0.2,'Iris-setosa'),(51,7,3.2,NULL,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,1.5,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,NULL,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,1.5,'Iris-versicolor'),(56,5.7,2.8,NULL,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,NULL,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,1.4,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,NULL,1.5,'Iris-versicolor'),(63,6,2.2,NULL,1,'Iris-versicolor'),(64,6.1,2.9,NULL,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,1.3,'Iris-versicolor'),(66,6.7,3.1,NULL,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,NULL,1,'Iris-versicolor'),(69,6.2,2.2,NULL,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,1.8,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,NULL,1.5,'Iris-versicolor'),(74,6.1,2.8,NULL,1.2,'Iris-versicolor'),(75,6.4,2.9,NULL,1.3,'Iris-versicolor'),(76,6.6,3,NULL,1.4,'Iris-versicolor'),(77,6.8,2.8,NULL,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,1,'Iris-versicolor'),(81,5.5,2.4,3.8,1.1,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,1.2,'Iris-versicolor'),(84,6,2.7,5.1,1.6,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,1.6,'Iris-versicolor'),(87,6.7,3.1,NULL,1.5,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,NULL,1.3,'Iris-versicolor'),(90,5.5,2.5,NULL,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,1.2,'Iris-versicolor'),(92,6.1,3,4.6,1.4,'Iris-versicolor'),(93,5.8,2.6,NULL,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,1.3,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,NULL,1.1,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,NULL,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,1.9,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,1.8,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,NULL,2.1,'Iris-virginica'),(107,4.9,2.5,NULL,1.7,'Iris-virginica'),(108,7.3,2.9,NULL,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,1.8,'Iris-virginica'),(110,7.2,3.6,6.1,2.5,'Iris-virginica'),(111,6.5,3.2,NULL,2,'Iris-virginica'),(112,6.4,2.7,NULL,1.9,'Iris-virginica'),(113,6.8,3,NULL,2.1,'Iris-virginica'),(114,5.7,2.5,5,2,'Iris-virginica'),(115,5.8,2.8,NULL,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,NULL,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,2,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,2.1,'Iris-virginica'),(126,7.2,3.2,NULL,1.8,'Iris-virginica'),(127,6.2,2.8,NULL,1.8,'Iris-virginica'),(128,6.1,3,4.9,1.8,'Iris-virginica'),(129,6.4,2.8,NULL,2.1,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,NULL,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,1.5,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,2.3,'Iris-virginica'),(137,6.3,3.4,NULL,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,NULL,1.8,'Iris-virginica'),(140,6.9,3.1,NULL,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,2.4,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,NULL,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,2.5,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,NULL,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,NULL,2.3,'Iris-virginica'),(150,5.9,3,NULL,1.8,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petallength_40` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `jb_iris_mcar_petalwidth_40`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jb_iris_mcar_petalwidth_40` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jb_iris_mcar_petalwidth_40`;

--
-- Table structure for table `iris_mcar_petalwidth_40`
--

DROP TABLE IF EXISTS `iris_mcar_petalwidth_40`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris_mcar_petalwidth_40` (
  `id` int(11) NOT NULL,
  `sepal_length` double DEFAULT NULL,
  `sepal_width` double DEFAULT NULL,
  `petal_length` double DEFAULT NULL,
  `petal_width` double DEFAULT NULL,
  `class` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris_mcar_petalwidth_40`
--

LOCK TABLES `iris_mcar_petalwidth_40` WRITE;
/*!40000 ALTER TABLE `iris_mcar_petalwidth_40` DISABLE KEYS */;
INSERT INTO `iris_mcar_petalwidth_40` VALUES (1,5.1,3.5,1.4,NULL,'Iris-setosa'),(2,4.9,3,1.4,0.2,'Iris-setosa'),(3,4.7,3.2,1.3,0.2,'Iris-setosa'),(4,4.6,3.1,1.5,NULL,'Iris-setosa'),(5,5,3.6,1.4,0.2,'Iris-setosa'),(6,5.4,3.9,1.7,NULL,'Iris-setosa'),(7,4.6,3.4,1.4,NULL,'Iris-setosa'),(8,5,3.4,1.5,NULL,'Iris-setosa'),(9,4.4,2.9,1.4,0.2,'Iris-setosa'),(10,4.9,3.1,1.5,NULL,'Iris-setosa'),(11,5.4,3.7,1.5,0.2,'Iris-setosa'),(12,4.8,3.4,1.6,0.2,'Iris-setosa'),(13,4.8,3,1.4,0.1,'Iris-setosa'),(14,4.3,3,1.1,0.1,'Iris-setosa'),(15,5.8,4,1.2,0.2,'Iris-setosa'),(16,5.7,4.4,1.5,NULL,'Iris-setosa'),(17,5.4,3.9,1.3,NULL,'Iris-setosa'),(18,5.1,3.5,1.4,0.3,'Iris-setosa'),(19,5.7,3.8,1.7,0.3,'Iris-setosa'),(20,5.1,3.8,1.5,0.3,'Iris-setosa'),(21,5.4,3.4,1.7,NULL,'Iris-setosa'),(22,5.1,3.7,1.5,0.4,'Iris-setosa'),(23,4.6,3.6,1,NULL,'Iris-setosa'),(24,5.1,3.3,1.7,NULL,'Iris-setosa'),(25,4.8,3.4,1.9,0.2,'Iris-setosa'),(26,5,3,1.6,NULL,'Iris-setosa'),(27,5,3.4,1.6,NULL,'Iris-setosa'),(28,5.2,3.5,1.5,0.2,'Iris-setosa'),(29,5.2,3.4,1.4,0.2,'Iris-setosa'),(30,4.7,3.2,1.6,0.2,'Iris-setosa'),(31,4.8,3.1,1.6,NULL,'Iris-setosa'),(32,5.4,3.4,1.5,0.4,'Iris-setosa'),(33,5.2,4.1,1.5,NULL,'Iris-setosa'),(34,5.5,4.2,1.4,0.2,'Iris-setosa'),(35,4.9,3.1,1.5,0.1,'Iris-setosa'),(36,5,3.2,1.2,0.2,'Iris-setosa'),(37,5.5,3.5,1.3,NULL,'Iris-setosa'),(38,4.9,3.1,1.5,NULL,'Iris-setosa'),(39,4.4,3,1.3,NULL,'Iris-setosa'),(40,5.1,3.4,1.5,0.2,'Iris-setosa'),(41,5,3.5,1.3,0.3,'Iris-setosa'),(42,4.5,2.3,1.3,NULL,'Iris-setosa'),(43,4.4,3.2,1.3,NULL,'Iris-setosa'),(44,5,3.5,1.6,NULL,'Iris-setosa'),(45,5.1,3.8,1.9,NULL,'Iris-setosa'),(46,4.8,3,1.4,0.3,'Iris-setosa'),(47,5.1,3.8,1.6,NULL,'Iris-setosa'),(48,4.6,3.2,1.4,0.2,'Iris-setosa'),(49,5.3,3.7,1.5,0.2,'Iris-setosa'),(50,5,3.3,1.4,NULL,'Iris-setosa'),(51,7,3.2,4.7,1.4,'Iris-versicolor'),(52,6.4,3.2,4.5,NULL,'Iris-versicolor'),(53,6.9,3.1,4.9,1.5,'Iris-versicolor'),(54,5.5,2.3,4,1.3,'Iris-versicolor'),(55,6.5,2.8,4.6,NULL,'Iris-versicolor'),(56,5.7,2.8,4.5,1.3,'Iris-versicolor'),(57,6.3,3.3,4.7,1.6,'Iris-versicolor'),(58,4.9,2.4,3.3,1,'Iris-versicolor'),(59,6.6,2.9,4.6,1.3,'Iris-versicolor'),(60,5.2,2.7,3.9,NULL,'Iris-versicolor'),(61,5,2,3.5,1,'Iris-versicolor'),(62,5.9,3,4.2,NULL,'Iris-versicolor'),(63,6,2.2,4,1,'Iris-versicolor'),(64,6.1,2.9,4.7,1.4,'Iris-versicolor'),(65,5.6,2.9,3.6,NULL,'Iris-versicolor'),(66,6.7,3.1,4.4,1.4,'Iris-versicolor'),(67,5.6,3,4.5,1.5,'Iris-versicolor'),(68,5.8,2.7,4.1,1,'Iris-versicolor'),(69,6.2,2.2,4.5,1.5,'Iris-versicolor'),(70,5.6,2.5,3.9,1.1,'Iris-versicolor'),(71,5.9,3.2,4.8,NULL,'Iris-versicolor'),(72,6.1,2.8,4,1.3,'Iris-versicolor'),(73,6.3,2.5,4.9,1.5,'Iris-versicolor'),(74,6.1,2.8,4.7,1.2,'Iris-versicolor'),(75,6.4,2.9,4.3,1.3,'Iris-versicolor'),(76,6.6,3,4.4,1.4,'Iris-versicolor'),(77,6.8,2.8,4.8,1.4,'Iris-versicolor'),(78,6.7,3,5,1.7,'Iris-versicolor'),(79,6,2.9,4.5,1.5,'Iris-versicolor'),(80,5.7,2.6,3.5,NULL,'Iris-versicolor'),(81,5.5,2.4,3.8,NULL,'Iris-versicolor'),(82,5.5,2.4,3.7,1,'Iris-versicolor'),(83,5.8,2.7,3.9,NULL,'Iris-versicolor'),(84,6,2.7,5.1,NULL,'Iris-versicolor'),(85,5.4,3,4.5,1.5,'Iris-versicolor'),(86,6,3.4,4.5,NULL,'Iris-versicolor'),(87,6.7,3.1,4.7,NULL,'Iris-versicolor'),(88,6.3,2.3,4.4,1.3,'Iris-versicolor'),(89,5.6,3,4.1,NULL,'Iris-versicolor'),(90,5.5,2.5,4,1.3,'Iris-versicolor'),(91,5.5,2.6,4.4,NULL,'Iris-versicolor'),(92,6.1,3,4.6,NULL,'Iris-versicolor'),(93,5.8,2.6,4,1.2,'Iris-versicolor'),(94,5,2.3,3.3,1,'Iris-versicolor'),(95,5.6,2.7,4.2,NULL,'Iris-versicolor'),(96,5.7,3,4.2,1.2,'Iris-versicolor'),(97,5.7,2.9,4.2,1.3,'Iris-versicolor'),(98,6.2,2.9,4.3,1.3,'Iris-versicolor'),(99,5.1,2.5,3,NULL,'Iris-versicolor'),(100,5.7,2.8,4.1,1.3,'Iris-versicolor'),(101,6.3,3.3,6,2.5,'Iris-virginica'),(102,5.8,2.7,5.1,NULL,'Iris-virginica'),(103,7.1,3,5.9,2.1,'Iris-virginica'),(104,6.3,2.9,5.6,NULL,'Iris-virginica'),(105,6.5,3,5.8,2.2,'Iris-virginica'),(106,7.6,3,6.6,2.1,'Iris-virginica'),(107,4.9,2.5,4.5,NULL,'Iris-virginica'),(108,7.3,2.9,6.3,1.8,'Iris-virginica'),(109,6.7,2.5,5.8,NULL,'Iris-virginica'),(110,7.2,3.6,6.1,NULL,'Iris-virginica'),(111,6.5,3.2,5.1,2,'Iris-virginica'),(112,6.4,2.7,5.3,1.9,'Iris-virginica'),(113,6.8,3,5.5,NULL,'Iris-virginica'),(114,5.7,2.5,5,NULL,'Iris-virginica'),(115,5.8,2.8,5.1,2.4,'Iris-virginica'),(116,6.4,3.2,5.3,2.3,'Iris-virginica'),(117,6.5,3,5.5,1.8,'Iris-virginica'),(118,7.7,3.8,6.7,2.2,'Iris-virginica'),(119,7.7,2.6,6.9,2.3,'Iris-virginica'),(120,6,2.2,5,1.5,'Iris-virginica'),(121,6.9,3.2,5.7,2.3,'Iris-virginica'),(122,5.6,2.8,4.9,2,'Iris-virginica'),(123,7.7,2.8,6.7,NULL,'Iris-virginica'),(124,6.3,2.7,4.9,1.8,'Iris-virginica'),(125,6.7,3.3,5.7,NULL,'Iris-virginica'),(126,7.2,3.2,6,NULL,'Iris-virginica'),(127,6.2,2.8,4.8,NULL,'Iris-virginica'),(128,6.1,3,4.9,NULL,'Iris-virginica'),(129,6.4,2.8,5.6,NULL,'Iris-virginica'),(130,7.2,3,5.8,1.6,'Iris-virginica'),(131,7.4,2.8,6.1,1.9,'Iris-virginica'),(132,7.9,3.8,6.4,2,'Iris-virginica'),(133,6.4,2.8,5.6,2.2,'Iris-virginica'),(134,6.3,2.8,5.1,NULL,'Iris-virginica'),(135,6.1,2.6,5.6,1.4,'Iris-virginica'),(136,7.7,3,6.1,NULL,'Iris-virginica'),(137,6.3,3.4,5.6,2.4,'Iris-virginica'),(138,6.4,3.1,5.5,1.8,'Iris-virginica'),(139,6,3,4.8,NULL,'Iris-virginica'),(140,6.9,3.1,5.4,2.1,'Iris-virginica'),(141,6.7,3.1,5.6,NULL,'Iris-virginica'),(142,6.9,3.1,5.1,2.3,'Iris-virginica'),(143,5.8,2.7,5.1,1.9,'Iris-virginica'),(144,6.8,3.2,5.9,2.3,'Iris-virginica'),(145,6.7,3.3,5.7,NULL,'Iris-virginica'),(146,6.7,3,5.2,2.3,'Iris-virginica'),(147,6.3,2.5,5,1.9,'Iris-virginica'),(148,6.5,3,5.2,2,'Iris-virginica'),(149,6.2,3.4,5.4,2.3,'Iris-virginica'),(150,5.9,3,5.1,NULL,'Iris-virginica');
/*!40000 ALTER TABLE `iris_mcar_petalwidth_40` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 16:23:04
