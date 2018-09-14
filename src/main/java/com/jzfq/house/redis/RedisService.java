package com.jzfq.house.redis;


import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <B>文件名称：</B>RedisService<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>2017/01/09<BR>
 *
 * @author 吕宏业  lvhongye@yingu.com
 * @version 1.0
 **/
@Component("redisTemplateService")
public class RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public void del(final String... keys) {
        if (keys == null || keys.length == 0) {
            return;
        }
        List<String> list = new ArrayList<>(keys.length);
        for (int i = 0; i < keys.length; i++) {
            list.add(keys[i]);
        }
        del(list);
    }

    public void del(final List<String> keys) {
        if (keys == null || keys.size() == 0) {
            return;
        }
        redisTemplate.delete(keys);
    }

    /**
     * 正则keys删除
     * @param pattern
     * @return
     */
    public long delKeys(final String pattern) {
        Set<String> set = keys(pattern);
        long n = 0;
        List<String> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(set)) {
            for (String key : set) {
                list.add(key);
            }
        }
        del(list);
        return list.size();
    }

    /**
     * @param key
     * @param value
     * @param timeout
     */
    public void set(final String key, final Object value, final long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key
     * @return
     */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String getForString(final String  key) {
        Object obj = get(key);
        return obj != null ? obj.toString() : null;
    }

    /**
     * @param key
     * @param requiredType
     * @return
     */
    public <T> T get(final String key, Class<T> requiredType) {
        Object o = get(key);
        if(requiredType != null){
            if(requiredType.isInstance(o))
                return requiredType.cast(o);
            else
                return null;
        }
        return null;
    }

    /**
     * @param pattern
     * @return
     */
    public Set keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @return
     */
    public String flushDB() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)  {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * @return
     */
    public long dbSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)  {
                return connection.dbSize();
            }
        });
    }

    /**
     * @return
     */
    public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)  {

                return connection.ping();
            }
        });
    }

    /**
     * 递增
     * 如果key不存在，则第一次调用初始化为0，并递增为1，并返回递增后的值
     * 如果key存在，则递增1，并返回递增后的值
     * @param key
     * @return
     */
    public long incr(final String key) {
        return this.incr(key, 1);
    }

    /**
     * 指定递增步长
     * @param key
     * @param delta
     * @return
     */
    public long incr(final String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
    /**
     * 递增并设置过期时间
     * 如果key不存在，则第一次调用初始化为0，并递增为1，并返回递增后的值
     * 如果key存在，则递增1，并返回递增后的值
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    public long incr(final String key,final long timeout,final TimeUnit timeUnit) {
        long num = this.incr(key, 1);
        if(num == 1 && timeout > 0)
            redisTemplate.expire(key, timeout, timeUnit);
        return num;
    }

    /**
     * 设置key有效期，单位秒
     * @param key
     * @param timeout
     * @return
     */
    public Boolean expire(final String key, final long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 哈希,新增
     * @param key
     * @param hashKey
     * @param value
     */
    public void putH(String key, String hashKey, String value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    /**
     * 哈希，查询
     * @param key
     * @param hashKey
     * @return
     */
    public String getH (String key, String hashKey){
        return (String) redisTemplate.opsForHash().get(key,hashKey);
    }

    /**
     * 哈希，是否存在
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hasH(String key, String hashKey){
        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    public Long delH(String key, String hashKey) {
        return redisTemplate.opsForHash().delete(key, hashKey);
    }

    /**
     * 获取自增的值
     * @param key
     * @return
     */
    public long getIncrValue(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer=redisTemplate.getStringSerializer();
                byte[] rowkey=serializer.serialize(key);
                byte[] rowval=connection.get(rowkey);
                try {
                    String val=serializer.deserialize(rowval);
                    return Long.parseLong(val);
                } catch (Exception e) {
                    return 0L;
                }
            }
        });
    }
}
