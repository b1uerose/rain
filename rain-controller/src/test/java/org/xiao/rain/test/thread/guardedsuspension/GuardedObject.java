package org.xiao.rain.test.thread.guardedsuspension;

/**
 * Author: xiaojl
 * Date: 2021/9/20 22:37
 */
public class GuardedObject<T> {
    
    private int id;
    private T response;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public T get(long waitTime) {
        synchronized (this) {
            long startTime = System.currentTimeMillis();
            long passTime = 0;
            while(response == null) {
                
                long time = waitTime - passTime;
                if(time <= 0) {
                    break;
                }
                
                try {
                    wait(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                passTime = System.currentTimeMillis() - startTime;

            }
        }
        return response;
    }
    
    public void Complete(T object) {
        synchronized (this) {
            this.response = object;
            notify();
        }
    }
}
