-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2023 a las 22:16:51
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equipo_2db`
--
CREATE DATABASE IF NOT EXISTS `equipo_2db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `equipo_2db`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `nacionalidad_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `demografia`
--

DROP TABLE IF EXISTS `demografia`;
CREATE TABLE `demografia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `demografia`
--

INSERT INTO `demografia` (`id`, `nombre`) VALUES
(1, 'Shounen'),
(2, 'Seinen'),
(3, 'Shoujo'),
(4, 'Josei'),
(5, 'Kodomo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `manga_id` int(11) NOT NULL,
  `tipo_genero_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manga`
--

DROP TABLE IF EXISTS `manga`;
CREATE TABLE `manga` (
  `id` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `anio` int(4) NOT NULL,
  `autor_id` int(11) NOT NULL,
  `demografia_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nacionalidad`
--

DROP TABLE IF EXISTS `nacionalidad`;
CREATE TABLE `nacionalidad` (
  `id` int(11) NOT NULL,
  `iso` char(3) NOT NULL,
  `pais` varchar(80) NOT NULL,
  `gentilicio` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nacionalidad`
--

INSERT INTO `nacionalidad` (`id`, `iso`, `pais`, `gentilicio`) VALUES
(1, 'AFG', 'Afganistán', 'AFGANA'),
(2, 'ALB', 'Albania', 'ALBANESA'),
(3, 'DEU', 'Alemania', 'ALEMANA'),
(4, 'AND', 'Andorra', 'ANDORRANA'),
(5, 'AGO', 'Angola', 'ANGOLEÑA'),
(6, 'ATG', 'AntiguayBarbuda', 'ANTIGUANA'),
(7, 'SAU', 'ArabiaSaudita', 'SAUDÍ'),
(8, 'DZA', 'Argelia', 'ARGELINA'),
(9, 'ARG', 'Argentina', 'ARGENTINA'),
(10, 'ARM', 'Armenia', 'ARMENIA'),
(11, 'ABW', 'Aruba', 'ARUBEÑA'),
(12, 'AUS', 'Australia', 'AUSTRALIANA'),
(13, 'AUT', 'Austria', 'AUSTRIACA'),
(14, 'AZE', 'Azerbaiyán', 'AZERBAIYANA'),
(15, 'BHS', 'Bahamas', 'BAHAMEÑA'),
(16, 'BGD', 'Bangladés', 'BANGLADESÍ'),
(17, 'BRB', 'Barbados', 'BARBADENSE'),
(18, 'BHR', 'Baréin', 'BAREINÍ'),
(19, 'BEL', 'Bélgica', 'BELGA'),
(20, 'BLZ', 'Belice', 'BELICEÑA'),
(21, 'BEN', 'Benín', 'BENINÉSA'),
(22, 'BLR', 'Bielorrusia', 'BIELORRUSA'),
(23, 'MMR', 'Birmania', 'BIRMANA'),
(24, 'BOL', 'Bolivia', 'BOLIVIANA'),
(25, 'BIH', 'Bosnia y Herzegovina', 'BOSNIA'),
(26, 'BWA', 'Botsuana', 'BOTSUANA'),
(27, 'BRA', 'Brasil', 'BRASILEÑA'),
(28, 'BRN', 'Brunéi', 'BRUNEANA'),
(29, 'BGR', 'Bulgaria', 'BÚLGARA'),
(30, 'BFA', 'BurkinaFaso', 'BURKINÉS'),
(31, 'BDI', 'Burundi', 'BURUNDÉSA'),
(32, 'BTN', 'Bután', 'BUTANÉSA'),
(33, 'CPV', 'Cabo Verde', 'CABOVERDIANA'),
(34, 'KHM', 'Camboya', 'CAMBOYANA'),
(35, 'CMR', 'Camerún', 'CAMERUNESA'),
(36, 'CAN', 'Canadá', 'CANADIENSE'),
(37, 'QAT', 'Catar', 'CATARÍ'),
(38, 'TCD', 'Chad', 'CHADIANA'),
(39, 'CHL', 'Chile', 'CHILENA'),
(40, 'CHN', 'China', 'CHINA'),
(41, 'CYP', 'Chipre', 'CHIPRIOTA'),
(42, 'VAT', 'Ciudad del Vaticano', 'VATICANA'),
(43, 'COL', 'Colombia', 'COLOMBIANA'),
(44, 'COM', 'Comoras', 'COMORENSE'),
(45, 'PRK', 'Corea del Norte', 'NORCOREANA'),
(46, 'KOR', 'Corea del Sur', 'SURCOREANA'),
(47, 'CIV', 'Costa de Marfil', 'MARFILEÑA'),
(48, 'CRI', 'Costa Rica', 'COSTARRICENSE'),
(49, 'HRV', 'Croacia', 'CROATA'),
(50, 'CUB', 'Cuba', 'CUBANA'),
(51, 'DNK', 'Dinamarca', 'DANÉSA'),
(52, 'DMA', 'Dominica', 'DOMINIQUÉS'),
(53, 'ECU', 'Ecuador', 'ECUATORIANA'),
(54, 'EGY', 'Egipto', 'EGIPCIA'),
(55, 'SLV', 'El Salvador', 'SALVADOREÑA'),
(56, 'ARE', 'Emiratos Árabes Unidos', 'EMIRATÍ'),
(57, 'ERI', 'Eritrea', 'ERITREA'),
(58, 'SVK', 'Eslovaquia', 'ESLOVACA'),
(59, 'SVN', 'Eslovenia', 'ESLOVENA'),
(60, 'ESP', 'España', 'ESPAÑOLA'),
(61, 'USA', 'Estados Unidos', 'ESTADOUNIDENSE'),
(62, 'EST', 'Estonia', 'ESTONIA'),
(63, 'ETH', 'Etiopía', 'ETÍOPE'),
(64, 'PHL', 'Filipinas', 'FILIPINA'),
(65, 'FIN', 'Finlandia', 'FINLANDÉSA'),
(66, 'FJI', 'Fiyi', 'FIYIANA'),
(67, 'FRA', 'Francia', 'FRANCÉSA'),
(68, 'GAB', 'Gabón', 'GABONÉSA'),
(69, 'GMB', 'Gambia', 'GAMBIANA'),
(70, 'GEO', 'Georgia', 'GEORGIANA'),
(71, 'GIB', 'Gibraltar', 'GIBRALTAREÑA'),
(72, 'GHA', 'Ghana', 'GHANÉSA'),
(73, 'GRD', 'Granada', 'GRANADINA'),
(74, 'GRC', 'Grecia', 'GRIEGA'),
(75, 'GRL', 'Groenlandia', 'GROENLANDÉSA'),
(76, 'GTM', 'Guatemala', 'GUATEMALTECA'),
(77, 'GNQ', 'Guineaecuatorial', 'ECUATOGUINEANA'),
(78, 'GIN', 'Guinea', 'GUINEANA'),
(79, 'GNB', 'Guinea-Bisáu', 'GUINEANA'),
(80, 'GUY', 'Guyana', 'GUYANESA'),
(81, 'HTI', 'Haití', 'HAITIANA'),
(82, 'HND', 'Honduras', 'HONDUREÑA'),
(83, 'HUN', 'Hungría', 'HÚNGARA'),
(84, 'IND', 'India', 'HINDÚ'),
(85, 'IDN', 'Indonesia', 'INDONESIA'),
(86, 'IRQ', 'Irak', 'IRAQUÍ'),
(87, 'IRN', 'Irán', 'IRANÍ'),
(88, 'IRL', 'Irlanda', 'IRLANDÉSA'),
(89, 'ISL', 'Islandia', 'ISLANDÉSA'),
(90, 'COK', 'Islas Cook', 'COOKIANA'),
(91, 'MHL', 'Islas Marshall', 'MARSHALÉSA'),
(92, 'SLB', 'Islas Salomón', 'SALOMONENSE'),
(93, 'ISR', 'Israel', 'ISRAELÍ'),
(94, 'ITA', 'Italia', 'ITALIANA'),
(95, 'JAM', 'Jamaica', 'JAMAIQUINA'),
(96, 'JPN', 'Japón', 'JAPONÉSA'),
(97, 'JOR', 'Jordania', 'JORDANA'),
(98, 'KAZ', 'Kazajistán', 'KAZAJA'),
(99, 'KEN', 'Kenia', 'KENIATA'),
(100, 'KGZ', 'Kirguistán', 'KIRGUISA'),
(101, 'KIR', 'Kiribati', 'KIRIBATIANA'),
(102, 'KWT', 'Kuwait', 'KUWAITÍ'),
(103, 'LAO', 'Laos', 'LAOSIANA'),
(104, 'LSO', 'Lesoto', 'LESOTENSE'),
(105, 'LVA', 'Letonia', 'LETÓNA'),
(106, 'LBN', 'Líbano', 'LIBANÉSA'),
(107, 'LBR', 'Liberia', 'LIBERIANA'),
(108, 'LBY', 'Libia', 'LIBIA'),
(109, 'LIE', 'Liechtenstein', 'LIECHTENSTEINIANA'),
(110, 'LTU', 'Lituania', 'LITUANA'),
(111, 'LUX', 'Luxemburgo', 'LUXEMBURGUÉSA'),
(112, 'MDG', 'Madagascar', 'MALGACHE'),
(113, 'MYS', 'Malasia', 'MALASIA'),
(114, 'MWI', 'Malaui', 'MALAUÍ'),
(115, 'MDV', 'Maldivas', 'MALDIVA'),
(116, 'MLI', 'Malí', 'MALIENSE'),
(117, 'MLT', 'Malta', 'MALTÉSA'),
(118, 'MAR', 'Marruecos', 'MARROQUÍ'),
(119, 'MTQ', 'Martinica', 'MARTINIQUÉS'),
(120, 'MUS', 'Mauricio', 'MAURICIANA'),
(121, 'MRT', 'Mauritania', 'MAURITANA'),
(122, 'MEX', 'México', 'MEXICANA'),
(123, 'FSM', 'Micronesia', 'MICRONESIA'),
(124, 'MDA', 'Moldavia', 'MOLDAVA'),
(125, 'MCO', 'Mónaco', 'MONEGASCA'),
(126, 'MNG', 'Mongolia', 'MONGOLA'),
(127, 'MNE', 'Montenegro', 'MONTENEGRINA'),
(128, 'MOZ', 'Mozambique', 'MOZAMBIQUEÑA'),
(129, 'NAM', 'Namibia', 'NAMIBIA'),
(130, 'NRU', 'Nauru', 'NAURUANA'),
(131, 'NPL', 'Nepal', 'NEPALÍ'),
(132, 'NIC', 'Nicaragua', 'NICARAGÜENSE'),
(133, 'NER', 'Níger', 'NIGERINA'),
(134, 'NGA', 'Nigeria', 'NIGERIANA'),
(135, 'NOR', 'Noruega', 'NORUEGA'),
(136, 'NZL', 'Nueva Zelanda', 'NEOZELANDÉSA'),
(137, 'OMN', 'Omán', 'OMANÍ'),
(138, 'NLD', 'Países Bajos', 'NEERLANDÉSA'),
(139, 'PAK', 'Pakistán', 'PAKISTANÍ'),
(140, 'PLW', 'Palaos', 'PALAUANA'),
(141, 'PSE', 'Palestina', 'PALESTINA'),
(142, 'PAN', 'Panamá', 'PANAMEÑA'),
(143, 'PNG', 'Papúa Nueva Guinea', 'PAPÚ'),
(144, 'PRY', 'Paraguay', 'PARAGUAYA'),
(145, 'PER', 'Perú', 'PERUANA'),
(146, 'POL', 'Polonia', 'POLACA'),
(147, 'PRT', 'Portugal', 'PORTUGUÉSA'),
(148, 'PRI', 'Puerto Rico', 'PUERTORRIQUEÑA'),
(149, 'GBR', 'Reino Unido', 'BRITÁNICA'),
(150, 'CAF', 'RepúblicaCentroafricana', 'CENTROAFRICANA'),
(151, 'CZE', 'República Checa', 'CHECA'),
(152, 'MKD', 'República de Macedonia', 'MACEDONIA'),
(153, 'COG', 'República del Congo', 'CONGOLEÑA'),
(154, 'COD', 'República Democrática delCongo', 'CONGOLEÑA'),
(155, 'DOM', 'República Dominicana', 'DOMINICANA'),
(156, 'ZAF', 'República Sudafricana', 'SUDAFRICANA'),
(157, 'RWA', 'Ruanda', 'RUANDÉSA'),
(158, 'ROU', 'Rumanía', 'RUMANA'),
(159, 'RUS', 'Rusia', 'RUSA'),
(160, 'WSM', 'Samoa', 'SAMOANA'),
(161, 'KNA', 'San Cristóbal y Nieves', 'CRISTOBALEÑA'),
(162, 'SMR', 'San Marino', 'SANMARINENSE'),
(163, 'VCT', 'San Vicente y las Granadinas', 'SANVICENTINA'),
(164, 'LCA', 'Santa Lucía', 'SANTALUCENSE'),
(165, 'STP', 'Santo Tomé y Príncipe', 'SANTOTOMENSE'),
(166, 'SEN', 'Senegal', 'SENEGALÉSA'),
(167, 'SRB', 'Serbia', 'SERBIA'),
(168, 'SYC', 'Seychelles', 'SEYCHELLENSE'),
(169, 'SLE', 'Sierra Leona', 'SIERRALEONÉSA'),
(170, 'SGP', 'Singapur', 'SINGAPURENSE'),
(171, 'SYR', 'Siria', 'SIRIA'),
(172, 'SOM', 'Somalia', 'SOMALÍ'),
(173, 'LKA', 'Sri Lanka', 'CEILANÉSA'),
(174, 'SWZ', 'Suazilandia', 'SUAZI'),
(175, 'SSD', 'Sudán del Sur', 'SURSUDANÉSA'),
(176, 'SDN', 'Sudán', 'SUDANÉSA'),
(177, 'SWE', 'Suecia', 'SUECA'),
(178, 'CHE', 'Suiza', 'SUIZA'),
(179, 'SUR', 'Surinam', 'SURINAMESA'),
(180, 'THA', 'Tailandia', 'TAILANDÉSA'),
(181, 'TZA', 'Tanzania', 'TANZANA'),
(182, 'TJK', 'Tayikistán', 'TAYIKA'),
(183, 'TLS', 'Timor Oriental', 'TIMORENSE'),
(184, 'TGO', 'Togo', 'TOGOLÉSA'),
(185, 'TON', 'Tonga', 'TONGANA'),
(186, 'TTO', 'TrinidadyTobago', 'TRINITENSE'),
(187, 'TUN', 'Túnez', 'TUNECINA'),
(188, 'TKM', 'Turkmenistán', 'TURCOMANA'),
(189, 'TUR', 'Turquía', 'TURCA'),
(190, 'TUV', 'Tuvalu', 'TUVALUANA'),
(191, 'UKR', 'Ucrania', 'UCRANIANA'),
(192, 'UGA', 'Uganda', 'UGANDÉSA'),
(193, 'URY', 'Uruguay', 'URUGUAYA'),
(194, 'UZB', 'Uzbekistán', 'UZBEKA'),
(195, 'VUT', 'Vanuatu', 'VANUATUENSE'),
(196, 'VEN', 'Venezuela', 'VENEZOLANA'),
(197, 'VNM', 'Vietnam', 'VIETNAMITA'),
(198, 'YEM', 'Yemen', 'YEMENÍ'),
(199, 'DJI', 'Yibuti', 'YIBUTIANA'),
(200, 'ZMB', 'Zambia', 'ZAMBIANA'),
(201, 'ZWE', 'Zimbabue', 'ZIMBABUENSE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_genero`
--

DROP TABLE IF EXISTS `tipo_genero`;
CREATE TABLE `tipo_genero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_genero`
--

INSERT INTO `tipo_genero` (`id`, `nombre`) VALUES
(1, 'Acción'),
(2, 'Apocalíptico'),
(3, 'Aventura'),
(4, 'Comedia'),
(5, 'Deportes'),
(6, 'Drama'),
(7, 'Ecchi'),
(8, 'Escolar'),
(9, 'Fantasía'),
(10, 'Gastronomía'),
(11, 'Género bélico'),
(12, 'Gore'),
(13, 'Harem'),
(14, 'Hentai'),
(15, 'Histórico'),
(16, 'Horror'),
(17, 'Isekai'),
(18, 'Kawaii'),
(19, 'Lolicon'),
(20, 'Mecha'),
(21, 'Misterio'),
(22, 'Musical'),
(23, 'Parodia'),
(24, 'Policial'),
(25, 'Psicológico'),
(26, 'Romance'),
(27, 'Shotacon'),
(28, 'Slice of Life'),
(29, 'Sobrenatural'),
(30, 'Space Opera'),
(31, 'Supernatural'),
(32, 'Thriller'),
(33, 'Tragedia'),
(34, 'Yaoi'),
(35, 'Yuri');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tomo`
--

DROP TABLE IF EXISTS `tomo`;
CREATE TABLE `tomo` (
  `manga_id` int(11) NOT NULL,
  `tomo_num` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nacionalidad_id` (`nacionalidad_id`);

--
-- Indices de la tabla `demografia`
--
ALTER TABLE `demografia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`tipo_genero_id`,`manga_id`),
  ADD KEY `manga_id` (`manga_id`);

--
-- Indices de la tabla `manga`
--
ALTER TABLE `manga`
  ADD PRIMARY KEY (`id`),
  ADD KEY `autor_id` (`autor_id`),
  ADD KEY `demografia_id` (`demografia_id`);

--
-- Indices de la tabla `nacionalidad`
--
ALTER TABLE `nacionalidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_genero`
--
ALTER TABLE `tipo_genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tomo`
--
ALTER TABLE `tomo`
  ADD PRIMARY KEY (`manga_id`,`tomo_num`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `manga`
--
ALTER TABLE `manga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nacionalidad`
--
ALTER TABLE `nacionalidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `autor`
--
ALTER TABLE `autor`
  ADD CONSTRAINT `autor_ibfk_1` FOREIGN KEY (`nacionalidad_id`) REFERENCES `nacionalidad` (`id`);

--
-- Filtros para la tabla `genero`
--
ALTER TABLE `genero`
  ADD CONSTRAINT `genero_ibfk_1` FOREIGN KEY (`tipo_genero_id`) REFERENCES `tipo_genero` (`id`),
  ADD CONSTRAINT `genero_ibfk_2` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`);

--
-- Filtros para la tabla `manga`
--
ALTER TABLE `manga`
  ADD CONSTRAINT `manga_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`),
  ADD CONSTRAINT `manga_ibfk_2` FOREIGN KEY (`demografia_id`) REFERENCES `demografia` (`id`);

--
-- Filtros para la tabla `tomo`
--
ALTER TABLE `tomo`
  ADD CONSTRAINT `tomo_ibfk_1` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
