#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/resource.h>
#include <signal.h>

//Contador
int i;

//ordem: 1 - true, 0 - false
int crescente = 1;

// Função chamada quando um sinal é interceptado
static void signal_handler(int signal) 
{
    printf("Recebeu o sinal %d\n",signal);

    if (signal == SIGUSR2){
        printf("e é SIGUSR2!\n");
        i = 0;

        if(crescente == 0){
          crescente = 1;
        }
    }else if(signal == SIGUSR1){
      //para inverter as ordens
      printf("e é SIGUSR1!\n"); 
      if(crescente == 1){
        crescente = 0;
      }else if(crescente == 0){
        crescente = 1;
      }
    }

}



//Função que configura o tratamento dos sinais interceptados
int signal_handler_setup(void)
{
  /* a função signal associa o sinal a uma função de tratamento  */
  if (signal(SIGUSR2, signal_handler) == SIG_ERR){
    return -1;
  }

  if (signal(SIGUSR1, signal_handler) == SIG_ERR){
    return -1;
  }

  if (signal(SIGINT, signal_handler) == SIG_ERR) 
  {
    return -1;
  }

  if (signal(SIGHUP, signal_handler) == SIG_ERR) 
  {
    return -1;
  }

  if (signal(SIGTERM, signal_handler) == SIG_ERR) 
  {
    return -1;
  }

  if (signal(SIGUSR1, signal_handler) == SIG_ERR) 
  {
    return -1;
  }

  if (signal(SIGTSTP, signal_handler) == SIG_ERR) 
  {
    return -1;
  }


  // O sinal SIGWINCH (emitido quando a janela é redimensionada)não é um sinal padrão

  if (signal(SIGWINCH, signal_handler) == SIG_ERR) 
  {
    return -1;
  }



  return 0;

}

int main(int argc, char *argv[])
{

    // Configura a captura dos sinais
    if(signal_handler_setup()!=0)
    {
      printf("Erro ao configurar captura de sinais!\n");
      exit(EXIT_FAILURE);
    }

     
    
    while (1)
    {
      if(crescente == 1){
        printf("%d\n",i++);
      }else if(crescente == 0){
        printf("%d\n",i--);
      }

      sleep(1); 
    }

 
    return 0;  
}

