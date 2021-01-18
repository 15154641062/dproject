package com.bh.dao.impl;

import com.bh.dao.IUserDao;
import com.bh.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements IUserDao {
    public static int loginStrus=0;
    private static List<User> users=new ArrayList<User>();
    private BufferedReader bufferedReader=null;
    private BufferedWriter bufferedWriter=null;

    @Override
    public void login(){
        int isAlive=0;
        System.out.println("请输入用户名:");
        Scanner scanner=new Scanner(System.in);
        String username=scanner.nextLine();
        System.out.println("请输入密码:");
        String password=scanner.nextLine();

        readFile();

        for (User user:users) {
            if(username.equals(user.getUserName())){
                isAlive=1;
                if(password.equals(user.getPassWord())){
                    System.out.println("登录成功！");
                    loginStrus=1;
                }else{
                    System.out.println("密码错误！");
                }
            }
        }

        if(isAlive==0){
            System.out.println("该用户名不存在！");
        }
    }

    @Override
    public void register(){
        int isAlive=0;
        System.out.println("请输入用户名:");
        Scanner scanner=new Scanner(System.in);
        String username=scanner.nextLine();

        for (User user:users) {
            if(username.equals(user.getUserName())){
                isAlive=1;
            }
        }
        if(isAlive==0){
            System.out.println("请输入密码:");
            String password=scanner.nextLine();
            User user=new User();
            System.out.println(username+password);
            user.setUserName(username);
            user.setPassWord(password);
            writeFile(user);
            System.out.println("注册成功！");
        }else{
            System.out.println("该用户名已存在！");
        }
    }

    //将文件中的所有用户信息读入集合中
    private void readFile() {
        try {
            users.clear();
            String line=null;
            bufferedReader=new BufferedReader(new FileReader("information.txt"));
            while ((line = bufferedReader.readLine()) != null) {    //读入一行
                String[] str=line.split("\\$");        //通过$符号切割字符串
                User user=new User();
                user.setUserName(str[0]);
                user.setPassWord(str[1]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();     //释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将用户名密码写入文件
    private void writeFile(User user){
        try {
            bufferedWriter=new BufferedWriter(new FileWriter("information.txt",true));      //追加写
            bufferedWriter.write(user.getUserName()+"$"+user.getPassWord());
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();     //释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
