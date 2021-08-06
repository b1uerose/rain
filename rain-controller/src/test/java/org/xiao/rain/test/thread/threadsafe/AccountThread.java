package org.xiao.rain.test.thread.threadsafe;

/**
 * Author: xiaojl
 * Date: 2021/7/6 23:25
 */
public class AccountThread extends Thread {
    
    private Account account;
    
    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withDraw(5000);
    }
}
