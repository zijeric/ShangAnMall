package com.shangan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Alva
 * @CreateTime 2021/1/26 21:08
 * 数字工具类
 * 1.登录或注册成功后，生成保持用户登录状态会话 token 值
 * 2.判断电话号码
 * 3.生成随机数
 * 4.生产订单流水号
 */
public class NumberUtil {

    /**
     * 判断是否为11位电话号码
     * @param phone
     * @return
     */
    public static boolean isNotPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return !matcher.matches();
    }

    /**
     * 生成指定长度的随机数
     * @param length
     * @return
     */
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 生成订单流水号
     * @return
     */
    public static String genOrderNo() {
        StringBuilder buffer = new StringBuilder(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        buffer.append(num);
        return buffer.toString();
    }
}
