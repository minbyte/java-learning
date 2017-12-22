package com.mindasoft._07_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/18 9:43
 */
public class FileCount {

    /**
     * 我们写一个检测文件长度的小程序，别看这个程序挺长的，你忽略try catch块后发现也就那么几行而已。
     */
    public static void main(String[] args) {
        //TODO 自动生成的方法存根
        int count=0;  //统计文件字节长度
        InputStream streamReader = null;   //文件输入流
        try{
            System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
            System.out.println(Thread.currentThread().getContextClassLoader().getResource("com/mindasoft/_07_io/FileCount.class"));
            streamReader=new FileInputStream(new File(Thread.currentThread().getContextClassLoader().getResource("com/mindasoft/_07_io/FileCount.class").toString()));
            //FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
            while(streamReader.read()!=-1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            System.out.println("---长度是： "+count+" 字节");
        }catch (final IOException e) {
            e.printStackTrace();
        }finally{
            try{
                streamReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
