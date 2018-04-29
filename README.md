# ROB4-POO Projet Java par Alexis Devillard et Tiphaine Diot

## Introduction : Projet Java de simulation d'un Roomba

Le but de ce projet a été de simuler le fonctionnement d'un robot aspirateur (le Roomba) dans un environnement. 
Cet environnement a une taille connu et fixe mais son contenu est modifiable. C'est à dire qu'on peut y placer des obstacles ou des zones de poussières. 

Le déplacement du Roomba peut se faire de différentes manières, le fonctionnement de base est le comportement aléatoire. Ce comportement prend uniquement en compte le fait de ne pas rencontrer des obstacles mais pas les zones de poussières. 
Le robot peut prendre en compte les obstacles ou la poussière grâce à des capteurs, par défaut il comprend 3 capteurs de contacts et un de poussières au centre. 

Le projet est axé sur la réalisation des tâches mais il doit être également modulable. 

Le détail des informations se trouvant bien évidemment dans le sujet fournis. 

## Spécificité de notre projet

### L'interface graphique

Pour que l'affichage ne lague pas, nous lui avons intégré une classe permettant de lancer des threads graphiques. 


## Comment ajouter des fonctionnalités à notre robot ? 

Pour que notre projet soit plus modulable, nous avons essayé de créer des packages par grande catégorie. Ainsi pour ajouter des fonctionnalités, il faut créer une nouvelle classe dans le package adapté et l'importer dans les autres où il sera utiliser. 

### Les comportements

Pour qu'un nouveau comportement soit pris en compte il faut lui donner un nom et lui crée sa classe. Il doit alors hérité de la classe _Behavior_ et ainsi posséder au moins la fonction _generateNext()_ qui permet de générer la nouvelle position.  

### Les capteurs

Les capteurs sont différenciés en deux types : les capteurs d'obstacles et les capteurs de poussières. 

#### Les capteurs de poussières

Ces capteurs doivent détectés les zones de poussières sur le sol. Celles-ci sont plus petites que le robot. 
Les possibilités pour ce genre de capteurs ne sont pas très variantes. En effet, il est uniquement possible de jouer sur la forme de la zone de détection du capteur. Nous avons par défaut estimer que le capteur était rond. 

Si les capteurs de poussières n'offrent pas l'opportunité de créer de nouvelles fonctionnalités il est en revanche possible de jouer sur leurs paramètres, par exemple la taille de la zone de détection. 

Comme nous avons pensé que des dérivées d'un tel capteur poussière n'étaient pas pertinentes nous avons choisi d'implémenter la classe pour ces capteurs de manière non abstraites. 

#### Les capteurs d'obstacles 

Les capteurs d'obstacles sont des capteurs de distances. De manière simple ils doivent indiquer si le robot va rencontrer un obstacle lors de la génération d'une nouvelle position par le comportement. 

Du fait qu'ils existent de nombreux types de capteurs de distances comme les capteurs lasers, ou les capteurs de contacts par exemple, ils offrent beaucoup plus de possibilités que les capteurs de poussières. Ces différents types sont considérés comme des dérivées de la notion de capteurs d'obstacles. Pour cela nous avons mis la classe SensorObst en abstraite. 

Rajouter un type de capteurs de distance est assez simple, il suffit de créer un package le représentant et héritant de la classe _SensorObst_. 
Il faut ensuite gérer les différentes formes existant dans la simulation pour que le capteur soit correctement adapté à la simulation. 

### Les objets sur la carte

Nous avons considéré que les obstacles et les poussières sont les deux types d'objets présents dans l'environnement (mis à part le robot et les murs).
Cependant nous avons pris le parti de différencier ces deux classes (même si elles héritent toutes deux de la même classe _OnMap_) pour faciliter l'implémentation dans l'environnement, en effet celui ci connait indépendamment ses obstacles de ses zones de poussières. 
L'unique différence entre les deux est que les obstacles sont simuler en vert et les poussières en gris. 

#### Ajout de formes

Les formes doivent héritées de la classe _Shape_. Chaque nouvelle forme doit posséder une fonction _display()_ pour son affichage et une fonction qui permet de détecter ses limites (_istouching()_).

Cette dernière fonction est importante car elle permet aux différents capteurs d'appeler cette méthode pour vérifier s'il y a eu contact avec un obstacle ou si le robot se trouve sur de la poussière par exemple. Les capteurs alors ne se préoccupent pas de la forme à détecter vu que chaque objet possède sa fonction de détection propre. 

## Ce qu'on aurait aimé ajouter

Nous avons apprécié le fait de pouvoir utiliser un thread en Java car nous n'avions pas découvert cette possibilité avant. Le principe de simuler le comportement d'un robot assez simple c'est révélé assez compliqué et nous avons apprécié que le projet soit lié à la robotique directement. 

Nous aurions aimé pouvoir ajouter au robot au moins un autre comportement plus intelligent que le comportement aléatoire et éventuellement implémenter un autre capteur de distance. De plus nous aurions aimé implémenter la fonction de détection des carrés.

