#include <stdio.h> 
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <pthread.h>
# include <sys/wait.h>

#include "reseau.h"




int main(int argc, char *argv[]) {

	if(argc < 2){
        printf("utilisation: %s nom_fichier\n", argv[0]);
        exit(1);
    }

    //--------------------------------------------------------
    char t[256];
    char texte[1000000];
    char p = 'p';
    char e = 'e';
    int nbrProcessus = 0;
    int nbrLiaion = 0;

    //--------------------------------------------------------
    FILE *fichier = fopen(argv[1], "r");
    if(fichier == NULL){
    	printf("Fichier vide !!\n");
    	exit(1);
    }
    int j = 0;
    while(fgets(t, 255, fichier) != NULL){
    	strcat(texte, t);
    	char *str = strdup(t);
    	char *val;
    	int i = 0;
    	if(t[0] == p){
    		while(val = strsep(&str, " ")){
    			if(i == 2) nbrProcessus = atoi(val);
    			if(i == 3) nbrLiaion = atoi(val);
    			i++;
    		}
    		break;
    	}
    }
    //printf("\npro <%d>, lia <%d>\n", nbrProcessus, nbrLiaion);
    int tabLiaison[nbrLiaion / 2][2];
    while(fgets(t, 255, fichier) != NULL){
    	strcat(texte, t);
    	char *str = strdup(t);
    	char *val;
    	int i = 0;
    	if(t[0] == e){
    		while(val = strsep(&str, " ")){
    			if(i == 1) tabLiaison[j][0] = atoi(val);
    			if(i == 2) tabLiaison[j][1] = atoi(val);
    			i++;
    		}
    		j++;
    	}
    }
    // for(int i = 0; i < nbrLiaion / 2; i++){
    // 	printf("<%d><%d>\n", tabLiaison[i][0], tabLiaison[i][1]);
    // }

    //-------------------------------------------------------- creation du reseau
    int reseau = creation(tabLiaison, nbrProcessus, nbrLiaion / 2);
    //printf("%d\n", reseau);


	//--------------------------------------------------------
    fclose(fichier);

    return 0;
}