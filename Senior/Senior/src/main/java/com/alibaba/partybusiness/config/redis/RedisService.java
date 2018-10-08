package com.alibaba.partybusiness.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService{
	@Autowired
	private JedisPool jedisPool;

	//设置key
    public <T> boolean set(KeyPrefix prefix, String key, T t) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if(prefix.expireSeconds()<=0) {
            	 jedis.set(prefix.getprefix()+key, BeanToString(t));
            }else {
            	jedis.setex(key, prefix.expireSeconds(), BeanToString(t));
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	 returnToPool(jedis);
        }
        return false;
    }
   
	//得到key
    public <T> T get(KeyPrefix prefix, String key,Class<T> clazz) {
    	Jedis jedis=null;
    	 try {
           jedis = jedisPool.getResource();
           T t=StringToBean(jedis.get(prefix.getprefix()+key),clazz);
           return t;
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             returnToPool(jedis);
         }
		return null;
    }
    //判断key
    public boolean exists(KeyPrefix prefix, String key) {
    	Jedis jedis=null;
    	 try {
           jedis = jedisPool.getResource();
           if(jedis.exists(key)) {
        	   return true;
           }else {
        	   return false;
           }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             returnToPool(jedis);
         }
		return false;
    }
    //key加一
    public Long incr(KeyPrefix prefix, String key) {
    	Jedis jedis=null;
    	 try {
           jedis = jedisPool.getResource();
          return jedis.incr(prefix.getprefix()+key);
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             returnToPool(jedis);
         }
		return null;
    }
    //key减一
    public Long decr(KeyPrefix prefix, String key) {
    	Jedis jedis=null;
    	 try {
           jedis = jedisPool.getResource();
          return jedis.decr(prefix.getprefix()+key);
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             returnToPool(jedis);
         }
		return null;
    }
    
    
    
    
    
    
    //对象转字符串（redis存对象进去）
    private <T> String BeanToString(T t) {
    	if(t==null) {
    		return null;
    	}
    	Class<?> clazz=t.getClass();
    	if(clazz==int.class||clazz==Integer.class||clazz==double.class||clazz==Double.class||clazz==float.class||clazz==Float.class||clazz==long.class||clazz==Long.class) {
    		return ""+t;
    	}
		return JSON.toJSONString(t);
	}
    
    //字符串转对象（redis拿对象出来）
    @SuppressWarnings("unchecked")
	private <T> T StringToBean(String string,Class<T> clazz) {
		if(string==null||string.length()<=0||clazz==null) {
			return null;
		}
    	if(clazz==int.class||clazz==Integer.class) {
    		return (T)Integer.valueOf(string);
    	}else if(clazz==String.class) {
    		return (T)string;
    	}else if(clazz==Long.class||clazz==long.class) {
    		return (T)Long.valueOf(string);
    	}else if(clazz==double.class||clazz==Double.class) {
    		return (T)Double.valueOf(string);
    	}else if(clazz==float.class||clazz==Float.class) {
    		return (T)Float.valueOf(string);
    	}else {
    		return JSON.toJavaObject(JSON.parseObject(string), clazz);
		}
	}
    
	//返回连接池
	private void returnToPool(Jedis jedis) {
		if(jedis!=null) {
			jedis.close();
		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
