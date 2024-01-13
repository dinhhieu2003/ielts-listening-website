-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: luyenngheielts
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bode`
--

DROP TABLE IF EXISTS `bode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bode` (
  `MaBoDe` int NOT NULL AUTO_INCREMENT,
  `TenBoDe` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`MaBoDe`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bode`
--

LOCK TABLES `bode` WRITE;
/*!40000 ALTER TABLE `bode` DISABLE KEYS */;
INSERT INTO `bode` VALUES (1,'IELTS C18 Full Test 1'),(2,'IELTS C18 Full Test 2'),(3,'IELTS C18 Full Test 3'),(4,'IELTS C18 Full Test 4'),(5,'IELTS C18 Full Test 5'),(6,'IELTS C18 Full Test 6'),(7,'IELTS C18 Full Test 7'),(8,'IELTS C18 Full Test 8'),(9,'IELTS C18 Full Test 9'),(10,'IELTS C18 Full Test 10');
/*!40000 ALTER TABLE `bode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cauhoi`
--

DROP TABLE IF EXISTS `cauhoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cauhoi` (
  `MaCauHoi` int NOT NULL AUTO_INCREMENT,
  `AnhCauHoi` varchar(2000) DEFAULT NULL,
  `NoiDungCauHoi` varchar(2000) DEFAULT NULL,
  `MaLoaiCauHoi` int NOT NULL,
  `MaPart` int NOT NULL,
  `MaDeThi` int NOT NULL,
  `GiaiThich` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`MaCauHoi`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoi`
--

LOCK TABLES `cauhoi` WRITE;
/*!40000 ALTER TABLE `cauhoi` DISABLE KEYS */;
INSERT INTO `cauhoi` VALUES (1,'1.num1-5','<h4 style=\"font-weight: bold;\">SECTION 1\r\n<h4 style=\"font-weight: bold;\">Question 1-5\r\n<h4>Complete the table below. Write ONE WORD AND/OR NUMBERS for each answer.',2,1,1,NULL),(2,NULL,'',2,1,1,NULL),(3,NULL,'',2,1,1,NULL),(4,NULL,'',2,1,1,NULL),(5,NULL,'',2,1,1,NULL),(6,NULL,'<h4 style=\"font-weight: bold;\">Question 6 -10\r\n<h4>Complete the notes below. Write ONE WORD ONLY for each answer.\r\n<h4>Notes on Jobs\r\n<h4>• Local jobs can be found in the 6 ......................... \r\n<h4>• Buy the 7......................... to get one free magazine (Job Plus) \r\n<h4>• Feel stress and spend a lot of time looking for jobs \r\n<h4>• Advisable to go to an 8 ......................... instead of the recruitment seminar \r\n<h4>• Bring a student card (10% discount) \r\n<h4>• Referee: - former boss (once had a job) - one of the 9 ......................... (if not) \r\n<h4>• Intend to take the art course • Fill out a 10 ......................... form at the end of the course',2,1,1,NULL),(7,NULL,'',2,1,1,NULL),(8,NULL,'',2,1,1,NULL),(9,NULL,'',2,1,1,NULL),(10,NULL,'',2,1,1,NULL),(11,NULL,'<h4 style=\"font-weight: bold;\">SECTION 2\r\n<h4 style=\"font-weight: bold;\">Question 11 - 15\r\n<h4>Choose the correct letter, A, B or C. \r\n<h4>11 The reason why David is replacing Jane is that\r\n<h4>A. she is unwell. \r\n<h4>B. she is very busy. \r\n<h4>C. she is inexperienced. ',3,2,1,NULL),(12,NULL,'<h4>12 According to the speaker, what is the problem for the museum currently?\r\n<h4>A. lack of staff \r\n<h4>B. lack of publicity \r\n<h4>C. lack of money ',3,2,1,NULL),(13,NULL,'<h4>13 Why were the thieves able to successfully steal the statue?\r\n<h4>A. The security device is outdated.\r\n<h4>B. The security guard is not well-trained. \r\n<h4>C. They knew what they were searching for.',3,2,1,NULL),(14,NULL,'<h4>14 In order to improve security, they are going to\r\n<h4>A. get more closed-circuit television cameras. \r\n<h4>B. hire more security guards. \r\n<h4>C. buy more computers. ',3,2,1,NULL),(15,NULL,'<h4>15 What kind of librarian are they looking for?\r\n<h4>A. responsible \r\n<h4>B. experienced \r\n<h4>C. highly-trained ',3,2,1,NULL),(16,'1.num16-20','<h4 style=\"font-weight: bold;\">Question 16 - 20\r\n<h4>Label the map below. Write the correct letter, A-H, next to questions 16-20. \r\n<h4>16 Box Office .................... \r\n<h4>17 Children’s Room .................... \r\n<h4>18 Cafe .................... \r\n<h4>19 Multimedia Room .................... \r\n<h4>20 Showroom .................... ',1,2,1,NULL),(17,NULL,'',1,2,1,NULL),(18,NULL,'',1,2,1,NULL),(19,NULL,'',1,2,1,NULL),(20,NULL,'',1,2,1,NULL),(21,NULL,'<h4 style=\"font-weight: bold;\">SECTION 3\r\n<h4 style=\"font-weight: bold;\">Question 21 - 26\r\n<h4>Choose the correct letter, A, B or C.\r\n<h4>21 What field is Willows currently focused on?\r\n<h4>A. Specialising in one product\r\n<h4>B. making a variety of products\r\n<h4>C. adding a lot of retial outlet',1,3,1,NULL),(22,NULL,'<h4>22. How did the students feel about the software?</h4>\r\n<h4>A. The professor contacted the company. </h4>\r\n<h4>B. An article was read in a newspaper</h4>\r\n<h4>C. A student work their part-time during the vacations.</h4>',1,3,1,NULL),(23,NULL,'<h4>23. How did the student fell about the software\r\n<h4>A. It’s not easy to predict. \r\n<h4>B. It’s slow for drawing designs\r\n<h4>C. It had a good interface.',1,3,1,NULL),(24,NULL,'<h4>24 How did the students find out about the effects of the software on the company?\r\n<h4>A. They went to the IT department. \r\n<h4>B. They talked with the manager. \r\n<h4>C. They inspected the accounts.',1,3,1,NULL),(25,NULL,'<h4>25 The reason why the students have a face-to-face interview alone is that\r\n<h4>A. they could prepare for exams. \r\n<h4>B. there will be less disturbance. \r\n<h4>C. it\'s less realistic.',1,3,1,NULL),(26,NULL,'<h4>26 How did the two students perform in the exam?\r\n<h4>A. very disappointing\r\n<h4>B. significantly good\r\n<h4>C. above the average',1,3,1,NULL),(27,NULL,'<h4 style=\"font-weight: bold;\">Question 27 - 28\r\n<h4>Choose TWO letters, A-E.\r\n<h4>In which TWO ways will the new system affect the company?\r\n<h4>A. gain more profit\r\n<h4>B. employ more new staff\r\n<h4>C. increase sales\r\n<h4>D. reduce production time\r\n<h4>E. cut labour costs',1,3,1,NULL),(28,NULL,'',1,3,1,NULL),(29,NULL,'<h4 style=\"font-weight: bold;\">Questions 29 and 30\r\n<h4>Choose TWO letters, A-E\r\n<h4>Which TWO effects will the new system have on new clients?\r\n<h4>A. getting more involved in the design\r\n<h4>B. obtaining more contacts\r\n<h4>C. linking at home to do online work\r\n<h4>D. wasting less time\r\n<h4>E. decreasing labour costs',1,3,1,NULL),(30,NULL,'',1,3,1,NULL),(31,NULL,'<h4 style=\"font-weight: bold;\">SECTION 4\r\n<h4>Complete the notes below. \r\n<h4>Write ONE WORD ONLY for each answer. \r\n<h4>------------------------ A Survey Research ------------------------\r\n<br><br>\r\n<h4>Results of Questionnaire \r\n<h4>• The patients preferred to choose the hospital because of the free 31.......................... service provided. \r\n<h4>• Most patients wished the hospital to be 32.......................... \r\n<h4>• Patients were concerned about prior 33.......................... about the hospital treatment. \r\n<br><br>\r\n\r\n<h4>Actions in the next year\r\n<h4>• improvements on website for local 34.......................... as well as hospital medical staff \r\n<h4>• incentive to motivate the members of staff \r\n<h4>• extra 35.......................... for staff’s success in work \r\n<h4>• considering the opinions of the 36 .......................... \r\n<h4>• improving the effectiveness of 37.......................... between patients, doctors and staff \r\n<h4>• first-come-first-served system\r\n<br><br>\r\n\r\n<h4>Recommendation\r\n<h4>• A new unit would be built for those who are suffering from 38.......................... disturbance. \r\n<h4>• A new ward would be proposed to those in need of 39.......................... surgery. \r\n<h4>• The equipment is advanced enough to do with the treatments. \r\n<h4>• More effective 40.......................... is needed to improve the efficiency of communication.',2,4,1,NULL),(32,NULL,'',2,4,1,NULL),(33,NULL,'',2,4,1,NULL),(34,NULL,'',2,4,1,NULL),(35,NULL,'',2,4,1,NULL),(36,NULL,'',2,4,1,NULL),(37,NULL,'',2,4,1,NULL),(38,NULL,'',2,4,1,NULL),(39,NULL,'',2,4,1,NULL),(40,NULL,'',2,4,1,NULL);
/*!40000 ALTER TABLE `cauhoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietlambai`
--

DROP TABLE IF EXISTS `chitietlambai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietlambai` (
  `username` varchar(255) NOT NULL,
  `MaDeThi` int NOT NULL,
  `NgayLam` date DEFAULT NULL,
  `ThoiGianLam` time DEFAULT NULL,
  `KetQua` int DEFAULT NULL,
  PRIMARY KEY (`username`,`MaDeThi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietlambai`
--

LOCK TABLES `chitietlambai` WRITE;
/*!40000 ALTER TABLE `chitietlambai` DISABLE KEYS */;
INSERT INTO `chitietlambai` VALUES ('user1',1,'2023-11-03','00:24:00',30);
/*!40000 ALTER TABLE `chitietlambai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dapan`
--

DROP TABLE IF EXISTS `dapan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dapan` (
  `MaDapAn` int NOT NULL AUTO_INCREMENT,
  `NoiDungDapAn` varchar(2000) DEFAULT NULL,
  `ChanTri` bit(1) DEFAULT NULL,
  `MaCauHoi` int NOT NULL,
  PRIMARY KEY (`MaDapAn`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dapan`
--

LOCK TABLES `dapan` WRITE;
/*!40000 ALTER TABLE `dapan` DISABLE KEYS */;
INSERT INTO `dapan` VALUES (1,'warehouse',NULL,1),(2,'Hitcher',NULL,2),(3,'supermarket',NULL,3),(4,'bakery',NULL,4),(5,'ARW204',NULL,5),(6,'adverts',NULL,6),(7,'newspaper',NULL,7),(8,'agency',NULL,8),(9,'tutors',NULL,9),(10,'feedback',NULL,10),(11,'A',NULL,11),(12,'B',NULL,12),(13,'C',NULL,13),(14,'A',NULL,14),(15,'B',NULL,15),(16,'C',NULL,16),(17,'B',NULL,17),(18,'E',NULL,18),(19,'H',NULL,19),(20,'G',NULL,20),(21,'A',NULL,21),(22,'B',NULL,22),(23,'A',NULL,23),(24,'C',NULL,24),(25,'B',NULL,25),(26,'C',NULL,26),(27,'B',NULL,27),(28,'E',NULL,28),(29,'A',NULL,29),(30,'D',NULL,30),(31,'transportation',NULL,31),(32,'clean',NULL,32),(33,'information',NULL,33),(34,'residents',NULL,34),(35,'bonus',NULL,35),(36,'visitors',NULL,36),(37,'communication',NULL,37),(38,'sleep',NULL,38),(39,'plastic',NULL,39),(40,'planning',NULL,40),(41,'advertisements',NULL,6),(42,'E',NULL,27),(43,'B',NULL,28),(44,'D',NULL,29),(45,'A',NULL,30);
/*!40000 ALTER TABLE `dapan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dethi`
--

DROP TABLE IF EXISTS `dethi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dethi` (
  `MaDeThi` int NOT NULL AUTO_INCREMENT,
  `TenDeThi` varchar(255) DEFAULT NULL,
  `MaBoDe` int NOT NULL,
  PRIMARY KEY (`MaDeThi`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dethi`
--

LOCK TABLES `dethi` WRITE;
/*!40000 ALTER TABLE `dethi` DISABLE KEYS */;
INSERT INTO `dethi` VALUES (1,'C18 IELTS listening test 1',1),(2,'C18 IELTS listening test 2',1),(3,'C18 IELTS listening test 3',2),(4,'C18 IELTS listening test 4',2),(5,'C18 IELTS listening test 5',3),(6,'C18 IELTS listening test 6',3),(7,'C18 IELTS listening test 7',4),(8,'C18 IELTS listening test 8',4),(9,'C18 IELTS listening test 9',5),(10,'C18 IELTS listening test 10',5),(11,'C18 IELTS listening test 11',6),(12,'C18 IELTS listening test 12',6),(13,'C18 IELTS listening test 13',7),(14,'C18 IELTS listening test 14',7),(15,'C18 IELTS listening test 15',8),(16,'C18 IELTS listening test 16',8),(17,'C18 IELTS listening test 17',9),(18,'C18 IELTS listening test 18',9),(19,'C18 IELTS listening test 19',10),(20,'C18 IELTS listening test 20',10);
/*!40000 ALTER TABLE `dethi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaicauhoi`
--

DROP TABLE IF EXISTS `loaicauhoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaicauhoi` (
  `MaLoai` int NOT NULL AUTO_INCREMENT,
  `TenLoai` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`MaLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaicauhoi`
--

LOCK TABLES `loaicauhoi` WRITE;
/*!40000 ALTER TABLE `loaicauhoi` DISABLE KEYS */;
INSERT INTO `loaicauhoi` VALUES (1,'Multiple Choice'),(2,'Note/Form Completion'),(3,'Matching and map');
/*!40000 ALTER TABLE `loaicauhoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part` (
  `MaPart` int NOT NULL AUTO_INCREMENT,
  `SoHieuPart` int NOT NULL,
  `SoCauHoi` int DEFAULT NULL,
  `Audio` varchar(255) DEFAULT NULL,
  `MaDeThi` int NOT NULL,
  PRIMARY KEY (`MaPart`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,1,10,'1part1',1),(2,2,10,'1part2',1),(3,3,10,'1part3',1),(4,4,10,'1part4',1);
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','seedadmin',NULL,1),('user1','password1',NULL,0),('user2','password2',NULL,0),('user3','password3',NULL,0),('user4','password4',NULL,0),('user5','password5',NULL,0),('user6','password6',NULL,0),('user7','password7',NULL,0),('user8','password8',NULL,0),('user9','password9',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-07 17:25:42
