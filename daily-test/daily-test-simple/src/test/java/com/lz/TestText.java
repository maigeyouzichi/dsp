package com.lz;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.lz.entity.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author lihao
 * @date 2021-11-23 11:42
 */
public class TestText {

    @Test
    void test001() {
        /*ArrayList<String> names = Lists.newArrayList("tangliming","guyuntao","puyanmin","wangyongjun","wanlijun",
                "yuzhujun","zhourenguo","huchao","luzhongwei","zhangwei",
                "chenli","qimengnan","wangjunru","wujiajun","yaojun",
                "zhengzhou","zhouxuan","hutianbao","shipengfei","siguoqiang",
                "zhangchengzhi","hujiahui","liangshichao","fuguangyong");*/
        ArrayList<String> names = Lists.newArrayList("limenglong", "wangzhenhua", "zhangxiaolin1");
        for (String name : names) {
            for (int i = 1; i < 14; i++) {
                String format = StrUtil.format("INSERT INTO yzs_driver_safety.user_comp_rel (id, create_by, " +
                                "create_time, updated_by, updated_time, deleted, user_id, company_id) VALUES (null, " +
                                "'admin', now(), null, null, false, '{}', {});"
                        , name, i);
                System.out.println(format);

            }
        }
    }

    @Test
    void test002() {
        /*ArrayList<String> names = Lists.newArrayList("tangliming","guyuntao","puyanmin","wangyongjun","wanlijun",
                "yuzhujun","zhourenguo","huchao","luzhongwei","zhangwei",
                "chenli","qimengnan","wangjunru","wujiajun","yaojun",
                "zhengzhou","zhouxuan","hutianbao","shipengfei","siguoqiang",
                "zhangchengzhi","hujiahui","liangshichao","fuguangyong");*/
        ArrayList<String> names = Lists.newArrayList("limenglong", "wangzhenhua", "zhangxiaolin1");

        for (String name : names) {
            int roleId;
            if (Objects.equals(name,"tangliming") || Objects.equals(name,"guyuntao") ||Objects.equals(name,"wanlijun")){
                roleId = 1;
            }else {
                roleId = 2;
            }
            String format = StrUtil.format("INSERT INTO yzs_driver_safety.user_role_rel (id, create_by, create_time, updated_by, updated_time, deleted, user_id, role_id) VALUES (null, 'admin', now(), null, null, false, '{}', {});",name,roleId);
            System.out.println(format);
        }
    }

    public int maxChunksToSorted(int[] arr) {
        int currIndex = 0;
        int count = 0;
        int[] target = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            target[arr[i]] = i;
        }
        while(currIndex<arr.length) {
            currIndex = nextIndex(arr,target,currIndex)+1;
            count++;
        }
        return count;
    }

    private int nextIndex(int[] arr, int[] target, int currIndex) {
        int nextIndex = Math.max(target[arr[currIndex]],target[currIndex]);
        for(int i=currIndex;i<=nextIndex;i++) {
            int tmpIndex = Math.max(target[arr[i]],target[i]);
            nextIndex = Math.max(nextIndex,tmpIndex);
        }
        return nextIndex;
    }

    public ListNode sortList(ListNode head) {
        List<ListNode> container = new ArrayList<>();
        while(head != null) {
            container.add(head);
            head = head.next;
        }
        ListNode rns = new ListNode();
        ListNode curr = rns;
        List<ListNode> newList = container.stream().sorted(Comparator.comparingInt(o -> o.val)).collect(Collectors.toList());
        for (ListNode node : newList) {
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;
        return rns.next;
    }


    public int countStudents(int[] students, int[] sandwiches) {
        //不同口味的学生的数量
        int stuNum_0 = 0, stuNum_1 = 0;
        for(int taste: students) {
            if(taste == 1) {
                stuNum_1++;
            }else {
                stuNum_0++;
            }
        }
        for(int taste: sandwiches) {
            if(taste == 0 && stuNum_0 == 0) return stuNum_1;
            if(taste == 1 && stuNum_1 == 0) return stuNum_0;
            if(taste == 0) stuNum_0--;
            if(taste == 1) stuNum_1--;
        }
        return 0;
    }
}
