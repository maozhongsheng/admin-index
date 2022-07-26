package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



@Data
public class LineDTO implements Serializable {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    /**  小时*/
    private String date_hour;

    /**  预估收入*/
    private BigDecimal nums;

    /**  千次展示数据*/
    private BigDecimal cpm;

    /**  下游广告位请求量*/
    private String downstream_req;

    /**  下游广告位返回量*/
    private String downstream_fill;

    /**  下游广告请求量*/
    private String downstream_dsp_req;

    /**  下游广告返回量*/
    private String downstream_dsp_fill;

    /**  曝光量*/
    private String pv;

    /**  点击量*/
    private String click;

    /**  下游广告位填充率*/
    private String downstream_fillOs;

    /**  下游广告位曝光率*/
    private String downstream_pv;

    /**  点击率*/
    private String ckTr;

    /**  下游广告填充率*/
    private String downstream_dsp_fillOs;

    /**  下游广告曝光率*/
    private String downstream_dsp_pv;

    /**  上游点击成本*/
    private BigDecimal upper_reaches_ckPrice;

}
