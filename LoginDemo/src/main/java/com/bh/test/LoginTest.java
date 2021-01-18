package com.bh.test;

import com.bh.dao.impl.UserDaoImpl;
import com.bh.utils.GuessNumGame;

import java.util.Scanner;

public class LoginTest {
    private UserDaoImpl userDao=new UserDaoImpl();

    //    @Test
//    public void test(){
//        chooseFunc();
//    }
    public static void main(String[] args) {
        new LoginTest().chooseFunc();
    }

    //功能选择
    public void chooseFunc() {
        System.out.println("==================欢迎使用本系统======================");
        System.out.println("请按1-4选择功能");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.猜数游戏");
        System.out.println("4.退出");
        System.out.println("===================================================");
        int chooseStrus = 1;
        do {
            Scanner scanner = new Scanner(System.in);
            String funcNumber = scanner.nextLine();

            if ("1".equals(funcNumber)) {
                if (userDao.loginStrus == 1) {
                    System.out.println("您已登录，请勿重复登录！");
                    chooseFunc();
                } else {
                    userDao.login();
                    chooseFunc();
                }
            } else if ("2".equals(funcNumber)) {
                userDao.register();
                chooseFunc();
            } else if ("3".equals(funcNumber)) {
                if (userDao.loginStrus == 0) {
                    System.out.println("请先登录！");
                    chooseFunc();
                } else {
                    new GuessNumGame().play();
                    chooseFunc();
                }
            } else if ("4".equals(funcNumber)) {
                System.out.println("正在退出...");
                System.exit(0);
            } else {
                System.out.println("输入有误,请重新输入！");
                chooseStrus = 0;
            }
            scanner.close();
        } while (chooseStrus == 0);

    }
}
