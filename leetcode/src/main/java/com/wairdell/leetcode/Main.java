package com.wairdell.leetcode;

/**
 * date   : 2024/4/27 13:28
 * desc   :
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student a = new Student("xxxxxxxx");
        Student b = a.clone();
        b.name = "cccccccccc";
        System.out.println(a.name);
        System.out.println(b.name);
    }


    static class Student implements Cloneable {

        private String name;

        Student(String name) {
            this.name = name;
        }

        @Override
        public Student clone() throws CloneNotSupportedException {
            return (Student) super.clone();
        }
    }
}
