/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author reale
 */
public class Consumer implements Runnable{
    private final Container container;
    private final int idConsumer;
    
    public Consumer(Container container, int idConsumer) 
    {
        this.container = container;
        this.idConsumer = idConsumer;
    }

    @Override
    public void run() 
    {
        while(Boolean.TRUE)
        {
            System.out.println("Consumer " + idConsumer + " consumes: " + container.get());
        }
    }
}
