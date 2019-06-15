package com.lihg.recover;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 读取sqlite数据库，这货不能用Blob，读到的是一堆乱码，不知该如何解密
 */
public class SqliteTest {

    public static void main(String[] args) {

        try {
            //连接SQLite的JDBC
            Class.forName("org.sqlite.JDBC");
            //建立一个数据库名lincj.db的连接，如果不存在就在当前目录下创建之
            Connection conn = DriverManager.getConnection("jdbc:sqlite:FTS5IndexMicroMsg_decrypt.db");

            Statement stat = conn.createStatement();

            ResultSet set = stat.executeQuery("select * from FTS5IndexMessage_data limit 6 ");

            while(set.next()){
                // 获取第一个列的值 编号id
                int id = set.getInt(1);
                byte[] test = set.getBytes(2);
                String note = new String(test,"gb2312");
                System.out.println(note);

                // 获取第二个列的值 图书名称 bookName
                //Blob content = set.getBlob(2);
                //InputStream is = set.getBinaryStream(2);
                //
                //String note = null;
                //ByteArrayInputStream bais = (ByteArrayInputStream)is;
                ////bais.available()返回此输入流的字节数
                //byte[] byte_data = new byte[bais.available()];
                ////将输入流中的内容读到指定的数组
                //bais.read(byte_data, 0,byte_data.length);
                ////再转为String，并使用指定的编码方式
                //note = new String(byte_data,"utf-8");
                //System.out.println(note);
                //is.close();

                //String note = null;
                //if(content != null){
                //    InputStream is = content.getBinaryStream();
                //    ByteArrayInputStream bais = (ByteArrayInputStream)is;
                //    //bais.available()返回此输入流的字节数
                //    byte[] byte_data = new byte[bais.available()];
                //    //将输入流中的内容读到指定的数组
                //    bais.read(byte_data, 0,byte_data.length);
                //    //再转为String，并使用指定的编码方式
                //    note = new String(byte_data,"utf-8");
                //    System.out.println(note);
                //    is.close();
                //}
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


