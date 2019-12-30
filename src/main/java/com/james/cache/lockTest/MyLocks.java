package com.james.cache.lockTest;

import java.util.concurrent.locks.*;

/**
 * @author admin
 * @ClassName MyLocks
 * @Description
 * @Date 2019/12/26
 */
public class MyLocks {


  public synchronized static void main() {

  }

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    lock.lock();

    Lock lock1 = new ReentrantReadWriteLock().readLock();

    //Condition condition = new AbstractQueuedSynchronizer();
  }

}
