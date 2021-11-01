package com.lz;

import com.alibaba.fastjson.JSON;
import com.lz.entity.Menu;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Java8-stream流返回权限数.
 * @author lihao
 * @date 2021-11-01 11:19
 */
@SpringBootTest
public class PermissionTreeTest {

    @Test
    public void testTree(){
        //模拟从数据库查询出来
        List<Menu> menus = Arrays.asList(
                new Menu(1,"根节点",0),
                new Menu(2,"子节点1",1),
                new Menu(3,"子节点1.1",2),
                new Menu(4,"子节点1.2",2),
                new Menu(5,"根节点1.3",2),
                new Menu(6,"根节点2",1),
                new Menu(7,"根节点2.1",6),
                new Menu(8,"根节点2.2",6),
                new Menu(9,"根节点2.2.1",7),
                new Menu(10,"根节点2.2.2",7),
                new Menu(11,"根节点3",1),
                new Menu(12,"根节点3.1",11)
        );
        //获取父节点
        List<Menu> collect = menus.stream()
                .filter(m -> m.getParentId() == 0)
                .peek( m -> m.setChildList(this.getChildren(m, menus)))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }

    /**
     * 递归查询子节点
     * @param root  根节点
     * @param all   所有节点
     * @return 根节点信息
     */
    private List<Menu> getChildren(Menu root, List<Menu> all) {
        return all.stream()
                .filter(m -> Objects.equals(m.getParentId(), root.getId()))
                .peek(m -> m.setChildList(this.getChildren(m, all)))
                .collect(Collectors.toList());
    }

}
