-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2023 at 09:02 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parque_vendas`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `codigo_cliente` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `apelido` varchar(40) NOT NULL,
  `data_nascimento` date NOT NULL,
  `BI` varchar(40) NOT NULL,
  `contacto` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `codigo_funcionario` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `apelido` varchar(40) NOT NULL,
  `data_nascimento` date NOT NULL,
  `BI` varchar(40) NOT NULL,
  `contacto` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `Posicao` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `codigo_stock` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `cod_viatura` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vendas`
--

CREATE TABLE `vendas` (
  `codigo_venda` int(11) NOT NULL,
  `quantidade` int(8) NOT NULL,
  `preco_venda` decimal(40,0) NOT NULL,
  `cliente_cod` int(8) NOT NULL,
  `stock_cod` int(8) NOT NULL,
  `funcionario_cod` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `viatura`
--

CREATE TABLE `viatura` (
  `codigo_viatura` int(11) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `Modelo` varchar(40) NOT NULL,
  `numero_portas` int(11) NOT NULL,
  `cilindrada` varchar(40) NOT NULL,
  `potencia` varchar(40) NOT NULL,
  `preco` decimal(40,0) NOT NULL,
  `cor` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo_cliente`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`codigo_funcionario`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`codigo_stock`),
  ADD KEY `cod_viatura` (`cod_viatura`);

--
-- Indexes for table `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`codigo_venda`),
  ADD KEY `cliente_cod` (`cliente_cod`),
  ADD KEY `stock_cod` (`stock_cod`),
  ADD KEY `funcionario` (`funcionario_cod`);

--
-- Indexes for table `viatura`
--
ALTER TABLE `viatura`
  ADD PRIMARY KEY (`codigo_viatura`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`cod_viatura`) REFERENCES `viatura` (`codigo_viatura`);

--
-- Constraints for table `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`cliente_cod`) REFERENCES `cliente` (`codigo_cliente`),
  ADD CONSTRAINT `vendas_ibfk_2` FOREIGN KEY (`funcionario_cod`) REFERENCES `funcionario` (`codigo_funcionario`),
  ADD CONSTRAINT `vendas_ibfk_3` FOREIGN KEY (`stock_cod`) REFERENCES `stock` (`codigo_stock`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
