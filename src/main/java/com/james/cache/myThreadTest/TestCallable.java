package com.james.cache.myThreadTest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一、创建执行线程的方式三：实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 * 二、执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果。FutureTask是Future接口的实现类
 */
public class TestCallable {

  public static void main(String[] args) {
    ThreadDemo td = new ThreadDemo();
    Map<String,Object>map = new HashMap<>();
    map.put("1",1);
    System.out.println(map.size());

    // 1.执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果
    FutureTask<Integer> result = new FutureTask<>(td);
    new Thread(result).start();
    boolean flag = true;
    // 2.接收线程运算后的结果
    while(flag){
      if(result.isDone()){
        try {
          Integer integer=result.get();
          System.out.println(integer+"-----------");
        } catch(InterruptedException e) {
          e.printStackTrace();
        } catch(ExecutionException e) {
          e.printStackTrace();
        }finally {
          flag=false;
        }
      }
    }
    try {
      Integer sum = result.get(); // FutureTask可用于闭锁
      System.out.println(sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    System.out.println("system . ....  over");
  }

}

class ThreadDemo implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
      sum += i;
    }
    Thread.sleep(10000);
    // int a  = 1/0;
    return sum;
  }
}
