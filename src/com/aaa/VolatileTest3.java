package com.aaa;

public class VolatileTest3 {

    private static int found = 0;

    public static void main(String[] args) {
        new Thread((Runnable) () -> {
            System.out.println("等基友送笔。。。");

            while (0 == found) {
            }
            System.out.println("比来了， 开始写字");
        }, "我线程").start();

        new Thread((Runnable) () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("基友找到笔了， 送过去。。。");

            change();

        }, "基友线程").start();
    }

    public static void change() {
        found = 1;
    }
}
