package com.eiecc.fire.spring_4_no_xml.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.jredis.JredisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.srp.SrpConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	public JredisConnectionFactory jredisConnectionFactory() {
		JredisConnectionFactory jredisConnectionFactory = new JredisConnectionFactory();
		jredisConnectionFactory.setHostName("");
		jredisConnectionFactory.setPort(6379);
		return jredisConnectionFactory;
	}

	public SrpConnectionFactory srpConnectionFactory() {
		SrpConnectionFactory srpConnectionFactory = new SrpConnectionFactory();
		srpConnectionFactory.setHostName("");
		srpConnectionFactory.setPort(6379);
		return srpConnectionFactory;
	}

	/*
	 * Spring Data Redis 1.x二进制文件需要JDK 6.0及更高版本，以及Spring Framework
	 * 4.2.8.RELEASE及更高版本。
	 * 
	 * 对于键值存储，需要Redis 2.6.x或更高版本。 Spring Data Redis目前正在针对最新的3.0版本进行测试。
	 * 
	 * Spring Redis需要Redis 2.6或更高版本以及Java SE 6.0或更高版本。 在语言绑定（或连接器）方面，Spring
	 * Redis与Jedis，
	 * JRedis（自1.7以来弃用），SRP（自1.7以来弃用）和Lettuce（Redis的四个流行的开源Java库）集成。
	 * 如果您知道任何其他连接器，我们应该整合，请给我们反馈。
	 */
	public JedisConnectionFactory jedisConnectionFactory1() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("");
		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	/**
	 * jedis
	 */
	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
				.sentinel("127.0.0.1", 26379).sentinel("127.0.0.1", 26380);

		// return new JedisConnectionFactory(sentinelConfig);
		// 这个的加jedis包
		return new JedisConnectionFactory(sentinelConfig);
	}

	/*
	 * <bean id="redisTemplate"
	 * class="org.springframework.data.redis.core.RedisTemplate"
	 * p:connection-factory-ref="jedisConnectionFactory"/>
	 */
	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate1() {

		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
		return stringRedisTemplate;
	}

	public LettuceConnectionFactory lettuceConnectionFactory() {
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
		lettuceConnectionFactory.setHostName("");
		lettuceConnectionFactory.setPort(6379);
		return lettuceConnectionFactory;
	}

	/**
	 * lettuce
	 */
	@Bean
	public RedisConnectionFactory lettuceConnectionFactory1() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
				.sentinel("127.0.0.1", 26379).sentinel("127.0.0.1", 26380);
		return new LettuceConnectionFactory(sentinelConfig);
	}

}
