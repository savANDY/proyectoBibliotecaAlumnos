-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2017 a las 10:26:35
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(2) NOT NULL,
  `titulo` varchar(27) DEFAULT NULL,
  `autor` varchar(24) DEFAULT NULL,
  `num_pag` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `autor`, `num_pag`) VALUES
(1, 'NOSTRADAMUS', 'FRANCIS X.KING', 176),
(2, 'EL ESCRITOR Y SUS FANTASMAS', 'ERNESTO SABATO', 208),
(3, 'VIDAS MAGICAS E INQUISICION', 'JULIO CARO BAROJA', 850),
(4, 'FUNDACION Y TIERRA', 'ISAAC ASIMOV', 528),
(5, 'MUSEO DEL PRADO', 'SANTIAGO ALCOLEA BLANS', 464),
(6, 'EL OPALO NEGRO', 'VICTORIA HOLT', 384),
(7, 'POESIA Y OTROS TEXTOS', 'SAN JUAN DE LA CRUZ', 304),
(8, 'EL JUEGO DE HERRALL', 'STEPHEN KING', 400),
(9, 'HONOR ENTRE LADRONES', 'JEFFREY ARCHER', 400),
(10, 'EL SEÑOR DE LOS ANILLOS', 'J.R. TOLKIEN', 1104),
(11, 'EL RESPLANDOR', 'STEPHEN KING', 380),
(12, 'IT', 'STEPHEN KING', 1000),
(13, 'LA TIENDA', 'STEPHEN KING', 886),
(14, 'EN COMA', 'ROBIN COOK', 400),
(15, 'COMO SI FUERA DIOS', 'ROBIN COOK', 456),
(16, 'TEMINAL', 'ROBIN COOK', 370),
(17, 'OCEANO', 'ALBERTO VAZQUEZ FIGUEROA', 250),
(18, 'LA IGUANA', 'ALBERTO VAZQUEZ FIGUEROA', 290),
(19, 'YALZA', 'ALBERTO VAZQUEZ FIGUEROA', 350),
(20, 'LA TABLA DE FLANDES', 'ARTURO PEREZ REVERTE', 450),
(21, 'EL CLUB DUMAS', 'ARTURO PEREZ REVERTE', 600);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id_libro` int(2) NOT NULL,
  `id_socio` int(1) NOT NULL,
  `fecha` date NOT NULL,
  `devuelto` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `id` int(1) NOT NULL,
  `nombre` varchar(8) DEFAULT NULL,
  `apellido` varchar(17) DEFAULT NULL,
  `direccion` varchar(22) DEFAULT NULL,
  `poblacion` varchar(11) DEFAULT NULL,
  `provincia` varchar(15) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `nombre`, `apellido`, `direccion`, `poblacion`, `provincia`, `dni`) VALUES
(1, 'MERTXE', 'MEANA GOMEZ', 'KAREAGA 13', 'BARAKALDO', 'BIZKAIA', '13929563'),
(2, 'JOSEBA', 'ALTUNA GARAY', 'AVDA. MINERO 28', 'ORTUELLA', 'BIZKAIA', '14903129'),
(3, 'JAVIER', 'MARTINEZ BELAUSTE', 'LASAGABAS¡TER , 15, 15', 'ORTUELLA', 'BIZKAIA', '22145980'),
(4, 'JUAN', 'GALARZA IZA', 'CORREOS, 27', 'PORTUGALETE', 'BIZKAIA', '22567412'),
(5, 'MERCEDES', 'PEREZ GARCIA', 'PEREZ GALDOS 30', 'BILBAO', 'BIZKAIA', '22435018'),
(6, 'AITOR', 'RIVAS CARRERAS', 'AVDA. LA LIBERTAD, 26', 'BARAKALDO', 'BIZKAIA', '22768546'),
(7, 'MARTA', 'RIVAS CARRERAS', 'AVDA. LA LIBERTAD, 26', 'BARAKALDO', 'BIZKAIA', '22579061'),
(8, 'AMAIA', 'GONZALEZ GONZALEZ', 'AVDA. EUSKADI', 'BARAKALDO', 'BIZKAIA', '14679405');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id_libro`,`id_socio`,`fecha`),
  ADD KEY `id_socio` (`id_socio`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
