package com.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		//jedis.set("foo", "bar");
		String value = jedis.get("name");
		System.out.println(value);
		
		System.out.println(jedis.get("xx"));
		
		//jedis.set("hello", "���ѽ��");
		
		System.out.println(jedis.get("users"));
	}
}
