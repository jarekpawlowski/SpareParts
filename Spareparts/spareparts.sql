-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Sty 2017, 02:49
-- Wersja serwera: 10.1.10-MariaDB
-- Wersja PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `sklep`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `album`
--

CREATE TABLE `album` (
  `Album_ID` int(11) NOT NULL,
  `AlbumNazwa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Wytwornia` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DataWydania` date DEFAULT NULL,
  `Autor_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `autor`
--

CREATE TABLE `autor` (
  `Autor_ID` int(11) NOT NULL,
  `AutorNazwa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `utwor`
--

CREATE TABLE `utwor` (
  `Utwor_ID` int(11) NOT NULL,
  `UtworNazwa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Dlugosc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Album_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`Album_ID`),
  ADD KEY `Autor_ID` (`Autor_ID`);

--
-- Indexes for table `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`Autor_ID`);

--
-- Indexes for table `utwor`
--
ALTER TABLE `utwor`
  ADD PRIMARY KEY (`Utwor_ID`),
  ADD KEY `Album_ID` (`Album_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `album`
--
ALTER TABLE `album`
  MODIFY `Album_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `autor`
--
ALTER TABLE `autor`
  MODIFY `Autor_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `utwor`
--
ALTER TABLE `utwor`
  MODIFY `Utwor_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`Autor_ID`) REFERENCES `autor` (`Autor_ID`);

--
-- Ograniczenia dla tabeli `utwor`
--
ALTER TABLE `utwor`
  ADD CONSTRAINT `utwor_ibfk_1` FOREIGN KEY (`Album_ID`) REFERENCES `album` (`Album_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
