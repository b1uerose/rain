package org.xiao.rain.test.thread;

/**
 * Author: xiaojl
 * Date: 2021/7/26 17:28
 */
public class ThreadTest10 {

    public static void main(String[] args) {
        One01 one = new One01();
        Thread t1 = new Thread(new numberThread(one));
        Thread t2 = new Thread(new numberThread(one));
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
    
    
}

class One01 {
    int seqNo = 10;
    
    public void getNumber() {
        System.out.println("得到的seqno" + seqNo);
        int no = getNo();
        System.out.println("得到的number"+no);
    }
    
    private synchronized int getNo() {
        int no = seqNo;
        no = no + 1;
        
        // 序列号达到9999后重置为0
        if (no > 9999) {
            no = 0;
        }
        seqNo = no;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return no;
    }
}

class numberThread implements Runnable {
    
    private One01 one;
    public numberThread(One01 one) {
        this.one = one;
    }
    @Override
    public void run() {
        one.getNumber();
    }
}
