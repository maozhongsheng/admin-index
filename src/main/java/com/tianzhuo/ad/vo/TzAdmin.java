package com.tianzhuo.ad.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TzAdmin implements Serializable {

    /**  预估收入*/
    private BigDecimal num;

    /**  千次展示收入*/
    private BigDecimal cpm;

    /**  广告位请求量*/
    private BigDecimal reqs;

    /**  广告位返回量*/
    private BigDecimal fills;

    /**  广告请求量*/
    private BigDecimal dspReqs;

    /**  广告返回量*/
    private BigDecimal dspFills;

    /**  曝光量*/
    private BigDecimal pvs;

    /**  点击率*/
    private BigDecimal ckTr;

    /**  点击成本*/
    private BigDecimal ckPrice;

    /**  广告位曝光率*/
    private BigDecimal adEx;

    /**  广告位填充率*/
    private BigDecimal fillOs;

    /**  点击量*/
    private BigDecimal ck;

    /**  日期*/
    private Date date;

    /**  小时*/
    private String date_hour;

    /**  代理商id*/
    private String publish_id;

    /**  媒体id （ssp媒体id）*/
    private String media_id;

    /**  广告位id*/
    private String pos_id;

    /**  广告位类型*/
    private String slot_type;

    /**  广告联盟id*/
    private String dsp_id;

    /**  dsp广告位id*/
    private String dsp_pos_id;

    /**  dsp联盟媒体id*/
    private String dsp_media_id;

    /**  展示消耗(单位:百万分之一元)*/
    private Integer pv_cost;

    /**  点击消耗(单位:百万分之一元)*/
    private Integer click_cost;

    /**  请求*/
    private Integer req;

    /**  填充*/
    private Integer fill;

    /**  曝光*/
    private Integer pv;

    /**  点击*/
    private Integer click;

    /**  开始下载*/
    private Integer download_start;

    /**  下载结束*/
    private Integer download_end;

    /**  安装开始*/
    private Integer install_start;

    /**  结束安装*/
    private Integer install_end;

    /**  激活*/
    private Integer activation;

    /**  唤醒*/
    private Integer deeplink;

    /**  无效唤醒*/
    private Integer ideeplink;

    /**  视频播放开始*/
    private Integer video_start;

    /**  视频播放结束*/
    private Integer video_end;
}
