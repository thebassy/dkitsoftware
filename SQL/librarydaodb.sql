-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2016 at 03:55 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarydaodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookId` int(5) NOT NULL,
  `title` varchar(50) NOT NULL,
  `authorLastName` text NOT NULL,
  `authorFirstName` text NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `yearPublished` year(4) NOT NULL,
  `subject` text,
  `isbn` varchar(50) NOT NULL,
  `copiesRemaining` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookId`, `title`, `authorLastName`, `authorFirstName`, `publisher`, `yearPublished`, `subject`, `isbn`, `copiesRemaining`) VALUES
(1, 'Gardens of the Moon', 'Erikson', 'Steven', 'Bantam Books', 2000, 'High Fantasy ', '978-0-553-81957-1', 3),
(2, 'Deadhouse Gates', 'Erikson', 'Steven', 'Bantam Books', 2001, 'High Fantasy ', '978-0-553-81311-1', 3),
(3, 'Memories of Ice', 'Erikson', 'Steven', 'Bantam Books', 2002, 'High Fantasy ', '978-0-553-81312-8', 3),
(4, 'House of Chains', 'Erikson', 'Steven', 'Bantam Books', 2003, 'High Fantasy ', '978-0-553-81313-5', 3),
(5, 'Midnight Tides', 'Erikson', 'Steven', 'Bantam Books', 2005, 'High Fantasy', '978-0-553-81314-2', 3),
(6, 'The Bonehunters', 'Erikson', 'Steven', 'Bantam Books', 2007, 'High Fantasy ', '978-0-553-81315-9', 3),
(7, 'Reaper''s Gale', 'Erikson', 'Steven', 'Tor Fantasy', 2008, 'High Fantasy ', '978-0-7653-4884-5', 3),
(8, 'Toll the Hounds', 'Erikson', 'Steven', 'Tor Fantasy', 2008, 'High Fantasy ', '978-0-7653-4885-2', 3),
(9, 'Dust of Dreams', 'Erikson', 'Steven', 'Tor Fantasy', 2010, 'High Fantasy ', '978-0-7653-4886-9', 3),
(10, 'The Crippled God', 'Erikson', 'Steven', 'Tor Fantasy', 2011, 'High Fantasy ', '978-0-7653-4887-6', 3),
(11, 'Prince of Thorns', 'Lawrence', 'Mark', 'Harper Voyager', 2012, 'Fantasy Adventure', '978-0-00-742363-7', 3),
(12, 'King of Thorns', 'Lawrence', 'Mark', 'Harper Voyager', 2013, 'Fantasy Adventure', '978-0-00-743902-7', 3),
(13, 'Emperor of Thorns', 'Lawrence', 'Mark', 'Harper Voyager', 2013, 'Fantasy Adventure', '978-0-00-743906-5', 3),
(14, 'American Gods ', 'Gaiman', 'Neil', 'Headline Publishing Group', 2013, 'Fantasy', '978-0-7553-2281-7', 3),
(15, 'Tricks of the Mind', 'Brown', 'Derren', 'Channel 4 Books', 2007, 'Special Interest', '978-1-905-02635-7', 3),
(16, 'The Good, the Bad and the Multiplex', 'Kermode', 'Mark', 'Random House Books', 2011, 'Cinema', '978-1-84-794603-4', 3),
(17, 'Flipnosis', 'Dutton', 'Kevin', 'Arrow Books', 2011, 'Psycology', '978-0-099-50562-4', 3),
(18, 'The Children of Hurin', 'Tolkien', 'J.R.R.', 'Harper Collins', 2008, 'High Fantasy', '978-0-00-725226-8', 3),
(19, 'The Hobbit', 'Tolkien', 'J.R.R.', 'Harper Collins', 2008, 'High Fantasy', '978-0-00-727061-3', 3),
(20, 'The Lord of the Rings', 'Tolkien', 'J.R.R.', 'Harper Collins', 2012, 'High Fantasy', '978-0-00-748997-8', 3),
(21, 'A Game of Thrones', 'Martin', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-744803-6', 3),
(22, 'A Clash of Kings', 'Martin ', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-744783-1', 3),
(23, 'A Storm of Swords 1: Steel and Snow', 'Martin ', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-744784-8', 3),
(24, 'A Storm of Swords 1: Blood and Gold', 'Martin ', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-754826-2', 3),
(25, 'A Feast for Crows', 'Martin ', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-744786-2', 3),
(26, 'A Dance with Dragons 1: Dreams and Dust', 'Martin', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-746606-1', 3),
(27, 'A Dance with Dragons 2: After the Feast', 'Martin', 'George R.R.', 'Harper Voyager', 2011, 'High Fantasy', '978-0-00-746607-8', 3),
(28, 'Classroom in a Book: Adobe Photoshop CS5', 'Adobe', '', 'Adobe Press', 2010, 'Multimedia', '978-0-321-70176-3', 3),
(29, 'Classroom in a Book: Adobe Flash Professional CS5', 'Adobe', '', 'Adobe Press', 2010, 'Multimedia', '978-0-321-70180-0', 3),
(30, 'Classroom in a Book: Adobe Illustrator CS5', 'Adobe', '', 'Adobe Press', 2010, 'Multimedia', '978-0-321-70178-7', 3),
(31, 'Classroom in a Book: Adobe Dreamweaver CS5', 'Adobe', '', 'Adobe Press', 2010, 'Multimedia', '978-0-321-70177-0', 3),
(32, 'Autodesk 3ds Max 2012', 'Derakhshani', 'Randi L.', 'Wiley Publishing', 2011, 'Multimedia', '978-1-118-01675-6', 3),
(33, 'Java all in one for Dummies', 'Lowe', 'Doug', 'John Wiley and Sons', 2011, 'Computer Science', '978-0-470-37172-5', 3),
(34, 'C for Dummies', 'Gookin', 'Dan', 'John Wiley and Sons', 2004, 'Computer Science', '978-0-7645-7068-1', 3),
(35, 'Programming the Raspberry Pi', 'Monk', 'Simon', 'McGraw Hill Books', 2013, 'Computer Science', '978-0-07-180783-8', 3),
(36, 'Raspberry Pi Projects for the Evil Genius', 'Norris', 'Donald', 'McGraw Hill Books', 2014, 'Computer Science', '978-0-07-182158-2', 3),
(37, 'Hacking Exposed Wirelesss', 'Cache', 'Johnny', 'McGraw Hill Books', 2010, 'Networks', '978-0-07-166661-9', 3);

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `loanId` int(5) NOT NULL,
  `bookId` int(5) NOT NULL,
  `userId` int(5) NOT NULL,
  `datestamp` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`loanId`, `bookId`, `userId`, `datestamp`, `dueDate`, `returnDate`) VALUES
(1, 4, 1, '2016-10-08', '2016-10-29', NULL),
(2, 9, 1, '2016-10-08', '2016-10-29', NULL),
(3, 22, 4, '2016-10-28', '2016-11-18', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(5) NOT NULL,
  `lastName` text NOT NULL,
  `firstName` text NOT NULL,
  `userLogin` varchar(20) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `userType` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `lastName`, `firstName`, `userLogin`, `userPassword`, `address`, `email`, `userType`) VALUES
(1, 'McHugh', 'Niall', 'mchughn', 'niall', '77 loughantarve, knockbridge, co. louth', 'nmchu07@gmail.com', 1),
(2, 'Bekx', 'Sebastian', 'bekxs', 'sebastian', '148 ath lethan, racecourse road, co. louth', 'd00187654@student.dkit.ie', 1),
(3, 'Duffy', 'Andrew', 'duffya', 'andrew', 'avenue road, dundalk, co. louth', 'duffyandrew@gmail.com', 1),
(4, 'rogan', 'dermot', 'rogand', 'dermot', 'dundalk, co. louth', 'dkitguy@gmail.com', 0),
(5, 'hudson', 'mark', 'hudsonm', 'mark', 'navan, co. meath', 'hudsonmark@gmail.com', 0),
(6, 'pakenham', 'connor', 'pakenhamc', 'connor', 'cavan town, co.cavan', 'pakenhamconnor@gmail.com', 0),
(7, 'treanor', 'jimmy', 'treanorj', 'jimmy', 'monaghan town, co. monaghan', 'treanorjimmy@gmail.com', 0),
(8, 'mccabe', 'aaron', 'mccabea', 'aaron', 'cavan town, co.cavan', 'mccabeaaron@gmail.com', 0),
(9, 'mcceneaney', 'emmett', 'mcceneaneye', 'emmett', 'knockbridge, co. louth', 'mceneaneyemmett@gmail.com', 0),
(10, 'nutuatas', 'nedas', 'nutautasn', 'nedas', 'dundalk, co. louth', 'nutautasnedas@gmail.com', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`loanId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bookId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `loanId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
