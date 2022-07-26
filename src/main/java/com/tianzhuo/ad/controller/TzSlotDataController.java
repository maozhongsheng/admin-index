package com.tianzhuo.ad.controller;


import com.tianzhuo.ad.client.SspSlotClient;
import com.tianzhuo.ad.service.TzSlotDataService;
import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.vo.Request.AdminIndexSlotRequestDTO;
import com.tianzhuo.ad.vo.Request.AdminUnionSlotRequestDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
public class TzSlotDataController {

    @Autowired
    public TzSlotDataService tzSlotDataService;

    @Autowired
    public SspSlotClient sspSlotClient;



    @ApiOperation(value = "admin广告数据查询")
    @RequestMapping(value = "/api/adminSlotIndexList", method = RequestMethod.POST)
    public ResponseResult slotIndexList (@RequestBody TzSspRequestDTO tzSspRequestDTO) throws Exception {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(tzSspRequestDTO.getCompany_name_id());
        adminDTO.setSlot_type(tzSspRequestDTO.getSlot_type());
        adminDTO.setMedia_id(tzSspRequestDTO.getMedia_id());
        adminDTO.setSlot_id(tzSspRequestDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        AdminUnionSlotRequestDTO adminUnionSlotRequestDTO = new AdminUnionSlotRequestDTO();
        adminUnionSlotRequestDTO.setDsp_id(tzSspRequestDTO.getDsp_id());
        adminUnionSlotRequestDTO.setDsp_media(tzSspRequestDTO.getDsp_media());
        adminUnionSlotRequestDTO.setDsp_slot(tzSspRequestDTO.getDsp_slot());
        List<String> adList = sspSlotClient.adminUnionSlotId(adminUnionSlotRequestDTO);
        List<SlotIndexResponseDTO> slotIndexResponseDTO = tzSlotDataService.slotIndexList(tzSspRequestDTO,posList,adList);
        return new ResponseResult(slotIndexResponseDTO);

    }

    @ApiOperation(value = "admin广告数据数据趋势查询")
    @RequestMapping(value = "/api/adminSlotIndexLine", method = RequestMethod.POST)
    public ResponseResult slotIndexLine (@RequestBody TzSspRequestDTO tzSspRequestDTO) {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(tzSspRequestDTO.getCompany_name_id());
        adminDTO.setSlot_type(tzSspRequestDTO.getSlot_type());
        adminDTO.setMedia_id(tzSspRequestDTO.getMedia_id());
        adminDTO.setSlot_id(tzSspRequestDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        AdminUnionSlotRequestDTO adminUnionSlotRequestDTO = new AdminUnionSlotRequestDTO();
        adminUnionSlotRequestDTO.setDsp_id(tzSspRequestDTO.getDsp_id());
        adminUnionSlotRequestDTO.setDsp_media(tzSspRequestDTO.getDsp_media());
        adminUnionSlotRequestDTO.setDsp_slot(tzSspRequestDTO.getDsp_slot());
        List<String> adList = sspSlotClient.adminUnionSlotId(adminUnionSlotRequestDTO);
        List<LineDTO> tzAdBiddingResponseDTO = tzSlotDataService.slotIndexLine(tzSspRequestDTO,posList,adList);
        return new ResponseResult(tzAdBiddingResponseDTO);
    }


    @ApiOperation(value = "广告数据报表查询")
    @RequestMapping(value = "/api/adminReportDataList", method = RequestMethod.POST)
    public ResponseResult tzAdminDataList (@RequestBody TzSspRequestDTO tzSspRequestDTO) {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(tzSspRequestDTO.getCompany_name_id());
        adminDTO.setSlot_type(tzSspRequestDTO.getSlot_type());
        adminDTO.setMedia_id(tzSspRequestDTO.getMedia_id());
        adminDTO.setSlot_id(tzSspRequestDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        AdminUnionSlotRequestDTO adminUnionSlotRequestDTO = new AdminUnionSlotRequestDTO();
        adminUnionSlotRequestDTO.setDsp_id(tzSspRequestDTO.getDsp_id());
        adminUnionSlotRequestDTO.setDsp_media(tzSspRequestDTO.getDsp_media());
        adminUnionSlotRequestDTO.setDsp_slot(tzSspRequestDTO.getDsp_slot());
        List<String> adList = sspSlotClient.adminUnionSlotId(adminUnionSlotRequestDTO);
        LarkPageInfoVo<TzDownLoadResponseDTO> list = tzSlotDataService.tzAdminDataList(tzSspRequestDTO,posList,adList);
        return new ResponseResult(list);
    }



    @ApiOperation(value = "广告数据报表下载")
    @RequestMapping(value = "/api/adminDataDownLoad", method = RequestMethod.POST)
    public void downLoad (HttpServletResponse response, @RequestBody TzSspRequestDTO tzSspRequestDTO) {
        AdminIndexSlotRequestDTO adminDTO = new AdminIndexSlotRequestDTO();
        adminDTO.setCompany_name_id(tzSspRequestDTO.getCompany_name_id());
        adminDTO.setSlot_type(tzSspRequestDTO.getSlot_type());
        adminDTO.setMedia_id(tzSspRequestDTO.getMedia_id());
        adminDTO.setSlot_id(tzSspRequestDTO.getSlot_id());
        List<String> posList = sspSlotClient.adminIndexSlotId(adminDTO);
        AdminUnionSlotRequestDTO adminUnionSlotRequestDTO = new AdminUnionSlotRequestDTO();
        adminUnionSlotRequestDTO.setDsp_id(tzSspRequestDTO.getDsp_id());
        adminUnionSlotRequestDTO.setDsp_media(tzSspRequestDTO.getDsp_media());
        adminUnionSlotRequestDTO.setDsp_slot(tzSspRequestDTO.getDsp_slot());
        List<String> adList = sspSlotClient.adminUnionSlotId(adminUnionSlotRequestDTO);
            tzSlotDataService.downLoad(response,tzSspRequestDTO,posList,adList);

    }


}
