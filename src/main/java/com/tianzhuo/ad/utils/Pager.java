package com.tianzhuo.ad.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Tiny
 */
@Getter
@Setter
@ToString
public class Pager<T> implements Serializable {

    private static final long serialVersionUID = -3691816780249039134L;

    /**
     * 起始位置
     */
    private Integer start;

    /**
     * 结束位置
     */
    private Integer end;

    /**
     * 当前页
     */
    private Integer page;

    /**
     * 每页条数
     */
    private Integer rows;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Integer totalRows;

    /**
     * 结果集
     */
    private List<T> list;

    /**
     * 聚合
     */
    private Object aggregations;

    public Pager() {
    }

    public Pager(Integer page, Integer rows, Integer totalRows) {
        // 计算总页数
        Integer totalPage = (int) Math.ceil(totalRows / (rows.doubleValue()));

        // 若总条数为0时,当前页为1
        // 若总条数不为0时,判断当前页是否大于总页数,若大于,当前页为最大页数
        if (totalPage == 0) {
            page = 1;
            this.start = 0;
            this.end = 0;
        } else {
            page = page > totalPage ? totalPage : page;
            this.start = (page - 1) * rows + 1;
            this.end = page * rows > totalRows ? totalRows : page * rows;
        }

        // 赋值
        this.page = page;
        this.rows = rows;
        this.totalPage = totalPage;
        this.totalRows = totalRows;
    }

    public Integer position() {
        return (this.page - 1) * rows;
    }

}
