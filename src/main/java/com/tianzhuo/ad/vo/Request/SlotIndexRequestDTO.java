package com.tianzhuo.ad.vo.Request;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SlotIndexRequestDTO implements Serializable {

    /**  日期（天）*/
    private Integer day_group;

    /**  日期（小时）*/
    private Integer hour_group;
    /**  媒体*/
    private Integer media_group;
    /**  广告位类型*/
    private Integer slot_type_group;
    /**  广告位*/
    private Integer slot_group;


    /**  开始时间*/
    private Date dateStart;

    /**  结束时间*/
    private Date dateEnd;

    /**  广告位id*/
    private List<String> pos_id;

    /**  用户id*/
    private String user_id;

    /**  账户id*/
    private List<String> publish_id;

    /**  媒体id*/
    private List<String> medias_id;

    /**  媒体*/
    private List<String> media_id;

    /**  广告位类型*/
    private List<String> slot_type;

    /**  广告位*/
    private List<String> slot_id;

    /**  排序*/
    private String sort;

    /**  排序规则*/
    private String sort_rules;

    /**  类别0-总和 1-条件*/
    private String type;

    /**  页码*/
    private Integer pageNo = 1;

    /**  每页条数*/
    private Integer pageSize = 20;

    private static final long serialVersionUID = 1L;
}
