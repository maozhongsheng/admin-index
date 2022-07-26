package com.tianzhuo.ad.controller;


import com.tianzhuo.ad.client.SspSlotClient;
import com.tianzhuo.ad.service.TzAdSspService;
import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.vo.Request.AdSspReqDTO;
import com.tianzhuo.ad.vo.Request.AdminIndexSlotRequestDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.AdSspDTO;
import com.tianzhuo.ad.vo.Response.AdSspDataDTO;
import com.tianzhuo.ad.vo.Response.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
public class TzAdSspController {

    @Autowired
    private TzAdSspService tzAdSspService;

    @Autowired
    public SspSlotClient sspSlotClient;


    @ApiOperation(value = "AdSsp数据")
    @RequestMapping(value = "/api/adSspList", method = RequestMethod.POST)
    public ResponseResult adSspList (@RequestBody AdSspReqDTO adSspReqDTO) {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(adSspReqDTO.getCompany_name_id());
        adminDTO.setSlot_type(adSspReqDTO.getSlot_type());
        adminDTO.setMedia_id(adSspReqDTO.getMedia_id());
        adminDTO.setSlot_id(adSspReqDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        List<AdSspDTO> adSspDTOS = tzAdSspService.adSspList(adSspReqDTO,posList);
        return new ResponseResult(adSspDTOS);
    }


    @ApiOperation(value = "AdSsp数据")
    @RequestMapping(value = "/api/adSspDataList", method = RequestMethod.POST)
    public ResponseResult adSspDataList (@RequestBody AdSspReqDTO adSspReqDTO) {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(adSspReqDTO.getCompany_name_id());
        adminDTO.setSlot_type(adSspReqDTO.getSlot_type());
        adminDTO.setMedia_id(adSspReqDTO.getMedia_id());
        adminDTO.setSlot_id(adSspReqDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        LarkPageInfoVo<AdSspDataDTO> adSspDataList = tzAdSspService.adSspDataList(adSspReqDTO,posList);
        return new ResponseResult(adSspDataList);
    }
}
