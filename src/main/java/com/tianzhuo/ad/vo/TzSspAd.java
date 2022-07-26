package com.tianzhuo.ad.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TzSspAd implements Serializable {

    /**  消耗*/
    private BigDecimal num;

    /**  曝光量*/
    private BigDecimal pvs;

    /**  曝光量*/
    private BigDecimal pvsUv;

    /**  eCpm*/
    private BigDecimal eCpm;

    /**  点击量*/
    private BigDecimal ck;

    /**  点击率*/
    private BigDecimal ckTr;

    /**  点击量*/
    private BigDecimal ckUv;

    /**  CPC*/
    private BigDecimal sumCpc;



    /**  日期*/
    private Date date;

    /**  开发者*/
    private String publish_id;

    /**  媒体*/
    private String media_id;

    /**  平台类型*/
    private String platform;

    /**  广告位类型*/
    private String slot_type;

    /**  广告位*/
    private String pos_id;

    /**  广告联盟*/
    private String dsp_id;

    /**  联盟广告位*/
    private String dsp_pos_id;

    /**  分发计划*/
    private String plant_id;

    /**  广告id*/
    private String ad_id;

    /**  标题*/
    private String title;

    /**  描述*/
    private String desc;

    /**  dsp来源名称*/
    private String dsp_name;

    /**  点击类型*/
    private String click_type;

    /**  素材个数*/
    private String bid_count;

    /**  素材*/
    private String images;

    /**  包名*/
    private String bundle;

    /**  请求数*/
    private Integer request_cn;

    /**  曝光*/
    private Integer pv;

    /**  曝光IP数*/
    private Integer pv_ip_cn;

    /**  曝光UV*/
    private String pv_uv;

    /**  千次展示成本*/
    private Float cpm;

    /**  点击*/
    private Integer click;

    /**  点击IP数*/
    private Integer cl_ip_cn;

    /**  点击UV*/
    private String cl_uv;

    /**  点击成本*/
    private Float cpc;

    /**  开始下载*/
    private Integer download_start;

    /**  结束下载*/
    private Integer download_end;

    /**  开始安装*/
    private Integer install_start;

    /**  结束安装*/
    private Integer install_end;

    /**  激活*/
    private Integer activation;

    private static final long serialVersionUID = 1L;


}
