package com.spider.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spider.bean.MainWithBLOBs;

import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
/**
 * <p>
 * DataTablePageUtil
 * </p>
 *
 * @author msi-
 * @package: com.spider.utils
 * @description: DataTable插件格式通用返回实体类
 * @date: Created in 2020-09-27 15:17
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: msi-
 */
public class DataTablePageUtil<T> implements Serializable {

    private int nowPage;//当前页（当前页和页大小也传可不传，但下面4个必传！）
    private int pageSize;//页大小
    private int draw;//记录数
    private long recordsTotal;//总数量
    private long recordsFiltered;//总数据
    private List<T> data;//要展示的数据 bean

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Object parseDataTableValue(Integer draw, List<MainWithBLOBs> mainList, int total) {
        /**
         * 最重要的格式处理！
         * 工具类，处理成 datatable 规定的格式返回，才能正常显示！
         */
        DataTablePageUtil<MainWithBLOBs> pages = new DataTablePageUtil<>();
        pages.setRecordsTotal(total);
        pages.setRecordsFiltered(total);
        pages.setDraw(draw);
        pages.setData(mainList);

        /**
         * 集合对象转成json数据返回
         */
        ObjectMapper MAPPER = new ObjectMapper();

        String jsonString = null;
        try {
            jsonString = MAPPER.writeValueAsString(pages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JSONObject.stringToValue(jsonString.replaceAll("%(?![0-9a-fA-F]{2})", "%25"));
    }
}