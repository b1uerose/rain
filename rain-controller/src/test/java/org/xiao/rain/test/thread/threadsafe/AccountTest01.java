package org.xiao.rain.test.thread.threadsafe;

/**
 * Author: xiaojl
 * Date: 2021/7/6 23:28
 */
public class AccountTest01 {

    public static void main(String[] args) {
        Account account = new Account("act-001", 10000);
        Thread t1 = new AccountThread(account);
        Thread t2 = new AccountThread(account);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        
        Account account2 = new Account("act-002", 20000);
        Thread t3 = new AccountThread(account2);
        t3.setName("t3");
        t3.start();
    }
}
