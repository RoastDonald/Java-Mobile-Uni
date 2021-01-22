-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 09 2020 г., 01:22
-- Версия сервера: 10.3.22-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `authors`
--

-- --------------------------------------------------------

--
-- Структура таблицы `authors`
--

CREATE TABLE `authors` (
  `id` int(11) NOT NULL,
  `author` varchar(100) CHARACTER SET utf8 NOT NULL,
  `genre` varchar(100) CHARACTER SET utf8 NOT NULL,
  `countryOfIssue` int(11) NOT NULL,
  `critivallyTestedFlg` tinyint(1) NOT NULL,
  `onSaleFlg` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `authors`
--

INSERT INTO `authors` (`id`, `author`, `genre`, `countryOfIssue`, `critivallyTestedFlg`, `onSaleFlg`) VALUES
(1, 'Electronic Arts', 'Приключения, шутер, аркада', 0, 1, 1),
(2, 'Ubisoft', 'Экшен, шутеры, приключения', 0, 1, 1),
(3, 'Relic Entertainment', 'Стратегия, аркада', 1, 0, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `games`
--

CREATE TABLE `games` (
  `id` int(11) NOT NULL,
  `game` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `games`
--

INSERT INTO `games` (`id`, `game`, `author_id`) VALUES
(1, 'Watch Dogs', 2),
(2, 'Assassins Creed', 2),
(3, 'Tom Clancys RainbowSix', 2),
(4, 'Tom Clancys Ghost Recon', 2),
(5, 'Tom Clancys The Division', 2),
(6, 'The Crew', 2),
(7, 'Anno 1800', 2),
(8, 'Steep', 2),
(9, 'For Honor', 2),
(10, 'Apex Legends', 1),
(11, 'The Sims', 1),
(12, 'Battlefield', 1),
(13, 'Need For Speed', 1),
(14, 'Star Wars: The Old Republic', 1),
(15, 'Titanfall', 1),
(16, 'Mass Effect', 1),
(17, 'Spore', 1),
(18, 'Star Wars: Battlefront', 1),
(19, 'FIFA', 1),
(20, 'Company Of Heroes', 3),
(21, 'Warhammer 40,000', 3),
(22, 'Homeworld', 3),
(23, 'Age Of Empires', 3),
(24, 'Impossible Creatures', 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `authors`
--
ALTER TABLE `authors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `games`
--
ALTER TABLE `games`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
