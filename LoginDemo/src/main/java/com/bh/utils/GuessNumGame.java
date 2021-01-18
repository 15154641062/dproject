package com.bh.utils;

import java.util.Scanner;

public class GuessNumGame {
    public void play(){
        System.out.println("猜数游戏开始...");

        int guessTime=0;
        int isRigh=0;
        int randomNumber=(int)(100*Math.random());
        System.out.println(randomNumber);
        do {
            System.out.println("请输入一个自然数:");
            int guessNumber=0;
            try{
                Scanner scanner=new Scanner(System.in);
                guessNumber=scanner.nextInt();
            }catch (Exception e){
                System.out.println("输入有误！");
                continue;
            }
            guessTime++;
            switch (compare(guessNumber,randomNumber)){
                case 0:
                    System.out.println("恭喜您猜对了！共猜了"+guessTime+"次...");
                    isRigh=1;
                    break;
                case 1:
                    System.out.println("猜大了");
                    break;
                case -1:
                    System.out.println("猜小了");
                    break;
                default:
                    break;
            }
        }while (isRigh==0);
    }

    //比较
    public int compare(int guessNumber,int randomNumber){
        if(guessNumber==randomNumber){
            return 0;
        }else{
            return guessNumber>randomNumber?1:-1;
        }
    }
}
