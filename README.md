# Jeu d'echecs
Ce projet est un jeu d'échecs en Java avec l'architecture Modèle Vue Contrôleur.
Les pièces blanches sont controlées par le joueur et les pièces noires sont controlées par une intelligence artificielle.

Quelques spécificités sont à noter :
- La partie se termine quand un roi se fait manger, il n'y a pas d'échec et mat ou échec au roi.
- Les pions peuvent avancer que d'une seule case maximum lors de leurs premiers déplacements.
- La promotion des pions est choisie aléatoirement.
- Le petit roque et le grand roque ne sont pas présents.

L'intelligence artificielle essaye de deviner la prochaine pièce déplacée par le joueur.
Pour decider de son prochain mouvement elle dispose d'un système de points des pièces :
- pion : 1 point
- tour : 3 points
- cavalier : 5 points
- fou : 7 points
- reine : 9 points
- roi : 11 points

L'intelligence artificielle  regarde tous les mouvements possibles et pour chaque mouvement elle calcule le score du mouvement en ajoutant les points de la pièce blanche qui peut se faire manger et en soustrayant les points de la pièce noire qui risque se faire manger. Le mouvement qui a le plus gros score est celui qui est joué par le joueur virtuel. Cependant il y a une exception, si l'intelligence artificielle dispose d'un mouvement qui peut prendre le roi blanc, celui-ci est forcément choisi.
