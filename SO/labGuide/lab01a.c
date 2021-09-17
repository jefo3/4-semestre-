#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/resource.h>


void my_routine(void)
{
  int j = 2;
  while (j-- > 0)
  {
    printf("My PID:%d My parent PID: %d\n", getpid(),getppid());
    sleep(5);
  } 
}


int main(void)
{
     
    for (int i=0;i<5;i++)
    {
      pid_t ret = fork();

      if (ret < 0) // fork unsuccessful
      {
        printf("Erro ao criar processo.\n");
        exit(1);
      }

      if (ret == 0) // child process 
      { 
        my_routine();
        exit(0);
      }
     
    }
    
    my_routine();
   
    return 0;
}
