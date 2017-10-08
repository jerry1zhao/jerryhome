// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, Jerry, creation
// ============================================================================

package pers.jerry.quick.jedis;

import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Jerry
 *
 */
public class JedisUtil {
    private static final Logger logger = Logger.getLogger(JedisUtil.class);

	private static JedisPool pool;

	static {
		final ResourceBundle bundle = ResourceBundle.getBundle("redis");
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxTotal(Integer.valueOf(bundle.getString("jedis.pool.maxTotal")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("jedis.pool.maxIdle")));
		config.setMaxWaitMillis(Integer.valueOf(bundle.getString("jedis.pool.maxWaitMillis")));
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("jedis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("jedis.pool.testOnReturn")));
		Integer timeOut = Integer.valueOf(bundle.getString("jedis.pool.timeOut"));
		String ip = bundle.getString("redis.ip");
		Integer port = Integer.valueOf(bundle.getString("redis.port"));
		String auth = bundle.getString("redis.auth");
		pool = new JedisPool(config,ip,port,timeOut);
	}
	
	public synchronized static Jedis getJedis(){
		try {
			if(pool != null){
				return pool.getResource();
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Jedis pool exception", e);
			return null;
		}
	}
	
	public static void close(Jedis jedis){
		if (jedis != null){
			jedis.close();
		}
	}
	
	public static String get(String key){
		String value = null;
		Jedis jedis = getJedis();
		try {
			value = jedis.get(key);
		} catch (Exception e){
			logger.error("Jedis pool exception", e);
		} finally {
			close(jedis);
		}
		return value;
	}
	
	public static String set(String key,String value){
		String ans = null;
		Jedis jedis = getJedis();
		try {
			ans = jedis.set(key,value);
		} catch (Exception e){
			logger.error("Jedis pool exception", e);
		} finally {
			close(jedis);
		}
		return ans;
	}
	
	public static Long sadd(String key,String value){
		Long ans = null;
		Jedis jedis = getJedis();
		try {
			ans = jedis.sadd(key,value);
		} catch (Exception e){
			logger.error("Jedis pool exception", e);
		} finally {
			close(jedis);
		}
		return ans;
	}
	
	public static Set<String> sinter(String set1,String set2){
		Set<String> result = null;
		Jedis jedis = getJedis();
		try {
			result = jedis.sinter(set1,set2);
		} catch (Exception e){
			logger.error("Jedis pool exception", e);
		} finally {
			close(jedis);
		}
		return result;
	}
	
	public static Set<String> sdiff(String set1,String set2){
		Set<String> result = null;
		Jedis jedis = getJedis();
		try {
			result = jedis.sdiff(set1,set2);
		} catch (Exception e){
			logger.error("Jedis pool exception", e);
		} finally {
			close(jedis);
		}
		return result;
	}
}
