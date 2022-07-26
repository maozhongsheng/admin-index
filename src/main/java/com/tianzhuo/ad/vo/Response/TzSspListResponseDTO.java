package com.tianzhuo.ad.vo.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TzSspListResponseDTO implements Serializable {
    //数据中心SSP平台数据-数据趋势

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    /**  时间*/
    private List<Date> date;

    /**  预估收入*/
    private List<String> num;

    /**  千次展示收入*/
    private List<String> cpm;

    /**  请求量*/
    private List<String> reqList;

    /**  返回量*/
    private List<String> fillList;

    /**  展示量*/
    private List<String> pvList;

    /**  点击量*/
    private List<String> clickList;

    /**  广告曝光率*/
    private List<String> adEx;

    /**  广告填充率*/
    private List<String> fillOs;

    /**  广告点击率*/
    private List<String> clickTr;

    /**  广告点击成本*/
    private List<String> clickCost;






}
