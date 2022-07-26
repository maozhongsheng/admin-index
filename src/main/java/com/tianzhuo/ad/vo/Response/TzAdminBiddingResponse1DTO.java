package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class TzAdminBiddingResponse1DTO implements Serializable {

    //SSP平台折线图数据
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    /**  时间*/
    private Date date;

    /**  时间*/
    private String date_hour;

    /**  请求量*/
    private String reqList;

    /**  返回量*/
    private String fillList;

    /**  展示量*/
    private String pvList;

    /**  点击量*/
    private String clickList;


}
