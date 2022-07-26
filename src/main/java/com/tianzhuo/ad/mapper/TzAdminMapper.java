package com.tianzhuo.ad.mapper;


import com.tianzhuo.ad.vo.Request.AdminTimeDateReqDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.AdminTimeDateDTO;
import com.tianzhuo.ad.vo.TzAdmin;
import com.tianzhuo.ad.vo.TzAdminBidding;

import java.util.List;

public interface TzAdminMapper {

    List<TzAdmin> tzAdminDataList(TzSspRequestDTO tzSspRequestDTO);

    Integer selectTzAdminDataListCount(TzSspRequestDTO tzSspRequestDTO);

    Integer selectTzAdminDataListCountHour(TzSspRequestDTO tzSspRequestDTO);

    List<TzAdmin> slotIndexList(TzSspRequestDTO tzSspRequestDTO);

    List<TzAdmin> selectLineAll(TzSspRequestDTO tzSspRequestDTO);

    List<TzAdmin> tzAdminDownLoad(TzSspRequestDTO tzSspRequestDTO);

    List<TzAdmin> selectConsumption();

    List<TzAdmin> selectDataLine();

    List<TzAdmin> selectDataLineNum();

    List<TzAdmin> selectTopList();

    List<AdminTimeDateDTO> adminTimeDate(AdminTimeDateReqDTO adminTimeDateDTO);
}
