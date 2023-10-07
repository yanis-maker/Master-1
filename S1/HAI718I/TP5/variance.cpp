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
  double ddp[256]={0.0};

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

    double moyenne = 0;
    double variance = 0;
    double ecartType = 0;

    for (int i=0; i < nH; i++)
        for (int j=0; j < nW; j++)
           histo[ImgIn[i*nW+j]]++;

    for (int i=0; i<256; i++)
        ddp[i] = (double)histo[i] /nTaille;

    for(int i=0; i<256; i++)
        moyenne += ddp[i] * i;

    for(int i=0; i<256; i++)
        variance += ((((double)histo[i]/256) - moyenne) * (((double)histo[i]/256) - moyenne));

    ecartType = sqrt(variance);

    std::ofstream outfile("./stats/variance.dat");

    outfile<<"moyenne : "<<" "<<moyenne<<std::endl;
    outfile<<"variance : "<<" "<<variance<<std::endl;
    outfile<<"ecart - type : "<<" "<<ecartType<<std::endl;
   free(ImgIn);

   return 1;
}
