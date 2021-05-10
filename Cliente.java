package tpsit.ordinazionicaffe;

import java.util.Random;

//thread produttore
public class Cliente extends Thread{
    
    public Cliente(String name) {
        super(name);
    }

    @Override
    public void run() {
        try{
            System.out.println("Cliente " + getName() + " aspetta di dare l'ordinazione");
        
            Tavolo.semVuoto.acquire();
            
            Tavolo.generaOrdinazioni();
            System.out.println("\nCliente " + getName() + " dà " + Tavolo.ordinazioni + " ordinazioni");
            
            Tavolo.semPieno.release();
            
        }catch(InterruptedException e){}
        
    }
    
}
