package com.tianzhuo.ad.vo.Response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class TzAdminBiddingResponseDTO implements Serializable {

    /**  SSP总消耗*/
    private BigDecimal sspNum;

    /**  请求量*/
    private String reqList;

    /**  返回量*/
    private String fillList;

    /**  广告位填充率*/
    private String fillOs;

    /**  曝光量*/
    private String pvList;

    /**  广告位曝光率*/
    private String adExs;

    /**  点击量*/
    private String clickList;

    /**  点击率*/
    private String clickTrs;


    /**  DSP总消耗*/
    private Integer dspNum;

}
