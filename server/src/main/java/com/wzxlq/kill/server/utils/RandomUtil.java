package com.wzxlq.kill.server.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数生成util
 *
 * @author 王照轩
 * @date 2020/2/3 - 11:18
 */
public class RandomUtil {
    private static final SimpleDateFormat dateFormatOne = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static String generateOrderCode() {
        //ToDO:时间戳+N位随机数流水号
        return dateFormatOne.format(DateTime.now().toDate()) + gennerateNumber(4);
    }

    public static String gennerateNumber(final int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
     String password="123456";
        System.out.println(new Md5Hash(password,"debug").toString());
    }
}
