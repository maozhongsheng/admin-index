package com.tianzhuo.ad.service.impl;


import com.github.pagehelper.PageHelper;
import com.tianzhuo.ad.client.AdminNameClient;
import com.tianzhuo.ad.mapper.TzSspAdMapper;
import com.tianzhuo.ad.service.TzAdSspService;
import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.vo.Request.AdSspClientDTO;
import com.tianzhuo.ad.vo.Request.AdSspReqDTO;
import com.tianzhuo.ad.vo.Request.AdminClientIndexDTO;
import com.tianzhuo.ad.vo.Response.AdSspDTO;
import com.tianzhuo.ad.vo.Response.AdSspDataDTO;
import com.tianzhuo.ad.vo.Response.PageImpl;
import com.tianzhuo.ad.vo.Response.TzDownLoadResponseDTO;
import com.tianzhuo.ad.vo.TzSspAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TzAdSspServiceImpl implements TzAdSspService {

    @Autowired
    TzSspAdMapper tzSspAdMapper;

    @Autowired
    public AdminNameClient adminNameClient;

    @Override
    public List<AdSspDTO> adSspList(AdSspReqDTO adSspReqDTO, List<String> posList) {
        adSspReqDTO.setPos_id(posList);
        List<AdSspDTO> list = new ArrayList<>();
        List<TzSspAd> data = null;
        try {
            data = tzSspAdMapper.selectAdSspData(adSspReqDTO);// drunk, fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TzSspAd tzSspAd : data){
            AdSspDTO adSspDTO = new AdSspDTO();
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            DecimalFormat dff = new DecimalFormat("#,###,##0");

            String num = df.format(tzSspAd.getNum());
            adSspDTO.setNum(num);//消耗

            String pv = dff.format(tzSspAd.getPvs());
            adSspDTO.setPv(pv);//曝光

            String pvUv = df.format(tzSspAd.getPvsUv());
            adSspDTO.setPvUv(pvUv);//曝光UV

            String cpm = df.format(tzSspAd.getECpm());
            adSspDTO.setCpm(cpm);//CPM

            String click = dff.format(tzSspAd.getCk());
            adSspDTO.setClick(click);//总点击

            String ckTr = df.format(tzSspAd.getCkTr());
            adSspDTO.setCkTr(ckTr);//点击率

            String ckUV = df.format(tzSspAd.getCkUv());
            adSspDTO.setClickUv(ckUV);//点击UV

            String cpc = df.format(tzSspAd.getSumCpc());
            adSspDTO.setCpc(cpc);//CPC



            list.add(adSspDTO);
        }

        return list;
    }


    @Override
    public LarkPageInfoVo<AdSspDataDTO> adSspDataList(AdSspReqDTO adSspReqDTO, List<String> posList) {
        adSspReqDTO.setPos_id(posList);
        List<AdSspDataDTO> list = new ArrayList<>();
        AdminClientIndexDTO adSspClientDTO = new AdminClientIndexDTO();
        Integer pageNum = (adSspReqDTO.getPageNum()-1) * adSspReqDTO.getPageSize();
        adSspReqDTO.setPageNum(pageNum);
        PageHelper.startPage(adSspReqDTO.getPageNum(),adSspReqDTO.getPageSize());
        List<TzSspAd> data = null;
        try {
            data = tzSspAdMapper.selectAdSspDataList(adSspReqDTO);// drunk, fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer count = tzSspAdMapper.selectCount(adSspReqDTO);
        for(TzSspAd tzSspAd : data){
            AdSspDataDTO adSspDTO = new AdSspDataDTO();
            DecimalFormat dff = new DecimalFormat("#,###,##0");

            adSspDTO.setDate(tzSspAd.getDate());//时间
            adSspDTO.setTitle(tzSspAd.getTitle());//标题
            adSspDTO.setImages(tzSspAd.getImages());//落地页链接和尺寸
            adSspDTO.setDsp_name(tzSspAd.getDsp_name());//DSP来源
            adSspDTO.setClick_type(tzSspAd.getClick_type());//点击类型
            adSspDTO.setDesc(tzSspAd.getDesc());//素材内容

            //获取媒体名称
            String mId = tzSspAd.getMedia_id();
            adSspClientDTO.setMedia_id(mId);
            String media_name = adminNameClient.adminSelectMediaName(adSspClientDTO);
            adSspDTO.setMediaName(media_name);//媒体

            //获取广告位名称
            String sId = tzSspAd.getPos_id();
            adSspClientDTO.setSlot_id(sId);
            String slot_name = adminNameClient.adminSelectSlotName(adSspClientDTO);
            adSspDTO.setSlotName(slot_name);//广告位

            //获取广告位类型名称
            String stypeId = tzSspAd.getSlot_type();
            adSspClientDTO.setSlot_type(stypeId);
            String slot_type_name = adminNameClient.adminSelectSlotTypeName(adSspClientDTO);
            adSspDTO.setSlotType(slot_type_name);//广告位类型


//            adSspDTO.setMedia(tzSspAd.getMedia_id());//媒体
//            adSspDTO.setSlot_type(tzSspAd.getSlot_type());//广告位类型
//            adSspDTO.setSlot(tzSspAd.getPos_id());//广告位
            adSspDTO.setIndustryType("0");//行业分类
            adSspDTO.setDownload_start(tzSspAd.getDownload_start());//开始下载
            adSspDTO.setDownload_end(tzSspAd.getDownload_end());//结束下载
            adSspDTO.setInstall_start(tzSspAd.getInstall_start());//开始安装
            adSspDTO.setInstall_end(tzSspAd.getInstall_end());//结束安装
            adSspDTO.setActivation(tzSspAd.getActivation());//激活
            adSspDTO.setAwakenStart("0");//唤醒成功
            adSspDTO.setAwakenEnd("0");//唤醒失败
            String pv = dff.format(tzSspAd.getPvs());
            adSspDTO.setPv(pv);//曝光
            String click = dff.format(tzSspAd.getCk());
            adSspDTO.setClick(click);//点击
            list.add(adSspDTO);
        }

        return new PageImpl<AdSspDataDTO>().pageZset(list, (int) count, adSspReqDTO.getPageSize(), adSspReqDTO.getPageNum());

    }
}
