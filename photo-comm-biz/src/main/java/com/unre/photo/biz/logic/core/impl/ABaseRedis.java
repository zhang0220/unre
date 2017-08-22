package com.unre.photo.biz.logic.core.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class ABaseRedis<K, V> {

	//@Autowired
	protected RedisTemplate<K, V> redisTemplate;

	/**
	 * 设置redisTemplate 
	 * @param redisTemplate the redisTemplate to set 
	 */
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@SuppressWarnings("unchecked")
	protected RedisSerializer<K> getKeyRedisSerializer() {
		return (RedisSerializer<K>) redisTemplate.getKeySerializer();
	}

	@SuppressWarnings("unchecked")
	protected RedisSerializer<V> getValueRedisSerializer() {
		return (RedisSerializer<V>) redisTemplate.getValueSerializer();
	}

	protected boolean add(final K k, final V v) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<K> kSerializer = getKeyRedisSerializer();
				RedisSerializer<V> vSerializer = getValueRedisSerializer();
				byte[] key = kSerializer.serialize(k);
				byte[] value = vSerializer.serialize(v);
				return connection.setNX(key, value);
			}
		});
		return result;
	}

	protected V get(final K k) {
		V v = redisTemplate.execute(new RedisCallback<V>() {
			public V doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<K> kSerializer = getKeyRedisSerializer();
				RedisSerializer<V> vSerializer = getValueRedisSerializer();
				byte[] key = kSerializer.serialize(k);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				V v = vSerializer.deserialize(value);
				return v;
			}
		});
		return v;
	}

	protected long del(final K k) {
		long result = (long) redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<K> kSerializer = getKeyRedisSerializer();
				byte[] key = kSerializer.serialize(k);
				return connection.del(key);
			}
		});
		return result;
	}
}
