package com.james.cache.test;

import com.james.cache.utils.JedisUtils;

/**
 * @author admin
 * @ClassName RedisT
 * @Description
 * @Date 2019/12/25
 */
public class RedisT {

  public static void main(String[] args) {
    JedisUtils ju = new JedisUtils();
    String set=ju.set("myName","Value");
    System.out.println(set);

    System.out.println(ju.get("myName"));

    System.out.println(ju.setSerializer("setSerializer".getBytes(),"setSerializer".getBytes()));
    String[]arr = new String[]{"myName","aaaaaa1"};
    System.out.println(ju.del(arr));
  }

}
