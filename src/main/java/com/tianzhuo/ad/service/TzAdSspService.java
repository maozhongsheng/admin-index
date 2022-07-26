package com.tianzhuo.ad.service;

import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.vo.Request.AdSspReqDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.AdSspDTO;
import com.tianzhuo.ad.vo.Response.AdSspDataDTO;

import java.util.List;

public interface TzAdSspService {
    List<AdSspDTO> adSspList(AdSspReqDTO adSspReqDTO, List<String> posList);


    LarkPageInfoVo<AdSspDataDTO> adSspDataList(AdSspReqDTO adSspReqDTO, List<String> posList);
}
