package com.tianzhuo.ad.client;

import com.tianzhuo.ad.vo.Request.AdminIndexSlotRequestDTO;
import com.tianzhuo.ad.vo.Request.AdminUnionSlotRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient( value = "ad-admin")
public interface SspSlotClient {
    /*
     *  根据token查询出userid
     **/
    @RequestMapping(value = "/ad-admin/api/adminIndexSlotId",method = RequestMethod.POST)
    List<String> adminIndexSlotId(@RequestBody AdminIndexSlotRequestDTO adminIndexSlotRequestDTO);


    @RequestMapping(value = "/ad-admin/api/adminUnionSlotId", method = RequestMethod.POST)
    List<String> adminUnionSlotId(@RequestBody AdminUnionSlotRequestDTO adminUnionSlotRequestDTO);

}
