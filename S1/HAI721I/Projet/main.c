#include <stdio.h> 
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <sys/types.h>
/*#include <sys/socket.h>
#include <netdb.h>
#include <arpa/inet.h>*/
#include <pthread.h>
//# include <sys/wait.h>
#include "dimacs_read.h"



int main(int argc,char ** argv){

    int data[2];
    data=dimacs_read(argv[1]);
    printf("Nb Processus : %i\n",data[0]);
    printf("Nb Liaison : %i\n",data[1]);

    edge=(int **)malloc(nbLiaison * sizeof(int *));
    for(int i=0;i<nbLiaison;i++){
        edge[i]=(int*)malloc(2 * sizeof(int));
    }

    FILE *file2=fopen(fichier,"r");

    while(fgets(line2,250,file2)!=NULL){
        printf("%s\n",line);
        if(line[0]!='c' && line[0]=='e'){
            char * token2=strtok(line," ");
            int cpt=0;
            while(token2 != NULL){
                if(cpt==1){ printf("%s\n",token2);edge[i][0]=atoi(token2); }
                if(cpt==2) { printf("%s\n",token2);edge[i][1]=atoi(token2);}
                token2=strtok(NULL, " ");
                cpt++;
            }
            i++;
        }
    }
    
    //printf("Taille  : %li\n",sizeof(edge)/sizeof(int));
    int cpt=0;
    for(int i=0;i<nbLiaison;i++){
        if(edge[i][0] != 0 || edge[i][1] !=0)printf("%i-->%i\n",edge[i][0],edge[i][1]);
        cpt++;
    }
    printf("Taille de edge : %i\n",cpt);
    fclose(file2);
    //int liaisons[nbLiaison][2];
    //char ligne[250];
    /*while(fgets(ligne,250,file)!=NULL){
        printf("%c\n",ligne[0]);
        if(line[0]!='c' && line[0]=='e'){
            
            char*token=strtok(line," ");
            int cpt=0;
            int i=0;
            while(token!=NULL){
                printf("%s\n",token);
                if(cpt==1){
                    liaisons[i][0]=atoi(token);
                }
                if(cpt==2)
                    liaisons[i][1]=atoi(token);
                token = strtok(NULL," ");
                i++;cpt++;
            }
        }
    }*/
   //printf("%i",liaisons[0][1]);
}