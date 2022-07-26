package com.tianzhuo.ad.vo.Response;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SlotIndexResponseDTO implements Serializable {

    /**  预估收入*/
    private BigDecimal num;

    /**  千次展示收入*/
    private BigDecimal cpm;

    /**  点击率*/
    private String clickTr;

    /**  广告位曝光率*/
    private String adEx;

    /**  广告位填充率*/
    private String fillOs;

    /**  广告位请求量*/
    private String req;

    /**  广告位返回量*/
    private String fill;

    /**  曝光量*/
    private String pv;

    /**  点击量*/
    private String click;


    private static final long serialVersionUID = 1L;
}
