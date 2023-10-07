#include <string.h>
#include <iostream>
#include <stdio.h>//perror
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <iostream>
#include <pthread.h>
#include "calcul.h"
using namespace std;

struct varCommunes{
    int cpt;
    pthread_mutex_t verrou;
    pthread_cond_t condi;
};

void *monThread1 (void * par){
    varCommunes * variables =(struct varCommunes *) par;
    cout<<"Thread 1 : je regarde si le compteur a atteint le seuil requis"<<endl;
    pthread_mutex_lock(&(variables->verrou));
    while (variables->cpt<=1000){
        pthread_cond_wait(&(variables->condi),&(variables->verrou));
        cout<<"Thread 1 : En  attente que la vartiable ateigne le seuil"<<endl;
    }
    pthread_mutex_unlock(&(variables->verrou));
    cout<<"Thread 1: La variable a atteint le seuil désirer"<<endl;
    pthread_mutex_lock(&(variables->verrou));
    variables->cpt +=250;
    cout<<"Thread 1 : compteur modifié"<<endl;
    pthread_mutex_unlock(&(variables->verrou));

    pthread_exit(NULL);
}

void *monThread2 (void * par){
    varCommunes * variables =(struct varCommunes *) par;
    pthread_mutex_lock(&(variables->verrou));
    for(int i=1;i<=1100;i++)
        variables->cpt++;
    pthread_mutex_unlock(&(variables->verrou));
    if(variables->cpt>1000){
        cout<<"Thread 2: Seuil atteint, reveil des autres thread"<<endl;
        pthread_cond_broadcast(&(variables->condi));
        cout<<"Thread 2 : Les threads sont révéiller"<<endl;
    }
    pthread_exit(NULL);
}

int main(){
    pthread_t idT1, idT2;
    struct varCommunes varCommunes;
    varCommunes.cpt=0;
    pthread_mutex_init(&(varCommunes.verrou),NULL);
    pthread_cond_init(&(varCommunes.condi) ,NULL);
    if (pthread_create(&idT1, NULL, monThread1, &varCommunes) != 0)
        cout << "erreur creation" <<endl;
    if (pthread_create(&idT2, NULL, monThread2, &varCommunes) != 0)
        cout << "erreur creation" <<endl;
    int res = pthread_join(idT1, NULL);
    res=pthread_join(idT2,NULL);
    pthread_mutex_destroy(&(varCommunes.verrou));
    pthread_cond_destroy(&(varCommunes.condi));
    std::cout<<" Total = "<<varCommunes.cpt<<std::endl;
    cout<< "principal : fin"<< endl;

    return 0;
}