package com.epam.troubleshooting.deadlock;


public class Main {

    private final static Object resource1 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 is locking resource 1");

                    while (true) {
                        // Sleep for a long time
                        try { Thread.sleep(Long.MAX_VALUE);} catch (Exception e) {}
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 2 is locking resource 1");
                }
            }
        };

        Thread thread3 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 3 is locking resource 1");
                }
            }
        };

        Thread thread4 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 4 is locking resource 1");
                }
            }
        };

        Thread thread5 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 5 is locking resource 1");
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
