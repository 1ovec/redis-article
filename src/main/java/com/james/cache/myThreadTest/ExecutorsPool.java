package com.james.cache.myThreadTest;

import org.apache.commons.lang.StringUtils;

import java.util.concurrent.*;

/**
 * @author admin
 * @ClassName ExecutorsPool
 * @Description
 * @Date 2019/12/27
 */
public class ExecutorsPool {

  public static void main(String[] args) {
    //创建简单线程池（基本参数配置已给定）
    Executor executor =Executors.newSingleThreadExecutor();

    RejectedExecutionHandler handler =(r,executor1) -> {

    };
    //自定义的线程池
    ThreadFactory threadFactory;
    ThreadPoolExecutor threadPoolExecutor1=new ThreadPoolExecutor(5,
            10,
            60,
            TimeUnit.SECONDS,new LinkedBlockingDeque<>(),
            //Executors.defaultThreadFactory()
            //饱和策略，如果当线程池的最大线程数都被占用的时候采取的执行措施（默认抛异常）
            Executors.privilegedThreadFactory(),(runnable,executor1) -> {
              System.out.println("线程已满啊");
            }
            //new ThreadPoolExecutor.CallerRunsPolicy().rejectedExecution(parm1,parm2)

    );

  }

}
