package com.james.cache.lockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * @deprecated 读写锁demo--> ReentrantReadWriteLock
 */
public class Cache {
  private static Map<String, Object> map =new HashMap<>();
  private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  private static Lock r = rwl.readLock();
  private static Lock w = rwl.writeLock();

  // 获取一个key对应的value
  private static Object get(String key) {
    r.lock();
    try {
      System.out.println("正在做读的操作,key:" + key + " 开始");
      Thread.sleep(100);
      Object object = map.get(key);
      System.out.println("正在做读的操作,key:" + key + " 结束");
      System.out.println();
      return object;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      r.unlock();
    }
    return key;
  }

  // 设置key对应的value，并返回旧有的value
  private static Object put(String key,Object value) {
    w.lock();
    try {

      System.out.println("正在做写的操作,key:" + key + ",value:" + value + "开始.");
      Thread.sleep(100);
      Object object = map.put(key, value);
      System.out.println("正在做写的操作,key:" + key + ",value:" + value + "结束.");
      System.out.println();
      return object;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      w.unlock();
    }
    return value;
  }

  // 清空所有的内容
  private static void clear() {
    w.lock();
    try {
      map.clear();
    } finally {
      w.unlock();
    }
  }

  public static void main(String[] args) {
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        Cache.put(i + "", i + "");
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        Cache.get(i + "");
      }
    }).start();
  }
}
