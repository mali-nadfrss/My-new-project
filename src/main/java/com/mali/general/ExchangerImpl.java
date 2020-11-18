package com.mali.general;

import java.util.concurrent.Exchanger;

public class ExchangerImpl {

    public static void main(String[] args) {
        final Exchanger<String> stringExchanger = new Exchanger<>();
        Thread producer = new Thread("producer") {
            @Override
            public void run() {
                try {
                    String msg = stringExchanger.exchange("from producer ");
                    System.out.println(msg+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread("consumer") {
            @Override
            public void run() {
                try {
                    String msg = stringExchanger.exchange("from consumer ");
                    System.out.println(msg+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread neutral = new Thread("neutral") {
            @Override
            public void run() {
                try {
                    String msg = stringExchanger.exchange("from neutral ");
                    System.out.println(msg+Thread.currentThread().getName());
                    String msg1 = stringExchanger.exchange("from neutral ");
                    System.out.println(msg1+Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        neutral.start();
        producer.start();
        consumer.start();

    }
}
