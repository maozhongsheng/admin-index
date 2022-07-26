package com.tianzhuo.ad.vo.Request;

import lombok.Data;

import java.util.Date;

@Data
public class AdminTimeDateReqDTO {

    /**  开始时间*/
    private Date dateStart;

    /**  结束时间*/
    private String pos_id;


}
