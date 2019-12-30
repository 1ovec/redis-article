package com.james.cache.interfaceCall;
//一个接口叫做Inter，里面定义了一个happy（）方法，有两个类A、B实现了这个接口

interface Inter{
  void happy();
}

class A implements Inter{

  @Override
  public void happy() {
    System.out.println("happy...A");
  }
}

class B implements Inter{

  @Override
  public void happy() {
    System.out.println("happy...B");
  }
}

public class Test{
  public static void happys(Inter inter){
    inter.happy();
  }

  public static void main(String[] args) {
    happys(new A());
    happys(new B());
  }
}