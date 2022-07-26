package com.tianzhuo.ad.vo.Request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminIndexSlotRequestDTO implements Serializable {

    /**  媒体id*/
    private List<String> media_id;

    /**  广告位id*/
    private List<String> slot_id;

    /**  广告类型id*/
    private List<String> slot_type;

    /**  公司名称*/
    private List<String> company_name_id;

}
