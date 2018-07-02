/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.Random;

/**
 *
 * @author reale
 */
public class Producer implements Runnable {
    
    private final Random random;
    private final Container container;
    private final int idProducer;
    private final int wait = 1500;
    
    public Producer(Container container, int idProducer) 
    {
        this.container = container;
        this.idProducer = idProducer;
        random = new Random();
    }
    
    @Override
    public void run() 
    {
        while(Boolean.TRUE)
        {
            int quantity = random.nextInt(300);
            container.put(quantity);
            System.out.println("The producer " + idProducer + " puts: " + quantity);
            try 
            {
                Thread.sleep(wait);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Producer " + idProducer + ": Error " + e.getMessage());
            }
        }
    }
}
