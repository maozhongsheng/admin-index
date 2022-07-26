package com.tianzhuo.ad.vo.Response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TzAdBiddingResponseDTO implements Serializable {


     @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
     @DateTimeFormat(pattern="yyyy-MM-dd")
     /**  时间*/
     private List<Date> date;

    /**  分时*/
    private List<String> date_hour;

     /**  预估收入*/
     private List<String> nums;

     /**  千次展示*/
     private List<String> cpm;

     /**  下游广告位请求量*/
     private List<String> downstream_req;

     /**  下游广告位返回量*/
     private List<String> downstream_fill;

     /**  下游广告请求量*/
     private List<String> downstream_dsp_req;

     /**  下游广告返回量*/
     private List<String> downstream_dsp_fill;

     /**  曝光量*/
     private List<String> pv;

     /**  点击量*/
     private List<String> click;

     /**  下游广告位填充率*/
     private List<String> downstream_fillOs;

     /**  下游广告位曝光率*/
     private List<String> downstream_pv;

     /**  点击率*/
     private List<String> ckTr;

     /**  下游广告填充率*/
     private List<String> downstream_dsp_fillOs;

     /**  下游广告曝光率*/
     private List<String> downstream_dsp_pv;

     /**  上游点击成本*/
     private List<String> upper_reaches_ckPrice;


}
