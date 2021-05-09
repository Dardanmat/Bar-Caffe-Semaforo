package tpsit.ordinazionicaffe;
import java.util.concurrent.Semaphore;


public class Cameriere {
    
    protected static int ordinazioni = 0; //ordinazioni del cameriere
    protected static Semaphore semaforoCameriere = new Semaphore(1);
}
