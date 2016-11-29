package com.eiecc.fire.spring_4_no_xml.redis;

import java.net.URL;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Example {

	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> template;

	@Autowired
	private StringRedisTemplate redisTemplate;

	// inject the template as ListOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	public void addLink(String userId, URL url) {
		listOps.leftPush(userId, url.toExternalForm());
	}

	public void addLink2(String userId, URL url) {
		redisTemplate.opsForList().leftPush(userId, url.toExternalForm());
	}

	public void useCallback() {

		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Long size = connection.dbSize();
				// Can cast to StringRedisConnection if using a
				// StringRedisTemplate
				((StringRedisConnection) connection).set("key", "value");
				return size;
			}
		});
	}
}
