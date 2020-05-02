package com.gang.common.lib.utils;

import java.util.Random;

/**
 * @Classname RandomUtils
 * @Description TODO
 * @Date 2020/5/2 16:20
 * @Created by zengzg
 */
public final class AntRandomUtils {

    private AntRandomUtils() {
    }

    /**
     * 生成 随机数
     *
     * @param len
     * @return
     */
    public static String getRandom(int len) {
        int digit = (int) Math.pow(10, Double.valueOf(len) - 1);
        int rs = new Random().nextInt(digit * 10);
        if (rs < digit) {
            rs += digit;
        }
        return String.valueOf(rs);
    }
}
