package com.bh.throwable;

//继承Exception:编译期异常
//继承RuntimeException:运行期异常
public class MyException extends Exception{


    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
