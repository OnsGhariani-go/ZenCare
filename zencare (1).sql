-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le : Jeu 05 Novembre 2026 à 12:50
-- Version du serveur: 5.5.16
-- Version de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `zencare`
--

-- --------------------------------------------------------

--
-- Structure de la table `malade`
--

CREATE TABLE IF NOT EXISTS `malade` (
  `Nom` varchar(100) NOT NULL,
  `Prenom` varchar(100) NOT NULL,
  `Datenaiss` date NOT NULL,
  `Sexe` varchar(10) NOT NULL,
  `Tel` int(8) NOT NULL,
  `Mdp` varchar(100) NOT NULL,
  PRIMARY KEY (`Tel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `malade`
--

INSERT INTO `malade` (`Nom`, `Prenom`, `Datenaiss`, `Sexe`, `Tel`, `Mdp`) VALUES
('GHARIANI', 'Ons', '2005-07-30', 'Femme', 23661127, '123'),
('GHARIANI', 'Abdessattar', '1975-05-22', 'Homme', 23746120, 'stoura123');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE IF NOT EXISTS `medicament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Trait` varchar(100) NOT NULL,
  `Dure` varchar(100) NOT NULL,
  `Nommed` varchar(100) NOT NULL,
  `Dose` int(11) NOT NULL,
  `Jour` varchar(100) NOT NULL,
  `Temps` varchar(100) NOT NULL,
  `des` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=77 ;

--
-- Contenu de la table `medicament`
--

INSERT INTO `medicament` (`id`, `Trait`, `Dure`, `Nommed`, `Dose`, `Jour`, `Temps`, `des`) VALUES
(73, 'Anemie', '7 jours', 'VitaFer', 2, 'MatinDiner', 'Apres le Repas', NULL),
(74, 'Anemie', '7 jours', 'VitaFer', 1, '30/04/2026', 'Matin ', 'bie(n cv'),
(75, 'Alllergie', '2 mois', 'Pivalone', 2, 'MatinDiner', 'Apres le Repas', NULL),
(76, 'Alllergie', '2 mois', 'Pivalone', 1, '02/05/2026', 'Matin Diner ', 'cv juste un peu de fatique et vertige');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
