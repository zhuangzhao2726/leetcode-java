package com.zhuangzhao.leetcode.test;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-07-03 16:04
 */
public class Main {

    public Main() {

    }


    public void Main() {

    }




    public static void main(String[] args) {
        Person person1 = new Student();
        Person person2 = new Teacher();
        Main main = new Main();
        main.test(person1);
        main.test(person2);

        Short s = 1;
        System.out.println(s.hashCode());
        Integer i = 1;
        System.out.println(i.hashCode());

        main.notify();
    }


    public void test(Person person) {
        if (person instanceof Student) {
            System.out.println("It is a student");
            Student student = (Student) person;
        }

        if (person instanceof Teacher) {
            System.out.println("It is a teacher");
            Teacher teacher = (Teacher) person;
        }
    }


}


class Person {
}


class Student extends Person {
}



class Teacher extends Person {
}
