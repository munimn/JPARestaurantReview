-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `idreview` varchar(200) NOT NULL,
  `userid` varchar(200) DEFAULT NULL,
  `restaurantid` varchar(200) DEFAULT NULL,
  `review` varchar(1000) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `foodquality` int DEFAULT NULL,
  `ambiance` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`idreview`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES ('3d43d192-f8e1-11ee-8c60-29bf4416a3ef','31fb92bc-f8e0-11ee-8c60-29bf4416a3ef','983d2b6c-f8e0-11ee-8c60-29bf4416a3ef','Very Good Burgers','2023-02-21 06:00:00',5,5,5),('41013186-f8e5-11ee-8c60-29bf4416a3ef','31fb92bc-f8e0-11ee-8c60-29bf4416a3ef','983d2b6c-f8e0-11ee-8c60-29bf4416a3ef','Very Good Burgers','2022-02-21 06:00:00',5,2,5),('52d3d490-f88b-11ee-8c60-29bf4416a3ef','c9152b76-f85a-11ee-8c60-29bf4416a3ef','9a71d9e0-f864-11ee-8c60-29bf4416a3ef','tasty','2023-02-01 06:00:00',5,4,5),('82ed81d0-f89a-11ee-8c60-29bf4416a3ef','c9152b76-f85a-11ee-8c60-29bf4416a3ef','9a71d9e0-f864-11ee-8c60-29bf4416a3ef','tasty','2023-02-01 06:00:00',5,4,5),('9af40c1e-f88a-11ee-8c60-29bf4416a3ef','c9152b76-f85a-11ee-8c60-29bf4416a3ef','9a71d9e0-f864-11ee-8c60-29bf4416a3ef','Great food, loved the ambiance, slightly pricey but worth it.','2023-04-01 07:00:00',5,4,4);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-02 21:17:46
