package com.tianzhuo.ad.vo.Request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminUnionSlotRequestDTO implements Serializable {

    /**  联盟id*/
    private List<String> dsp_id;

    /**  联盟媒体id*/
    private List<String> dsp_media;

    /**  联盟广告位id*/
    private List<String> dsp_slot;
}
