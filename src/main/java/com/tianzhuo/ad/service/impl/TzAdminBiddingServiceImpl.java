package com.tianzhuo.ad.service.impl;


import com.tianzhuo.ad.client.AdminNameClient;
import com.tianzhuo.ad.mapper.TzAdminMapper;
import com.tianzhuo.ad.service.TzAdminBiddingService;
import com.tianzhuo.ad.vo.Request.AdminClientIndexDTO;
import com.tianzhuo.ad.vo.Request.AdminTimeDateReqDTO;
import com.tianzhuo.ad.vo.Response.*;
import com.tianzhuo.ad.vo.TzAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class TzAdminBiddingServiceImpl implements TzAdminBiddingService {

    @Autowired
    private TzAdminMapper tzAdminMapper;

    @Autowired
    AdminNameClient adminNameClient;


    //admin首页数据查询
    @Override
    public List<TzAdminBiddingResponseDTO> selectAdminList() {

        List<TzAdminBiddingResponseDTO> list = new ArrayList<>();
        List<TzAdmin> data = null;
        try {
            data = tzAdminMapper.selectConsumption();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (TzAdmin tzAdmin : data){
            TzAdminBiddingResponseDTO tabr = new TzAdminBiddingResponseDTO();
            DecimalFormat df = new DecimalFormat("######0.00");
            DecimalFormat dff = new DecimalFormat("######0");

            tabr.setSspNum(tzAdmin.getNum());//SSP总消耗

            tabr.setDspNum(0);//DSP总消耗

            String req = dff.format(tzAdmin.getReqs());
            tabr.setReqList(req);//广告请求量

            String fill = dff.format(tzAdmin.getFills());
            tabr.setFillList(fill);//广告返回量

            String fillOs = df.format(tzAdmin.getFillOs());
            tabr.setFillOs(fillOs);//广告填充率

            String pv = dff.format(tzAdmin.getPvs());
            tabr.setPvList(pv);//曝光量

            String adex = df.format(tzAdmin.getAdEx());
            tabr.setAdExs(adex);//广告曝光率

            String click = dff.format(tzAdmin.getCk());
            tabr.setClickList(click);//点击量

            String ckTr = df.format(tzAdmin.getCkTr());
            tabr.setClickTrs(ckTr);//点击率

            list.add(tabr);
        }
        return list;
    }


    //SSP折线图
    @Override
    public List<TzAdminBiddingResponse1DTO> selectDataList() {
        List<TzAdminBiddingResponse1DTO> list = new ArrayList<>();
        List<TzAdmin> data= null;
        try {
            data = tzAdminMapper.selectDataLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TzAdmin tab : data) {
            TzAdminBiddingResponse1DTO dto = new TzAdminBiddingResponse1DTO();
            DecimalFormat dff = new DecimalFormat("######0");

            dto.setDate(tab.getDate());

            dto.setDate_hour(tab.getDate_hour());

            String req = dff.format(tab.getReqs());
            dto.setReqList(req);//广告请求量

            String fill = dff.format(tab.getFills());
            dto.setFillList(fill);//广告返回量

            String pv = dff.format(tab.getPvs());
            dto.setPvList(pv);//曝光量

            String click = dff.format(tab.getCk());
            dto.setClickList(click);//点击量

            list.add(dto);
        }
        return list;
    }

    @Override
    public List<TzAdminBiddingResponse2DTO> selectBigDecimalList() {
        List<TzAdminBiddingResponse2DTO> list = new ArrayList<>();
        List<TzAdmin> data= null;
        try {
            data = tzAdminMapper.selectDataLineNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TzAdmin tab : data) {
            TzAdminBiddingResponse2DTO dto = new TzAdminBiddingResponse2DTO();
            dto.setDate(tab.getDate());

            dto.setDate_hour(tab.getDate_hour());

            dto.setECpmList(tab.getCpm());//eCPM

            dto.setCpcList(tab.getCkPrice());//cpc

            dto.setSspNumList(tab.getNum());//SSP收入

            list.add(dto);
        }
        return list;
    }


    //首页Top
    @Override
    public List<TzAdminRankingResponseDTO> selectTopList() {
        List<TzAdminRankingResponseDTO> list = new ArrayList<>();
        AdminClientIndexDTO adminClientIndexDTO = new AdminClientIndexDTO();
        List<TzAdmin> data= null;
        try {
            data = tzAdminMapper.selectTopList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TzAdmin tab : data) {
            TzAdminRankingResponseDTO dto = new TzAdminRankingResponseDTO();
            DecimalFormat dff = new DecimalFormat("######0");

            //获取账户名称
            String sspId = tab.getPublish_id();
            adminClientIndexDTO.setSsp_id(sspId);
            String ssp_name = adminNameClient.adminSelectSspCompanyName(adminClientIndexDTO);
            dto.setSspName(ssp_name);//账户名称

            dto.setNum(tab.getNum());//预估收入

            String pv = dff.format(tab.getPvs());
            dto.setPv(pv);//曝光量

            String click = dff.format(tab.getCk());
            dto.setClick(click);//点击量

            list.add(dto);
        }

        return list;
    }

    @Override
    public List<DspTopDTO> selectDspTopList() {
        List<DspTopDTO> list = new ArrayList<>();
//        List<TzAdminBidding> data= null;
//        try {
//            data = tzAdminBiddingMapper.selectDspTopList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for(TzAdminBidding tab : data) {
            DspTopDTO dto = new DspTopDTO();
            //DecimalFormat dff = new DecimalFormat("######0");

            dto.setDspName("0");//账户名称

            dto.setNum("0");//预估收入

            //String pv = dff.format(tab.getPvs());
            dto.setPv("0");//曝光量

            //String click = dff.format(tab.getCk());
            dto.setClick("0");//点击量

            list.add(dto);
        //}

        return list;
    }

    @Override
    public List<AdminTimeDateDTO> adminTimeDate(AdminTimeDateReqDTO adminTimeDateDTO) {
        List<AdminTimeDateDTO> adminTimeDate = tzAdminMapper.adminTimeDate(adminTimeDateDTO);
        return adminTimeDate;
    }


}