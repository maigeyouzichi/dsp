package com.lz;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

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
}
