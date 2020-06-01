# jeedit

> Projet de création d'une plateforme de posts style **reddit** à partir d'une architecture JEE.
> L'interface devra permettre à l'utilisateur de :
> 1. Ecrire des posts
> 2. Commenter des posts
> 3. Répondre à ces commentaires
> 4. Voter _up_ ou _down_ sur les posts et commentaires.

Début du projet : 13 mars 2020



## Initialisation de la base de données

Dans l'interface utilisateur `root` :
```sql
SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';

CREATE USER 'dbadmin'@'localhost' IDENTIFIED BY 'JintnR';

DROP DATABASE IF EXISTS jeedit;
CREATE DATABASE jeedit; 
GRANT ALL PRIVILEGES ON jeedit.* TO 'dbadmin'@'localhost';
```

Dans l'interface utilisateur `dbadmin` :
```sql
DROP DATABASE IF EXISTS jeedit;
CREATE DATABASE jeedit CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE jeedit;
CREATE TABLE Post (post_id int(32) NOT NULL auto_increment primary key, 
author varchar(128) DEFAULT "Anonymous", 
title varchar(512),
content varchar(4096),
post_type enum('text','media','type') default 'text', 
post_date datetime default NOW(),
parent_id int(32) default 0,
votes int(32) default 0) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

INSERT INTO Post(`post_id`,`author`,`title`,`content`,`votes`) 
VALUES (1,'Marion & Thomas','Bienvenue sur ce super site ! 🤩',
'Bon voilà, c\'est le premier post sur jeedit 🍵, j\'espère que ça marchera bien 
surtout les commentaires 🧾. Pour le système de votes y\'a encore un peu de boulot 
mais on est sûr que ça va le faire voilà voilà 😅 Des bisous 😘',20);
```

