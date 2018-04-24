# ROB4-POO Projet Java par Alexis Devillard et Tiphaine Diot

# Introduction : Projet Java de simulation d'un Roomba

Le but de ce projet a été de simuler le fonctionnement d'un robot aspirateur (le Roomba) dans un environnement. 
Cet environnement a une taille connu et fixe mais son contenu est modifiable. C'est à dire qu'on peut y placer des obstacles ou des zones de poussières. 

Le déplacement du Roomba peut se faire de différentes manières, le fonctionnement de base est le comportement aléatoire. Ce comportement prend uniquement en compte le fait de ne pas rencontrer des obstacles mais pas les zones de poussières. 
Le robot peut prendre en compte les obstacles ou la poussière grâce à des capteurs, par défaut il comprend 3 capteurs de contacts et un de poussières au centre. 

Le projet est axé sur la réalisation des tâches mais il doit être également modulable. 

# Comment ajouter des fonctionnalités à notre robot ? 

Pour que des comportements, des capteurs ou des objets sur la carte puissent être ajoutés nous avons utilisés à plusieurs reprises les classes abstraites. 

Notamment pour la partie objet, une classe permet de tout réaliser mais nous avons décidé de séparer en deux classes abstraites les obstacles et les zones de poussières. Il est alors possibles de rajouter une classe abstraite d'un nouveau nom si on décide par exemple d'ajouter des murs. Cette classe est liée également à des formes. En effet, les tâches peuvent être circulaires, carrées, polygonales etc.. 
Il est possible d'ajouter des formes, dans ce cas les fonctionnalités des capteurs doivent être complétées en ajoutant une méthode private dans chaque capteurs permet de détecter ses formes et de rajouter un cas ou switch case de la méthode eventDetect(). 

Les capteurs sont également modulables, nous avons séparés les capteurs de poussières des capteurs d'obstacles. Les capteurs d'obstacles peuvent être alors être divisés : capteurs de contact, capteurs lasers (non implémenté) etc... Les capteurs de poussières sont par défaut tous circulaires mais la portée et l'emplacement peuvent être variés. 



