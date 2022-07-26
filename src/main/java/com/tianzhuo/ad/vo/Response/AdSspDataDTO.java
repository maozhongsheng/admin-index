package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
public class AdSspDataDTO implements Serializable {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    /**  标题*/
    private String title;

    /**  落地页链接和尺寸*/
    private String images;

    /**  dsp来源名称*/
    private String dsp_name;

    /**  点击类型*/
    private String click_type;

    /**  富媒体*/
    private String desc;

    /**  媒体名称*/
    private String mediaName;

    /**  广告位名称*/
    private String slotName;

    /**  广告位类型*/
    private String slotType;

    /**  行业分类*/
    private String IndustryType;

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

    /**  唤醒成功*/
    private String awakenStart;

    /**  唤醒失败*/
    private String awakenEnd;

    /**  曝光*/
    private String pv;

    /**  点击*/
    private String click;







}
