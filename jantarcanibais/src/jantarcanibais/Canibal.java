package jantarcanibais;

import java.util.concurrent.Semaphore;

public class Canibal implements Runnable{
	Semaphore local, dependente;
    private final Travessa travessa;
    private final int id;
    
    
    
    Canibal(Travessa t, int id, Semaphore m1, Semaphore m2){
        travessa = t;
        this.id = id;
    }
    
    
    @Override
    public void run() {
        while(true){
            //aqui o canibal faz suas ações: servir-se, comer...
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            travessa.seserve();
        }
        
    }
    
}
