package com.tianzhuo.ad.mapper;


import com.tianzhuo.ad.vo.Request.AdSspReqDTO;
import com.tianzhuo.ad.vo.TzSspAd;

import java.util.List;

public interface TzSspAdMapper {


    List<TzSspAd> selectAdSspData(AdSspReqDTO adSspReqDTO);

    List<TzSspAd> selectAdSspDataList(AdSspReqDTO adSspReqDTO);

    Integer selectCount(AdSspReqDTO adSspReqDTO);
}
