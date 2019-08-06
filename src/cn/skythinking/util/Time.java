package cn.skythinking.util;

public class Time {
    public static void sleep(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
