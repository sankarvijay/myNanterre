[![Build Status](https://travis-ci.com/sankarvijay/myNanterre.svg?branch=master)](https://travis-ci.org/sankarvijay/myNanterre)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/86d12dbdeda94a9193f592d34d71574f)](https://app.codacy.com/app/sankarvijay/myNanterre?utm_source=github.com&utm_medium=referral&utm_content=sankarvijay/myNanterre&utm_campaign=Badge_Grade_Dashboard)
[![Waffle.io - Columns and their card count](https://badge.waffle.io/sankarvijay/myNanterre.svg?columns=all)](https://waffle.io/sankarvijay/myNanterre)
[![GitHub issues](https://img.shields.io/github/issues/sankarvijay/myNanterre.svg)](https://github.com/sankarvijay/myNanterre/issues)
[![License](https://img.shields.io/github/license/sankarvijay/myNanterre.svg?style=flat-square)](LICENSE)
[![Version](https://img.shields.io/github/release/sankarvijay/MyNanterre.svg?label=version&style=flat-square)](build.gradle)
[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg)](http://commitizen.github.io/cz-cli/)
[![Coverage Status](https://coveralls.io/repos/github/sankarvijay/myNanterre/badge.svg?branch=master)](https://coveralls.io/github/sankarvijay/myNanterre?branch=master)

# MyNanterre

**MyNanterre**, l'application pour une meilleure vie étudiante à Nanterre. 

## Qu'est ce que c'est ?

Une application pour aider les étudiants de Nanterre durant leurs vies étudiantes. Développée sur mobile, et plus spécialement sur la plateforme **Android**, MyNanterre est une application sur smartphone.

MyNanterre est une application qui vous permettra de :

- programmer vos propres séances de sports auxquelles les étudiants pourront s'inscrire.
- de découvrir les sports disponibles à Nanterre et leurs horaires.
- visualiser l'afflucence sur les différents points de restauration ouverts à l'Université et les produits disponibles.
- connaitre les prochains départs de train depuis Nanterre-Université, mais aussi personnalisez avec votre gare favorite pour le rer A et la ligne L.

Pour avoir plus d'informations, visitez notre site web : https://sankarvijay.github.io/myNanterre/

## Télécharger 

L'application peut être téléchargée 

- soit via l'url : <a href="https://github.com/sankarvijay/myNanterre/releases/download/v1.0/myNanterre_v1.0.apk">/releases/download/v1.0/myNanterre_v1.0.apk</a> 

- soit via le QR Code : 

<a rel='nofollow' href='http://www.qrcode-generator.de
        ' border='0' style='cursor:default'><img src='https://chart.googleapis.com/chart?cht=qr&chl=https%3A%2F%2Fgithub.com%2Fsankarvijay%2FmyNanterre%2Freleases%2Fdownload%2Fv1.0%2FmyNanterre_v1.0.apk&chs=180x180&choe=UTF-8&chld=L|2' alt=''></a>

## Librairies
-   Données Open data : [RATP](https://github.com/pgrimaud/horaires-ratp-api) sous [(licences)](https://github.com/pgrimaud/horaires-ratp-api/blob/master/LICENSE)
-   Données Open data : [STIF](https://opendata.stif.info/page/licences/) sous [(licences)](https://opendata.stif.info/page/licences/)

## Système de Build
* [Gradle](https://gradle.org/)

### Compiling

```shell
cd myNanterre/
./gradlew
ou sur windows :
./gradlew.bat

et enfin :

adb install -r myNanterre.apk

```
## Installation

### Prérequis

Avant de pouvoir utiliser notre projet, il faut installer certains outils.

#### Installer le SDK

- Télécharger et installer le SDK : http://www.oracle.com/technetwork/java/javase/downloads/index.html

  
#### Installer Git

- Télécharger et installer Git : [Télécharger Git](https://gitforwindows.org/)

#### Installer Android Studio

- Télécharger et installer Git : [Télécharger Android Studio](https://developer.android.com/studio/install)

## Deux manières de lancer l'application

### Via l'émulateur d'Android Studio

Suivre ce tuto : [Tutoriel AVD Manager](http://vogella.developpez.com/tutoriels/android/installation-outils-developpement/#L5)

#### Cloner MyNanterre

Une fois Git installé, il suffit de suivre les instructions ci-dessous.

git clone https://github.com/sankarvijay/myNanterre.git

### Via votre mobile

Depuis votre mobile Android, récupérez l'apk sur notre site web https://sankarvijay.github.io/myNanterre/. Puis, autorisez l'installation. Une fois installé, vous verrez dans votre menu, l'application myNanterre.

Et voila ! le projet est prêt pour utilisation.

## Auteurs
* **SANKAR Vijay** - [Github](https://github.com/sankarvijay)
* **VIEIRA Dorian** - [Github](https://github.com/dorianvieira)
* **VOUILLOT Marie** - [Github](https://github.com/marievouillot12)
