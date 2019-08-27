package com.zyt.myblog.redis.api;

public interface RedisService {
     void setString(String key, Object object);

     /**
      *
      * @param key
      * @param object
      * @param time 有效时间 单位：秒
      */
     void setString(String key, Object object, Long time);
     void setSet(String key, Object object);
     String getString(String key);
}
