-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 22 jan. 2019 à 11:18
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `my_nanterre`
--

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `id_avis` int(11) NOT NULL AUTO_INCREMENT,
  `filiere` varchar(80) DEFAULT NULL,
  `posteOccupe` varchar(100) DEFAULT NULL,
  `commentaire` varchar(200) DEFAULT NULL,
  `noteAmbiance` int(11) DEFAULT NULL,
  `noteEncadrement` int(11) DEFAULT NULL,
  `noteMission` int(11) DEFAULT NULL,
  `entreprise` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_avis`),
  KEY `avis_entreprise` (`entreprise`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `avis`
--

INSERT INTO `avis` (`id_avis`, `filiere`, `posteOccupe`, `commentaire`, `noteAmbiance`, `noteEncadrement`, `noteMission`, `entreprise`) VALUES
(1, 'MIAGE', 'Chef de projet', 'une bonne expérience', 3, 4, 4, 1),
(2, 'Mathématique', 'Consultant finiancière', 'une expérience assez bien', 2, 3, 3, 1),
(3, 'MIAGE', 'Chef de projet', 'une bonne expérience', 3, 4, 4, 2),
(4, 'Droit', 'Chef de projet', 'mauvaise expérience', 2, 3, 1, 2),
(5, 'MIAGE', 'Chef de projet', 'une bonne expérience', 3, 4, 4, 3),
(6, 'MIAGE', 'Développeur JEE', 'une bonne expérience', 3, 4, 4, 4),
(7, 'MIAGE', 'Développeur JAVA', 'une mauvaise expérience', 1, 2, 4, 5);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

DROP TABLE IF EXISTS `entreprise`;
CREATE TABLE IF NOT EXISTS `entreprise` (
  `id_entreprise` int(11) NOT NULL AUTO_INCREMENT,
  `nom_entreprise` varchar(80) DEFAULT NULL,
  `image_entreprise` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_entreprise`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`id_entreprise`, `nom_entreprise`, `image_entreprise`) VALUES
