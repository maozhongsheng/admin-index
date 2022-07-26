package com.tianzhuo.ad.vo.Request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class AdSspReqDTO implements Serializable {

    /**  开始时间*/
    private Date dateStart;

    /**  结束时间*/
    private Date dateEnd;

    /**  开发者*/
    private List<String> company_name_id;

    /**  行业分类*/
    private List<String> industry;

    /**  平台类型*/
    private List<String> platform;

    /**  媒体id*/
    private List<String> media_id;

    /**  广告位类型*/
    private List<String> slot_type;

    /**  广告位*/
    private List<String> slot_id;

    /**  广告位id*/
    private List<String> pos_id;

    /**  媒体*/
    private Integer media_group;
    /**  广告位*/
    private Integer slot_group;
    /**  广告位类型*/
    private Integer slot_type_group;
    /**  分页*/
    private Integer group;


    /**  页码*/
    private Integer pageNum = 1;

    /**  每页条数*/
    private Integer pageSize = 10;
}
