-- MariaDB dump 10.19  Distrib 10.4.20-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: pastelesalex
-- ------------------------------------------------------
-- Server version	10.4.20-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administracion`
--

DROP TABLE IF EXISTS `administracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administracion` (
  `id_administrador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_administrador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administracion`
--

LOCK TABLES `administracion` WRITE;
/*!40000 ALTER TABLE `administracion` DISABLE KEYS */;
INSERT INTO `administracion` VALUES (1,'Kevin Alexander','Sánchez','Torres','5512345678','kev@gmail.com','kevin');
/*!40000 ALTER TABLE `administracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` varchar(36) DEFAULT NULL,
  `id_producto` varchar(10) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,'87258b4f-006d-449c-8eff-051be16a3263','VA1002',3),(2,'87258b4f-006d-449c-8eff-051be16a3263','VA1003',4),(3,'420dc112-aab5-417e-9ed3-b088b0673a22','FT1002',4),(4,'420dc112-aab5-417e-9ed3-b088b0673a22','VA1001',2),(5,'ef52aba0-26d8-4eff-aad9-51072ef2df48','CH1001',5),(6,'ef52aba0-26d8-4eff-aad9-51072ef2df48','FS1001',3),(7,'41f537ba-443c-4d76-8a39-2311dbbe8061','CH1002',1),(8,'1a90b484-d262-4407-8585-43c6542131e5','3L1003',1),(9,'400fcd20-2212-4bfd-a8ed-79c3cf5e18a4','VA1001',1),(10,'847a9ed3-990a-4612-84df-44ff5e3b363a','VA1001',2),(11,'5a57bc91-d047-4203-9cab-14fbb49c2277','FL1004',1);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmaciones`
--

