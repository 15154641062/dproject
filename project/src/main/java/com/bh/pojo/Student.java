package com.bh.pojo;

public class Student {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() { }

    public Student(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.bh.pojo.Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
