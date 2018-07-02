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
public class ProducerConsumer {

    private static Container container;
    private static Thread producer;
    private static Thread [] consumers;
    private static final int QUANTITY = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        container = new Container();
        producer = new Thread(new Producer(container, 1));
        consumers = new Thread[QUANTITY];

        for(int i = 0; i < QUANTITY; i++)
        {
            consumers[i] = new Thread(new Consumer(container, i));
            consumers[i].start();
        }
        
        producer.start();
    }
    
}
