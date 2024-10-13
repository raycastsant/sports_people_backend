-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2024 a las 07:10:39
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sports_people`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `countries`
--

CREATE TABLE `countries` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `countries`
--

INSERT INTO `countries` (`id`, `name`) VALUES
(160, 'Canada'),
(154, 'China'),
(158, 'Colombia'),
(2, 'Cuba'),
(303, 'Egypt'),
(161, 'France'),
(155, 'Japan'),
(157, 'Mexico'),
(203, 'Morocco'),
(302, 'Netherlands'),
(156, 'New Zeland'),
(252, 'Norway'),
(354, 'Taiwan'),
(162, 'Uganda'),
(53, 'USA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `countries_seq`
--

CREATE TABLE `countries_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `countries_seq`
--

INSERT INTO `countries_seq` (`next_val`) VALUES
(551);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medals`
--

CREATE TABLE `medals` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `event_name` varchar(255) NOT NULL,
  `medal_type` enum('BRONZE','GOLD','SILVER') NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `sport_man_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medals`
--

INSERT INTO `medals` (`id`, `date`, `event_name`, `medal_type`, `category_id`, `sport_man_id`) VALUES
(452, '2004-08-16', 'Olympic Games', 'GOLD', 1, 653);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medals_seq`
--

CREATE TABLE `medals_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medals_seq`
--

INSERT INTO `medals_seq` (`next_val`) VALUES
(651);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport_categories`
--

CREATE TABLE `sport_categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sport_categories`
--

INSERT INTO `sport_categories` (`id`, `name`) VALUES
(10, 'Acrobatic Gymnastics'),
(7, 'Baseball'),
(9, 'Basketball'),
(4, 'Boxing'),
(13, 'Cycling Road'),
(52, 'Fencing'),
(8, 'HandBall'),
(12, 'Hockey'),
(3, 'Judo'),
(102, 'Sailing'),
(5, 'Soccer'),
(2, 'Swimming'),
(1, 'Tennis'),
(6, 'Volleyball');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport_categories_seq`
--

CREATE TABLE `sport_categories_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sport_categories_seq`
--

INSERT INTO `sport_categories_seq` (`next_val`) VALUES
(401);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport_men`
--

CREATE TABLE `sport_men` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sport_men`
--

INSERT INTO `sport_men` (`id`, `age`, `description`, `country_id`, `name`) VALUES
(252, 25, 'example desc', 53, 'Helenette Diaz'),
(552, 16, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat', 53, 'Renee Walker'),
(653, 25, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat', 157, 'Ricardo Gonzalez'),
(702, 28, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat', 2, 'Lorenzo Valdivia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport_men_seq`
--

CREATE TABLE `sport_men_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sport_men_seq`
--

INSERT INTO `sport_men_seq` (`next_val`) VALUES
(1101);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK1pyiwrqimi3hnl3vtgsypj5r` (`name`);

--
-- Indices de la tabla `medals`
--
ALTER TABLE `medals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKos41ysiyh7g2y86pypm5a4wxx` (`category_id`),
  ADD KEY `FKa3orxus8hmrjxkf9xy9hk8llw` (`sport_man_id`);

--
-- Indices de la tabla `sport_categories`
--
ALTER TABLE `sport_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKng1opy6ci38r3asqhojfw5lgf` (`name`);

--
-- Indices de la tabla `sport_men`
--
ALTER TABLE `sport_men`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7qi1spolltebbqxqggys0rden` (`country_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `medals`
--
ALTER TABLE `medals`
  ADD CONSTRAINT `FKa3orxus8hmrjxkf9xy9hk8llw` FOREIGN KEY (`sport_man_id`) REFERENCES `sport_men` (`id`),
  ADD CONSTRAINT `FKos41ysiyh7g2y86pypm5a4wxx` FOREIGN KEY (`category_id`) REFERENCES `sport_categories` (`id`);

--
-- Filtros para la tabla `sport_men`
--
ALTER TABLE `sport_men`
  ADD CONSTRAINT `FK7qi1spolltebbqxqggys0rden` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
