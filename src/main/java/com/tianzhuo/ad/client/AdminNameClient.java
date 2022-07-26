package com.tianzhuo.ad.client;

import com.tianzhuo.ad.vo.Request.AdminClientIndexDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient( value = "ad-admin")
public interface AdminNameClient {

    @RequestMapping(value = "/ad-admin/api/adminSelectMediaName", method = RequestMethod.POST)
    String adminSelectMediaName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectSlotName", method = RequestMethod.POST)
    String adminSelectSlotName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectSspCompanyName", method = RequestMethod.POST)
    String adminSelectSspCompanyName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectSlotTypeName", method = RequestMethod.POST)
    String adminSelectSlotTypeName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectUnionName", method = RequestMethod.POST)
    String adminSelectUnionName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectUnionMediaName", method = RequestMethod.POST)
    List<String> adminSelectUnionMediaName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);

    @RequestMapping(value = "/ad-admin/api/adminSelectUnionSlotName", method = RequestMethod.POST)
    List<String> adminSelectUnionSlotName(@RequestBody AdminClientIndexDTO adminClientIndexDTO);


}
