package com.lz;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lz.entity.Cat;
import com.lz.entity.Dog;
import com.lz.entity.ListNode;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DailyTestSimpleApplication.class)
class DailyTestSimpleApplicationTests {

    @Autowired
    private JSONConfig jsonConfig;

    @Test
    void testForLoop() {
        ArrayList<Object> objects = Lists.newArrayList();
        for (Object object : objects) {
            Class<?> aClass = object.getClass();
        }
    }

    @Test
    void contextLoads() {
        //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date date = new Date();
        Dog dog = new Dog();
        dog.setName(null);
        dog.setBirthday(date);
        Cat cat = new Cat();
        cat.setDog(dog);
        cat.setName(null);
        System.out.println(JSONUtil.toJsonStr(JSONUtil.wrap(cat, jsonConfig)));
    }

    @Test
    void test002() {
        long hour = 19;
        System.out.println(hour / 24);
        System.out.println(hour % 24);
    }

    @Test
    void test003() {
        Dog dog = new Dog();
        String string = "{\"name\":\"\",\"birthday\":0}";
        Dog dog1 = JSON.parseObject(string, Dog.class);
        System.out.println(JSON.toJSONString(dog1));
    }

    @SneakyThrows
    @Test
    void test004() {
        Dog dog = new Dog();
        String string = "{\"name\":\"\",\"birthday\":0}";
        ObjectMapper mapper = new ObjectMapper();
        Dog dog1 = mapper.readValue(string, Dog.class);
        System.out.println(JSON.toJSONString(dog1));
    }


    /**
     * 两数相加
     * @param l1 链表节点1
     * @param l2 链表节点2
     * @return 链表节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //res存放结果，cur为res的尾指针
        ListNode res = new ListNode();
        ListNode cur = res;
        //表示进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            //如果其中有一个到达结尾了，那么这个链表这一位的的数字就为0。
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            //两个链表的两位相加
            int sum = a + b + carry;
            //大于10进位
            carry = sum / 10;
            //进位完剩下的余数
            sum %= 10;
            //创建一个节点接入res后面
            cur.next = new ListNode(sum);
            cur = cur.next;
            //分别后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //如果最后还有进位的话，增加一个节点
        if (carry == 1) cur.next = new ListNode(1);
        return res.next;
    }


    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null ) {
            int a = l1!=null?l1.val:0;
            int b = l2!=null?l2.val:0;
            int sum = carry + a + b;
            carry = sum/10;
            int val = sum%10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        if (carry ==1) cur.next = new ListNode(1);
        return res.next;
    }

    @Test
    public void testBuilderPlateCard() {
        String s = buildVclNsBySubVehiclePlates(Lists.newArrayList());
        System.out.println(s);
    }

    /**逗号拼接车牌*/
    private String buildVclNsBySubVehiclePlates(List<String> subVehiclePlates) {
        StringBuilder builder = new StringBuilder();
        for (String plate : subVehiclePlates) {
            builder.append(plate).append(CharUtil.COMMA);
        }
        return StrUtil.subPre(builder.toString(),-1);
    }

    /**
     * 测试二维数组
     */
    @Test
    public void testArray() {
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        int[] array3 = {5, 6};
        int[][] ints = {array1,array2,array3};
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

        System.out.println(ints[0][1]);
    }
}
