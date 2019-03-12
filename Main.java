public class Main{
  public static void main(String[] args){
    Meute testColony = new Meute(100);
    int i;
    for(i=1;i<80;i++){
      testColony.vivre();
      System.out.println("mois : " + i);
      System.out.println(testColony);
    }
  }
}
