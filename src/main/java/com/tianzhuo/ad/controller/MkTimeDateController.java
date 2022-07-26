package com.tianzhuo.ad.controller;

import com.tianzhuo.ad.service.TzAdminBiddingService;

import com.tianzhuo.ad.vo.Response.AdminTimeDateDTO;
import com.tianzhuo.ad.vo.Request.AdminTimeDateReqDTO;
import com.tianzhuo.ad.vo.Response.ResponseResult;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
public class MkTimeDateController {

    @Autowired
    public TzAdminBiddingService tzAdminBiddingService;

    //首页
    @ApiOperation(value = "admin查看时长")
    @RequestMapping(value = "/api/adminTimeDate", method = RequestMethod.POST)
    public ResponseResult adminTimeDate (@RequestBody AdminTimeDateReqDTO adminTimeDateDTO) throws Exception {
        List<AdminTimeDateDTO> adminTimeDate = tzAdminBiddingService.adminTimeDate(adminTimeDateDTO);
        return new ResponseResult(adminTimeDate);
    }

}
