-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: sysdebit
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `documento` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tipo` enum('credor','devedor') DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divida`
--

DROP TABLE IF EXISTS `divida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `divida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credor` int(11) DEFAULT NULL,
  `devedor` int(11) DEFAULT NULL,
  `data_atualizacao` date DEFAULT NULL,
  `valor_divida` float DEFAULT NULL,
  `pago` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `credor` (`credor`),
  KEY `devedor` (`devedor`),
  CONSTRAINT `divida_ibfk_1` FOREIGN KEY (`credor`) REFERENCES `cliente` (`id`),
  CONSTRAINT `divida_ibfk_2` FOREIGN KEY (`devedor`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divida`
--

LOCK TABLES `divida` WRITE;
/*!40000 ALTER TABLE `divida` DISABLE KEYS */;
/*!40000 ALTER TABLE `divida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscreve_divida`
--

DROP TABLE IF EXISTS `inscreve_divida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inscreve_divida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_inscricao` date DEFAULT NULL,
  `id_usuario` varchar(35) DEFAULT NULL,
  `id_devedor` int(11) DEFAULT NULL,
  `id_credor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_devedor` (`id_devedor`),
  KEY `id_credor` (`id_credor`),
  CONSTRAINT `inscreve_divida_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`login`),
  CONSTRAINT `inscreve_divida_ibfk_2` FOREIGN KEY (`id_devedor`) REFERENCES `cliente` (`id`),
  CONSTRAINT `inscreve_divida_ibfk_3` FOREIGN KEY (`id_credor`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscreve_divida`
--

LOCK TABLES `inscreve_divida` WRITE;
/*!40000 ALTER TABLE `inscreve_divida` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscreve_divida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `divida` int(11) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `valor_pago` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `divida` (`divida`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`divida`) REFERENCES `divida` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registra_pagamento`
--

DROP TABLE IF EXISTS `registra_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registra_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_pagamento` date DEFAULT NULL,
  `id_usuario` varchar(35) DEFAULT NULL,
  `id_devedor` int(11) DEFAULT NULL,
  `id_credor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_devedor` (`id_devedor`),
  KEY `id_credor` (`id_credor`),
  CONSTRAINT `registra_pagamento_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`login`),
  CONSTRAINT `registra_pagamento_ibfk_2` FOREIGN KEY (`id_devedor`) REFERENCES `cliente` (`id`),
  CONSTRAINT `registra_pagamento_ibfk_3` FOREIGN KEY (`id_credor`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registra_pagamento`
--

LOCK TABLES `registra_pagamento` WRITE;
/*!40000 ALTER TABLE `registra_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `registra_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `nome` varchar(40) DEFAULT NULL,
  `cargo` varchar(35) DEFAULT NULL,
  `login` varchar(35) NOT NULL,
  `senha` varchar(35) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('admin','Administrador','admin','admin','admin@admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sysdebit'
--

--
-- Dumping routines for database 'sysdebit'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-25 11:11:21
