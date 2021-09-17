#define _GNU_SOURCE
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include <sched.h>


#define N_THREADS 2

pthread_t threads[N_THREADS];
int thread_data[N_THREADS];

volatile int flag_run = 0;


void *thread_routine(void *t_data)
{
  while(flag_run==0);
 
  for (int i=0;i<10;i++)
  {
    printf("Thread %d : %d\n",*(int *)t_data, i);
    sched_yield();    
    sleep(5);
  }

  pthread_exit(0);
}


void print_enabled_CPU()
{
    cpu_set_t cpu_mask;
    long num_cpu;

    /* Número de cores da CPU */
    num_cpu = sysconf(_SC_NPROCESSORS_ONLN);

    /* Lê quais cores estão habilitados para escalonamento */
    if (sched_getaffinity(0, sizeof(cpu_set_t), &cpu_mask) == -1)
    {
      perror("Error on sched_getaffinity");
    }

    
    for (int i = 0; i < num_cpu; i++) 
    {
        printf("CPU Core %d: %s\n",i, (CPU_ISSET(i, &cpu_mask)?"ON":"OFF"));
    }
    printf("\n");
}

///////////////////////////////////////////////////////
void choose_CPU(int core_id)
{

  cpu_set_t my_cores;
  
  /* Desabilita todos os cores */           
  CPU_ZERO(&my_cores);          
  
  /* Seleciona apenas o core indicado por core_id */
  CPU_SET(core_id, &my_cores);  
  
  /* Associa o processo ao(s) core(s) selecionado */
  sched_setaffinity(0, sizeof(cpu_set_t), &my_cores); 
}
///////////////////////////////////////////////////////

int main(void)
{
  /* Habilita apenas o core 0 para escalonamento deste processo */

  //print_enabled_CPU(); //Descomente essa linha quando indicado
  //choose_CPU(0);       //Descomente essa linha quando indicado
  //print_enabled_CPU(); //Descomente essa linha quando indicado

  int status, i;
  void *ret=0;

  for(i=0; i < N_THREADS; i++)
  {
    printf("Criando thread %d\n", i);
    thread_data[i] = i;
    status = pthread_create(&threads[i], NULL, thread_routine, &thread_data[i]);
    

    if (status != 0)
    {
     printf("Erro ao criar thread %d\n", status);
     exit(-1);
    }
  }
  flag_run = 1;

  //Espera as threads terminarem
  for(i=0; i < N_THREADS; i++)
  {
    pthread_join(threads[i], &ret);
    free(ret);
  }

  exit(0);
  
}
