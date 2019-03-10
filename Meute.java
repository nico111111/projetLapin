import java.util.ArrayList;

//ID : Une liste pour chauqe sexe

public class Meute{
    private ArrayList<Lapin> laMeute;
    private ArrayList<Lapin> laPinettes;

    public Meute(int nbLapinDepart){
        MTRandom randGlob = new MTRandom();
        this.laMeute=new ArrayList<Lapin>();
        this.laPinettes=new ArrayList<Lapin>();
        Lapin lapinTemp;
        for (int i=0;i<nbLapinDepart;i++){
            lapinTemp=new Lapin(5,1);
            if(lapinTemp.estMale()){
                this.laMeute.add(lapinTemp);
            }else{
                this.laPinettes.add(lapinTemp);
            }

        }
    }
    //TODO tester sexe
    public void ajouterLapin(Lapin lapin){
        this.laMeute.add(lapin);
    }

    public void retirerLapin(Lapin lapin){
        this.laMeute.remove(lapin);
    }

    public void retirerLapine(Lapin lapin){
        this.laPinettes.remove(lapin);
    }

    public boolean peutSurvivre(){
        return laMeute.size()!=0 && laPinettes.size()!=0;
    }

    public boolean portePourTous(){
        if(peutSurvivre()){
            Lapin lapin;
            for(Lapin lapine : laPinettes){
                if(lapine.peutFaireDesLapins()){
                    for(int i=0;i<lapine.acouplement();i++){
                        lapin=new Lapin();
                        ajouterLapin(lapin);
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
          this.retirerLapine(lapine);
        }
      }
      ArrayList<Lapin> laMeuteCopy = new ArrayList<Lapin>(laMeute);
      for(Lapin lapin : laMeuteCopy){
        lapin.veillir();
        if(lapin.estMort()){
          this.retirerLapin(lapin);
        }
      }

    }

    @Override
    public String toString(){
        return "nb de Male : " + laMeute.size() + "\nnb de Female : " + laPinettes.size();
    }

}
