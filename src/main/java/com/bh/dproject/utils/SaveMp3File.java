package com.bh.dproject.utils;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveMp3File {
    @Test
    public void saveMp3FileTest(){
        String filePath="D:\\work\\filePractice\\in";
        System.out.println(saveMp3File(filePath));
    }

    /**
     * 将制定目录下的mp3文件存入数据库
     * @param filePath
     * @return
     */
    public static int saveMp3File(String filePath){
        int flag=0;
        Connection connection=null;
        FileInputStream mp3file=null;

        try {
            File path=new File(filePath);
            if (path.listFiles().length>0){         //判断指定目录下是否有文件
                File[] files=path.listFiles();
                for (File file:files) {
                    if (file.isFile()){             //判断是否是文件类型
                        if (file.getName().contains(".mp3")){          //是否是mp3的文件类型
                            String fileName=file.getName();        //是则获取文件名
                            mp3file=new FileInputStream(filePath+"\\"+fileName);     //创建问价输入流对象
                            byte[] bytes= IOUtils.toByteArray(mp3file);     //数据转化为byte数组
                            SerialBlob blob=new SerialBlob(bytes);         //byte数组转化为数据库的Blob对象  SerialBlob是Blob的一个实现类

                            connection=GetConnection.getConnection();
                            String sql="insert into mp3_file (filename,data) values(?,?)";
                            PreparedStatement statement=connection.prepareStatement(sql);
                            statement.setString(1,fileName);
                            statement.setBlob(2,blob);
                            flag+=statement.executeUpdate();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SerialException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();     //释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (mp3file!=null){
                try {
                    mp3file.close();      //释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
