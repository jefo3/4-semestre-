#include "filosofos.h"

pthread_t threads[N];           // Threads
sem_t mutex;                    // Mutex para acessar os estados dos filosofos

PhilosopherState state[N];      // Estados dos filosofos
PhilosopherData thread_data[N]; // Dados das threads


/**********************************************/
/* Pensando                                   */
/**********************************************/
void think(int i)
{
  printf("Filósofo %d pensando\n",thread_data[i].num);
}
/**********************************************/
/* Comendo                                    */
/**********************************************/
void eat(int i)
{
  thread_data[i].espaguete--;
  printf("Filósofo %d comendo. Restam %d\n",thread_data[i].num,thread_data[i].espaguete );

}
/**********************************************/
/* Testa se pode pegar os garfos              */
/**********************************************/
void test(int i) 
{
  if (state[i] == HUNGRY && 
     state[LEFT] != EATING && 
     state[RIGHT] != EATING)
  {
    state[i] = EATING;
    up(&thread_data[i].s);
  }
}

/**********************************************/
/* Pega os garfos                             */
/**********************************************/
void take_forks(int i)
{
  down(&mutex);
  state[i] = HUNGRY;
  printf("Filósofo %d com fome\n",thread_data[i].num);
  test(i) ;
  up(&mutex);
  down(&thread_data[i].s);
}
/**********************************************/
/* Libera os garfos                           */
/**********************************************/
void put_forks(int i)
{
  down(&mutex);
  state[i] = THINKING;
  test(LEFT);
  test(RIGHT);
  up(&mutex);
}

/**********************************************/
/* Função principal de cada thread 'filosofo' */
/**********************************************/
void *philosopher(void *t_data)
{
  int i = *(int *)t_data;
  
  printf("Filósofo %u (%d) criado\n",(unsigned int)pthread_self(), *(int *)t_data);
  
  while(1)
  {
    think(i);
    take_forks(i);
    eat(i);
    put_forks(i);

    /* Encerra quando comer todo o espaguete */
    if(thread_data[i].espaguete == 0)
    {
      pthread_exit(0);
    }

  }

  
}

/**********************************************/
/* Main                                       */
/**********************************************/
int main(void)
{
  int status, i;
  void *ret=0;
  
  /* Inicia o mutex */
  /* o valor 0 no início garante que as trheads vão bloquear até que haja um up no mutex */
  sem_init(&mutex, 0, 0);

  /* Inicia os semaforos referentes aos garfos */
  for(int i=0; i < N; i++)
  {
      sem_init(&thread_data[i].s, 0, 0);
  }
 
  /* Inicia as threads dos filosofos */
  for(int i=0; i < N; i++)
  {
    printf("Criando filósofo %d\n", i);

    thread_data[i].num = i;
    thread_data[i].espaguete = ESPAGUETE;
    
    status = pthread_create(&threads[i], NULL, philosopher, &thread_data[i].num);
    

    if (status != 0)
    {
     printf("Erro ao criar thread %d\n", status);
     exit(-1);
    }
  }
 
  /* Libera o mutex para as threads */
  up(&mutex);

  //Espera as threads terminarem
  for(i=0; i < N; i++)
  {
    pthread_join(threads[i], &ret);
    free(ret);
  }


  exit(0);
  
}
/**********************************************/
