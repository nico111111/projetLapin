//----------------------------------------------------------------------------//
//                                                                            //
//                                                                            //
//                                                                            //
//                                                                            //
//                                                                            //
//----------------------------------------------------------------------------//

public class test
{

    public static void main(String[] args)
    {
        MTRandom oui = new MTRandom();
        int nbun=0;
        int nbzero=0;
        int test;
        for(int i=0;i<100000;i++)
        {
          test = oui.nextInt(2);
          if(test==0)
          {
            nbzero++;
          }
          else
          {
            nbun++;
          }
        }
        System.out.println("nb de un : " + nbun + "\nnb de zero : " + nbzero
        + "nb de un : " + nbun + "\nnb de zero : " + nbzero + "nb de un : "
        + nbun + "\nnb de zero : " + nbzero);
    }
}
