//----------------------------------------------------------------------------//
// Class Main permet d'executer le programme                                  //
//----------------------------------------------------------------------------//

import java.util.Scanner;

public class Main
{

//----------------------------------------------------------------------------//
// main                                                                       //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: ------                                                          //
//----------------------------------------------------------------------------//

  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int i, nbMois, nbLapin;

    System.out.println("nombre de lapin de depart : ");
    nbLapin = scan.nextInt();

    Meute testColony = new Meute(nbLapin);

    System.out.println("nombre de mois : ");
    nbMois = scan.nextInt();

    for (i = 1 ; i < nbMois ; i++)
    {
      testColony.vivre();
      System.out.print("mois : " + i);
      System.out.println(testColony);
    }
  }
}
