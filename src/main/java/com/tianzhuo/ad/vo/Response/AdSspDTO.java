package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AdSspDTO implements Serializable {

    /**  消耗*/
    private String num;

    /**  曝光*/
    private String pv;

    /**  曝光/UV*/
    private String pvUv;

    /**  CPM*/
    private String cpm;

    /**  点击*/
    private String click;

    /**  点击率*/
    private String ckTr;

    /**  点击/UV*/
    private String clickUv;

    /**  CPC*/
    private String cpc;

}
