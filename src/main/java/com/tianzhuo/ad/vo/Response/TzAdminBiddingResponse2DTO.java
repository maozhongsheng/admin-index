package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TzAdminBiddingResponse2DTO implements Serializable {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    /**  时间*/
    private Date date;

    /**  时间*/
    private String date_hour;

    //SSP平台折线图数据
    /**  eCpm(元)*/
    private BigDecimal eCpmList;

    /**  CPC(元)*/
    private BigDecimal cpcList;

    /**  SSP总消耗*/
    private BigDecimal sspNumList;
}
