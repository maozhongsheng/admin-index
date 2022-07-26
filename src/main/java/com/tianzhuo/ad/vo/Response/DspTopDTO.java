package com.tianzhuo.ad.vo.Response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class DspTopDTO implements Serializable {

    /**  DSP名称*/
    private String dspName;

    /**  预估收入*/
    private String num;

    /**  展示量*/
    private String pv;

    /**  点击量*/
    private String click;
}
