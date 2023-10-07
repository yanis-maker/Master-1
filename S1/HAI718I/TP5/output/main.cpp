#include <iostream>
#include "evalperf/evalperf.h"
#include "exo10/reduce.h"
#include "exo11/minimum.h"
#include "exo12/polynome.h"
#include <vector>

using namespace std;

typedef double T;

int main(){
    size_t N;

    N = 10;
    T res;
    std::vector<T> T(N);
    T[0] = 0.3;
    double a = 3;
    for(size_t i = 1; i<N; i++){
        T[i] = T[i-1]+1;
    }

    // T[3000] = 0.2;



    EvalPerf PE;

    PE.start();
    // reduce_mult(T, res);
    // reduce_plus(T, res);
    // reduce3(T, res);
    // minimum_float(T, res);
    // minimum_float_naive(T, res);
    // minimum_algo(T, res);
    polynome(T, a, res);
    PE.STOP();
    std::cout<<"res : " << res <<std::endl;
    std::cout<<"nbr cycles : " << PE.nb_cycle()<<std::endl;
    std::cout<<"nbr secondes : " << PE.nb_second()<<std::endl;
    std::cout<<"nbr millisecondes : " << PE.millisecond()<<std::endl;
    std::cout<<"CPI =  " << PE.CPI(N)<<std::endl;
    std::cout<<"IPC =  " << PE.IPC(N)<<std::endl;
}
