package tpsit.ordinazionicaffe;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        
        System.out.println("Apre il Bar Caffè\n");
        
        ArrayList<Cliente> listaClienti = new ArrayList<>();
        
        listaClienti.add(new Cliente("Alessandro"));
        listaClienti.add(new Cliente("Francesco"));
        listaClienti.add(new Cliente("Alessio"));
        listaClienti.add(new Cliente("Lorenzo"));
        listaClienti.add(new Cliente("Leonardo"));
        listaClienti.add(new Cliente("Mohammed"));
        listaClienti.add(new Cliente("Giuseppe"));
        
        Cameriere cameriere = new Cameriere("Grullo", listaClienti.size());
        
        cameriere.start();
        
        for (Cliente c : listaClienti) {
            c.start();
        }
        
        try{
            for (Cliente c : listaClienti) {
                c.join();
            }
            cameriere.join();
        }catch(InterruptedException e){}
        
        System.out.println("\nChiusura del Bar Caffè");
        System.out.println("Totali incassi della giornata: " + Cameriere.ordinazioniTot + "€");
        
    }
}