DROP TABLE IF EXISTS `confirmaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confirmaciones` (
  `id_confirmacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` varchar(36) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `pagado` varchar(3) DEFAULT NULL,
  `fecha_hora_estado` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id_confirmacion`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmaciones`
--

LOCK TABLES `confirmaciones` WRITE;
/*!40000 ALTER TABLE `confirmaciones` DISABLE KEYS */;
INSERT INTO `confirmaciones` VALUES (1,'87258b4f-006d-449c-8eff-051be16a3263','CANCELADO','NO','2023-12-28 08:11:47'),(3,'420dc112-aab5-417e-9ed3-b088b0673a22','PENDIENTE','NO','2023-12-28 18:50:28'),(4,'ef52aba0-26d8-4eff-aad9-51072ef2df48','ENTREGADO','SI','2023-12-30 21:45:34'),(5,'41f537ba-443c-4d76-8a39-2311dbbe8061','CANCELADO','NO','2023-12-28 21:03:31'),(6,'1a90b484-d262-4407-8585-43c6542131e5','CANCELADO','NO','2023-12-28 21:05:41'),(7,'400fcd20-2212-4bfd-a8ed-79c3cf5e18a4','ENTREGADO','SI','2023-12-28 21:21:06'),(8,'847a9ed3-990a-4612-84df-44ff5e3b363a','ENTREGADO','SI','2023-12-29 08:21:34'),(9,'5a57bc91-d047-4203-9cab-14fbb49c2277','ENTREGADO','SI','2023-12-30 21:38:57');
/*!40000 ALTER TABLE `confirmaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_tarjeta`
--

DROP TABLE IF EXISTS `datos_tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_tarjeta` (
  `id_dato_envio` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `numero_tarjeta` varchar(16) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `cvv` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_dato_envio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_tarjeta`
--

LOCK TABLES `datos_tarjeta` WRITE;
/*!40000 ALTER TABLE `datos_tarjeta` DISABLE KEYS */;
INSERT INTO `datos_tarjeta` VALUES (1,2,'5ta de Juan','CDMX','55654','1234567898765432','2025-02-03','123');
/*!40000 ALTER TABLE `datos_tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasteles`
--

DROP TABLE IF EXISTS `pasteles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasteles` (
  `id_producto` varchar(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `img_producto` varchar(50) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `tamaño` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasteles`
--

LOCK TABLES `pasteles` WRITE;
/*!40000 ALTER TABLE `pasteles` DISABLE KEYS */;
INSERT INTO `pasteles` VALUES ('3L1001','Esponjosidad de Tres Leches','leches.PNG','TLeches, Frutas, Flores, Blanco, Grande',1200,'31cm'),('3L1002','Trío Lechoso de Vainilla y Caramelo','leches2.PNG','TLeches, Vainilla, Chocolate',900,'28cm'),('3L1003','Sueño Lechero de Chocolate Blanco','leches3.PNG','TLeches, Vainilla, Blanco, Pequeno',400,'17cm'),('CH1001','Delicia de Chocolate Negro','chocolate.PNG','Chocolate, Popular',555,'27cm'),('CH1002','Sueño de Cacao Intenso','chocolate2.PNG','Chocolate, Flores, Blanco',475,'25cm'),('CH1003','Volcán de Chocolate Dulce','chocolate3.PNG','Chocolate, Frutas, Moras',825,'28cm'),('CH1004','Tentación de Chocolate Suave','chocolate4.PNG','Chocolate, Flores',800,'28cm'),('FL1001','Jardín en la Mesa','flores.PNG','Flores, Vainilla, Blanco',750,'20cm'),('FL1002','Éxtasis Floral de Vainilla','flores2.PNG','Flores, Vainilla, Blanco, Popular',900,'28cm'),('FL1003','Primavera en Capas de Fresa','flores3.PNG','Flores, Chocolate, Pequeno',500,'15cm'),('FL1004','Dulce Rosaleda de Chocolate Blanco','flores4.PNG','Flores, Vainilla, Blanco',830,'27cm'),('FS1001','Beso de Fresa y Crema','fresas.PNG','Fresa, Flores, Popular',780,'27cm'),('FS1002','Delirio Chocolatoso de Fresa Fresca','fresas2.PNG','Fresa, Flores, Frutas, Chocolate, Grande',1050,'30cm'),('FT1001','Explosión Tropical de Frutas','frutas.PNG','Frutas, Flores, Chocolate, Blanco, Pequeno',610,'17cm'),('FT1002','Arcoíris de Frutas Frescas','frutas2.PNG','Frutas, Vainilla, Blanco, Popular',810,'26cm'),('MO1001','Magia de Mora Salvaje','moras.PNG','Moras, Frutas, Flores, Pequeno',600,'18cm'),('MO1002','Explosión de Mora y Chocolate','moras2.PNG','Moras, Frutas, Chocolate',840,'25cm'),('VA1001','Vainilla Encantada','vainilla.PNG','Vainilla, Grande',1300,'35cm'),('VA1002','Deseo de Vainilla y Canela','vainilla2.PNG','Vainilla, Flores, Grande',1350,'34cm'),('VA1003','Sueño Suave de Vainilla y Almendra','vainilla3.PNG','Vainilla, Flores',550,'26cm');
/*!40000 ALTER TABLE `pasteles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id_pedido` varchar(36) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `direccion_envio` varchar(255) DEFAULT NULL,
  `total` decimal(7,2) DEFAULT NULL,
  `fecha_hora_compra` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES ('1a90b484-d262-4407-8585-43c6542131e5',1,'aca',400.00,'2023-12-28 21:05:41'),('400fcd20-2212-4bfd-a8ed-79c3cf5e18a4',1,'aqui',1300.00,'2023-12-28 21:21:06'),('41f537ba-443c-4d76-8a39-2311dbbe8061',1,'',475.00,'2023-12-28 21:03:31'),('420dc112-aab5-417e-9ed3-b088b0673a22',1,'ESCOM, CDMX',5840.00,'2023-12-28 18:50:28'),('5a57bc91-d047-4203-9cab-14fbb49c2277',1,'ESCOM, CDMX, 55764',830.00,'2023-12-30 21:38:57'),('847a9ed3-990a-4612-84df-44ff5e3b363a',2,'Calle Juan c32, CDMX, 55764',2600.00,'2023-12-29 08:21:34'),('87258b4f-006d-449c-8eff-051be16a3263',1,NULL,6250.00,'2023-12-28 08:11:47'),('ef52aba0-26d8-4eff-aad9-51072ef2df48',1,'5ta de Juan, CDMX, 55764',5115.00,'2023-12-28 21:00:59');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `fecha_hora_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Kevin','Sánchez','T','5621560564','kevalexan@gmail.com','kevin','2023-12-26 21:16:58'),(2,'Jose','Madero','Vizcano','5512345678','josem@gmail.com','Josemv1+','2023-12-29 08:19:09');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-30 15:50:04
