package cn.skythinking.util;

import java.util.Random;

public class RandomUtil {
    private RandomUtil(){
    }
    private static final Random random = new Random();
    public static int randomInt(int min,int max){
        return min+ random.nextInt(max-min);
    }
}
