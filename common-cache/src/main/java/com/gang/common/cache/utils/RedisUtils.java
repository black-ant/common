//package com.gang.common.cache.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Classname RedisUtils
// * @Description TODO
// * @Date 2020/2/4 21:34
// * @Created by zengzg
// */
//@Component
//public class RedisUtils {
//
//
//
//    public RedisUtils() {
//        if (null == redisTemplate) {
//            this.redisTemplate = new RedisTemplate<>();
//        }
//    }
//
//    /**
//     * 指定缓存失效时间
//     *
//     * @param key
//     * @param time
//     * @return
//     */
//    public boolean expire(String key, Long time) {
//        try {
//            if (time > 0) {
//                redisTemplate.expire(key, time, TimeUnit.SECONDS);
//            }
//            return true;
//        } catch (Exception e1) {
//            e1.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 获取key的过期时间
//     *
//     * @param key
//     * @return
//     */
//    public long getExpire(String key) {
//        return redisTemplate.getExpire(key);
//    }
//
//    /**
//     * 判断key是否存在
//     *
//     * @param key
//     * @return
//     */
//    public boolean hashKey(String key) {
//        try {
//            return redisTemplate.hasKey(key);
//        } catch (Exception e2) {
//            e2.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 删除缓存
//     *
//     * @param key
//     */
//    public void del(String... key) {
//        if (key != null && key.length > 0) {
//            if (key.length == 1) {
//                redisTemplate.delete(key[0]);
//            } else {
//                redisTemplate.delete(CollectionUtils.arrayToList(key));
//            }
//        }
//    }
//    //=====================================String========================================
//
//    /**
//     * 普通缓存获取
//     *
//     * @param key
//     * @return
//     */
//    public Object get(String key) {
//
//    }
//
//    /**
//     * 普通放入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(String key, Object value) {
//
//    }
//
//    /**
//     * 普通放入缓存并设置时效
//     *
//     * @param key
//     * @param value
//     * @param time  time > 0 设置时效, time < 0 设置无限期
//     * @return
//     */
//    public boolean set(String key, Object value, long time) {
//        try {
//            if (time > 0) {
//                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
//            } else {
//                redisTemplate.opsForValue().set(key, value);
//            }
//            return true;
//        } catch (Exception e4) {
//            e4.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 递增
//     *
//     * @param key
//     * @param data
//     * @return
//     */
//    public long incr(String key, long data) {
//        if (data < 0) {
//            throw new RuntimeException("递增因子 不能小于0");
//        }
//        return redisTemplate.opsForValue().increment(key, data);
//    }
//
//    public long decr(String key, long data) {
//        if (data < 0) {
//            throw new RuntimeException("递减因子,不能小于0");
//        }
//        return redisTemplate.opsForValue().increment(key, -data);
//    }
//    //===================================Hash==================================
//
//    /**
//     * hashKey
//     *
//     * @param key
//     * @param keyItem
//     * @return
//     */
//    public Object getHash(String key, String keyItem) {
//        return redisTemplate.opsForHash().get(key, keyItem);
//    }
//
//    /**
//     * 获取hashkey所有的键值
//     *
//     * @param key
//     * @return
//     */
//    public Map<Object, Object> hmget(String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    /**
//     * hashSet
//     *
//     * @param key
//     * @param map
//     * @return
//     */
//    public boolean hsset(String key, Map<Object, Object> map) {
//        try {
//            redisTemplate.opsForHash().putAll(key, map);
//            return true;
//        } catch (Exception e4) {
//            e4.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * hashSet 设置时效
//     *
//     * @param key
//     * @param map
//     * @param time
//     * @return
//     */
//    public boolean hsset(String key, Map<Object, Object> map, Long time) {
//        try {
//            redisTemplate.opsForHash().putAll(key, map);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return true;
//        } catch (Exception e5) {
//            e5.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 向hash表中插入键值
//     *
//     * @param key
//     * @param itemKey
//     * @param value
//     * @return
//     */
//    public boolean hset(String key, String itemKey, Object value) {
//        try {
//            redisTemplate.opsForHash().put(key, itemKey, value);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 向hash表中插入键值,设置时效
//     *
//     * @param key
//     * @param itemKey
//     * @param value
//     * @param time
//     * @return
//     */
//    public boolean hset(String key, String itemKey, Object value, long time) {
//        try {
//            redisTemplate.opsForHash().put(key, itemKey, value);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 删除hash表中的项
//     *
//     * @param key  不能为null
//     * @param item 不能为null,可以是多个
//     */
//    public void hdel(String key, Object... item) {
//        redisTemplate.opsForHash().delete(key, item);
//    }
//
//    /**
//     * 判断hash表中有没有键,项
//     *
//     * @param key
//     * @param item
//     * @return
//     */
//    public boolean hHashKey(String key, Object item) {
//        return redisTemplate.opsForHash().hasKey(key, item);
//    }
//
//    /**
//     * 递增,值如果不存在就会创建一个,并把创建的值返回
//     *
//     * @param key
//     * @param item
//     * @param by
//     * @return
//     */
//    public double haIncr(String key, Object item, double by) {
//        if (by < 0) {
//            throw new RuntimeException("递增因子不能小于0");
//        }
//        return redisTemplate.opsForHash().increment(key, item, by);
//    }
//
//    /**
//     * 递减,值如果不存在就会创建一个,并把创建的值返回
//     *
//     * @param key
//     * @param item
//     * @param by
//     * @return
//     */
//    public double haDenr(String key, Object item, double by) {
//        return redisTemplate.opsForHash().increment(key, item, -by);
//    }
//    //===================================set============================================
//
//    /**
//     * 根据key获取set
//     *
//     * @param key
//     * @return
//     */
//    public Set<Object> sGet(String key) {
//        return redisTemplate.opsForSet().members(key);
//    }
//
//    /**
//     * 从一个set中查询value是否存在
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean sHashKey(String key, Object value) {
//        return redisTemplate.opsForSet().isMember(key, value);
//    }
//
//    /**
//     * 将set数据放入缓存
//     *
//     * @param key
//     * @param values
//     * @return 成功的个数
//     */
//    public long sSet(String key, Object... values) {
//        try {
//            return redisTemplate.opsForSet().add(key, values);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 将set数据放入缓存并给key设置时效
//     *
//     * @param key    键
//     * @param time   key 时效
//     * @param values 值,可以是多个
//     * @return 成功的个数
//     */
//    public long sSet(String key, Long time, Object... values) {
//        try {
//            Long count = redisTemplate.opsForSet().add(key, values);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return count;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 获取set缓存长度
//     *
//     * @param key
//     * @return
//     */
//    public long sSize(String key) {
//        try {
//            return redisTemplate.opsForSet().size(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 移除set缓存中的值
//     *
//     * @param key    键
//     * @param values 值可以是多个
//     * @return 移除的个数
//     */
//    public long sRemove(String key, Object... values) {
//        try {
//            return redisTemplate.opsForSet().remove(key, values);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//    //======================================list=========================
//
//    /**
//     * 获取list缓存中的值
//     *
//     * @param key   键
//     * @param start 开始
//     * @param end   结束  从0到-1显示所有的值
//     * @return
//     */
//    public List<Object> lGet(String key, long start, long end) {
//        try {
//            return redisTemplate.opsForList().range(key, start, end);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 获取list缓存长度
//     *
//     * @param key
//     * @return
//     */
//    public long lSize(String key) {
//        try {
//            return redisTemplate.opsForList().size(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 根据index获取list缓存的值
//     *
//     * @param key   键
//     * @param index -1代表表尾,-2代表倒数第二个元素 以此类推
//     * @return
//     */
//    public Object lIndex(String key, long index) {
//        try {
//            return redisTemplate.opsForList().index(key, index);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 把list放入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean lSet(String key, Object value) {
//        try {
//            redisTemplate.opsForList().leftPush(key, value);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 把list放入缓存,设置key的时效
//     *
//     * @param key
//     * @param time
//     * @param value
//     * @return
//     */
//    public boolean lSet(String key, long time, Object value) {
//        try {
//            redisTemplate.opsForList().leftPush(key, value);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 根据索引修改list缓存中具体值
//     *
//     * @param key
//     * @param index
//     * @param value
//     * @return
//     */
//    public boolean lUpdate(String key, Long index, Object value) {
//        try {
//            redisTemplate.opsForList().set(key, index, value);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 移除N个值为value
//     *
//     * @param key
//     * @param count
//     * @param value
//     * @return
//     */
//    public long lRomve(String key, Long count, Object value) {
//        try {
//            long remove = redisTemplate.opsForList().remove(key, count, value);
//            return remove;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//}
