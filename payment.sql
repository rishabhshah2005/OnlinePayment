-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2024 at 07:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `balance`
--

CREATE TABLE `balance` (
  `user_id` int(11) NOT NULL,
  `bank_id` int(11) NOT NULL,
  `amount` double NOT NULL DEFAULT 200
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `balance`
--

INSERT INTO `balance` (`user_id`, `bank_id`, `amount`) VALUES
(1, 1, 94260),
(5, 2, 850),
(6, 1, 1290),
(7, 2, 1590),
(8, 2, 1390),
(9, 3, 1730),
(10, 4, 2620),
(11, 3, 12070),
(12, 1, 15350),
(13, 2, 1250),
(17, 3, 200),
(20, 3, 900),
(21, 2, 200);

-- --------------------------------------------------------

--
-- Table structure for table `banks`
--

CREATE TABLE `banks` (
  `bank_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `banks`
--

INSERT INTO `banks` (`bank_id`, `name`, `branch`) VALUES
(1, 'sbi', 'bopal'),
(2, 'icici', 'bopal'),
(3, 'Indusland', 'bopal'),
(4, 'sbi', 'chandkheda');

-- --------------------------------------------------------

--
-- Table structure for table `payment_history`
--

CREATE TABLE `payment_history` (
  `ref_no` int(11) NOT NULL,
  `to_` varchar(50) NOT NULL,
  `from_` varchar(50) NOT NULL,
  `amount` double NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp(),
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment_history`
--

INSERT INTO `payment_history` (`ref_no`, `to_`, `from_`, `amount`, `time`, `type`) VALUES
(1, 'avipatel', 'rishabhshah2005', 200, '2024-07-24 17:55:33', 'user'),
(2, 'avipatel', 'rishabhshah2005', 300, '2024-07-24 18:00:55', 'user'),
(3, 'dominos', 'rishabhshah2005', 100, '2024-07-24 16:23:44', 'food'),
(4, 'avipatel', 'rishabhshah2005', -100, '2024-07-24 18:38:19', 'user'),
(5, 'rishabhshah2005', 'saransh', 50, '2024-07-25 11:16:27', 'user'),
(6, 'rishabhshah2005', 'avipatel', 125, '2024-07-25 17:54:40', 'user'),
(7, 'dominos', 'rishabhshah2005', 200, '2024-07-25 19:08:02', 'food'),
(8, 'dominos', 'rishabhshah2005', 500, '2024-07-25 19:10:00', 'food'),
(9, 'avipatel', 'rishabhshah2005', 175, '2024-07-25 19:14:52', 'user'),
(10, 'saransh', 'rishabhshah2005', 50, '2024-07-25 19:15:08', 'user'),
(11, 'apollopharmacy', 'rishabhshah2005', 600, '2024-07-25 19:22:34', 'medicine'),
(12, 'pizzahut', 'rishabhshah2005', 300, '2024-07-25 19:22:53', 'food'),
(13, 'pizzahut', 'rishabhshah2005', 250, '2024-07-25 19:23:01', 'food'),
(14, 'medhut', 'rishabhshah2005', 900, '2024-07-25 19:23:14', 'medicine'),
(15, 'medhut', 'rishabhshah2005', 0, '2024-07-25 19:23:22', 'medicine'),
(16, 'medhut', 'rishabhshah2005', 150, '2024-07-25 19:24:02', 'medicine'),
(17, 'medhut', 'rishabhshah2005', 450, '2024-07-26 09:45:21', 'medicine'),
(18, 'kashakjain', 'rutvivora', 350, '2024-07-26 09:57:04', 'user'),
(19, 'kashakjain', 'rutvivora', 600, '2024-07-26 09:57:14', 'user'),
(20, 'dominos', 'rutvivora', 200, '2024-07-26 09:57:22', 'food'),
(21, 'rishabhshah2005', 'rutvivora', 100, '2024-07-26 09:57:31', 'user'),
(22, 'apollopharmacy', 'rutvivora', 900, '2024-07-26 09:57:40', 'medicine'),
(23, 'medhut', 'rutvivora', 670, '2024-07-26 09:57:55', 'medicine'),
(24, 'pizzahut', 'rutvivora', 560, '2024-07-26 09:58:07', 'food'),
(25, 'rutvivora', 'kashakjain', 600, '2024-07-26 09:59:00', 'user'),
(26, 'medhut', 'rishabhshah2005', 250, '2024-07-26 10:13:51', 'medicine'),
(27, 'apollopharmacy', 'saransh', 30, '2024-07-26 10:16:09', 'medicine'),
(28, 'rishabhshah2005', 'saransh', 50, '2024-07-26 10:19:49', 'user'),
(29, 'saransh', 'rishabhshah2005', 400, '2024-07-26 10:22:14', 'user'),
(30, 'dominos', 'saransh', 90, '2024-07-26 10:23:59', 'food'),
(31, 'pizzahut', 'saransh', 80, '2024-07-26 10:25:52', 'food'),
(32, 'cinepolis', 'rutvivora', 150, '2024-07-26 16:00:02', 'entertainment'),
(33, 'cinepolis', 'rishabhshah2005', 700, '2024-07-26 16:26:09', 'entertainment'),
(34, 'cinepolis', 'kavya', 200, '2024-07-26 16:48:13', 'entertainment'),
(35, 'rishabhshah2005', 'saransh', 10, '2024-08-02 18:39:34', 'user'),
(36, 'saransh', 'rishabhshah2005', 1000, '2024-08-02 18:40:56', 'user'),
(37, 'saransh', 'mayank', 200, '2024-08-02 18:50:42', 'user'),
(38, 'mayank', 'rishabhshah2005', 800, '2024-08-02 18:52:12', 'user'),
(39, 'mayank', 'rishabhshah2005', 100, '2024-08-02 18:55:24', 'dance'),
(40, 'pizzahut', 'rishabhshah2005', 2481, '2024-07-03 18:30:00', 'food'),
(41, 'medhut', 'rishabhshah2005', 540, '2024-07-05 18:30:00', 'medicine'),
(42, 'medhut', 'rishabhshah2005', 2906, '2024-07-14 18:30:00', 'medicine'),
(43, 'medhut', 'rishabhshah2005', 1558, '2024-07-18 18:30:00', 'medicine'),
(44, 'apollopharmacy', 'rishabhshah2005', 686, '2024-07-03 18:30:00', 'medicine'),
(45, 'dominos', 'rishabhshah2005', 393, '2024-07-02 18:30:00', 'food'),
(46, 'pizzahut', 'rishabhshah2005', 2651, '2024-07-10 18:30:00', 'food'),
(47, 'pizzahut', 'rishabhshah2005', 2765, '2024-07-02 18:30:00', 'food'),
(48, 'apollopharmacy', 'rishabhshah2005', 553, '2024-07-01 18:30:00', 'medicine'),
(49, 'medhut', 'rishabhshah2005', 2289, '2024-06-30 18:30:00', 'medicine'),
(50, 'medhut', 'rishabhshah2005', 2268, '2024-07-28 18:30:00', 'medicine'),
(51, 'dominos', 'rishabhshah2005', 1161, '2024-07-10 18:30:00', 'food'),
(52, 'dominos', 'rishabhshah2005', 2046, '2024-07-09 18:30:00', 'food'),
(53, 'apollopharmacy', 'rishabhshah2005', 394, '2024-07-20 18:30:00', 'medicine'),
(54, 'apollopharmacy', 'rishabhshah2005', 1815, '2024-07-07 18:30:00', 'medicine'),
(55, 'pizzahut', 'rishabhshah2005', 2045, '2024-07-13 18:30:00', 'food'),
(56, 'medhut', 'rishabhshah2005', 445, '2024-07-10 18:30:00', 'medicine'),
(57, 'pizzahut', 'rishabhshah2005', 813, '2024-07-23 18:30:00', 'food'),
(58, 'cinepolis', 'rishabhshah2005', 1401, '2024-07-20 18:30:00', 'entertainment'),
(59, 'pizzahut', 'rishabhshah2005', 2478, '2024-07-16 18:30:00', 'food'),
(60, 'medhut', 'avipatel', 1394, '2024-07-07 18:30:00', 'medicine'),
(61, 'dominos', 'avipatel', 1157, '2024-07-10 18:30:00', 'food'),
(62, 'medhut', 'avipatel', 2055, '2024-07-26 18:30:00', 'medicine'),
(63, 'apollopharmacy', 'avipatel', 2732, '2024-07-02 18:30:00', 'medicine'),
(64, 'pizzahut', 'avipatel', 1906, '2024-07-08 18:30:00', 'food'),
(65, 'apollopharmacy', 'avipatel', 1496, '2024-07-28 18:30:00', 'medicine'),
(66, 'medhut', 'avipatel', 992, '2024-07-03 18:30:00', 'medicine'),
(67, 'pizzahut', 'avipatel', 888, '2024-07-02 18:30:00', 'food'),
(68, 'cinepolis', 'avipatel', 963, '2024-07-27 18:30:00', 'entertainment'),
(69, 'apollopharmacy', 'avipatel', 845, '2024-07-07 18:30:00', 'medicine'),
(70, 'pizzahut', 'avipatel', 1741, '2024-07-17 18:30:00', 'food'),
(71, 'medhut', 'avipatel', 2130, '2024-07-14 18:30:00', 'medicine'),
(72, 'pizzahut', 'avipatel', 2184, '2024-06-30 18:30:00', 'food'),
(73, 'cinepolis', 'avipatel', 1576, '2024-07-08 18:30:00', 'entertainment'),
(74, 'apollopharmacy', 'avipatel', 1684, '2024-07-25 18:30:00', 'medicine'),
(75, 'apollopharmacy', 'avipatel', 1628, '2024-07-21 18:30:00', 'medicine'),
(76, 'dominos', 'avipatel', 1627, '2024-07-12 18:30:00', 'food'),
(77, 'cinepolis', 'avipatel', 2208, '2024-07-05 18:30:00', 'entertainment'),
(78, 'apollopharmacy', 'avipatel', 177, '2024-07-22 18:30:00', 'medicine'),
(79, 'pizzahut', 'avipatel', 906, '2024-07-04 18:30:00', 'food'),
(80, 'dominos', 'rutvivora', 1841, '2024-07-07 18:30:00', 'food'),
(81, 'cinepolis', 'rutvivora', 1810, '2024-07-19 18:30:00', 'entertainment'),
(82, 'dominos', 'rutvivora', 2903, '2024-07-18 18:30:00', 'food'),
(83, 'pizzahut', 'rutvivora', 1613, '2024-07-13 18:30:00', 'food'),
(84, 'cinepolis', 'rutvivora', 876, '2024-07-20 18:30:00', 'entertainment'),
(85, 'apollopharmacy', 'rutvivora', 364, '2024-07-12 18:30:00', 'medicine'),
(86, 'cinepolis', 'rutvivora', 1468, '2024-07-01 18:30:00', 'entertainment'),
(87, 'cinepolis', 'rutvivora', 2270, '2024-07-20 18:30:00', 'entertainment'),
(88, 'pizzahut', 'rutvivora', 403, '2024-07-16 18:30:00', 'food'),
(89, 'dominos', 'rutvivora', 1376, '2024-07-25 18:30:00', 'food'),
(90, 'medhut', 'rutvivora', 1734, '2024-07-23 18:30:00', 'medicine'),
(91, 'apollopharmacy', 'rutvivora', 2055, '2024-07-21 18:30:00', 'medicine'),
(92, 'apollopharmacy', 'rutvivora', 367, '2024-07-04 18:30:00', 'medicine'),
(93, 'cinepolis', 'rutvivora', 1191, '2024-07-27 18:30:00', 'entertainment'),
(94, 'medhut', 'rutvivora', 910, '2024-07-08 18:30:00', 'medicine'),
(95, 'dominos', 'rutvivora', 528, '2024-07-14 18:30:00', 'food'),
(96, 'dominos', 'rutvivora', 2817, '2024-07-15 18:30:00', 'food'),
(97, 'apollopharmacy', 'rutvivora', 626, '2024-07-19 18:30:00', 'medicine'),
(98, 'cinepolis', 'rutvivora', 2270, '2024-07-20 18:30:00', 'entertainment'),
(99, 'apollopharmacy', 'rutvivora', 1465, '2024-07-12 18:30:00', 'medicine'),
(100, 'pizzahut', 'kashakjain', 2717, '2024-07-18 18:30:00', 'food'),
(101, 'dominos', 'kashakjain', 1215, '2024-07-26 18:30:00', 'food'),
(102, 'dominos', 'kashakjain', 570, '2024-07-21 18:30:00', 'food'),
(103, 'cinepolis', 'kashakjain', 484, '2024-07-10 18:30:00', 'entertainment'),
(104, 'dominos', 'kashakjain', 565, '2024-07-23 18:30:00', 'food'),
(105, 'medhut', 'kashakjain', 1242, '2024-07-11 18:30:00', 'medicine'),
(106, 'pizzahut', 'kashakjain', 1654, '2024-07-20 18:30:00', 'food'),
(107, 'medhut', 'kashakjain', 2483, '2024-07-17 18:30:00', 'medicine'),
(108, 'cinepolis', 'kashakjain', 947, '2024-07-05 18:30:00', 'entertainment'),
(109, 'apollopharmacy', 'kashakjain', 439, '2024-07-28 18:30:00', 'medicine'),
(110, 'pizzahut', 'kashakjain', 928, '2024-07-13 18:30:00', 'food'),
(111, 'cinepolis', 'kashakjain', 2272, '2024-07-25 18:30:00', 'entertainment'),
(112, 'medhut', 'kashakjain', 1685, '2024-07-22 18:30:00', 'medicine'),
(113, 'medhut', 'kashakjain', 2180, '2024-07-18 18:30:00', 'medicine'),
(114, 'dominos', 'kashakjain', 1746, '2024-07-24 18:30:00', 'food'),
(115, 'dominos', 'kashakjain', 1900, '2024-07-01 18:30:00', 'food'),
(116, 'cinepolis', 'kashakjain', 1855, '2024-07-04 18:30:00', 'entertainment'),
(117, 'apollopharmacy', 'kashakjain', 1365, '2024-07-11 18:30:00', 'medicine'),
(118, 'medhut', 'kashakjain', 2305, '2024-07-20 18:30:00', 'medicine'),
(119, 'cinepolis', 'kashakjain', 2716, '2024-07-25 18:30:00', 'entertainment'),
(120, 'apollopharmacy', 'saransh', 1154, '2024-07-09 18:30:00', 'medicine'),
(121, 'medhut', 'saransh', 263, '2024-07-23 18:30:00', 'medicine'),
(122, 'cinepolis', 'saransh', 2517, '2024-07-01 18:30:00', 'entertainment'),
(123, 'apollopharmacy', 'saransh', 1426, '2024-07-18 18:30:00', 'medicine'),
(124, 'medhut', 'saransh', 871, '2024-07-05 18:30:00', 'medicine'),
(125, 'dominos', 'saransh', 2542, '2024-07-17 18:30:00', 'food'),
(126, 'apollopharmacy', 'saransh', 396, '2024-07-24 18:30:00', 'medicine'),
(127, 'apollopharmacy', 'saransh', 2864, '2024-07-15 18:30:00', 'medicine'),
(128, 'cinepolis', 'saransh', 1275, '2024-07-02 18:30:00', 'entertainment'),
(129, 'dominos', 'saransh', 2663, '2024-07-07 18:30:00', 'food'),
(130, 'dominos', 'saransh', 305, '2024-07-19 18:30:00', 'food'),
(131, 'pizzahut', 'saransh', 1962, '2024-07-03 18:30:00', 'food'),
(132, 'pizzahut', 'saransh', 2848, '2024-07-18 18:30:00', 'food'),
(133, 'apollopharmacy', 'saransh', 730, '2024-07-24 18:30:00', 'medicine'),
(134, 'cinepolis', 'saransh', 1180, '2024-07-13 18:30:00', 'entertainment'),
(135, 'dominos', 'saransh', 1101, '2024-07-28 18:30:00', 'food'),
(136, 'pizzahut', 'saransh', 500, '2024-07-10 18:30:00', 'food'),
(137, 'medhut', 'saransh', 2538, '2024-07-01 18:30:00', 'medicine'),
(138, 'dominos', 'saransh', 2582, '2024-07-20 18:30:00', 'food'),
(139, 'apollopharmacy', 'saransh', 2801, '2024-07-05 18:30:00', 'medicine'),
(140, 'medhut', 'ankit', 2668, '2024-07-09 18:30:00', 'medicine'),
(141, 'cinepolis', 'ankit', 554, '2024-07-28 18:30:00', 'entertainment'),
(142, 'pizzahut', 'ankit', 2512, '2024-07-28 18:30:00', 'food'),
(143, 'dominos', 'ankit', 1656, '2024-07-17 18:30:00', 'food'),
(144, 'dominos', 'ankit', 2588, '2024-07-13 18:30:00', 'food'),
(145, 'medhut', 'ankit', 1620, '2024-07-06 18:30:00', 'medicine'),
(146, 'apollopharmacy', 'ankit', 2174, '2024-07-22 18:30:00', 'medicine'),
(147, 'apollopharmacy', 'ankit', 1479, '2024-07-11 18:30:00', 'medicine'),
(148, 'cinepolis', 'ankit', 1167, '2024-07-25 18:30:00', 'entertainment'),
(149, 'dominos', 'ankit', 960, '2024-07-01 18:30:00', 'food'),
(150, 'apollopharmacy', 'ankit', 2784, '2024-07-08 18:30:00', 'medicine'),
(151, 'pizzahut', 'ankit', 1158, '2024-07-05 18:30:00', 'food'),
(152, 'dominos', 'ankit', 2412, '2024-07-24 18:30:00', 'food'),
(153, 'apollopharmacy', 'ankit', 2779, '2024-07-26 18:30:00', 'medicine'),
(154, 'apollopharmacy', 'ankit', 500, '2024-06-30 18:30:00', 'medicine'),
(155, 'pizzahut', 'ankit', 1415, '2024-07-12 18:30:00', 'food'),
(156, 'pizzahut', 'ankit', 975, '2024-07-08 18:30:00', 'food'),
(157, 'pizzahut', 'ankit', 1384, '2024-07-07 18:30:00', 'food'),
(158, 'apollopharmacy', 'ankit', 884, '2024-07-21 18:30:00', 'medicine'),
(159, 'pizzahut', 'ankit', 2151, '2024-07-28 18:30:00', 'food'),
(160, 'cinepolis', 'mayank', 340, '2024-07-13 18:30:00', 'entertainment'),
(161, 'cinepolis', 'mayank', 2068, '2024-07-03 18:30:00', 'entertainment'),
(162, 'apollopharmacy', 'mayank', 1647, '2024-07-03 18:30:00', 'medicine'),
(163, 'medhut', 'mayank', 2996, '2024-07-06 18:30:00', 'medicine'),
(164, 'apollopharmacy', 'mayank', 479, '2024-07-02 18:30:00', 'medicine'),
(165, 'pizzahut', 'mayank', 677, '2024-07-15 18:30:00', 'food'),
(166, 'apollopharmacy', 'mayank', 1012, '2024-07-12 18:30:00', 'medicine'),
(167, 'cinepolis', 'mayank', 144, '2024-07-01 18:30:00', 'entertainment'),
(168, 'pizzahut', 'mayank', 689, '2024-07-08 18:30:00', 'food'),
(169, 'cinepolis', 'mayank', 212, '2024-07-12 18:30:00', 'entertainment'),
(170, 'dominos', 'mayank', 482, '2024-07-19 18:30:00', 'food'),
(171, 'medhut', 'mayank', 1068, '2024-07-10 18:30:00', 'medicine'),
(172, 'medhut', 'mayank', 1590, '2024-07-25 18:30:00', 'medicine'),
(173, 'cinepolis', 'mayank', 297, '2024-07-13 18:30:00', 'entertainment'),
(174, 'apollopharmacy', 'mayank', 647, '2024-07-17 18:30:00', 'medicine'),
(175, 'dominos', 'mayank', 1318, '2024-07-11 18:30:00', 'food'),
(176, 'pizzahut', 'mayank', 1599, '2024-07-23 18:30:00', 'food'),
(177, 'medhut', 'mayank', 1497, '2024-07-06 18:30:00', 'medicine'),
(178, 'dominos', 'mayank', 2905, '2024-07-13 18:30:00', 'food'),
(179, 'cinepolis', 'mayank', 208, '2024-07-03 18:30:00', 'entertainment');

--
-- Triggers `payment_history`
--
DELIMITER $$
CREATE TRIGGER `addType` BEFORE INSERT ON `payment_history` FOR EACH ROW BEGIN
DECLARE
typ varchar(15);
set typ = (SELECT buisness_type from users where username=NEW.to_);
set NEW.type = typ;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `mobile` varchar(10) NOT NULL,
  `current_bank_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `buisness_type` varchar(15) NOT NULL DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `age`, `mobile`, `current_bank_id`, `username`, `password`, `pin`, `buisness_type`) VALUES
(1, 'Rishabh', 'Shah', 19, '8727145378', 1, 'rishabhshah2005', 'hello', '123456', 'user'),
(5, 'Avi', 'Patel', 18, '1234567890', 2, 'avipatel', 'avipatel', '333666', 'user'),
(6, 'Dominos', 'Pizza', 45, '8727415378', 1, 'dominos', 'hello', '123456', 'food'),
(7, 'Saransh', 'Saraswat', 19, '1234567890', 2, 'saransh', '1234', '654321', 'user'),
(8, 'Pizza', 'Hut', NULL, '7727335378', 2, 'pizzahut', 'pizza', '020202', 'food'),
(9, 'Apollo', 'Pharmacy', NULL, '7627315378', 3, 'apollopharmacy', 'pharma', '678901', 'medicine'),
(10, 'Med', 'Hut', NULL, '8707145378', 4, 'medhut', 'meds', '111112', 'medicine'),
(11, 'Rutvi', 'Vora', 19, '8727005178', 3, 'rutvivora', 'rukks', '281105', 'user'),
(12, 'Kashak', 'Jain', 19, '9827115308', 1, 'kashakjain', 'kashak', '140104', 'user'),
(13, 'Cine', 'polis', NULL, '1234567891', 2, 'cinepolis', 'cinepolis', '909090', 'entertainment'),
(17, 'Ankit', 'Gadhiya', 90, '1029384756', 3, 'ankit', 'ankit', '000000', 'user'),
(20, 'Mayank', 'Sonwane', 22, '9846712380', 3, 'mayank', 'mayank', '000000', 'dance'),
(21, 'GameZone', 'Zorba', NULL, '9234568235', 2, 'gamezone', 'gamezone', '090909', 'entertainment');

--
-- Triggers `users`
--
DELIMITER $$
CREATE TRIGGER `addToBalance` AFTER INSERT ON `users` FOR EACH ROW BEGIN
INSERT into balance(user_id, bank_id) values(NEW.user_id, NEW.current_bank_id);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `deleteFromBalance` AFTER DELETE ON `users` FOR EACH ROW BEGIN
delete from balance where user_id=OLD.user_id;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updateUsername` AFTER UPDATE ON `users` FOR EACH ROW Begin 
if NEW.username != OLD.username then
update payment_history set to_=NEW.username where to_=old.username;
UPDATE payment_history SET from_=NEW.username where from_=old.username;
end if;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `banks`
--
ALTER TABLE `banks`
  ADD PRIMARY KEY (`bank_id`);

--
-- Indexes for table `payment_history`
--
ALTER TABLE `payment_history`
  ADD PRIMARY KEY (`ref_no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `banks`
--
ALTER TABLE `banks`
  MODIFY `bank_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment_history`
--
ALTER TABLE `payment_history`
  MODIFY `ref_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=180;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
