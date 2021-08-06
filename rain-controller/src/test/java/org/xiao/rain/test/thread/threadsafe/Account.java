package org.xiao.rain.test.thread.threadsafe;

/**
 * Author: xiaojl
 * Date: 2021/7/6 23:23
 */
public class Account {

    private String vaccount;
    private double nbalance;

    public Account(String vaccount, double nbalance) {
        this.vaccount = vaccount;
        this.nbalance = nbalance;
    }

    public String getVaccount() {
        return vaccount;
    }

    public void setVaccount(String vaccount) {
        this.vaccount = vaccount;
    }

    public double getNbalance() {
        return nbalance;
    }

    public void setNbalance(double nbalance) {
        this.nbalance = nbalance;
    }

    public void withDraw(double nmny) {
        synchronized (this) {
            double before = this.getNbalance();
            if (before < nmny) {
                System.out.println(this.getVaccount() + "的余额不足！！");
            }
            double after = before - nmny;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "取款" + nmny + "，剩余" + after);
            this.setNbalance(after);
        }
    }
}
