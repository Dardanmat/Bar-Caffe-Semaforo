package tpsit.ordinazionicaffe;

import java.util.Random;

public class Cliente extends Thread{
    
    public Cliente(String name) {
        super(name);
    }

    @Override
    public void run() {
        
        try{
            
            System.out.println("Cliente " + getName() + " attende l'arrivo del cameriere");
            Cameriere.semaforoCameriere.acquire();
            
            System.out.println("\nCliente " + getName() + " riceve il servizio del cameriere");
            int num = new Random().nextInt(4) + 1;

            if(num == 1) System.out.println("Cliente " + getName() + " dà " + num + " ordine di caffè al cameriere");
            else System.out.println("Cliente " + getName() + " dà " + num + " ordini di caffè al cameriere");

            Cameriere.ordinazioni += num;

            System.out.println("Cliente " + getName() + " non necessita più il servizio del cameriere");
            Cameriere.semaforoCameriere.release();
            
        }catch(InterruptedException e){}
        
    }
    
}
