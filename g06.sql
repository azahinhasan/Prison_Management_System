-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 09:38 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `g06`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(8) NOT NULL,
  `employeeName` varchar(20) NOT NULL,
  `designation` varchar(16) NOT NULL,
  `salary` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('J01', 'Black Widow', 'Jailor', 3333.33),
('J02', 'Hulk', 'Jailor', 3333.33),
('R01', 'Iron Man', 'Receptionist', 5555.55),
('R02', 'Spider Man', 'Receptionist', 5555.55),
('W01', 'James Bond', 'Warden', 9999.99),
('W02', 'Thanos', 'Warden', 9999.99);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(16) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('J01', 'j011234', 1),
('J02', 'j021234', 1),
('R01', 'r011234', 2),
('R02', 'r021234', 2),
('W01', 'w011234', 0),
('W02', 'w021234', 0);

-- --------------------------------------------------------

--
-- Table structure for table `prisoner`
--

CREATE TABLE `prisoner` (
  `PrisonerId` int(20) NOT NULL,
  `PrisonerName` varchar(150) NOT NULL,
  `Crime` varchar(70) NOT NULL,
  `EntryDate` date NOT NULL,
  `ReleasedDate` date NOT NULL,
  `CellNo` int(200) DEFAULT NULL,
  `NID` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prisoner`
--

INSERT INTO `prisoner` (`PrisonerId`, `PrisonerName`, `Crime`, `EntryDate`, `ReleasedDate`, `CellNo`, `NID`) VALUES
(103, 'Peter Parker', 'Kidnapping', '2019-12-12', '2020-06-06', 1002, '987654321'),
(104, 'Bruce Wayne', 'Assault', '2019-12-12', '2020-07-07', 1004, '789456123'),
(110, 'Fahim', 'Murder', '2019-12-12', '2020-12-12', 123, '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `released_prisoner`
--

CREATE TABLE `released_prisoner` (
  `NID` varchar(20) NOT NULL,
  `PrisonerName` varchar(20) NOT NULL,
  `EntryDate` date NOT NULL,
  `ReleasedDate` date NOT NULL,
  `Crime` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `released_prisoner`
--

INSERT INTO `released_prisoner` (`NID`, `PrisonerName`, `EntryDate`, `ReleasedDate`, `Crime`) VALUES
('123455556', 'Arthur Fleck', '2019-12-12', '2021-12-12', 'Robbery'),
('123456789', 'Tony Stark', '2019-12-12', '2020-01-01', 'Assault'),
('987654321', 'Thor', '2019-12-12', '2019-12-23', 'Murder');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `Serial` int(11) NOT NULL,
  `prisonerId` int(11) NOT NULL,
  `Visitor Name` varchar(20) NOT NULL,
  `Relation` varchar(20) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`Serial`, `prisonerId`, `Visitor Name`, `Relation`, `Date`, `Time`) VALUES
(1, 102, 'Fahim', 'Brother', '2019-12-12', '5:12'),
(2, 110, 'Zahin', 'Brother', '2019-12-08', '10:10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `prisoner`
--
ALTER TABLE `prisoner`
  ADD PRIMARY KEY (`PrisonerId`);

--
-- Indexes for table `released_prisoner`
--
ALTER TABLE `released_prisoner`
  ADD PRIMARY KEY (`NID`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`Serial`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prisoner`
--
ALTER TABLE `prisoner`
  MODIFY `PrisonerId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `Serial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
