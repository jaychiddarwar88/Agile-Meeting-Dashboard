-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: agilemeeting
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `assignedtask`
--

DROP TABLE IF EXISTS `assignedtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignedtask` (
  `channelname` varchar(255) NOT NULL,
  `memberemail` varchar(255) NOT NULL,
  `task` varchar(255) NOT NULL,
  `duedate` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignedtask`
--

LOCK TABLES `assignedtask` WRITE;
/*!40000 ALTER TABLE `assignedtask` DISABLE KEYS */;
INSERT INTO `assignedtask` VALUES ('hello','jjschiddarwar@gmail.com','2','08/08/2020','completed'),('hello','jjschiddarwar@gmail.com','1','08/08/2020','completed'),('hello','raj@gmail.com','4','10/12/2020','pending'),('hello','jjschiddarwar@gmail.com','5','01/08/2020','pending'),('hello','jjschiddarwar@gmail.com','6','12/08/2020','review'),('hello','jjschiddarwar@gmail.com','7','nodate','completed'),('hello','jjschiddarwar@gmail.com','7','12/10/2020','completed'),('hello','jjschiddarwar@gmail.com','8','15/08/2020','completed'),('hello','jjschiddarwar@gmail.com','9','12/10/2020','completed'),('hello','jjschiddarwar@gmail.com','1','12/10/2020','pending'),('hello','jjschiddarwar@gmail.com','1','12/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','12/10/2021','pending'),('hello','jjschiddarwar@gmail.com','2','12/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','12/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','2','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','1','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','7','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','2','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','2','21/10/2021','pending'),('hello','jjschiddarwar@gmail.com','2','21-10-2021','pending'),('hello','jjschiddarwar@gmail.com','2','21-10-2021','pending'),('hello','jjschiddarwar@gmail.com','2','21-10-2021','pending'),('hello','jjschiddarwar@gmail.com','9','21-10-2021','pending'),('hello','jjschiddarwar@gmail.com','1','21-10-2021','pending');
/*!40000 ALTER TABLE `assignedtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditfunc`
--

DROP TABLE IF EXISTS `auditfunc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditfunc` (
  `channelname` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `remark` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditfunc`
--

LOCK TABLES `auditfunc` WRITE;
/*!40000 ALTER TABLE `auditfunc` DISABLE KEYS */;
INSERT INTO `auditfunc` VALUES ('hello','2020/08/10 21:01:45','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2020/08/10 21:08:22','Started Meeting in channel : hello'),('hello','2020/08/10 21:08:37','Started Meeting in channel : hello'),('hello','2020/08/10 21:09:08','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2020/08/10 21:09:21','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2020/08/10 22:51:45','Started Meeting in channel : hello'),('hello','2020/08/10 22:52:55','Started Meeting in channel : hello'),('hello','2020/08/10 23:35:08','Started Meeting in channel : hello'),('hello','2020/08/11 12:32:18','Started Meeting in channel : hello'),('hello','2020/08/11 12:32:21','Started Meeting in channel : hello'),('hello','2020/08/11 12:33:30','New Task is assigned to : jjschiddarwar@gmail.com'),('8','2020/08/11 12:34:31','Task with id : 8 is sent for review to admin/ team leader'),('8','2020/08/11 12:34:45','Task with id : 8 is : completed'),('2','2020/08/11 18:14:00','Task with id : 2 is : completed'),('hello','2020/08/11 18:37:24','Started Meeting in channel : hello'),('9','2020/08/11 18:37:50','Task with id : 9 is : edited'),('hello','2020/08/11 18:38:09','New Task is assigned to : jjschiddarwar@gmail.com'),('9','2020/08/11 18:38:15','Task with id : 9 is sent for review to admin/ team leader'),('9','2020/08/11 18:38:33','Task with id : 9 is : pending'),('9','2020/08/11 18:38:43','Task with id : 9 is sent for review to admin/ team leader'),('9','2020/08/11 18:38:53','Task with id : 9 is : completed'),('6','2020/08/11 18:39:10','Task with id : 6 is sent for review to admin/ team leader'),('hello','2020/08/11 18:40:33','Started Meeting in channel : hello'),('hello','2020/08/11 18:41:07','New Member is added : sample@gmail.com'),('test channel','2020/08/11 18:41:36','New Channel is created : test channel'),('test channel','2020/08/11 18:41:57','Started Meeting in channel : test channel'),('7','2020/08/11 18:42:37','Task with id : 7 is sent for review to admin/ team leader'),('7','2020/08/11 18:42:53','Task with id : 7 is : completed'),('hello','2020/08/11 19:54:17','New Task is assigned to : jjschiddarwar@gmail.com'),('chan','2021/06/13 23:22:25','New Member is added : vishwajeetjadhav982@gmail.com'),('hello','2021/06/13 23:41:31','Started Meeting in channel : hello'),('hello','2021/06/13 23:41:54','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:43:56','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:45:42','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:49:00','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:51:02','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:52:01','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/13 23:52:32','Started Meeting in channel : hello'),('hello','2021/06/14 00:21:15','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/14 00:24:23','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/14 00:36:11','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/14 09:45:02','New Task is assigned to : jjschiddarwar@gmail.com'),('hello','2021/06/14 11:46:56','Started Meeting in channel : hello'),('hello','2021/06/14 11:47:00','Started Meeting in channel : hello');
/*!40000 ALTER TABLE `auditfunc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capturednotes`
--

DROP TABLE IF EXISTS `capturednotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capturednotes` (
  `noteid` int NOT NULL,
  `channelname` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `adminemail` varchar(255) NOT NULL,
  `datetime` varchar(255) NOT NULL,
  `msgvalue` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capturednotes`
--

LOCK TABLES `capturednotes` WRITE;
/*!40000 ALTER TABLE `capturednotes` DISABLE KEYS */;
INSERT INTO `capturednotes` VALUES (1,'hello','sdsfd','jay@gmail.com','2020-07-29T11:50:19.429Z','recursion function task, detail '),(2,'hello','new note','jay@gmail.com','2020-07-31T08:48:55.553Z','sample message'),(3,'hi','hi','jay@gmail.com','2020-07-31T11:55:08.284Z','task 1 '),(4,'hello','new task','jay@gmail.com','2020-08-02T18:58:56.459Z','new task'),(5,'hello','hello','jay@gmail.com','2020-08-02T19:43:16.093Z','overdue note'),(6,'hello','hello','jay@gmail.com','2020-08-10T14:55:04.020Z','task new'),(7,'hello','hello','jay@gmail.com','2020-08-10T15:38:30.666Z','sample note '),(8,'hello','hello','jay@gmail.com','2020-08-11T07:02:28.387Z','sample message'),(9,'hello','test note','jay@gmail.com','2020-08-11T13:07:29.553Z','new note');
/*!40000 ALTER TABLE `capturednotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `channeldetail`
--

DROP TABLE IF EXISTS `channeldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channeldetail` (
  `channelname` varchar(255) NOT NULL,
  `admin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channeldetail`
--

LOCK TABLES `channeldetail` WRITE;
/*!40000 ALTER TABLE `channeldetail` DISABLE KEYS */;
INSERT INTO `channeldetail` VALUES ('abc','jay@gmail.com'),('hello','jay@gmail.com'),('hi','jay@gmail.com'),('jay','jay@gmail.com'),('new channel','jay@gmail.com'),('sample','abcd@gmail.com'),('chan','jjschiddarwar@gmail.com'),('test channel','jay@gmail.com');
/*!40000 ALTER TABLE `channeldetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `channelmember`
--

DROP TABLE IF EXISTS `channelmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channelmember` (
  `channelname` varchar(255) NOT NULL,
  `memberemail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channelmember`
--

LOCK TABLES `channelmember` WRITE;
/*!40000 ALTER TABLE `channelmember` DISABLE KEYS */;
INSERT INTO `channelmember` VALUES ('hello','jay@gmail.com'),('hi','jay@gmail.com'),('jay','jay@gmail.com'),('new channel','jay@gmail.com'),('hello','raj@gmail.com'),('',''),('hello','abcd@gmail.com'),('sample','abcd@gmail.com'),('hi','raj@gmail.com'),('hello','jjschiddarwar@gmail.com'),('chan','jjschiddarwar@gmail.com'),('hello','sample@gmail.com'),('test channel','jay@gmail.com'),('chan','vishwajeetjadhav982@gmail.com');
/*!40000 ALTER TABLE `channelmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatdetails`
--

DROP TABLE IF EXISTS `chatdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatdetails` (
  `channel` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `msgby` varchar(255) NOT NULL,
  `timestamp` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatdetails`
--

LOCK TABLES `chatdetails` WRITE;
/*!40000 ALTER TABLE `chatdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empsatisfaction`
--

DROP TABLE IF EXISTS `empsatisfaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empsatisfaction` (
  `useremail` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `student` varchar(255) DEFAULT NULL,
  `employment` varchar(255) DEFAULT NULL,
  `companysize` varchar(255) DEFAULT NULL,
  `devtype` varchar(255) DEFAULT NULL,
  `yearscoding` varchar(255) DEFAULT NULL,
  `careersat` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `exercise` varchar(255) DEFAULT NULL,
  `prediction` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empsatisfaction`
--

LOCK TABLES `empsatisfaction` WRITE;
/*!40000 ALTER TABLE `empsatisfaction` DISABLE KEYS */;
INSERT INTO `empsatisfaction` VALUES ('jay@gmail.com','Yes','No','Employed full-time','20 to 99 employees','Full-stack developer','6-8 years','Moderately satisfied','500000','I dont typically exercise','Satisfied'),('jay@gmail.com','Yes','No','Employed full-time','20 to 99 employees','Full-stack developer','6-8 years','Moderately satisfied','500000','I dont typically exercise','Satisfied'),('jjschiddarwar@gmail.com','Yes','No','Employed full-time','20 to 99 employees','Full-stack developer','6-8 years','Moderately satisfied','500000','I dont typically exercise','Satisfied');
/*!40000 ALTER TABLE `empsatisfaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_table`
--

DROP TABLE IF EXISTS `survey_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_table` (
  `useremail` varchar(255) DEFAULT NULL,
  `hastaken` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_table`
--

LOCK TABLES `survey_table` WRITE;
/*!40000 ALTER TABLE `survey_table` DISABLE KEYS */;
INSERT INTO `survey_table` VALUES ('jay@gmail.com','yes'),('jjschiddarwar@gmail.com','yes'),('vishwajeetjadhav982@gmail.com','no');
/*!40000 ALTER TABLE `survey_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetail` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES (0,'jay','jay@gmail.com','8888'),(1,'raj','raj@gmail.com','1111'),(2,'abcd','abcd@gmail.com','1234'),(3,'Jay Chiddarar','jjschiddarwar@gmail.com','8888'),(4,'Vishwajeet Jadhav','vishwajeetjadhav982@gmail.com','1234');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-20 16:57:01
