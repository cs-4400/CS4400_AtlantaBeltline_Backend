-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: atl_beltline
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

DROP DATABASE IF EXISTS atl_beltline;
CREATE DATABASE atl_beltline;
USE atl_beltline;
--
-- Table structure for table `assign_to`
--

DROP TABLE IF EXISTS `assign_to`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assign_to` (
  `StaffUsername` varchar(55) NOT NULL,
  `Event_Name` varchar(50) NOT NULL,
  `Event_Start` date NOT NULL,
  `Site_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`StaffUsername`,`Event_Name`,`Event_Start`,`Site_Name`),
  KEY `Event_Name` (`Event_Name`,`Event_Start`),
  KEY `Site_Name` (`Site_Name`),
  CONSTRAINT `assign_to_ibfk_1` FOREIGN KEY (`StaffUsername`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `assign_to_ibfk_2` FOREIGN KEY (`Event_Name`, `Event_Start`) REFERENCES `event` (`event_name`, `event_start`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `assign_to_ibfk_3` FOREIGN KEY (`Site_Name`) REFERENCES `site` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assign_to`
--

LOCK TABLES `assign_to` WRITE;
/*!40000 ALTER TABLE `assign_to` DISABLE KEYS */;
INSERT INTO `assign_to` VALUES ('staff1','Official Atlanta BeltLine Bike Tour','2019-02-09','Atlanta BeltLine Center'),('michael.smith','Eastside Trail','2019-02-13','Historic Fourth Ward Park'),('michael.smith','Bus Tour','2019-02-01','Inman Park'),('michael.smith','Bus Tour','2019-02-08','Inman Park'),('robert.smith','Bus Tour','2019-02-08','Inman Park'),('robert.smith','Eastside Trail','2019-02-04','Inman Park'),('robert.smith','Private Bus Tour','2019-02-01','Inman Park'),('staff1','Eastside Trail','2019-03-01','Inman Park'),('staff2','Bus Tour','2019-02-01','Inman Park'),('staff2','Eastside Trail','2019-02-04','Inman Park'),('staff3','Arboretum Walking Tour','2019-02-08','Inman Park'),('michael.smith','Eastside Trail','2019-02-04','Piedmont Park'),('staff1','Eastside Trail','2019-02-04','Piedmont Park'),('staff1','Westside Trail','2019-02-18','Westview Cemetery'),('staff3','Westside Trail','2019-02-18','Westview Cemetery');
/*!40000 ALTER TABLE `assign_to` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connects`
--

DROP TABLE IF EXISTS `connects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `connects` (
  `Site_name` varchar(50) NOT NULL,
  `Transit_type` varchar(25) NOT NULL,
  `Transit_route` varchar(25) NOT NULL,
  PRIMARY KEY (`Site_name`,`Transit_type`,`Transit_route`),
  KEY `Transit_type` (`Transit_type`,`Transit_route`),
  CONSTRAINT `connects_ibfk_1` FOREIGN KEY (`Site_name`) REFERENCES `site` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `connects_ibfk_2` FOREIGN KEY (`Transit_type`, `Transit_route`) REFERENCES `transitDTO` (`type`, `route`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connects`
--

LOCK TABLES `connects` WRITE;
/*!40000 ALTER TABLE `connects` DISABLE KEYS */;
INSERT INTO `connects` VALUES ('Historic Fourth Ward Park','Bike','Relay'),('Piedmont Park','Bike','Relay'),('Historic Fourth Ward Park','Bus','152'),('Inman Park','Bus','152'),('Piedmont Park','Bus','152'),('Historic Fourth Ward Park','MARTA','Blue'),('Inman Park','MARTA','Blue'),('Piedmont Park','MARTA','Blue'),('Westview Cemetery','MARTA','Blue');
/*!40000 ALTER TABLE `connects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeDTO`
--

DROP TABLE IF EXISTS `employeeDTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employeeDTO` (
  `Username` varchar(50) NOT NULL,
  `EmpID` int(11) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Address` varchar(95) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(3) DEFAULT NULL,
  `Zip` int(11) DEFAULT NULL,
  `EmpType` enum('Admin','Manager','Staff') DEFAULT NULL,
  PRIMARY KEY (`EmpID`),
  KEY `Username` (`Username`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeDTO`
--

LOCK TABLES `employeeDTO` WRITE;
/*!40000 ALTER TABLE `employeeDTO` DISABLE KEYS */;
INSERT INTO `employeeDTO` VALUES ('james.smith',1,'4043721234','123 East Main Street','Rochester','NY',14604,'Admin'),('michael.smith',2,'4043726789','350 Ferst Drive','Atlanta','GA',30332,'Staff'),('robert.smith',3,'1234567890','123 East Main Street','Columbus','OH',43215,'Staff'),('maria.garcia',4,'7890123456','123 East Main Street','Richland','PA',17987,'Manager'),('david.smith',5,'5124776435','350 Ferst Drive','Atlanta','GA',30332,'Manager'),('manager1',6,'8045126767','123 East Main Street','Rochester','NY',14604,'Manager'),('manager2',7,'9876543210','123 East Main Street','Rochester','NY',14604,'Manager'),('manager3',8,'5432167890','350 Ferst Drive','Atlanta','GA',30332,'Manager'),('manager4',9,'8053467565','123 East Main Street','Columbus','OH',43215,'Manager'),('manager5',10,'8031446782','801 Atlantic Drive','Atlanta','GA',30332,'Manager'),('staff1',11,'8024456765','266 Ferst Drive Northwest','Atlanta','GA',30332,'Staff'),('staff2',12,'8888888888','266 Ferst Drive Northwest','Atlanta','GA',30332,'Staff'),('staff3',13,'3333333333','801 Atlantic Drive','Atlanta','GA',30332,'Staff');
/*!40000 ALTER TABLE `employeeDTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `event` (
  `Event_Name` varchar(50) NOT NULL,
  `Event_Start` date NOT NULL,
  `Site_Name` varchar(50) NOT NULL,
  `End_date` date DEFAULT NULL,
  `Event_Price` int(11) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `Min_staff` int(11) DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`Event_Name`,`Event_Start`,`Site_Name`),
  KEY `Site_Name` (`Site_Name`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`Site_Name`) REFERENCES `site` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES ('Arboretum Walking Tour','2019-02-08','Inman Park','2019-02-11',5,5,1,'Official Atlanta BeltLine Arboretum Walking Tours provide an up-close view of the Westside Trail and the Atlanta BeltLine Arboretum led by Trees Atlanta Docents. The one and a half hour tours step off at at 10am (Oct thru May), and 9am (June thru September). Departure for all tours is from Rose Circle Park near Brown Middle School. More details at: https://beltline.org/visit/atlanta-beltline-tours/#arboretum-walking'),('Bus Tour','2019-02-01','Inman Park','2019-02-02',25,6,2,'The Atlanta BeltLine Partnership’s tour program operates with a natural gas-powered, ADA accessible tour bus funded through contributions from 10th & Monroe, LLC, SunTrust Bank Trusteed Foundations – Florence C. and Harry L. English Memorial Fund and Thomas Guy Woolford Charitable Trust, and AGL Resources'),('Bus Tour','2019-02-08','Inman Park','2019-02-10',25,6,2,'The Atlanta BeltLine Partnership’s tour program operates with a natural gas-powered, ADA accessible tour bus funded through contributions from 10th & Monroe, LLC, SunTrust Bank Trusteed Foundations – Florence C. and Harry L. English Memorial Fund and Thomas Guy Woolford Charitable Trust, and AGL Resources'),('Eastside Trail','2019-02-04','Inman Park','2019-02-05',0,99999,1,'A combination of multi-use trail and linear greenspace, the Eastside Trail was the first finished section of the Atlanta BeltLine trail in the old rail corridor. The Eastside Trail, which was funded by a combination of public and private philanthropic sources, runs from the tip of Piedmont Park to Reynoldstown. More details at https://beltline.org/explore-atlanta-beltline-trails/eastside-trail/'),('Eastside Trail','2019-02-04','Piedmont Park','2019-02-05',0,99999,1,'A combination of multi-use trail and linear greenspace, the Eastside Trail was the first finished section of the Atlanta BeltLine trail in the old rail corridor. The Eastside Trail, which was funded by a combination of public and private philanthropic sources, runs from the tip of Piedmont Park to Reynoldstown. More details at https://beltline.org/explore-atlanta-beltline-trails/eastside-trail/'),('Eastside Trail','2019-02-13','Historic Fourth Ward Park','2019-02-14',0,99999,1,'A combination of multi-use trail and linear greenspace, the Eastside Trail was the first finished section of the Atlanta BeltLine trail in the old rail corridor. The Eastside Trail, which was funded by a combination of public and private philanthropic sources, runs from the tip of Piedmont Park to Reynoldstown. More details at https://beltline.org/explore-atlanta-beltline-trails/eastside-trail/'),('Eastside Trail','2019-03-01','Inman Park','2019-03-02',0,99999,1,'A combination of multi-use trail and linear greenspace, the Eastside Trail was the first finished section of the Atlanta BeltLine trail in the old rail corridor. The Eastside Trail, which was funded by a combination of public and private philanthropic sources, runs from the tip of Piedmont Park to Reynoldstown. More details at https://beltline.org/explore-atlanta-beltline-trails/eastside-trail/'),('Official Atlanta BeltLine Bike Tour','2019-02-09','Atlanta BeltLine Center','2019-02-14',5,5,1,'These tours will include rest stops highlighting assets and points of interest along the Atlanta BeltLine. Staff will lead the rides, and each group will have a ride sweep to help with any unexpected mechanical difficulties.'),('Private Bus Tour','2019-02-01','Inman Park','2019-02-02',40,4,1,'Private tours are available most days, pending bus and tour guide availability. Private tours can accommodate up to 4 guests per tour, and are subject to a tour fee (nonprofit rates are available). As a nonprofit organization with limited resources, we are unable to offer free private tours. We thank you for your support and your understanding as we try to provide as many private group tours as possible. The Atlanta BeltLine Partnership’s tour program operates with a natural gas-powered, ADA accessible tour bus funded through contributions from 10th & Monroe, LLC, SunTrust Bank Trusteed Foundations – Florence C. and Harry L. English Memorial Fund and Thomas Guy Woolford Charitable Trust, and AGL Resources'),('Westside Trail','2019-02-18','Westview Cemetery','2019-02-21',0,99999,1,'The Westside Trail is a free amenity that offers a bicycle and pedestrian-safe corridor with a 14-foot-wide multi-use trail surrounded by mature trees and grasses thanks to Trees Atlanta’s Arboretum. With 16 points of entry, 14 of which will be ADA-accessible with ramp and stair systems, the trail provides numerous access points for people of all abilities. More details at: https://beltline.org/explore-atlanta-beltline-trails/westside-trail/');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `site` (
  `Name` varchar(50) NOT NULL,
  `Address` varchar(95) DEFAULT NULL,
  `Zipcode` int(11) DEFAULT NULL,
  `Open_Everyday` varchar(50) DEFAULT NULL,
  `ManagerUsername` varchar(55) NOT NULL,
  PRIMARY KEY (`Name`),
  KEY `ManagerUsername` (`ManagerUsername`),
  CONSTRAINT `site_ibfk_1` FOREIGN KEY (`ManagerUsername`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES ('Atlanta Beltline Center','112 Krog Street Northeast',30307,'No','manager3'),('Historic Fourth Ward Park','680 Dallas Street Northeast',30308,'Yes','manager4'),('Inman Park',NULL,30307,'Yes','david.smith'),('Piedmont Park','400 Park Drive Northeast',30306,'Yes','manager2'),('Westview Cemetery','1680 Westview Drive Southwest',30310,'No','manager5');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `take_transit`
--

DROP TABLE IF EXISTS `take_transit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `take_transit` (
  `Username` varchar(50) NOT NULL,
  `Type` varchar(25) NOT NULL,
  `Route` varchar(25) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Username`,`Date`,`Type`,`Route`),
  KEY `Type` (`Type`,`Route`),
  CONSTRAINT `take_transit_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `take_transit_ibfk_2` FOREIGN KEY (`Type`, `Route`) REFERENCES `transitDTO` (`type`, `route`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `take_transit`
--

LOCK TABLES `take_transit` WRITE;
/*!40000 ALTER TABLE `take_transit` DISABLE KEYS */;
INSERT INTO `take_transit` VALUES ('manager3','Bike','Relay','2019-03-20'),('maria.hernandez','Bike','Relay','2019-03-20'),('mary.smith','Bike','Relay','2019-03-23'),('manager2','Bus','152','2019-03-20'),('maria.hernandez','Bus','152','2019-03-20'),('maria.hernandez','Bus','152','2019-03-22'),('manager2','MARTA','Blue','2019-03-20'),('manager2','MARTA','Blue','2019-03-21'),('manager2','MARTA','Blue','2019-03-22'),('visitor1','MARTA','Blue','2019-03-21');
/*!40000 ALTER TABLE `take_transit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitDTO`
--

DROP TABLE IF EXISTS `transitDTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transitDTO` (
  `Type` varchar(25) NOT NULL,
  `Route` varchar(25) NOT NULL,
  `Price` float DEFAULT NULL,
  PRIMARY KEY (`Type`,`Route`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitDTO`
--

LOCK TABLES `transitDTO` WRITE;
/*!40000 ALTER TABLE `transitDTO` DISABLE KEYS */;
INSERT INTO `transitDTO` VALUES ('Bike','Relay',1),('Bus','152',2),('MARTA','Blue',2);
/*!40000 ALTER TABLE `transitDTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userDTO`
--

DROP TABLE IF EXISTS `userDTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userDTO` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Status` enum('Pending','Approved','Declined') DEFAULT 'Pending',
  `UserType` enum('EmployeeDTO','Visitor','EmployeeDTO, Visitor','UserDTO') DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userDTO`
--

LOCK TABLES `userDTO` WRITE;
/*!40000 ALTER TABLE `userDTO` DISABLE KEYS */;
INSERT INTO `userDTO` VALUES ('david.smith','dsmith456','David','Smith','Approved','EmployeeDTO'),('james.smith','jsmith123','James','Smith','Approved','EmployeeDTO'),('manager1','manager1','Manager','One','Pending','EmployeeDTO'),('manager2','manager2','Manager','Two','Approved','EmployeeDTO, Visitor'),('manager3','manager3','Manager','Three','Approved','EmployeeDTO'),('manager4','manager4','Manager','Four','Approved','EmployeeDTO, Visitor'),('manager5','manager5','Manager','Five','Approved','EmployeeDTO, Visitor'),('maria.garcia','mgarcia123','Maria','Garcia','Approved','EmployeeDTO, Visitor'),('maria.hernandez','mhernandez','Maria','Hernandez','Approved','UserDTO'),('maria.rodriguez','mrodriguez','Maria','Rodriguez','Declined','Visitor'),('mary.smith','msmith789','Mary','Smith','Approved','Visitor'),('michael.smith','msmith456','Michael','Smith','Approved','EmployeeDTO, Visitor'),('robert.smith','rsmith789','Robert','Smith','Approved','EmployeeDTO'),('staff1','staff1234','Staff','One','Approved','EmployeeDTO'),('staff2','staff4567','Staff','Two','Approved','EmployeeDTO, Visitor'),('staff3','staff7890','Staff','Three','Approved','EmployeeDTO, Visitor'),('user1','user123456','UserDTO','One','Pending','UserDTO'),('visitor1','visitor123','Visitor','One','Approved','Visitor');
/*!40000 ALTER TABLE `userDTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_email`
--

DROP TABLE IF EXISTS `user_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_email` (
  `Username` varchar(50) NOT NULL,
  `Email` varchar(75) NOT NULL,
  PRIMARY KEY (`Username`,`Email`),
  CONSTRAINT `user_email_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_email`
--

LOCK TABLES `user_email` WRITE;
/*!40000 ALTER TABLE `user_email` DISABLE KEYS */;
INSERT INTO `user_email` VALUES ('david.smith','dsmith@outlook.com'),('james.smith','jsmith@gatech.edu'),('james.smith','jsmith@gmail.com'),('james.smith','jsmith@hotmail.com'),('james.smith','jsmith@outlook.com'),('manager1','m1@beltline.com'),('manager2','m2@beltline.com'),('manager3','m3@beltline.com'),('manager4','m4@beltline.com'),('manager5','m5@beltline.com'),('maria.garcia','mgarcia@gatech.edu'),('maria.garcia','mgarcia@yahoo.com'),('maria.hernandez','mh@gatech.edu'),('maria.hernandez','mh123@gmail.com'),('maria.rodriguez','mrodriguez@gmail.com'),('mary.smith','mary@outlook.com'),('michael.smith','msmith@gmail.com'),('robert.smith','rsmith@hotmail.com'),('staff1','s1@beltline.com'),('staff2','s2@beltline.com'),('staff3','s3@beltline.com'),('user1','u1@beltline.com'),('visitor1','v1@beltline.com');
/*!40000 ALTER TABLE `user_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_event`
--

DROP TABLE IF EXISTS `visit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visit_event` (
  `Username` varchar(50) NOT NULL,
  `Event_Name` varchar(50) NOT NULL,
  `Event_Start` date NOT NULL,
  `Site_Name` varchar(50) NOT NULL,
  `Visit_Date` date NOT NULL,
  PRIMARY KEY (`Username`,`Visit_Date`,`Event_Name`,`Event_Start`,`Site_Name`),
  KEY `Event_Name` (`Event_Name`,`Event_Start`),
  KEY `Site_Name` (`Site_Name`),
  CONSTRAINT `visit_event_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `visit_event_ibfk_2` FOREIGN KEY (`Event_Name`, `Event_Start`) REFERENCES `event` (`event_name`, `event_start`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `visit_event_ibfk_3` FOREIGN KEY (`Site_Name`) REFERENCES `site` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_event`
--

LOCK TABLES `visit_event` WRITE;
/*!40000 ALTER TABLE `visit_event` DISABLE KEYS */;
INSERT INTO `visit_event` VALUES ('mary.smith','Official Atlanta BeltLine Bike Tour','2019-02-09','Atlanta BeltLine Center','2019-02-10'),('visitor1','Official Atlanta BeltLine Bike Tour','2019-02-09','Atlanta BeltLine Center','2019-02-10'),('mary.smith','Eastside Trail','2019-02-13','Historic Fourth Ward Park','2019-02-13'),('mary.smith','Eastside Trail','2019-02-13','Historic Fourth Ward Park','2019-02-14'),('visitor1','Eastside Trail','2019-02-13','Historic Fourth Ward Park','2019-02-14'),('manager2','Bus Tour','2019-02-01','Inman Park','2019-02-02'),('manager4','Bus Tour','2019-02-01','Inman Park','2019-02-01'),('manager5','Bus Tour','2019-02-01','Inman Park','2019-02-02'),('maria.garcia','Bus Tour','2019-02-01','Inman Park','2019-02-02'),('mary.smith','Bus Tour','2019-02-01','Inman Park','2019-02-01'),('mary.smith','Private Bus Tour','2019-02-01','Inman Park','2019-02-01'),('mary.smith','Private Bus Tour','2019-02-01','Inman Park','2019-02-02'),('mary.smith','Arboretum Walking Tour','2019-02-08','Inman Park','2019-02-10'),('staff2','Bus Tour','2019-02-01','Inman Park','2019-02-02'),('mary.smith','Eastside Trail','2019-02-04','Piedmont Park','2019-02-04'),('mary.smith','Westside Trail','2019-02-18','Westview Cemetery','2019-02-19'),('visitor1','Westside Trail','2019-02-18','Westview Cemetery','2019-02-19');
/*!40000 ALTER TABLE `visit_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_site`
--

DROP TABLE IF EXISTS `visit_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visit_site` (
  `Username` varchar(50) NOT NULL,
  `Site_Name` varchar(50) NOT NULL,
  `Visit_Date` date NOT NULL,
  PRIMARY KEY (`Username`,`Visit_Date`,`Site_Name`),
  KEY `Site_Name` (`Site_Name`),
  CONSTRAINT `visit_site_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userDTO` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `visit_site_ibfk_2` FOREIGN KEY (`Site_Name`) REFERENCES `site` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_site`
--

LOCK TABLES `visit_site` WRITE;
/*!40000 ALTER TABLE `visit_site` DISABLE KEYS */;
INSERT INTO `visit_site` VALUES ('mary.smith','Atlanta Beltline Center','2019-02-01'),('mary.smith','Atlanta Beltline Center','2019-02-10'),('visitor1','Atlanta Beltline Center','2019-02-09'),('visitor1','Atlanta Beltline Center','2019-02-13'),('mary.smith','Historic Fourth Ward Park','2019-02-02'),('visitor1','Historic Fourth Ward Park','2019-02-11'),('mary.smith','Inman Park','2019-02-01'),('mary.smith','Inman Park','2019-02-02'),('mary.smith','Inman Park','2019-02-03'),('visitor1','Inman Park','2019-02-01'),('mary.smith','Piedmont Park','2019-02-02'),('visitor1','Piedmont Park','2019-02-01'),('visitor1','Piedmont Park','2019-02-11'),('visitor1','Westview Cemetery','2019-02-06');
/*!40000 ALTER TABLE `visit_site` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 16:26:48
