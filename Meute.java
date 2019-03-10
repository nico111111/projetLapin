import java.util.ArrayList;

//ID : Une liste pour chauqe sexe

public class Meute{
    private ArrayList<Lapin> laMeute;
    private ArrayList<Lapin> laPinettes;

    public Meute(int nbLapinDepart){
        this.laMeute=new ArrayList<Lapin>();
        this.laPinettes=new ArrayList<Lapin>();
        Lapin lapinTemp;
        for (int i=0;i<nbLapinDepart;i++){
            lapinTemp=new Lapin();
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

    public boolean peutSurvivre(){
        return laMeute.size()!=0 && laPinettes.size()!=0;
    }

    public void portePourTous(){
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
        }
    }

    @Override
    public String toString(){
        return laMeute.toString() + "\n\n" + laPinettes.toString();
    }

}
