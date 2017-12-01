CREATE DATABASE  IF NOT EXISTS `webentrega` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webentrega`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: webentrega
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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `id_administrador` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_administrador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'Melquisedeque','admin@email.com','102030');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atualizacao`
--

DROP TABLE IF EXISTS `atualizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atualizacao` (
  `id_atualizacao` int(11) NOT NULL AUTO_INCREMENT,
  `local` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `id_entrega` int(11) NOT NULL,
  PRIMARY KEY (`id_atualizacao`),
  KEY `fk01_idx` (`id_entrega`),
  CONSTRAINT `fk01` FOREIGN KEY (`id_entrega`) REFERENCES `pedido` (`id_entrega`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atualizacao`
--

LOCK TABLES `atualizacao` WRITE;
/*!40000 ALTER TABLE `atualizacao` DISABLE KEYS */;
INSERT INTO `atualizacao` VALUES (1,'XXX','XXX','XX','Em andamento',3),(2,'XXX','XXX','XXX','Saiu para entrega',3),(3,'XXX','XXX','12:00','Entregue',3);
/*!40000 ALTER TABLE `atualizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` double NOT NULL,
  `prazo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cidade`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Barbacena',99.99,'8 dias úteis'),(3,'Montes Claros',80.72,'5 dias úteis'),(4,'Abadia dos Dourados',103.1,'10 dias úteis'),(5,'Bicas',127.9,'10 dias úteis'),(6,'Campos Altos',57.9,'3 dias úteis'),(7,'Descoberto',99.73,'6 dias úteis'),(8,'Itaguara',105.77,'5 dias úteis');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Matheus','matheus@email.com','102030','José Antônio Benhame','Progresso','412','36050-330'),(2,'Marcos','marcos@email.com','102030','Santo Antônio','Linhares','798','36022-991'),(3,'Lucas','lucas@email.com','102030','Orlinda Cruz','Jóquei','74','36050-994'),(4,'João','joao@email.com','102030','Olavo Costa','Parque Guarani','997','78905-123'),(5,'Elisangela','elisangela@eli.com','123','José antonio benhame','progresso','412','36050-330'),(6,'Ester','ester@hotmail.com','123','Rua José antônio Behame','Progresso','412','36050-330');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorista`
--

DROP TABLE IF EXISTS `motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motorista` (
  `id_motorista` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_motorista`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorista`
--

LOCK TABLES `motorista` WRITE;
/*!40000 ALTER TABLE `motorista` DISABLE KEYS */;
INSERT INTO `motorista` VALUES (1,'Bino','bino@bino.com','123'),(2,'Pedro','pedro@pedro','102030'),(3,'Tião','tiao@tiao.com','147'),(4,'Chiquinho','chiquinho@hotmail.com','2020');
/*!40000 ALTER TABLE `motorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id_entrega` int(11) NOT NULL AUTO_INCREMENT,
  `id_cidade` int(13) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `id_tipo` int(13) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_motorista` int(13) DEFAULT NULL,
  PRIMARY KEY (`id_entrega`),
  KEY `001_idx` (`id_cliente`),
  KEY `002_idx` (`id_tipo`),
  KEY `003_idx` (`id_motorista`),
  KEY `004_idx` (`id_cidade`),
  CONSTRAINT `001` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `002` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `003` FOREIGN KEY (`id_motorista`) REFERENCES `motorista` (`id_motorista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `004` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,'Rua São Pedro','Linhares','10','80701-456',3,1,4),(2,1,'Rua São Pedro','São Pedro','140','30050-870',1,1,4),(3,1,'São Sebastião','Santa Luzia','89','80901-124',2,6,4),(4,8,'Rua Geraldo','Sagrado','10','45610-124',2,4,4),(5,3,'xx','xx','1','1',1,5,4),(6,5,'xx','xx','2','2',2,2,4),(7,1,'xx','xx','1','2',2,3,4),(8,7,'xx','xx','897','78911-145',3,5,2);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Moto',11.81),(2,'Carro',67.99),(3,'Caminhão',198.63);
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 20:45:25
