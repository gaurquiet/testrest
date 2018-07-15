package com.mkyong;

import java.util.ArrayList;
import java.util.List;

public class Test implements test1, test2{
    public String test(){
    System.out.println("I am of interface method implementation");
    return "abc";
    }

    public static void main(String args[]){
        Test test = new Test();
        System.out.println("----"+test.test());
        List list = new ArrayList<String>(10);
        list.add("ab");
        list.add("cd");
        list.add("ef");
        System.out.println("----"+list.remove(1));

    }
}


interface test1{

    String  test();
}

interface test2{

    String test();
}