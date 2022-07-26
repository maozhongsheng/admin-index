package com.tianzhuo.ad.vo.Request;

import lombok.Data;

import java.io.Serializable;


@Data
public class AdSspClientDTO implements Serializable {

    /**  媒体id*/
    private String media_id;

    /**  广告位id*/
    private String slot_id;

    /**  广告位类型*/
    private String slot_type;
}
