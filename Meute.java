import java.util.ArrayList;

//ID : Une liste pour chauqe sexe

public class Meute{
    private ArrayList<Lapin> laMeute;
    private ArrayList<Lapin> laPinettes;
    private MTRandom randomGlob;
    private int lapineMorte;
    private int lapinMort;
    private int lapinNe;

    public Meute(int nbLapinDepart){
        this.lapineMorte=0;
        this.lapinMort=0;
        this.lapinNe=0;
        this.randomGlob = new MTRandom();
        this.laMeute=new ArrayList<Lapin>();
        this.laPinettes=new ArrayList<Lapin>();
        Lapin lapinTemp;
        for (int i=0;i<nbLapinDepart;i++){
            lapinTemp=new Lapin(5,1,this.randomGlob.nextInt(2));
            if(lapinTemp.estMale()){
                this.laMeute.add(lapinTemp);
            }else{
                this.laPinettes.add(lapinTemp);
            }

        }
    }
    
    //TODO tester sexe
    public void ajouterLapin(Lapin lapin){
      if(lapin.estMale()){
        this.laMeute.add(lapin);
      }else{
        this.laPinettes.add(lapin);
      }
    }

    public void retirerLapin(Lapin lapin){
      if(lapin.estMale()){
        this.laMeute.remove(lapin);
      }else{
        this.laPinettes.remove(lapin);
      }
    }

    public boolean peutSurvivre(){
        return laMeute.size()!=0 && laPinettes.size()!=0;
    }

    //TODO faire des porté plus etalé sur une année plutot que tout au début
    public boolean portePourTous(){
        if(peutSurvivre()){
            Lapin lapin;
            ArrayList<Lapin> laPinettesCopy = new ArrayList<Lapin>(laPinettes);
            for(Lapin lapine : laPinettesCopy){
                if(lapine.peutFaireDesLapins()){
                    for(int i=0;i<lapine.acouplement();i++){
                        lapin=new Lapin(this.randomGlob.nextInt(2));
                        ajouterLapin(lapin);
                        this.lapinNe++;
                    }
                }
            }
            return true;
        }else{
          return false;
        }
    }

    public void vivre(){
      portePourTous();
      ArrayList<Lapin> laPinettesCopy = new ArrayList<Lapin>(laPinettes);
      for(Lapin lapine : laPinettesCopy){
        lapine.veillir();
        if(lapine.estMort()){
          this.retirerLapin(lapine);
          this.lapineMorte++;
        }
      }
      ArrayList<Lapin> laMeuteCopy = new ArrayList<Lapin>(laMeute);
      for(Lapin lapin : laMeuteCopy){
        lapin.veillir();
        if(lapin.estMort()){
          this.retirerLapin(lapin);
          this.lapinMort++;
        }
      }

    }

    @Override
    public String toString(){
        return "nb de Male : " + laMeute.size() + "\nnb de Female : " + laPinettes.size() +"\nnb naissance : " + this.lapinNe + "\nnb male mort : " + this.lapinMort + " nb female mort : " + this.lapineMorte + "\n\n";
    }

}
