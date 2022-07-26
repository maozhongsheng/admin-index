package com.tianzhuo.ad.service;

import com.tianzhuo.ad.vo.Request.AdminTimeDateReqDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TzAdminBiddingService {
    List<TzAdminBiddingResponseDTO> selectAdminList();

    List<TzAdminBiddingResponse1DTO> selectDataList();

    List<TzAdminBiddingResponse2DTO> selectBigDecimalList();

    List<TzAdminRankingResponseDTO> selectTopList();

    List<DspTopDTO> selectDspTopList();

    List<AdminTimeDateDTO> adminTimeDate(AdminTimeDateReqDTO adminTimeDateDTO);
}
