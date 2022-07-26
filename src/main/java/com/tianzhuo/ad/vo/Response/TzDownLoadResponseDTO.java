package com.tianzhuo.ad.vo.Response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TzDownLoadResponseDTO implements Serializable {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    /**  小时*/
    private String date_hour;

    /**  SSP名称*/
    private String sspName;

    /**  SSPid*/
    private String sspNameId;

    /**  媒体名称*/
    private String mediaName;

    /**  媒体id*/
    private String mediaNameId;

    /**  广告位类型*/
    private String slotType;

    /**  广告位类型id*/
    private String slotTypeId;

    /**  广告位名称*/
    private String slotName;

    /**  广告位id*/
    private String slotId;

    /**  联盟*/
    private String dspName;

    /**  联盟媒体*/
    private String dspMedia;

    /**  联盟广告位*/
    private String dspSlot;

    /**  预估收入*/
    private BigDecimal nums;

    /**  千次展示数据*/
    private BigDecimal cpm;

    /**  广告位请求量*/
    private String downstream_req;

    /**  广告位返回量*/
    private String downstream_fill;

    /**  下游广告位填充率*/
    private String downstream_fillOs;

    /**  曝光量*/
    private String pv;

    /**  广告位曝光率*/
    private String downstream_pv;

    /**  点击量*/
    private String click;

    /**  点击率*/
    private String ckTr;

    /**   媒体广告位填充率*/
    private String downstream_dspMedia_fillOs;

    /**  媒体广告请求量*/
    private String downstream_dsp_req;

    /**  媒体广告返回量*/
    private String downstream_dsp_fill;

    /**  媒体广告填充率*/
    private String downstream_dsp_fillOs;

    /**  上游点击成本*/
    private BigDecimal upper_reaches_ckPrice;

    /**  下载开始*/
    private Integer download_start;

    /**  下载结束*/
    private Integer download_end;

    /**  唤醒成功*/
    private Integer deeplink;

    /**  唤醒失败*/
    private Integer ideeplink;

    /**  安装开始*/
    private Integer install_start;

    /**  结束安装*/
    private Integer install_end;

    /**  激活*/
    private Integer activation;


}
