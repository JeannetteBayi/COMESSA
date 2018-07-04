-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2018 at 07:16 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `worldcup`
--

-- --------------------------------------------------------

--
-- Table structure for table `matchresult`
--

CREATE TABLE `matchresult` (
  `Id` int(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `fifaCode` varchar(5) NOT NULL,
  `groupId` varchar(5) NOT NULL,
  `groupLetter` varchar(2) NOT NULL,
  `goalsFor` int(2) NOT NULL,
  `goalsAgainst` int(2) NOT NULL,
  `points` int(3) NOT NULL,
  `gamesPlayed` int(2) NOT NULL,
  `losses` int(2) NOT NULL,
  `wins` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matchresult`
--

INSERT INTO `matchresult` (`Id`, `country`, `fifaCode`, `groupId`, `groupLetter`, `goalsFor`, `goalsAgainst`, `points`, `gamesPlayed`, `losses`, `wins`) VALUES
(13, 'Argentina', 'ARG', '4', 'D', 1, 1, 3, 1, 1, 0),
(14, 'Iceland', 'ISL', '4', 'D', 0, 1, 0, 1, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `Id` int(4) NOT NULL,
  `alternateName` varchar(20) NOT NULL,
  `fifaCode` varchar(10) NOT NULL,
  `groupId` varchar(10) NOT NULL,
  `groupLetter` varchar(12) NOT NULL,
  `country` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`Id`, `alternateName`, `fifaCode`, `groupId`, `groupLetter`, `country`) VALUES
(1, 'alternateName', 'fifaCode', 'groupId', 'groupLetter', 'country');

-- --------------------------------------------------------

--
-- Table structure for table `worldcupmatch`
--

CREATE TABLE `worldcupmatch` (
  `fifaId` int(3) NOT NULL,
  `venue` varchar(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `dateTime` datetime NOT NULL,
  `Status` varchar(10) NOT NULL,
  `winner` varchar(30) NOT NULL,
  `homeTeamStatistics` varchar(30) NOT NULL,
  `awayTeamStatistics` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `matchresult`
--
ALTER TABLE `matchresult`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `worldcupmatch`
--
ALTER TABLE `worldcupmatch`
  ADD PRIMARY KEY (`fifaId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
