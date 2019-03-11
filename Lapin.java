
public class Lapin{
    private int sexe; // 0 madame 1 monsieur
    private int age; // en mois
    private int maturite; // 0 pas mature 1 mature
    private MTRandom random; //utilisé pour tout le random
    private int comptPorte;

    //creation d'in nouveau lapin
    public Lapin(int _sexe){
        this.random=new MTRandom();
        this.sexe=this.random.nextInt(2);
        this.age=0;
        this.maturite=0;

    }

    public Lapin(int _age, int _maturite,int _sexe){
        this.random=new MTRandom();
        this.sexe=_sexe;
        this.age=_age;
        this.maturite=_maturite;
        if(this.sexe==0){
          this.comptPorte=8;
        }
    }

    //cette fonction est beaucoup trop bien
    public boolean estMort(){
      if(this.age%12==0){
          Double test=random.nextDouble();
          if(this.maturite==0){
              return (test<0.80);
          }
          return (test<0.5+((age/12)%10)/10);
      }
      return false;
    }

    //ça sert !
    public boolean peutFaireDesLapins() {
        if(this.sexe==0 && this.maturite==1 && this.comptPorte!=0){
            return true;
        }else{
            return false;
        }
    }


    public boolean estMale(){
        return this.sexe==1;
    }

    //TODO a refaire avec les bonne stat
    public int acouplement(){
        this.comptPorte--;
        return random.nextInt(5)+4;
    }

    //nice veillissement
    public void veillir(){
        this.age=this.age+1;
        maturer();
        if(this.age%12==0){
          if(!this.estMale()){
              this.comptPorte=random.nextInt(5)+4;
          }
        }
    }

    //la bonne puberté TODO a refaire degeu
    public void maturer(){
        MTRandom oui= new MTRandom();
        double test=oui.nextDouble();
        if(this.age==5){
            if(test>0.75){
                devientMature();
            }
        }
        if(this.age==6){
            if(test>0.5){
                devientMature();
            }
        }
        if(this.age==7){
            if(test>0.25){
                devientMature();
            }
        }
        if(this.age==8){
            devientMature();
        }
    }
    //TODO refaire les stats

    //sert pas a grand chose ça maintenant
    public void devientMature(){
        this.maturite=1;
    }

    @Override
    public String toString(){
        return "sexe : " + this.sexe + " age : " + this.age + " maturite : " + this.maturite;
    }

//petit rajout de ligne pour test git

}
