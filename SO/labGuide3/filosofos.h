#ifndef _FILOSOFOS_H_
#define _FILOSOFOS_H_

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <semaphore.h>
#include <sys/resource.h>



#define N 5             /* numero de filosofos */
#define ESPAGUETE 5     /* quantidade de espagute por filosofo */
#define LEFT (i+N-1)%N  /* numero do vizinho a esquerda de i */
#define RIGHT (i+1)%N   /* numero do vizinho a direita de i */


typedef enum
{
  THINKING, /* pensando */
  HUNGRY,   /* tentando pegar garfos */
  EATING    /* comendo */
} PhilosopherState;


typedef struct _THREAD_DATA_
{
  int num;        /* Indica o número do filosofo */
  sem_t s;        /* semáforo para o garfo */
  int espaguete;  /* quantidade de espaguete */

}PhilosopherData;

/* Define as funções down e up como sem_wait e sem_post*/
#define down sem_wait
#define up sem_post



#endif
