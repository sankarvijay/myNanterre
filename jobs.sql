-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 03 fév. 2019 à 16:54
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

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
-- Structure de la table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(80) DEFAULT NULL,
  `entreprise` varchar(50) DEFAULT NULL,
  `localisation` varchar(50) DEFAULT NULL,
  `date_publication` datetime DEFAULT NULL,
  `contrat` set('ALTERNANCE','CDD','CDI','STAGE','INTERIM') DEFAULT NULL,
  `descriptif` text,
  `site_web` varchar(300) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jobs`
--

INSERT INTO `jobs` (`id`, `titre`, `entreprise`, `localisation`, `date_publication`, `contrat`, `descriptif`, `site_web`, `image`) VALUES
(1, 'Technicien(ne) micro-informatique', 'Humensis', ' Paris 75012', '2019-01-20 15:41:48', 'CDD', 'Sous la responsabilité du Responsable des systèmes d’information de Humensis, vous aurez notamment en charge les missions suivantes: \r\n\r\nGestion et préparation des postes de travail utilisateurs (Mac & PC / Téléphonie/ Licences etc…)\r\nGestion des comptes utilisateurs sous Active Directory\r\nGestion des droits d \'accès dans le respect des règles de sécurité de l\'entreprise\r\nGestion du parc Impressions (Copieurs / Imprimantes)\r\nSupport auprès des utilisateurs sur site ou à distance (matériel, système d exploitation, applications, connexions réseau)Suivi des différents incidents déclarés', 'https://www.humensis.com/nous-rejoindre/', 'humensis.png'),
(2, 'Technicien informatique - H/F', 'COPY-TOP', ' Paris 75019', '2019-01-20 15:41:48', 'STAGE', 'Rattaché au Responsable d’Exploitation, vos missions au quotidien seront :\r\nLa gestion et la maintenance du parc informatique (PC/MAC)\r\nL’installation et la mise à jour des logiciels et applications métiers\r\nLes connexions RIP et paramétrages des drivers d\'impression (PC/MAC)\r\nL’assistance aux utilisateurs et la définition des procédures courantes de maintenance\r\nLa supervision des réseaux LAN et VPN\r\nLa veille technologique, les préconisations d’amélioration, le reporting d’activité', 'http://www.emploi-copytop.com/', 'copytop.png'),
(3, 'Product Owner / Designer H/F', 'Jellysmack', ' Levallois-Perret(92)', '2019-01-20 15:41:49', 'CDI', 'Aujourd\'hui, nous avons besoin d\'agrandir l\'équipe Produit et de la renforcer avec un Product Owner à très forte sensibilité UI/UX pour améliorer et soutenir le développement des différents produits, en collaboration avec le Product Manager, Product Designer et l\'équipe Tech (développeurs et data scientistes).\r\nVos missions seront de :\r\nTraduire les besoins utilisateurs en fonctionnalités,\r\nProduire les interfaces Sketch,\r\nSpécifier les fonctionnalités sous formes d\'User Story,\r\nDéfinir et maintenir le backlog et prioriser les développements au travers de Weekly Goals,\r\nFaire le suivi des développements et les recettes fonctionnelles et visuelles,\r\nCommuniquer sur l\'avancement de la réalisation du produit auprès du reste de l\'équipe.', 'https://www.welcometothejungle.co/companies/jellysmack/jobs/product-owner-designer-h-f_levallois-perret', 'jellysmack.png'),
(4, 'Technicien d\'exploitation réseaux LAN/WAN H/F', 'Orange', ' Massy(91)', '2019-01-20 15:41:49', 'CDI', '   Vous intégrez l\'entité gérant l\'activité des Services Managés en charge de la supervision et de l\'exploitation des Systèmes d\'Informations directement de nos clients grands comptes ;\r\nAu sein de cette équipe, vous serez assurerez la bonne coordination et prise en charge des problématiques remontées par le client. Vos missions seront les suivantes :\r\nAdministrer et exploiter les solutions informatiques implémentées chez nos clients,\r\nGérer les incidents et changements de niveau 1,\r\nParticiper à la rédaction des procédures d\'exploitation du niveau 1,\r\nOrienter les escalades vers le niveau 2 ou les services compétents,\r\nAssurer un reporting de l\'activité déployée chez le client.', 'https://orange.jobs/jobs/offer.do?joid=54321&lang=EN&sType=Indeed', 'orange.png'),
(5, 'STAGE - ASSISTANT IT ANALYST, H/F', 'BNP Paribas Securities Services', 'Pantin(93)', '2019-01-20 15:41:49', 'STAGE', 'Votre activité sera rythmée par l’analyse et le développement d’un outil de suivi interne : l’opportunité d’accéder à un poste à responsabilités dès le début de votre parcours chez BNP Paribas !\r\nVous recevrez les instructions et veillerez à leur bon déroulement :\r\nDans un premier temps le collaborateur aura en charge d\'effectuer l\'analyse du support fonctionnel relatif à un outil de suivi de l\'activité, utilisée par les responsables IT et MOA, qui est également un outil de suivi des dépenses en liaison avec d’autres logiciels. La version 1 de l\'outil est composée :\r\nd\'une application développée en PowerBuilder,\r\nd\'une base de données Sybase.\r\nDans un second temps, le collaborateur travaillera sur la nouvelle version de l’outil. La refonte en cours s\'effectue en mode AGILE sous JAVA EXTJS et Postgresql.   ', 'https://bnpparibasgt.taleo.net/careersection/gt/jobdetail.ftl?job=1044298&lang=fr_FR&src=JB-13160&src=JB-17660', 'bnp.png'),
(6, 'Administrateur Système et Réseau F/H', 'ACCENGAGE', 'Paris(75)', '2019-01-20 15:41:49', 'ALTERNANCE', 'Gestion du parc informatique sous l’assistance du pôle Opérationnel \r\nGestion et résolution des actions de support coté infrastructure \r\nGestion et résolution des tickets et support interne via freshdesk \r\nParticipation au projet de migration bigdata et autres évolutions internes \r\nSous la direction du Référent infra & Production vous interviendrez dans un environnement challengeant sur des technologies innovantes (big data, cloud…) sur une infrastructure à fort trafic. \r\n  ', 'https://cadres.apec.fr/offres-emploi-cadres/0_0_0_163836961W__________?numIdOffre=163836961W', 'accengage.png'),
(7, 'Spécialiste cyber H/F', 'ministère des Armées ', 'FRANCE', '2019-01-20 15:41:49', 'CDD', 'Ingénierie logicielle (expression du besoin, conception, développement, etc.).\r\nAdministration système et sécurité.\r\nSécurité des systèmes d’information (assistance, conseil, expertise).\r\nEvaluation des systèmes (audit, test d’intrusion, Red team, ...).\r\nLutte informatique défensive (évaluation de la menace cyber, analyse de traces et supervision dans les SOC, forensic, reverse engineering, …).\r\nVeille sur les réseaux sociaux.\r\nActions numériques dans le cyberespace.\r\n ', 'https://www.indeed.fr/emplois?l=Aix-en-Provence%20(13)&vjk=335559e29ad9f56c', 'armee.png'),
(8, 'consultant informatique développement PHP - Marseille - F/H', 'TECH VALLEY ', 'Marseille(13)', '2019-01-20 15:41:49', 'CDI', '\r\nVos compétences techniques :\r\nPHP \r\n Framework parmi Zend, Symfony, Laravel, Silex, CakePhp, CodeIgniter \r\n web services, XML, Api Rest ; \r\n Javascript, HTML5 et CSS ; Angular, Bootstrap ; \r\n SVN, GIT, ou équivalent ; \r\nVotre expérience, votre sens du service, votre goût du travail en équipe et vos qualités relationnelles font partie de vos atouts, rejoignez la team TECH VALLEY ! \r\n ', 'https://www.carriere-info.fr/Programmation/D%C3%A9veloppeur/offre-emploi-consultant-developpement-php-marseille-601472.html?_c54&utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed', 'techvalley.png'),
(9, 'Coursier livreur à vélo autoentrepreneur', 'STUART ', 'Nantes(44)', '2019-01-20 15:41:49', 'STAGE', '\r\nVous êtes à la recherche d\'un job, job étudiant ou job à temps partiel et désirez gagner jusqu\'à 120€/jour :\r\nDevenez coursier à vélo avec Stuart ! En rejoignant le réseau Stuart, vous gagnez de l’argent en réalisant des livraisons pour des professionnels.\r\nPourquoi devenir coursier avec Stuart ?\r\nPayé à la semaine : Vous recevez vos revenus de manière hebdomadaire.\r\nAutonomie: il suffit de vous connecter sur notre application mobile pour recevoir des courses.\r\nFlexibilité : Vous vous connectez quand et autant que vous voulez de 8h à minuit\r\nSimplicité: en tant que coursiers indépendants, vous générez un chiffre d\'affaires à la mission, et vous êtes votre propre patron.\r\nQuelles sont les conditions pour travailler avec Stuart ?\r\nÊtre majeur\r\nÊtre autoentrepreneur\r\nPosséder un vélo\r\nAvoir un smartphone', 'https://www.fountain.com/stuart/apply/france-coursier-a-velo?utm_source=IndeedAE', 'stuart.png'),
(10, 'Caissier ELS - Etudiant (h/f)', 'LIDL France ', 'Fegersheim (67)', '2019-01-20 15:41:49', 'INTERIM', '\r\nAccueillir les clients et répondre à leurs demandes,\r\nAssurer le bon approvisionnement des rayons,\r\nGarantir l\'encaissement fiable des produits,\r\nGarantir la qualité et la fraîcheur des produits,\r\nMaintenir un magasin propre et agréable pour nos clients,\r\nAppliquer au quotidien le concept commercial Lidl.\r\nVotre profil\r\nVous êtes étudiant et cherchez un emploi pour financer vos études.\r\nVous êtes organisé et savez prioriser vos actions,\r\nVous possédez de réelles qualités humaines, et aimez travailler en équipe,\r\nVous êtes doté d’un bon sens du relationnel\r\nNotre offre\r\nUn poste en CDI étudiant de 7h, 10h ou 14h hebdomadaires.\r\nUne activité professionnelle valorisante compatible avec vos horaires de cours.\r\nUne formation pratique de plusieurs semaines au métier de Caissier ELS,\r\nUne ambiance de travail à la fois professionnelle et conviviale.', 'https://emplois.lidl.fr/fr/Offres-d-emploi/Caissier-ELS-Etudiant-h-f-22123?utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed', 'lidl.png'),
(11, 'Titre', 'Entreprise', 'test', '2019-01-01 15:20:20', 'CDD', 'Descriptif de l\'offre', 'URL', NULL),
(12, 'test', 'test2', 'test', '2019-01-01 15:20:35', 'STAGE', 'bonjourrrrrr', 'tessssst', NULL),
(13, 'salam', 'malescoumes', 'okkkk', '2019-01-02 14:55:50', 'ALTERNANCE', 'Test okkkkk', 'http://salam.com', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
