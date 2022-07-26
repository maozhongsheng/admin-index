package com.tianzhuo.ad.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TzAdminBidding implements Serializable {

    /**  日期*/
    private Date date;

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
    private BigDecimal clickCost;

    /**  点击成本*/
    private BigDecimal ckPrice;

    /**  广告位曝光率*/
    private BigDecimal adEx;

    /**  广告位填充率*/
    private BigDecimal fillOs;

    /**  点击量*/
    private BigDecimal ck;

    /**  eCpm*/
    private BigDecimal eCpm;

    /**  CPC*/
    private BigDecimal cpc;

    /**  小时*/
    private String date_hour;

    /**  ssp账户id*/
    private String adx_id;

    /**  代理商id（暂时不需要）*/
    private String publish_id;

    /**  媒体id （ssp媒体id）*/
    private String media_id;

    /**  媒体广告位id*/
    private String pos_id;

    /**  广告联盟id*/
    private String dsp_id;

    /**  dsp广告位id*/
    private String dsp_pos_id;

    /**  dsp联盟媒体id*/
    private String ad_id;

    /**  omeid*/
    private String oem_id;

    /**  token*/
    private String token;

    /**  媒体类型*/
    private String media_type;

    /**  结算类型*/
    private String settle_type;

    /**  平台类型*/
    private String platform;

    /**  系统类型*/
    private String system_type;

    /**  广告位类型*/
    private String slot_type;

    /**  广告位分类*/
    private String slot_tag;

    /**  媒体分类*/
    private String media_tag;

    /**  系统版本号*/
    private String version;

    /**  分发计划id*/
    private String plant_id;

    /**  消耗时长*/
    private Integer cost_time;

    /**  请求数*/
    private Integer req;

    /**  返回量*/
    private Integer fill;

    /**  请求dsp（并发请求）*/
    private Integer dsp_req;

    /**  dsp广告返回（被选中）*/
    private Integer dsp_fill;

    /**  竞价成功*/
    private Integer mon;

    /**  曝光数*/
    private Integer pv;

    /**  无效曝光*/
    private Integer ipv;

    /**  点击*/
    private Integer click;

    /**  无效点击*/
    private Integer iclick;

    /**  下载开始*/
    private Integer download_start;

    /**  下载结束*/
    private Integer download_end;

    /**  安装开始*/
    private Integer install_start;

    /**  安装结束*/
    private Integer install_end;

    /**  激活*/
    private Integer activation;

    /**  唤醒*/
    private Integer deeplink;

    /**  无效唤醒*/
    private Integer ideeplink;

    /**  消耗，单位分*/
    private Integer price;

    /**  视频播放开始*/
    private Integer video_start;

    /**  视频播放结束*/
    private Integer video_end;

    /**  曝光/UV*/
    private Integer pv_uv;

    /**  曝光/IP*/
    private Integer pv_ip;

    /**  点击/UV*/
    private Integer cl_uv;

    /**  点击/IP*/
    private Integer cl_ip;

    /**  联盟竞价，单位分*/
    private Integer adx_price;

    /**  媒体底价，单位分*/
    private Integer bid_floor;

    /**  媒体竞价，单位分*/
    private Integer bid_price;

    /**  日活*/
    private Integer dau;

    /**  需要代理商ID，dsp_advertiser_info中pid 上面那个dsp_agent_id不对*/
    private String agent_id;

    /**  交易ID，pd流量合同号*/
    private String deal_id;

    private static final long serialVersionUID = 1L;


}
