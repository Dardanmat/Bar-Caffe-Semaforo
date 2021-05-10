package tpsit.ordinazionicaffe;

//thread consumatore
public class Cameriere extends Thread{

    protected static int ordinazioniTot = 0;
    
    private static int numClienti = 0;
    
    public Cameriere(String name, int numClienti) {
        super(name);
        this.numClienti = numClienti;
    }

    @Override
    public void run() {
        while (numClienti > 0) {            
            try{
                System.out.println("Cameriere aspetta l'ordinazione");

                Tavolo.semPieno.acquire();

                int ord = Tavolo.prelevaOrdinazioni();
                ordinazioniTot += ord;
                System.out.println("Cameriere ha preso " + ord + " ordinazioni");
                System.out.println("Cameriere ha " + ordinazioniTot + " ordinazioni totali");

                Tavolo.semVuoto.release();
            
            }catch(InterruptedException e){}
            numClienti--;
        }
    }
    
}
