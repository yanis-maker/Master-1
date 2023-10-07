// test_couleur.cpp : Seuille une image en niveau de gris
#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include "image_ppm.h"

int main(int argc, char* argv[])
{
  char cNomImgLue[250];
  int nH, nW, nTaille, S;
  int histo[256]={0};

  if (argc != 2)
     {
       printf("Usage: ImageIn.pgm \n");
       exit (1) ;
     }

   sscanf (argv[1],"%s",cNomImgLue) ;

   OCTET *ImgIn, *ImgOut;

   lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
   nTaille = nH * nW;

   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(cNomImgLue, ImgIn, nH * nW);

   double ddp;

    for (int i=0; i < nH; i++)
        for (int j=0; j < nW; j++)
         {
           histo[ImgIn[i*nW+j]]++;
         }

    std::ofstream outfile("./stats/ddp.dat");
    for (int i=0; i<256; i++){
        ddp = (double)histo[i] /nTaille;
        outfile<<i<<" "<<ddp<<std::endl;
    }
   free(ImgIn);

   return 1;
}
