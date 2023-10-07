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
void *monThread1 (void * par){
    int * cp = (int*)(par);
    for(int i=0; i < 1500; i++) ++(*cp);
    pthread_exit(NULL);
}

void *monThread2 (void * par){
    int * cp = (int*)(par);
    for(int i=0; i < 3000; i++) ++(*cp);
    pthread_exit(NULL);
}

int main(){
    pthread_t idT1, idT2;
    int counter=0;
    if (pthread_create(&idT1, NULL, monThread1, &counter) != 0)
        cout << "erreur creation" <<endl;
    if (pthread_create(&idT2, NULL, monThread2, &counter) != 0)
        cout << "erreur creation" <<endl;
    int res = pthread_join(idT1, NULL);
    res=pthread_join(idT2,NULL);
    std::cout<<" Total = "<<counter<<std::endl;
    cout<< "principal : fin"<< endl;

    return 0;
}