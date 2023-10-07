// ----------------------------------------------------------------------------
// Filename        : image.h
// Description     :
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>



typedef unsigned char OCTET;

/* procédure qui parcours les commentaires d'un fichier pgm ouvert en les ignorant. A la fin de cette procédure, le curseur de lecture doit être placé en début de ligne contenant la taille de l'image */
void ignorer_commentaires(FILE * f);
/*===========================================================================*/

/*procédure qui parcourt un fichier image nommé nom_image et qui extrait le nombre de lignes et le nombre de colonnes de l'image. Ces deux valeurs sont retournées via les deux derniers paramètres.*/
void lire_nb_lignes_colonnes_image_pgm(char nom_image[], int *nb_lignes, int *nb_colonnes);
/*===========================================================================*/
/* procédure qui parcours un fichier image nommé nom_image et qui copie le contenu de l'image (sans l'entête) dans le tableau pt_image. La taille de ce tableau taille_image = nb lignes * nb colonnes*/
void lire_image_pgm(char  nom_image[], OCTET *pt_image, int taille_image);
/*===========================================================================*/

