//----------------------------------------------------------------------------//
// Class Lapin permet de modéliser chaque lapin individuellement              //
//----------------------------------------------------------------------------//

public class Lapin
{
    private int      sexe; // 0 madame 1 monsieur
    private int      age; // en mois
    private int      maturite; // 0 pas mature 1 mature
    private MTRandom random; //utilisé pour tout le random
    private int      comptPorte; //nombre de portée possible sur 1 an

//----------------------------------------------------------------------------//
// Lapin         constructeur pour caractérisé chaque nouveau lapin           //
//                                                                            //
// En entrée: le sexe déterminé aléatoirement                                 //
//                                                                            //
// En sortie: un lapin nouveau né                                             //
//----------------------------------------------------------------------------//

    //creation d'in nouveau lapin
    public Lapin (int _sexe)
    {
        this.random = new MTRandom();
        this.sexe = this.random.nextInt(2);
        this.age = 0;
        this.maturite = 0;

    }

//----------------------------------------------------------------------------//
// Lapin         créateur de lapin mature dès leur naissance,                 //
//               correspondant au lapin de départ                             //
//                                                                            //
// En entrée: l'âge du lapin, sa maturité et son sexe                         //
//                                                                            //
// En sortie: un lapin mature prêt a se reproduire                            //
//----------------------------------------------------------------------------//

    public Lapin (int _age, int _maturite, int _sexe)
    {
        this.random = new MTRandom();
        this.sexe = _sexe;
        this.age = _age;
        this.maturite = _maturite;
        if (this.sexe == 0)
        {
          this.comptPorte = 8;
        }
    }

//----------------------------------------------------------------------------//
// estMort     test si le lapin survie ou non par rapport aux taux de survie  //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: nous dit si le lapin ets mort ou non                            //
//----------------------------------------------------------------------------//

    //cette fonction est beaucoup trop bien + +
    public boolean estMort ( )
    {
      if (this.age % 12 == 0)
      {
          Double test = random.nextDouble();
          if (this.maturite == 0)
          {
              return (test < 0.80);
          }
          return (test < 0.5 + ((age % 120) / 12) / 10);
      }
      return false;
    }

//----------------------------------------------------------------------------//
// peutFaireDesLapins       test si le lapin est une lapine, mature           //
//                          et qui peut avoir une portée                      //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: retourne vrai ou faux si le lapin peut avoir des bébés          //
//----------------------------------------------------------------------------//

    //ça sert !
    public boolean peutFaireDesLapins ( )
    {
        if (this.sexe == 0 && this.maturite == 1 && this.comptPorte != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

//----------------------------------------------------------------------------//
// estMale                    test si le lapin et un lapin male               //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: vrai si c'est male sinon faux                                   //
//----------------------------------------------------------------------------//

    public boolean estMale ( )
    {
        return this.sexe == 1;
    }

//----------------------------------------------------------------------------//
// acouplement                        enleve -1 au compteur de porté lorsque  //
//                                    une lapine fais des bébés               //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: un nombre entre 4 et 8 pour le nombre de bébé né                //
//----------------------------------------------------------------------------//

    public int acouplement ( )
    {
        this.comptPorte--;
        return random.nextInt(5) + 4;
    }

//----------------------------------------------------------------------------//
// veillir           TODO compteur de porté des femelles qui se reset         //
//                        en fonction du moment où elles sont matures         //
//                        compter 12 mois a partir de la maturiter            //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: veillit le lapin, le fais devenir mature et reset               //
//            le compteur de porté de la femelle                              //
//----------------------------------------------------------------------------//

    public void veillir ( )
    {
        this.age = this.age + 1;
        if (this.maturite != 1)
        {
          maturer();
        }

        if (!this.estMale())
        {
          if (this.age % 12 == 0)
          {
              double test = random.nextDouble();
              if (test < 0.125)
              {
                this.comptPorte = 4;
              }
              if (test < 0.375)
              {
                this.comptPorte = 5;
              }
              if (test < 0.625)
              {
                this.comptPorte = 6;
              }
              if (test < 0.875)
              {
                this.comptPorte = 7;
              }
              else
              {
                this.comptPorte = 8;
              }
          }
        }
    }

//----------------------------------------------------------------------------//
// maturer                    augmente les chances du lapin de devenir        //
//                            mature en fonction des mois passés              //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: rend le lapin mature                                                          //
//----------------------------------------------------------------------------//

    public void maturer ( )
    {
        double[] tabStat = {0.75,0.5,0.25,0};
        MTRandom oui = new MTRandom();
        double   test = oui.nextDouble();
        if (this.age > 4)
        {
          if (tabStat[this.age-5] < test)
          {
            this.maturite = 1;
          }
        }
      }

//----------------------------------------------------------------------------//
// toString                                                                   //
//                                                                            //
// En entrée: ------                                                          //
//                                                                            //
// En sortie: Renvoit le sexe, l'âge et la maturité de chaque lapin           //
//----------------------------------------------------------------------------//

    @Override
    public String toString ( )
    {
        return "sexe : " + this.sexe + " age : " + this.age + " maturite : "
        + this.maturite;
    }
}
