CREATE DATABASE my_nanterre ;
USE my_nanterre;

CREATE TABLE jobs ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, titre VARCHAR(80),entreprise VARCHAR (50), localisation VARCHAR (50), date_publication DATETIME, contrat SET("ALTERNANCE","CDD","CDI","STAGE","TEMPS PLEIN","TEMPS PARTIEL","FREELANCE"),descriptif TEXT,site_web VARCHAR(300), image VARCHAR(100));
SELECT * FROM  jobs;




INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Technicien(ne) micro-informatique','Humensis',' Paris 75012', NOW(),'CDD','Sous la responsabilité du Responsable des systèmes d’information de Humensis, vous aurez notamment en charge les missions suivantes: \r
Gestion et préparation des postes de travail utilisateurs (Mac & PC / Téléphonie/ Licences etc…)
Gestion des comptes utilisateurs sous Active Directory
Gestion des droits d \'accès dans le respect des règles de sécurité de l\'entreprise
Gestion du parc Impressions (Copieurs / Imprimantes)
Support auprès des utilisateurs sur site ou à distance (matériel, système d exploitation, applications, connexions réseau)Suivi des différents incidents déclarés','https://www.humensis.com/nous-rejoindre/','humensis.png');

INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Technicien informatique - H/F','COPY-TOP',' Paris 75', NOW(),'Stage','Rattaché au Responsable d’Exploitation, vos missions au quotidien seront :
La gestion et la maintenance du parc informatique (PC/MAC)
L’installation et la mise à jour des logiciels et applications métiers
Les connexions RIP et paramétrages des drivers d\'impression (PC/MAC)
L’assistance aux utilisateurs et la définition des procédures courantes de maintenance
La supervision des réseaux LAN et VPN
La veille technologique, les préconisations d’amélioration, le reporting d’activité','http://www.emploi-copytop.com/','copytop.png');

INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Product Owner / Designer H/F','Jellysmack',' Levallois-Perret(92)', NOW(),'CDI,TEMPS PLEIN','Aujourd\'hui, nous avons besoin d\'agrandir l\'équipe Produit et de la renforcer avec un Product Owner à très forte sensibilité UI/UX pour améliorer et soutenir le développement des différents produits, en collaboration avec le Product Manager, Product Designer et l\'équipe Tech (développeurs et data scientistes).
Vos missions seront de :
Traduire les besoins utilisateurs en fonctionnalités,
Produire les interfaces Sketch,
Spécifier les fonctionnalités sous formes d\'User Story,
Définir et maintenir le backlog et prioriser les développements au travers de Weekly Goals,
Faire le suivi des développements et les recettes fonctionnelles et visuelles,
Communiquer sur l\'avancement de la réalisation du produit auprès du reste de l\'équipe.',
'https://www.welcometothejungle.co/companies/jellysmack/jobs/product-owner-designer-h-f_levallois-perret','jellysmack.png');

INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Technicien d\'exploitation réseaux LAN/WAN H/F','Orange',' Massy(91)', NOW(),'CDI,TEMPS PLEIN','   Vous intégrez l\'entité gérant l\'activité des Services Managés en charge de la supervision et de l\'exploitation des Systèmes d\'Informations directement de nos clients grands comptes ;
Au sein de cette équipe, vous serez assurerez la bonne coordination et prise en charge des problématiques remontées par le client. Vos missions seront les suivantes :
Administrer et exploiter les solutions informatiques implémentées chez nos clients,
Gérer les incidents et changements de niveau 1,
Participer à la rédaction des procédures d\'exploitation du niveau 1,
Orienter les escalades vers le niveau 2 ou les services compétents,
Assurer un reporting de l\'activité déployée chez le client.','https://orange.jobs/jobs/offer.do?joid=54321&lang=EN&sType=Indeed','orange.png');

INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('STAGE - ASSISTANT IT ANALYST, H/F','BNP Paribas Securities Services','Pantin(93)', NOW(),'Stage','Votre activité sera rythmée par l’analyse et le développement d’un outil de suivi interne : l’opportunité d’accéder à un poste à responsabilités dès le début de votre parcours chez BNP Paribas !

Vous recevrez les instructions et veillerez à leur bon déroulement :
Dans un premier temps le collaborateur aura en charge d\'effectuer l\'analyse du support fonctionnel relatif à un outil de suivi de l\'activité, utilisée par les responsables IT et MOA, qui est également un outil de suivi des dépenses en liaison avec d’autres logiciels. La version 1 de l\'outil est composée :
d\'une application développée en PowerBuilder,
d\'une base de données Sybase.
Dans un second temps, le collaborateur travaillera sur la nouvelle version de l’outil. La refonte en cours s\'effectue en mode AGILE sous JAVA EXTJS et Postgresql.   ',
'https://bnpparibasgt.taleo.net/careersection/gt/jobdetail.ftl?job=1044298&lang=fr_FR&src=JB-13160&src=JB-17660','bnp.png');

INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Administrateur Système et Réseau F/H','ACCENGAGE','Paris(75)', NOW(),'Stage,Alternance','Gestion du parc informatique sous l’assistance du pôle Opérationnel 

Gestion et résolution des actions de support coté infrastructure 

Gestion et résolution des tickets et support interne via freshdesk 

Participation au projet de migration bigdata et autres évolutions internes 

Sous la direction du Référent infra & Production vous interviendrez dans un environnement challengeant sur des technologies innovantes (big data, cloud…) sur une infrastructure à fort trafic. 

  ',
'https://cadres.apec.fr/offres-emploi-cadres/0_0_0_163836961W__________?numIdOffre=163836961W','accengage.png');


INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Spécialiste cyber H/F','ministère des Armées ','FRANCE', NOW(),'CDD,CDI','Ingénierie logicielle (expression du besoin, conception, développement, etc.).
Administration système et sécurité.
Sécurité des systèmes d’information (assistance, conseil, expertise).
Evaluation des systèmes (audit, test d’intrusion, Red team, ...).
Lutte informatique défensive (évaluation de la menace cyber, analyse de traces et supervision dans les SOC, forensic, reverse engineering, …).
Veille sur les réseaux sociaux.
Actions numériques dans le cyberespace.
 ',
'https://www.indeed.fr/emplois?l=Aix-en-Provence%20(13)&vjk=335559e29ad9f56c','armee.png');


INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('consultant informatique développement PHP - Marseille - F/H','TECH VALLEY ','Marseille(13)', NOW(),'CDI','
Vos compétences techniques :
PHP 
 Framework parmi Zend, Symfony, Laravel, Silex, CakePhp, CodeIgniter 
 web services, XML, Api Rest ; 
 Javascript, HTML5 et CSS ; Angular, Bootstrap ; 
 SVN, GIT, ou équivalent ; 
Votre expérience, votre sens du service, votre goût du travail en équipe et vos qualités relationnelles font partie de vos atouts, rejoignez la team TECH VALLEY ! 
 ',
'https://www.carriere-info.fr/Programmation/D%C3%A9veloppeur/offre-emploi-consultant-developpement-php-marseille-601472.html?_c54&utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed','techvalley.png');




INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Coursier livreur à vélo autoentrepreneur','STUART ','Nantes(44)', NOW(),'Freelance','
Vous êtes à la recherche d\'un job, job étudiant ou job à temps partiel et désirez gagner jusqu\'à 120€/jour :

Devenez coursier à vélo avec Stuart ! En rejoignant le réseau Stuart, vous gagnez de l’argent en réalisant des livraisons pour des professionnels.

Pourquoi devenir coursier avec Stuart ?

Payé à la semaine : Vous recevez vos revenus de manière hebdomadaire.
Autonomie: il suffit de vous connecter sur notre application mobile pour recevoir des courses.
Flexibilité : Vous vous connectez quand et autant que vous voulez de 8h à minuit
Simplicité: en tant que coursiers indépendants, vous générez un chiffre d\'affaires à la mission, et vous êtes votre propre patron.
Quelles sont les conditions pour travailler avec Stuart ?
Être majeur
Être autoentrepreneur
Posséder un vélo
Avoir un smartphone',
'https://www.fountain.com/stuart/apply/france-coursier-a-velo?utm_source=IndeedAE','stuart.png');



INSERT INTO jobs  ( titre ,entreprise , localisation ,date_publication, contrat ,descriptif ,site_web , image ) VALUES ('Caissier ELS - Etudiant (h/f)','LIDL France ','Fegersheim (67)', NOW(),'CDI,TEMPS PARTIEL','
Accueillir les clients et répondre à leurs demandes,
Assurer le bon approvisionnement des rayons,
Garantir l\'encaissement fiable des produits,
Garantir la qualité et la fraîcheur des produits,
Maintenir un magasin propre et agréable pour nos clients,
Appliquer au quotidien le concept commercial Lidl.
Votre profil
Vous êtes étudiant et cherchez un emploi pour financer vos études.
Vous êtes organisé et savez prioriser vos actions,
Vous possédez de réelles qualités humaines, et aimez travailler en équipe,
Vous êtes doté d’un bon sens du relationnel
Notre offre
Un poste en CDI étudiant de 7h, 10h ou 14h hebdomadaires.
Une activité professionnelle valorisante compatible avec vos horaires de cours.
Une formation pratique de plusieurs semaines au métier de Caissier ELS,
Une ambiance de travail à la fois professionnelle et conviviale.',
'https://emplois.lidl.fr/fr/Offres-d-emploi/Caissier-ELS-Etudiant-h-f-22123?utm_source=Indeed&utm_medium=cpc&utm_campaign=Indeed','lidl.png');




