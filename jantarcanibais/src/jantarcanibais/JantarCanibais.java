/* Este código é apenas uma sugestão de implementação. 
   Pode ser modificado conforme necessário. */

package jantarcanibais;

import java.util.concurrent.Semaphore;

public class JantarCanibais {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int i;
        int num_canibais = 5;
        int num_porcoes = 5;
        int tempo_execucao = 30; /* em segundos */
        
        Semaphore mutex1 = new Semaphore(1);
        Semaphore mutex2 = new Semaphore(0);
        Semaphore mutex3 = new Semaphore(0);
        Semaphore mutex4 = new Semaphore(0);
        
        

        Travessa travessa = new Travessa(num_porcoes);
        

        /* Dispara thread Cozinheiro */
        Thread cozinheiro = new Thread(new Cozinheiro(travessa, mutex1, mutex2));
        cozinheiro.start();
        
        /* Dispara threads Cabinais. */
        for(i=0; i<num_canibais; i++){
            Thread canibal = new Thread(new Canibal(travessa, i, mutex2, mutex3));
            canibal.start();
        }
        
        /* Aguarda o tempo de execução. */
        Thread.sleep(tempo_execucao * 1000);
        
        /* Finaliza todas as threads. */
        System.exit(0);
    }
    
}
