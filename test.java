

public class test{

    public static void main(String[] args){
        MTRandom oui = new MTRandom();
        int nbun=0;
        int nbzero=0;
        for(int i=0;i<100;i++){
          if(oui.nextInt(2)==0){
            nbzero++;
          }else{
            nbun++;
          }
        }
        System.out.println("nb de un : " + nbun + "\n nb de zero : " + nbzero);
    }
}
