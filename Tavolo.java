package tpsit.ordinazionicaffe;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Tavolo {
    
    protected static int ordinazioni = 0;
    
    protected static Semaphore semPieno  = new Semaphore(0);
    protected static Semaphore semVuoto  = new Semaphore(1);
    
    public synchronized static void generaOrdinazioni(){
        ordinazioni = new Random().nextInt(4) + 1;
    }
    
    public synchronized static int prelevaOrdinazioni(){
        return ordinazioni;
    }
    
}