(1, 'Société Générale', 'societeGenerale.jpg'),
(2, 'Aviva', 'aviva.jpg'),
(3, 'EDF', 'edf.jpg'),
(4, 'Orange', 'orange.jpg'),
(5, 'CGI', 'cgi.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(80) DEFAULT NULL,
  `entreprise` varchar(50) DEFAULT NULL,
  `localisation` varchar(50) DEFAULT NULL,
  `date_publication` datetime DEFAULT NULL,
  `contrat` set('ALTERNANCE','CDD','CDI','STAGE','TEMPS PLEIN','TEMPS PARTIEL','FREELANCE') DEFAULT NULL,
  `descriptif` text,
  `site_web` varchar(300) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jobs`
--

INSERT INTO `jobs` (`id`, `titre`, `entreprise`, `localisation`, `date_publication`, `contrat`, `descriptif`, `site_web`, `image`) VALUES
(1, 'Technicien(ne) micro-informatique', 'Humensis', ' Paris 75012', '2019-01-21 14:49:25', 'CDD', 'Sous la responsabilité du Responsable des systèmes d’information de Humensis, vous aurez notamment en charge les missions suivantes: \r\nGestion et préparation des postes de travail utilisateurs (Mac & PC / Téléphonie/ Licences etc…)\nGestion des comptes utilisateurs sous Active Directory\nGestion des droits d \'accès dans le respect des règles de sécurité de l\'entreprise\nGestion du parc Impressions (Copieurs / Imprimantes)\nSupport auprès des utilisateurs sur site ou à distance (matériel, système d exploitation, applications, connexions réseau)Suivi des différents incidents déclarés', 'https://www.humensis.com/nous-rejoindre/', 'humensis.png'),
(2, 'Technicien informatique - H/F', 'COPY-TOP', ' Paris 75', '2019-01-21 14:49:25', 'STAGE', 'Rattaché au Responsable d’Exploitation, vos missions au quotidien seront :\nLa gestion et la maintenance du parc informatique (PC/MAC)\nL’installation et la mise à jour des logiciels et applications métiers\nLes connexions RIP et paramétrages des drivers d\'impression (PC/MAC)\nL’assistance aux utilisateurs et la définition des procédures courantes de maintenance\nLa supervision des réseaux LAN et VPN\nLa veille technologique, les préconisations d’amélioration, le reporting d’activité', 'http://www.emploi-copytop.com/', 'copytop.png'),
(3, 'Product Owner / Designer H/F', 'Jellysmack', ' Levallois-Perret(92)', '2019-01-21 14:49:25', 'CDI,TEMPS PLEIN', 'Aujourd\'hui, nous avons besoin d\'agrandir l\'équipe Produit et de la renforcer avec un Product Owner à très forte sensibilité UI/UX pour améliorer et soutenir le développement des différents produits, en collaboration avec le Product Manager, Product Designer et l\'équipe Tech (développeurs et data scientistes).\nVos missions seront de :\nTraduire les besoins utilisateurs en fonctionnalités,\nProduire les interfaces Sketch,\nSpécifier les fonctionnalités sous formes d\'User Story,\nDéfinir et maintenir le backlog et prioriser les développements au travers de Weekly Goals,\nFaire le suivi des développements et les recettes fonctionnelles et visuelles,\nCommuniquer sur l\'avancement de la réalisation du produit auprès du reste de l\'équipe.', 'https://www.welcometothejungle.co/companies/jellysmack/jobs/product-owner-designer-h-f_levallois-perret', 'jellysmack.png'),
(4, 'Technicien d\'exploitation réseaux LAN/WAN H/F', 'Orange', ' Massy(91)', '2019-01-21 14:49:25', 'CDI,TEMPS PLEIN', '   Vous intégrez l\'entité gérant l\'activité des Services Managés en charge de la supervision et de l\'exploitation des Systèmes d\'Informations directement de nos clients grands comptes ;\nAu sein de cette équipe, vous serez assurerez la bonne coordination et prise en charge des problématiques remontées par le client. Vos missions seront les suivantes :\nAdministrer et exploiter les solutions informatiques implémentées chez nos clients,\nGérer les incidents et changements de niveau 1,\nParticiper à la rédaction des procédures d\'exploitation du niveau 1,\nOrienter les escalades vers le niveau 2 ou les services compétents,\nAssurer un reporting de l\'activité déployée chez le client.', 'https://orange.jobs/jobs/offer.do?joid=54321&lang=EN&sType=Indeed', 'orange.png'),
(5, 'STAGE - ASSISTANT IT ANALYST, H/F', 'BNP Paribas Securities Services', 'Pantin(93)', '2019-01-21 14:49:25', 'STAGE', 'Votre activité sera rythmée par l’analyse et le développement d’un outil de suivi interne : l’opportunité d’accéder à un poste à responsabilités dès le début de votre parcours chez BNP Paribas !\n\nVous recevrez les instructions et veillerez à leur bon déroulement :\nDans un premier temps le collaborateur aura en charge d\'effectuer l\'analyse du support fonctionnel relatif à un outil de suivi de l\'activité, utilisée par les responsables IT et MOA, qui est également un outil de suivi des dépenses en liaison avec d’autres logiciels. La version 1 de l\'outil est composée :\nd\'une application développée en PowerBuilder,\nd\'une base de données Sybase.\nDans un second temps, le collaborateur travaillera sur la nouvelle version de l’outil. La refonte en cours s\'effectue en mode AGILE sous JAVA EXTJS et Postgresql.   ', 'https://bnpparibasgt.taleo.net/careersection/gt/jobdetail.ftl?job=1044298&lang=fr_FR&src=JB-13160&src=JB-17660', 'bnp.png'),
(6, 'Administrateur Système et Réseau F/H', 'ACCENGAGE', 'Paris(75)', '2019-01-21 14:49:25', 'ALTERNANCE,STAGE', 'Gestion du parc informatique sous l’assistance du pôle Opérationnel \n\nGestion et résolution des actions de support coté infrastructure \n\nGestion et résolution des tickets et support interne via freshdesk \n\nParticipation au projet de migration bigdata et autres évolutions internes \n\nSous la direction du Référent infra & Production vous interviendrez dans un environnement challengeant sur des technologies innovantes (big data, cloud…) sur une infrastructure à fort trafic. \n\n  ', 'https://cadres.apec.fr/offres-emploi-cadres/0_0_0_163836961W__________?numIdOffre=163836961W', 'accengage.png'),
(7, 'Spécialiste cyber H/F', 'ministère des Armées ', 'FRANCE', '2019-01-21 14:49:25', 'CDD,CDI', 'Ingénierie logicielle (expression du besoin, conception, développement, etc.).\nAdministration système et sécurité.\nSécurité des systèmes d’information (assistance, conseil, expertise).\nEvaluation des systèmes (audit, test d’intrusion, Red team, ...).\nLutte informatique défensive (évaluation de la menace cyber, analyse de traces et supervision dans les SOC, forensic, reverse engineering, …).\nVeille sur les réseaux sociaux.\nActions numériques dans le cyberespace.\n ', 'https://www.indeed.fr/emplois?l=Aix-en-Provence%20(13)&vjk=335559e29ad9f56c', 'armee.png'),
(8, 'consultant informatique développement PHP - Marseille - F/H', 'TECH VALLEY ', 'Marseille(13)', '2019-01-21 14:49:25', 'CDI', '\nVos compétences techniques :\nPHP \n Framework parmi Zend, Symfony, Laravel, Silex, CakePhp, CodeIgniter \n web services, XML, Api Rest ; \n Javascript, HTML5 et CSS ; Angular, Bootstrap ; \n SVN, GIT, ou équivalent ; \nVotre expérience, votre sens du service, votre goût du travail en équipe et vos qualités relationnelles font partie de vos atouts, rejoignez la team TECH VALLEY ! \n ', 'https://www.carriere-info.fr/Programmation/D%C3%A9veloppeur/offre-emploi-consultant-developpement-php-marseille-601472.html?_c54&utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed', 'techvalley.png'),
(9, 'Coursier livreur à vélo autoentrepreneur', 'STUART ', 'Nantes(44)', '2019-01-21 14:49:25', 'FREELANCE', '\nVous êtes à la recherche d\'un job, job étudiant ou job à temps partiel et désirez gagner jusqu\'à 120€/jour :\n\nDevenez coursier à vélo avec Stuart ! En rejoignant le réseau Stuart, vous gagnez de l’argent en réalisant des livraisons pour des professionnels.\n\nPourquoi devenir coursier avec Stuart ?\n\nPayé à la semaine : Vous recevez vos revenus de manière hebdomadaire.\nAutonomie: il suffit de vous connecter sur notre application mobile pour recevoir des courses.\nFlexibilité : Vous vous connectez quand et autant que vous voulez de 8h à minuit\nSimplicité: en tant que coursiers indépendants, vous générez un chiffre d\'affaires à la mission, et vous êtes votre propre patron.\nQuelles sont les conditions pour travailler avec Stuart ?\nÊtre majeur\nÊtre autoentrepreneur\nPosséder un vélo\nAvoir un smartphone', 'https://www.fountain.com/stuart/apply/france-coursier-a-velo?utm_source=IndeedAE', 'stuart.png'),
(10, 'Caissier ELS - Etudiant (h/f)', 'LIDL France ', 'Fegersheim (67)', '2019-01-21 14:49:25', 'CDI,TEMPS PARTIEL', '\nAccueillir les clients et répondre à leurs demandes,\nAssurer le bon approvisionnement des rayons,\nGarantir l\'encaissement fiable des produits,\nGarantir la qualité et la fraîcheur des produits,\nMaintenir un magasin propre et agréable pour nos clients,\nAppliquer au quotidien le concept commercial Lidl.\nVotre profil\nVous êtes étudiant et cherchez un emploi pour financer vos études.\nVous êtes organisé et savez prioriser vos actions,\nVous possédez de réelles qualités humaines, et aimez travailler en équipe,\nVous êtes doté d’un bon sens du relationnel\nNotre offre\nUn poste en CDI étudiant de 7h, 10h ou 14h hebdomadaires.\nUne activité professionnelle valorisante compatible avec vos horaires de cours.\nUne formation pratique de plusieurs semaines au métier de Caissier ELS,\nUne ambiance de travail à la fois professionnelle et conviviale.', 'https://emplois.lidl.fr/fr/Offres-d-emploi/Caissier-ELS-Etudiant-h-f-22123?utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed', 'lidl.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
