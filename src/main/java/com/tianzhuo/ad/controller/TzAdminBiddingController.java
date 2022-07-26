package com.tianzhuo.ad.controller;


import com.tianzhuo.ad.client.SspSlotClient;
import com.tianzhuo.ad.service.TzAdminBiddingService;
import com.tianzhuo.ad.vo.Request.AdminIndexSlotRequestDTO;
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
public class TzAdminBiddingController {

    @Autowired
    public TzAdminBiddingService tzAdminBiddingService;

    @Autowired
    public SspSlotClient sspSlotClient;


    //首页
    @ApiOperation(value = "admin首页查询")
    @RequestMapping(value = "/api/indexAdminList", method = RequestMethod.POST)
    public ResponseResult selectAdminList () throws Exception {
        List<TzAdminBiddingResponseDTO> tzAdminBiddingResponseDTO = tzAdminBiddingService.selectAdminList();
        return new ResponseResult(tzAdminBiddingResponseDTO);
    }


    @ApiOperation(value = "adminSSP折线图1")
    @RequestMapping(value = "/api/indexDataList", method = RequestMethod.POST)
    public ResponseResult selectDataList () throws Exception {
        List<TzAdminBiddingResponse1DTO> tzAdminBiddingResponse1DTO = tzAdminBiddingService.selectDataList();
        return new ResponseResult(tzAdminBiddingResponse1DTO);
    }


    @ApiOperation(value = "adminSSP折线图2")
    @RequestMapping(value = "/api/indexBigDecimalList", method = RequestMethod.POST)
    public ResponseResult selectBigDecimalList () throws Exception {
        List<TzAdminBiddingResponse2DTO> tzAdminBiddingResponse2DTO = tzAdminBiddingService.selectBigDecimalList();
        return new ResponseResult(tzAdminBiddingResponse2DTO);
    }


    @ApiOperation(value = "首页SSPTOP")
    @RequestMapping(value = "/api/adminIndexTop", method = RequestMethod.POST)
    public ResponseResult selectTopList () throws Exception {
        List<TzAdminRankingResponseDTO> list = tzAdminBiddingService.selectTopList();
        return new ResponseResult(list);
    }


    @ApiOperation(value = "首页DSPTOP")
    @RequestMapping(value = "/api/adminIndexDspTop", method = RequestMethod.POST)
    public ResponseResult selectDspTopList () throws Exception {
        List<DspTopDTO> list = tzAdminBiddingService.selectDspTopList();
        return new ResponseResult(list);
    }



}
