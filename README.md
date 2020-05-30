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
CREATE DATABASE jeedit; 
USE jeedit;
CREATE TABLE Post (post_id int(32) NOT NULL auto_increment primary key, author varchar(64), 
title varchar(500), content varchar(2000), post_type enum('text','media','type'), 
post_date datetime, parent int(32), votes int(32) default 0);

INSERT INTO jeedit.Post(author,title,content) values ("Toto","Post_0","content");
```

