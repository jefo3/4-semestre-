#include <stdio.h>

int main(){

	FILE* arq = fopen("t1.txt", "r");
	FILE* arq1 = fopen("t2.txt", "r");
  FILE* arqFinal = fopen("diff.txt", "w");
	

	char x;
  char y;
	

	while(1){
		fscanf(arq, "%s", &x);
		
		if(feof(arq)) break;
		
    fprintf(arqFinal, "%s", &x);
	}

  while(1){
		fscanf(arq1, "%s", &x);
		fscanf(arqFinal, "%s", &y);

		if(feof(arq1)) break;
		
    if(x == y){
      fprintf(arqFinal, "%s", "[");
      fprintf(arqFinal, "%s", &x);
      fprintf(arqFinal, "%s", "]");
    }
	}
	
	//fecha o arquivo
	fclose(arq);
	fclose(arq1);
  fclose(arqFinal);

	return 0;
}