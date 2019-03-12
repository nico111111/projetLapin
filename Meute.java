//----------------------------------------------------------------------------//
// Class Meute modélise chaque population de lapin restant après chaque mois  //
//----------------------------------------------------------------------------//

import java.util.ArrayList;

public class Meute
{
    private ArrayList<Lapin> laMeute; //Liste des lapins
    private ArrayList<Lapin> laPinettes; //Liste des lapines
    private MTRandom         randomGlob; //utilisé pour tout le random
    private int              lapineMorte; //nombre de lapine morte par mois
    private int              lapinMort; //nombre de lapin mort par mois
    private int              lapinNe; //nombre de lapin né par mois

//----------------------------------------------------------------------------//
// Meute           constructeur pour une population de lapin et y attribut    //
//                 un sexe a chaque lapin de la population de façon aléatoire //
//                                                                            //
// En entrée: Nombre de lapin au début de la simulation                       //
//                                                                            //
// En sortie: une population de lapin et de lapine                            //
//----------------------------------------------------------------------------//
    public Meute (int nbLapinDepart)
    {
        this.lapineMorte = 0;
        this.lapinMort = 0;
        this.lapinNe = 0;
        this.randomGlob = new MTRandom();
        this.laMeute = new ArrayList<Lapin>();
        this.laPinettes = new ArrayList<Lapin>();
        Lapin lapinTemp;
        for (int i = 0 ; i < nbLapinDepart ; i++)
        {
            lapinTemp = new Lapin(5, 1, this.randomGlob.nextInt(2));
            if (lapinTemp.estMale())
            {
                this.laMeute.add(lapinTemp);
            }
            else
            {
                this.laPinettes.add(lapinTemp);
            }

        }
    }


//----------------------------------------------------------------------------//
// ajouterLapin         ajoute le lapin male ou femelle à la liste concernée  //
//                                                                            //
// En entrée: Le lapin qui a un sexe attribué                                 //
//                                                                            //
// En sortie: ajout du lapin de la liste concernée                            //
//----------------------------------------------------------------------------//

    public void ajouterLapin (Lapin lapin)
    {
      if (lapin.estMale())
      {
        this.laMeute.add(lapin);
      }
      else
      {
        this.laPinettes.add(lapin);
      }
    }


//----------------------------------------------------------------------------//
// retirerLapin                   retire le lapin mal ou femelle              //
//                                dans la liste concernée quand il meurt      //
//                                                                            //
// En entrée: Le lapin qui a un sexe attribué                                 //
//                                                                            //
// En sortie: enleve un lapin de la liste a laquelle il appartient            //
//----------------------------------------------------------------------------//

    public void retirerLapin (Lapin lapin)
    {
      if (lapin.estMale())
      {
        this.laMeute.remove(lapin);
      }
      else
      {
        this.laPinettes.remove(lapin);
      }
    }

//----------------------------------------------------------------------------//
// peutSurvivre               test si il reste toujours des Lapins            //
//                            dans la population et des femelles              //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: retourne vrai ou faux qui indique si la population peut survivre//
//----------------------------------------------------------------------------//
    public boolean peutSurvivre ( )
    {
        return laMeute.size() != 0 && laPinettes.size() != 0;
    }

//----------------------------------------------------------------------------//
// portePourTous                   Fais en sorte que toutes les lapines       //
//                                 pouvant faire une portée fasse une portée  //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: rajoute des lapins nés a la liste                               //
//----------------------------------------------------------------------------//

    //TODO faire des porté plus etalé sur une année plutot que tout au début
    public boolean portePourTous ( )
    {
        this.lapinNe = 0;
        if (peutSurvivre())
        {
            Lapin            lapin;
            ArrayList<Lapin> laPinettesCopy = new ArrayList<Lapin>(laPinettes);
            for (Lapin lapine : laPinettesCopy)
            {
                if (lapine.peutFaireDesLapins())
                {
                    for (int i = 0 ; i < lapine.acouplement() ; i++)
                    {
                        lapin = new Lapin(this.randomGlob.nextInt(2));
                        ajouterLapin(lapin);
                        this.lapinNe++;
                    }
                }
            }
            return true;
        }
        else
        {
          return false;
        }
    }

//----------------------------------------------------------------------------//
// vivre                comptabilise le nombre de lapin et lapines mortes,    //
//                      les fais veillirs et fais naître les nouveaux lapins  //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: nombre lapin mort et lapine morte, rajoute +1 en âge,           //
//            et fais naîtres des nouveaux lapins                             //
//----------------------------------------------------------------------------//

    public void vivre ( )
    {
      this.lapinMort = 0;
      this.lapineMorte = 0;
      portePourTous();
      ArrayList<Lapin> laPinettesCopy = new ArrayList<Lapin>(laPinettes);
      for (Lapin lapine : laPinettesCopy)
      {
        if (lapine.estMort())
        {
          this.retirerLapin(lapine);
          this.lapineMorte++;
        }
        lapine.veillir();
      }
      ArrayList<Lapin> laMeuteCopy = new ArrayList<Lapin>(laMeute);
      for (Lapin lapin : laMeuteCopy)
      {
        if (lapin.estMort())
        {
          this.retirerLapin(lapin);
          this.lapinMort++;
        }
        lapin.veillir();
      }

    }

//----------------------------------------------------------------------------//
// toString                                                                   //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: renvoit le nombre de mâle, femelle, naissance,                  //
//                         de male mort et femelle morte                      //
//----------------------------------------------------------------------------//

    @Override
    public String toString ( )
    {
        return ",nb de Male : " + laMeute.size()
        + ",nb de Female : " + laPinettes.size()
        + ",nb naissance : " + this.lapinNe
        + ",nb male mort : " + this.lapinMort
        + ",nb female mort : " + this.lapineMorte + "\n\n";
    }

}
