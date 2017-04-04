package com.ullas.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumberInSequence implements Runnable {

	final AtomicInteger index = new AtomicInteger(1);

    String turn = "1"; 

    Map<String, String> sequence = new HashMap<String, String>();

    Object waitNotifySignal;

    public PrintNumberInSequence(Object waitNotifySignal) {
        this.waitNotifySignal = waitNotifySignal;
    }

    @Override
    public void run() {
        int i = index.get();
        while (i <= 10) {
            synchronized(waitNotifySignal){
                while(!Thread.currentThread().getName().equalsIgnoreCase(turn)) {
                    try{
                        waitNotifySignal.wait();
                    }catch(InterruptedException e){
                        return;//interrupted means that the thread should stop
                    }
                }
            }

            System.out.println("Thread: "
                    + Thread.currentThread().getName() + " --- " + i);
            i = index.incrementAndGet();

            synchronized(waitNotifySignal){
            //    turn = getNextTurn(turn);
                waitNotifySignal.notifyAll();
            }
        }
    }

}