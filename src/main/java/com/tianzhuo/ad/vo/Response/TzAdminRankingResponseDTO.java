package com.tianzhuo.ad.vo.Response;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TzAdminRankingResponseDTO implements Serializable {

    /**  SSP名称*/
    private String sspName;

    /**  预估收入*/
    private BigDecimal num;

    /**  展示量*/
    private String pv;

    /**  点击量*/
    private String click;


}
