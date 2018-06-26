package com.soecode.lyf.base.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * E:/others/a/mm.txt--->复制到E:/others/abc/mm0.txt
 * 输入流读取 ，输出流写出 边读取边写出
 *
 * Created by llh on 2018-06-25
 */
public class TestFileInputAndOutputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //建立输入流和源文件之间的联系
            fis = new FileInputStream(new File("E:/others/a/mm.txt"));
            //建立输出流和目标文件之间的联系
            fos = new FileOutputStream("E:/others/abc/mm2.txt",true);
            //通过输入流读取，输出流写出
            //声明byte[]数组，用于存储读取的数据
            byte[] buffer = new byte[10];
            int len = fis.read(buffer);
            while(len != -1 ){
                fos.write(buffer,0,len);
                len = fis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流：先打开的后关闭
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
