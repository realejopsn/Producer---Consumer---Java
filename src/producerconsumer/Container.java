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
public class Container {
    private int content;
    private boolean fullContainer = Boolean.FALSE;
    
    public synchronized int get()
    {
        while (!fullContainer)
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Container Error: " + e.getMessage());
            }
        }
        fullContainer = Boolean.FALSE;
        notify();
        return content;
    }
    
    public synchronized void put(int value) 
    {
        while (fullContainer) 
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Container Error: " + e.getMessage());
            }
        }
        content = value;
        fullContainer = Boolean.TRUE;
        notify();
    }
}
