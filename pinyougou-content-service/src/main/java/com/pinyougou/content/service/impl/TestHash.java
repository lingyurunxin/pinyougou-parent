package com.pinyougou.content.service.impl;

import com.pinyougou.pojo.TbContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     */
    @Test
    public void testSetValue() {
        redisTemplate.boundHashOps("namehash").put("a", "唐僧");
        redisTemplate.boundHashOps("namehash").put("b", "悟空");
        redisTemplate.boundHashOps("namehash").put("c", "八戒");
        redisTemplate.boundHashOps("namehash").put("d", "沙僧");

    }

    /**
     * 获取所有的key
     */
    @Test
    public void testGetKes() {
        Set keys = redisTemplate.boundHashOps("namehash").keys();
        System.out.println(keys);
    }

    /**
     * 获取所有的值
     */
    @Test
    public void testGetValues() {
        List list = redisTemplate.boundHashOps("namehash").values();
        System.out.println(list);
    }

    /**
     * 根据KEY取值
     */
    @Test
    public void searchValueByKey() {
        String str = (String) redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(str);
    }

    /**
     * 移除某个小key的值
     */
    @Test
    public void removeValue() {
        redisTemplate.boundHashOps("namehash").delete("c");
    }


    @Test
    public void check() {
        List<TbContent> list = (List<TbContent>) redisTemplate.boundHashOps("content").get(1);
        System.out.println(list);
    }

}
