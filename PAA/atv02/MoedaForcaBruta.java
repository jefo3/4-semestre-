public class MoedaForcaBruta {

  public static void verificaTroco(int dinheiro, int[] moedas){
    int comb = 0;
    for(int i = 0; i < moedas.length; i++){
      for(int j = 0; j < moedas.length; j++){
        for(int x = 0; x < moedas.length; x++){
          comb += moedas[x];
        }

        if(comb == dinheiro){
          System.out.println("tem troco");
        }else{
          System.out.println("nao tem troco");
        }

        comb = 0;
      }
    }
  }


  public static void main(String[] args){
   int v[] = {50, 20, 20, 5, 2};
   int x = 45;
   verificaTroco(x, v);



   //

  }
}
