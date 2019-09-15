CREATE DATABASE  IF NOT EXISTS `acervo` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `acervo`;
-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: acervo
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cliente` (
  `pk_id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `cli_nome` varchar(45) DEFAULT NULL,
  `cli_endereco` varchar(100) DEFAULT NULL,
  `cli_numero` varchar(20) DEFAULT NULL,
  `cli_bairro` varchar(50) DEFAULT NULL,
  `cli_cidade` varchar(50) DEFAULT NULL,
  `cli_uf` varchar(20) DEFAULT NULL,
  `cli_cep` varchar(15) DEFAULT NULL,
  `cli_telefone` varchar(45) DEFAULT NULL,
  `cli_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cliente`
--

LOCK TABLES `tbl_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_cliente` DISABLE KEYS */;
INSERT INTO `tbl_cliente` VALUES (2,'CLIENTE XX','RUA OITO DE OUTUBRO','008','REBOUÇAS','SÃO PAULO','SP','52828-060','(11) 8 2580-8890','teste@mail.com');
/*!40000 ALTER TABLE `tbl_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emprestimo`
--

DROP TABLE IF EXISTS `tbl_emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_emprestimo` (
  `pk_id_emprestimo` int(11) NOT NULL AUTO_INCREMENT,
  `fk_locador` bigint(20) NOT NULL,
  `fk_locatario` bigint(20) NOT NULL,
  `fk_livro` bigint(20) NOT NULL,
  `emprestimo_data` varchar(10) DEFAULT NULL,
  `emprestimo_data_devolucao` varchar(10) DEFAULT NULL,
  `emprestimo_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_id_emprestimo`),
  KEY `fk_locatario` (`fk_locatario`) USING BTREE,
  KEY `fk_livro` (`fk_livro`) USING BTREE,
  KEY `fk_locador` (`fk_locador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emprestimo`
--

LOCK TABLES `tbl_emprestimo` WRITE;
/*!40000 ALTER TABLE `tbl_emprestimo` DISABLE KEYS */;
INSERT INTO `tbl_emprestimo` VALUES (5,2,1,1,'23/06/19','23/06/2019','ATIVO'),(6,2,1,8,'06/07/19','06/07/2019','ATIVO');
/*!40000 ALTER TABLE `tbl_emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emprestimo_livro`
--

DROP TABLE IF EXISTS `tbl_emprestimo_livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_emprestimo_livro` (
  `pk_id_emprestimo_livro` int(11) NOT NULL AUTO_INCREMENT,
  `fk_livro` bigint(20) NOT NULL,
  `fk_emprestimo` bigint(20) NOT NULL,
  `emprestimo_quantidade` int(11) NOT NULL,
  PRIMARY KEY (`pk_id_emprestimo_livro`),
  KEY `fk_livro` (`fk_livro`),
  KEY `fk_emprestimo` (`fk_emprestimo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emprestimo_livro`
--

LOCK TABLES `tbl_emprestimo_livro` WRITE;
/*!40000 ALTER TABLE `tbl_emprestimo_livro` DISABLE KEYS */;
INSERT INTO `tbl_emprestimo_livro` VALUES (5,1,5,1),(6,8,6,1);
/*!40000 ALTER TABLE `tbl_emprestimo_livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_livro`
--

DROP TABLE IF EXISTS `tbl_livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_livro` (
  `pk_id_livro` int(11) NOT NULL AUTO_INCREMENT,
  `livro_titulo` varchar(100) NOT NULL DEFAULT '',
  `livro_autor` varchar(100) DEFAULT NULL,
  `livro_ano` int(4) NOT NULL DEFAULT '2000',
  `livro_categoria` varchar(20) DEFAULT '',
  `livro_obs` varchar(400) DEFAULT '',
  `livro_data` varchar(10) DEFAULT NULL,
  `livro_tipo` varchar(10) NOT NULL,
  `livro_quantidade` int(11) DEFAULT NULL,
  `livro_preco` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`pk_id_livro`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_livro`
--

LOCK TABLES `tbl_livro` WRITE;
/*!40000 ALTER TABLE `tbl_livro` DISABLE KEYS */;
INSERT INTO `tbl_livro` VALUES (1,'MAGNETISMO ESPIRITUAL','MICHAELUS',2010,'ESTUDO','','22/04/19','EMPRÉSTIMO',0,0.00),(2,'MECANISMO DA MEDIUNIDADE','CHICO XAVIER/ANDRÉ LUIZ',2013,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(3,'BRASIL,CORAÇÃO DO MUNDO,PÁTRIA DO EVANGELHO','CHICO XAVIER/ HUMBERTO DE CAMPOS',2008,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(4,'DESOBSESSÃO & APOMETRIA','VITOR RONALDO COSTA',2008,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(5,'REUNIÕES MEDIÚNICAS','THEREZINHA OLIVEIRA',2009,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(6,'ALÉM DA MORTE','DIVALDO FRANCO/OTÍLIA GONÇALVES',2000,'ROMANCE','','22/04/19','EMPRÉSTIMO',0,0.00),(7,'OS CHACRAS','C.W. LEADBEATER',2010,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(8,'REAVALIANDO VERDADES DISTORCIDAS','JACOB MELO',2007,'ESTUDO','','22/04/19','EMPRÉSTIMO',0,0.00),(9,'RECORDAÇÕES DA MEDIUNIDADE','YVONNE A. PEREIRA',2010,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(10,'O PASSE MAGNÉTICO','JACOB DE MELO',1994,'ESTUDO','','22/04/19','EMPRÉSTIMO',0,0.00),(11,'ONTEM E HOJE','BEZERRA DE MENEZES',2008,'ESTUDO','','22/04/19','EMPRÉSTIMO',1,0.00),(12,'O LIVRO DOS ESPÍRITOS','ALLAN KARDEC',2010,'CODIFICAÇÃO','','12/06/19','VENDA',1,15.05);
/*!40000 ALTER TABLE `tbl_livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_locador`
--

DROP TABLE IF EXISTS `tbl_locador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_locador` (
  `pk_id_locador` int(11) NOT NULL AUTO_INCREMENT,
  `locador_nome` varchar(500) DEFAULT NULL,
  `locador_rua` varchar(100) DEFAULT NULL,
  `locador_numero` varchar(5) DEFAULT NULL,
  `locador_bairro` varchar(50) DEFAULT NULL,
  `locador_cidade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `locador_uf` varchar(2) DEFAULT NULL,
  `locador_cep` varchar(15) DEFAULT NULL,
  `locador_telefone` varchar(15) DEFAULT NULL,
  `locador_email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`pk_id_locador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_locador`
--

LOCK TABLES `tbl_locador` WRITE;
/*!40000 ALTER TABLE `tbl_locador` DISABLE KEYS */;
INSERT INTO `tbl_locador` VALUES (2,'JOÃO DA LUZ','SETE DE SETEMBRO','158','GRAÇAS','RECIFE','PE','00.000-000','(00) 00000-0000','LUZJOAO@YAHOO.MAIL');
/*!40000 ALTER TABLE `tbl_locador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_locatario`
--

DROP TABLE IF EXISTS `tbl_locatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_locatario` (
  `pk_id_locatario` int(11) NOT NULL AUTO_INCREMENT,
  `locatario_nome` varchar(500) DEFAULT NULL,
  `locatario_rua` varchar(100) DEFAULT NULL,
  `locatario_numero` varchar(5) DEFAULT NULL,
  `locatario_bairro` varchar(50) DEFAULT NULL,
  `locatario_cidade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `locatario_uf` varchar(2) DEFAULT NULL,
  `locatario_cep` varchar(15) DEFAULT NULL,
  `locatario_telefone` varchar(15) DEFAULT NULL,
  `locatario_email` varchar(25) DEFAULT NULL,
  `locatario_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`pk_id_locatario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_locatario`
--

LOCK TABLES `tbl_locatario` WRITE;
/*!40000 ALTER TABLE `tbl_locatario` DISABLE KEYS */;
INSERT INTO `tbl_locatario` VALUES (1,'JOSÉ LUIZ DO MONTE GOMES','MARIA HERONILDES DO NASCIMENTO','16','SOCORRO','JABOATÃO DOS GUARARAPES','PE','54.150-600','(81) 98633-6496','LUIZJOSE48@YAHOO.COM.BR','ATIVO'),(2,'LUIZ','SEM DADOS','00','SEM DADOS','SEM DADOS','PE','00.000-000','(00) 00000-0000','SEM DADOS','SUSPENSO'),(3,'JOAO DE DEUS','MARIA SEVERIANA BITTENCOURT','58','ALAMEDA SEMPRE VERDE','CIDADE DOS ANJOS','PE','00.000-000','(00) 00000-0000','JOAO.585@MAIL.COM','BLOQUEADO');
/*!40000 ALTER TABLE `tbl_locatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `pk_id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `usu_nome` varchar(45) DEFAULT NULL,
  `usu_login` varchar(45) DEFAULT NULL,
  `usu_senha` varchar(45) DEFAULT NULL,
  `usu_tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'JOSÉ LUIZ','admin','jose1994','ADMINISTRADOR'),(2,'CONVIDADO','guest','guest','CONVIDADO'),(3,'LOCADOR','locador','locador','LOCADOR'),(4,'LUCAS','lucas','1234','ADMINISTRADOR');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendas`
--

DROP TABLE IF EXISTS `tbl_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_vendas` (
  `pk_id_vendas` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_cliente` bigint(20) NOT NULL DEFAULT '0',
  `ven_data_venda` varchar(10) NOT NULL,
  `ven_valor_liquido` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_valor_bruto` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_desconto` double(6,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`pk_id_vendas`) USING BTREE,
  KEY `fkcliente` (`fk_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendas`
--

LOCK TABLES `tbl_vendas` WRITE;
/*!40000 ALTER TABLE `tbl_vendas` DISABLE KEYS */;
INSERT INTO `tbl_vendas` VALUES (1,2,'12/06/19',0.00,0.00,0.00),(2,2,'12/06/19',15.05,20.25,5.20),(3,2,'12/06/19',10.00,15.05,5.05),(4,2,'18/06/19',43.05,46.05,3.00);
/*!40000 ALTER TABLE `tbl_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendas_livro`
--

DROP TABLE IF EXISTS `tbl_vendas_livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_vendas_livro` (
  `pk_id_venda_livro` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_livro` bigint(20) unsigned NOT NULL DEFAULT '0',
  `fk_vendas` bigint(20) unsigned NOT NULL DEFAULT '0',
  `ven_livro_valor` double(6,2) NOT NULL DEFAULT '0.00',
  `ven_livro_quantidade` int(11) NOT NULL,
  PRIMARY KEY (`pk_id_venda_livro`) USING BTREE,
  KEY `fk_livro` (`fk_livro`),
  KEY `fkvendas` (`fk_vendas`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendas_livro`
--

LOCK TABLES `tbl_vendas_livro` WRITE;
/*!40000 ALTER TABLE `tbl_vendas_livro` DISABLE KEYS */;
INSERT INTO `tbl_vendas_livro` VALUES (1,11,1,0.00,1),(2,12,2,15.05,1),(3,12,3,15.05,2),(4,12,4,15.05,1),(5,13,4,15.50,2);
/*!40000 ALTER TABLE `tbl_vendas_livro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-15 15:08:54
