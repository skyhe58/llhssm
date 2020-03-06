package com.soecode.lyf.util;

public class PasswordGeneratorUtil {

    /**
     * 生成六位数随机密码，大小写英文+数字
     *
     * @return
     */
    public static String getRandomPassword() {

        StringBuffer randomPasswordBuffer = new StringBuffer();
        for (int j = 0; j < 6; j++) {
            double rand = Math.random();
            double randTri = Math.random() * 3;
            if (randTri >= 0 && randTri < 1) {
                randomPasswordBuffer.append((char) (rand * ('9' - '0') + '0'));
            } else if (randTri >= 1 && randTri < 2) {
                randomPasswordBuffer.append((char) (rand * ('Z' - 'A') + 'A'));
            } else {
                randomPasswordBuffer.append((char) (rand * ('z' - 'a') + 'a'));
            }
        }
        return (randomPasswordBuffer.toString());
    }

}
