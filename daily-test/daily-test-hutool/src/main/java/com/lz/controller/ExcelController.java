package com.lz.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import com.lz.entity.User;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lihao
 * @date 2021-11-04 12:48
 */
@RestController
@SuppressWarnings("all")
public class ExcelController {

    /**
     * 简单excel
     */
    @SneakyThrows
    @RequestMapping("/export1")
    public void export1(HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan0", "1231", new Date()));
        list.add(new User("zhangsan1", "1232", new Date()));
        list.add(new User("zhangsan2", "1233", new Date()));
        list.add(new User("zhangsan3", "1234", new Date()));
        list.add(new User("zhangsan4", "1235", new Date()));
        list.add(new User("zhangsan5", "1236", new Date()));
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getBigWriter();
        //自定义标题别名
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("birthday", "生日");
        writer.setOnlyAlias(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        SXSSFSheet sheet = (SXSSFSheet) writer.getSheet();
        //上面需要强转SXSSFSheet  不然没有trackAllColumnsForAutoSizing方法
        sheet.trackAllColumnsForAutoSizing();
        //列宽自适应
        writer.autoSizeColumnAll();
        //默认取第一行数据，解决中文自适应宽度不足问题
        if (sheet.getRow(1) != null) {
            int physicalNumberOfCells = sheet.getRow(1).getPhysicalNumberOfCells();
            for (int i = 0; i < physicalNumberOfCells; i++) {
                // 调整每一列宽度
                sheet.autoSizeColumn((short) i);
                // 解决自动设置列宽中文失效的问题
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
            }
        }
        //out为OutputStream，需要写出到的目标流
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        String fileName = "申请清单";
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF8") +
                ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭writer，释放内存
            writer.close();
            //此处记得关闭输出Servlet流
            IoUtil.close(out);
        }
    }


    @SneakyThrows
    @RequestMapping("/export2")
    public void export2(HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan0", "1231", new Date()));
        list.add(new User("zhangsan1", "1232", new Date()));
        list.add(new User("zhangsan2", "1233", new Date()));
        list.add(new User("zhangsan3", "1234", new Date()));
        list.add(new User("zhangsan4", "1235", new Date()));
        list.add(new User("zhangsan5", "1236", new Date()));
        ExcelWriter writer = ExcelUtil.getBigWriter();
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("birthday", "生日");
        writer.setOnlyAlias(true);
        // 设置样式
        StyleSet style = writer.getStyleSet();
        CellStyle headCellStyle = style.getHeadCellStyle();
        style.setBackgroundColor(IndexedColors.WHITE, true);
        writer.setStyleSet(style);
        String content = "监控台账";
        writer.merge(0, 0, 0, 8, content, true);
        writer.setRowHeight(0, 30);
        //头部必须合并单元格
        writer.merge(1, 1, 0, 8, "车队名:上海鸭嘴兽                                   日期:2021-01-01至2021-02-01       监控人: 李浩", true);
        writer.setRowHeight(1, 30);
        //数据从第几行开始写入
        writer.passRows(2);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        SXSSFSheet sheet = (SXSSFSheet) writer.getSheet();
        //上面需要强转SXSSFSheet  不然没有trackAllColumnsForAutoSizing方法
        sheet.trackAllColumnsForAutoSizing();
        //列宽自适应
        writer.autoSizeColumnAll();
        //默认取第一行数据，解决中文自适应宽度不足问题
        if (sheet.getRow(3) != null) {
            int physicalNumberOfCells = sheet.getRow(1).getPhysicalNumberOfCells();
            for (int i = 0; i < physicalNumberOfCells; i++) {
                // 调整每一列宽度
                sheet.autoSizeColumn((short) i);
                // 解决自动设置列宽中文失效的问题
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
            }
        }
        //out为OutputStream，需要写出到的目标流
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        String fileName = "申请清单";
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF8") +
                ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭writer，释放内存
            writer.close();
            //此处记得关闭输出Servlet流
            IoUtil.close(out);
        }
    }
}
