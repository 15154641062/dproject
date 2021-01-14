package com.bh.throwable;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThrowableDemo {
    @Test
    public void throwableDemoTest() {
        //exceptionDemo01();
        //System.out.println("finally测试结果:"+finallyDemo());
        //exceptionDemo02();
        //exceptionDemo03();
        myExceptionDemo();
    }

    //try-catch
    public void exceptionDemo01() {
        int num01 = 10;
        int num02 = 0;
        int[] arr = {1, 2, 3};
        //System.out.println(num01/num02);    //java.lang.ArithmeticException: / by zero

        //try-catch-finally 处理异常
        // 可以有多个catch捕获不同类型的异常，一旦有匹配的就会执行相应catch块里的代码,
        // 然后结束try-catch,try之后的代码不会执行
        try {
            System.out.println(num01 / num02);
            System.out.println(arr[3]);     //前面的代码发生异常后，该行便不会执行
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界!");
        } finally {
            System.out.println("此处的代码一定会执行!");    //若执行finally之前jvm退出了，则无法执行，常用于释放资源(IO、数据库)
        }
    }

    //finally 与 return的问题
    public int finallyDemo() {
        int num01 = 10;
        int num02 = 0;
        try {
            System.out.println(num01 / num02);
        } catch (ArithmeticException e) {
            num01 += 10;
            return num01;       //此处会执行但不会返回而是继续执行finally中的代码
        } finally {
            num01 += 10;
            return num01;       // 30
        }

    }

    /* throws 与 throw 的区别
    throws:用在方法声明后，跟的是异常类名,可以跟多个异常类名，用逗号隔开,表示抛出异常，由该方法的调用者处理
           throws表示出现异常的一种可能性，并不一定会发生异常
	throw:用在方法体内，跟的是异常对象,只能抛出一个异常对象,表示抛出异常，由方法体内的语句处理
	*/
    //throws 抛出异常   在方法声明上抛出，是为了告诉调用者，此处有问题。
    public void exceptionDemo02() {
        String str = "Hello World";
        try {
            Date date = dateFormatMethod01(str);
        } catch (ParseException e) {
            //e.printStackTrace();      //打印具体异常信息
            System.out.println("日期解析出错!");
        }
    }

    public Date dateFormatMethod01(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse(str);
    }

    //throw 抛出异常，抛出的应该是异常的对象
    public void exceptionDemo03() {
        int num01 = 10;
        int num02 = 0;
        if (num02 == 0) {
            throw new ArithmeticException();
        } else {
            System.out.println(num01 / num02);
        }
    }

    /*
     * 异常注意事项:
     * 1:子类重写父类方法时，子类的方法必须抛出相同的异常或父类异常的子类
     * 2:如果父类抛出了多个异常,子类重写父类时,只能抛出相同的异常或者是其子集,子类不能抛出父类没有的异常
     * 3:如果被重写的方法没有异常抛出,那么子类的方法绝对不可以抛出异常,如果子类方法内有异常,那么子类只能try,不能throws
     */
    public void myExceptionDemo() {
        int score = 100;
        Teacher teacher = new Teacher();
        try {
            teacher.check(score);
        } catch (MyException myException) {
            myException.printStackTrace();
        }
    }
}
