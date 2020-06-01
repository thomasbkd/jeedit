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

INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (1,'Marion & Thomas','Bienvenue sur ce super site ! 🤩','Bon voilà, voici le premier post sur notre jeedit 🍵, j\'espère que ça marchera bien surtout les commentaires 🧾. \r\nPour le système de votes y\'a encore un peu de boulot mais on est sûr que ça va le faire 😅 (UPDATE : ça fonctionne !!! 🥳🎉)\r\nBonne visite ! 😄','text',NULL,0,23);
INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (2,'Anonymous',NULL,'bon par contre, quelques petites modifications manquent à l\'appel :','text',NULL,1,3);
INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (3,'Anonymous',NULL,'par exemple, on n\'a réussi qu\'à coder un étage de commentaire, bien qu\'on aurait voulu qu\'il y en ai un peu plus (on voulait exploiter un peu plus le parent_id), mais on n\'a pas trouvé d\'algorithme permettant de le faire efficacement à l\'aide des JSTL (pas de boucle while par exemple). ','text',NULL,1,1);
INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (4,'Anonymous',NULL,'on aurait également souhaité créer de réels utilisateurs plutôt que d\'utiliser des simples pseudos, cela nous aurait permis de limiter le nombre de votes, pour éviter qu\'il s\'agisse plus d\'une course au clic qu\'autre chose.','text',NULL,1,1);
INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (5,'Anonymous',NULL,'nous n\'avons pas non plus intégré la suppression des posts au site, bien que la fonction soit disponible dans le DAO !','text',NULL,1,1);
INSERT INTO Post (`post_id`,`author`,`title`,`content`,`post_type`,`post_date`,`parent_id`,`votes`) VALUES (6,'Anonymous',NULL,'Enfin bref, bonne utilisation 😉','text',NULL,2,0);
```

---
## VERSION ACTUELLE :
Dans cette version, il est possible de :
* Ecrire des posts
* Répondre à des posts
* Votes up ou down sur des posts et commentaires

Au niveau de l'affichage : 
* Inclusion de l'UTF-8 pour afficher les accents et les emojis 😀
* Système d'indentation pour différencier les posts des commentaires
* Affichage décroissant selon le nombre de votes sur les posts et les commentaires
* Impossibilité de passer en-dessous de zéro vote sur un post ou un commentaire.