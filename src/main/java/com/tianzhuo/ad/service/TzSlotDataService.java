package com.tianzhuo.ad.service;

import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.utils.Pager;
import com.tianzhuo.ad.vo.Request.SlotIndexRequestDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.LineDTO;
import com.tianzhuo.ad.vo.Response.SlotIndexResponseDTO;
import com.tianzhuo.ad.vo.Response.TzAdBiddingResponseDTO;
import com.tianzhuo.ad.vo.Response.TzDownLoadResponseDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TzSlotDataService {
    List<SlotIndexResponseDTO> slotIndexList(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList);

    List<LineDTO> slotIndexLine(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList);

    void downLoad(HttpServletResponse response, TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList);

    LarkPageInfoVo<TzDownLoadResponseDTO> tzAdminDataList(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList);
}
