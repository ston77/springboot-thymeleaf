package shan.yan.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {
	
	@Autowired
	JedisPool jedisPool;
	
	public <T> T get(KeyPrefix prefix,String key , Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource(); 
			String realKey = prefix.getPrefix()+key;
			String st = jedis.get(realKey);
			return stringToBean(st,clazz);
		} finally {
			returnToPool(jedis);
		}
		
	}
	
	public <T> boolean set(KeyPrefix prefix,String key ,T value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource(); 
			
			String realKey = prefix.getPrefix()+key;
			String str = benToString(realKey,value);
			int seconds = prefix.expireSeconds();
			if(seconds <= 0) { // 检查过期时间，此处表示永不失效
				jedis.set(realKey,str);
			} else {
				jedis.setex(realKey, seconds, str);
			}
			return true;
		} finally {
			returnToPool(jedis);
		}
	}
	
	public <T> boolean exits(KeyPrefix prefix,String key ,T value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource(); 
			
			String realKey = prefix.getPrefix()+key;
			return jedis.exists(realKey);
			
		} finally {
			returnToPool(jedis);
		}
	}
	
	private <T> String benToString(String key, T value) {
		if( value == null ) {
			return null;
		} 
		Class<?> clazz = value.getClass();
		if( clazz == int.class || clazz == Integer.class ) {
			return ""+value;
		} else if (clazz == String.class ) {
			return (String)value;
		} else if (clazz == long.class|| clazz == Long.class ) {
			return ""+value;
		} else {
			return JSON.toJSONString(value);
		}
		
	}


	private <T> T stringToBean(String st,Class<T> clazz) {
		if(st == null || st.length() <= 0 || clazz == null) {
			return null;
		} else if ( clazz == int.class || clazz == Integer.class ) {
			return (T)Integer.valueOf(st);
		} else if ( clazz == String.class ) {
			return (T)st;
		} else if ( clazz == Long.class || clazz == long.class ) {
			return (T)Long.valueOf(st);
		} else {
			return JSON.toJavaObject(JSON.parseObject(st), clazz);
		}
		
	}

	private void returnToPool(Jedis jedis) {
		if( jedis != null ) {
			jedis.close();
		}
		
	}

	
}
