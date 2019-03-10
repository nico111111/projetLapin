public class Main{
  public static void main(String[] args){
    Meute testColony = new Meute(100000);
    int i=0;
    while(testColony.peutSurvivre()){
      testColony.vivre();
      System.out.println("mois : " + i);
      i++;
      System.out.println(testColony);
    }
  }
}
