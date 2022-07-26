package com.tianzhuo.ad.service.impl;

import com.github.pagehelper.PageHelper;
import com.tianzhuo.ad.client.AdminNameClient;
import com.tianzhuo.ad.client.SspSlotClient;
import com.tianzhuo.ad.mapper.TzAdminMapper;
import com.tianzhuo.ad.service.TzSlotDataService;
import com.tianzhuo.ad.utils.ExcelExport;
import com.tianzhuo.ad.utils.LarkPageInfoVo;
import com.tianzhuo.ad.vo.Request.AdminClientIndexDTO;
import com.tianzhuo.ad.vo.Request.TzSspRequestDTO;
import com.tianzhuo.ad.vo.Response.*;
import com.tianzhuo.ad.vo.TzAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TzSlotDataServiceImpl implements TzSlotDataService {

    @Autowired
    private TzAdminMapper tzAdminMapper;

    @Autowired
    public SspSlotClient sspSlotClient;

    @Autowired
    public AdminNameClient adminNameClient;


    //广告数据数据总览
    @Override
    public List<SlotIndexResponseDTO> slotIndexList(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList) {
        tzSspRequestDTO.setPos_id(posList);
        tzSspRequestDTO.setDsp_pos_id(adList);
        List<SlotIndexResponseDTO> list = new ArrayList<>();
        List<TzAdmin> data= null;
        try {
            data = tzAdminMapper.slotIndexList(tzSspRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TzAdmin tab : data){
            SlotIndexResponseDTO sir = new SlotIndexResponseDTO();
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            DecimalFormat dff = new DecimalFormat("#,###,##0");
            sir.setNum(tab.getNum());//预估收入
            sir.setCpm(tab.getCpm());//千次展示收入
            String clickTr = df.format(tab.getCkTr());
            sir.setClickTr(clickTr);//点击率
            String adEx = df.format(tab.getAdEx());
            sir.setAdEx(adEx);//广告位曝光率
            String fillOs = df.format(tab.getFillOs());
            sir.setFillOs(fillOs);//广告位填充率
            String req = dff.format(tab.getReqs());
            sir.setReq(req);//广告位请求量
            String fill = dff.format(tab.getFills());
            sir.setFill(fill);//广告位返回量
            String pv = dff.format(tab.getPvs());
            sir.setPv(pv);//曝光量
            String click = dff.format(tab.getCk());
            sir.setClick(click);//点击量
            list.add(sir);
        }
        return list;
    }



    //广告数据折线图
    @Override
    public List<LineDTO> slotIndexLine(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList) {
        tzSspRequestDTO.setPos_id(posList);
        tzSspRequestDTO.setDsp_pos_id(adList);
        List<LineDTO> list = new ArrayList<>();

        List<TzAdmin> cmp = null;
        try {
            cmp = tzAdminMapper.selectLineAll(tzSspRequestDTO);// drunk, fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (TzAdmin tzAdmin : cmp) {
            LineDTO tbr = new LineDTO();
            DecimalFormat df = new DecimalFormat("######0.00");
            DecimalFormat dff = new DecimalFormat("######0");
            tbr.setDate(tzAdmin.getDate());
            tbr.setDate_hour(tzAdmin.getDate_hour());//分时
            tbr.setNums(tzAdmin.getNum());//预估收入(总收入)
            tbr.setCpm(tzAdmin.getCpm());//千次展示收入
            String req = dff.format(tzAdmin.getReqs());
            tbr.setDownstream_req(req);//下游广告位请求量
            String fill = dff.format(tzAdmin.getFills());
            tbr.setDownstream_fill(fill);//下游广告位返回量
            //String dspReqs = dff.format(tzAdmin.getDspReqs());
            tbr.setDownstream_dsp_req("0");//下游广告请求量
            //String dspFills = dff.format(tzAdmin.getDspFills());
            tbr.setDownstream_dsp_fill("0");//下游广告返回量
            String pv = dff.format(tzAdmin.getPvs());
            tbr.setPv(pv);//曝光量
            String click = dff.format(tzAdmin.getCk());
            tbr.setClick(click);//点击量
            String fillOs = df.format(tzAdmin.getFillOs());
            tbr.setDownstream_fillOs(fillOs);//下游广告位填充率
            String adExs = df.format(tzAdmin.getAdEx());
            tbr.setDownstream_pv(adExs);//下游广告位曝光率
            String ckTr = df.format(tzAdmin.getCkTr());
            tbr.setCkTr(ckTr);//点击率
            tbr.setDownstream_dsp_fillOs("0");//下游广告填充率
            tbr.setDownstream_dsp_pv("0");//下游广告曝光率
            tbr.setUpper_reaches_ckPrice(tzAdmin.getCkPrice());//上游点击成本
            list.add(tbr);
        }
        return list;
    }


    //广告数据详情
    @Override
    public LarkPageInfoVo<TzDownLoadResponseDTO> tzAdminDataList(TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList) {
        tzSspRequestDTO.setPos_id(posList);
        tzSspRequestDTO.setDsp_pos_id(adList);
        List<TzDownLoadResponseDTO> list = new ArrayList<>();
        AdminClientIndexDTO adminClientIndexDTO = new AdminClientIndexDTO();
        Integer pageNum = (tzSspRequestDTO.getPageNum()-1) * tzSspRequestDTO.getPageSize();
        tzSspRequestDTO.setPageNum(pageNum);
        PageHelper.startPage(tzSspRequestDTO.getPageNum(),tzSspRequestDTO.getPageSize());
        List<TzAdmin> cmp = null;
        try {
            cmp = tzAdminMapper.tzAdminDataList(tzSspRequestDTO);// drunk, fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer count = null;
        if(tzSspRequestDTO.getHour_group() == null){
            count = tzAdminMapper.selectTzAdminDataListCount(tzSspRequestDTO);
        }else if(tzSspRequestDTO.getHour_group() == 1){
            count = tzAdminMapper.selectTzAdminDataListCountHour(tzSspRequestDTO);
        }
        for (TzAdmin tzAdmin : cmp) {
            TzDownLoadResponseDTO tbr = new TzDownLoadResponseDTO();
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            DecimalFormat dff = new DecimalFormat("#,###,##0");
            tbr.setDate(tzAdmin.getDate());
            tbr.setDate_hour(tzAdmin.getDate_hour());//分时

            //获取账户名称
            String sspId = tzAdmin.getPublish_id();
            adminClientIndexDTO.setSsp_id(sspId);
            String ssp_name = adminNameClient.adminSelectSspCompanyName(adminClientIndexDTO);
            tbr.setSspName(ssp_name);//账户名称

            //获取媒体名称
            String mId = tzAdmin.getMedia_id();
            adminClientIndexDTO.setMedia_id(mId);
            String media_name = adminNameClient.adminSelectMediaName(adminClientIndexDTO);
            tbr.setMediaName(media_name);//媒体

            //获取广告位名称
            String sId = tzAdmin.getPos_id();
            adminClientIndexDTO.setSlot_id(sId);
            String slot_name = adminNameClient.adminSelectSlotName(adminClientIndexDTO);
            tbr.setSlotName(slot_name);//广告位

            //获取广告位类型名称
            String stypeId = tzAdmin.getSlot_type();
            adminClientIndexDTO.setSlot_type(stypeId);
            String slot_type_name = adminNameClient.adminSelectSlotTypeName(adminClientIndexDTO);
            tbr.setSlotType(slot_type_name);//广告位类型

            //获取联盟名称
            String dspId = tzAdmin.getDsp_id();
            adminClientIndexDTO.setDsp_id(dspId);
            String dsp_name = adminNameClient.adminSelectUnionName(adminClientIndexDTO);
            tbr.setDspName(dsp_name);//联盟名称

            //获取联盟媒体名称
            String dspMediaId = tzAdmin.getDsp_media_id();
            adminClientIndexDTO.setDsp_media(dspMediaId);
            List<String> dsp_media = adminNameClient.adminSelectUnionMediaName(adminClientIndexDTO);
            for (int j = 0; j < dsp_media.size(); j++){
                tbr.setDspMedia(dsp_media.get(j));//联盟媒体
            }

            //获取联盟广告位名称
            String dspSlotId = tzAdmin.getDsp_pos_id();
            adminClientIndexDTO.setDsp_slot(dspSlotId);
            List<String> dsp_slot = adminNameClient.adminSelectUnionSlotName(adminClientIndexDTO);
            for (int j = 0; j < dsp_slot.size(); j++) {
                tbr.setDspSlot(dsp_slot.get(j));//联盟广告
            }

            tbr.setNums(tzAdmin.getNum());//预估收入(总收入)
            tbr.setCpm(tzAdmin.getCpm());//eCPM(元)
            String req = dff.format(tzAdmin.getReqs());
            tbr.setDownstream_req(req);//广告位请求量
            String fill = dff.format(tzAdmin.getFills());
            tbr.setDownstream_fill(fill);//广告位返回量
            String fillOs = df.format(tzAdmin.getFillOs());
            tbr.setDownstream_fillOs(fillOs);//广告位填充率
            String pv = dff.format(tzAdmin.getPvs());
            tbr.setPv(pv);//曝光量
            String adExs = df.format(tzAdmin.getAdEx());
            tbr.setDownstream_pv(adExs);//广告位曝光率
            String click = dff.format(tzAdmin.getCk());
            tbr.setClick(click);//点击量
            String ckTr = df.format(tzAdmin.getCkTr());
            tbr.setCkTr(ckTr);//点击率
            tbr.setDownstream_dspMedia_fillOs(fillOs);//媒体广告位填充率
            tbr.setDownstream_dsp_req("0");//媒体广告请求量
            tbr.setDownstream_dsp_fill("0");//媒体广告返回量
            tbr.setDownstream_dsp_fillOs("0");//媒体广告填充率
            tbr.setUpper_reaches_ckPrice(tzAdmin.getCkPrice());//媒体点击成本
            tbr.setDownload_start(tzAdmin.getDownload_start());//下载开始
            tbr.setDownload_end(tzAdmin.getDownload_end());//下载结束
            tbr.setDeeplink(tzAdmin.getDeeplink());//唤醒成功
            tbr.setIdeeplink(tzAdmin.getIdeeplink());//唤醒失败
            tbr.setInstall_start(tzAdmin.getInstall_start());//开始安装
            tbr.setInstall_end(tzAdmin.getInstall_end());//安装成功
            tbr.setActivation(tzAdmin.getActivation());//激活
            list.add(tbr);
        }
        return new PageImpl<TzDownLoadResponseDTO>().pageZset(list, (int) count, tzSspRequestDTO.getPageSize(), tzSspRequestDTO.getPageNum());
    }

    //广告数据下载
    @Override
    public void downLoad(HttpServletResponse response, TzSspRequestDTO tzSspRequestDTO, List<String> posList, List<String> adList) {
        tzSspRequestDTO.setPos_id(posList);
        tzSspRequestDTO.setDsp_pos_id(adList);
        List<TzDownLoadResponseDTO> list = new ArrayList<>();
        AdminClientIndexDTO adminClientIndexDTO = new AdminClientIndexDTO();
        List<TzAdmin> cmp = null;
        try {
            cmp = tzAdminMapper.tzAdminDownLoad(tzSspRequestDTO);// drunk, fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (TzAdmin tzAdmin : cmp) {
            TzDownLoadResponseDTO tbr = new TzDownLoadResponseDTO();
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            DecimalFormat dff = new DecimalFormat("#,###,##0");
            tbr.setDate(tzAdmin.getDate());
            tbr.setDate_hour(tzAdmin.getDate_hour());//分时

            //获取账户名称
            String sspId = tzAdmin.getPublish_id();
            adminClientIndexDTO.setSsp_id(sspId);
            String ssp_name = adminNameClient.adminSelectSspCompanyName(adminClientIndexDTO);
            tbr.setSspName(ssp_name);//账户名称

            tbr.setSspNameId(tzAdmin.getPublish_id());//账户id

            //获取媒体名称
            String mId = tzAdmin.getMedia_id();
            adminClientIndexDTO.setMedia_id(mId);
            String media_name = adminNameClient.adminSelectMediaName(adminClientIndexDTO);
            tbr.setMediaName(media_name);//媒体

            tbr.setMediaNameId(tzAdmin.getMedia_id());//媒体id

            //获取广告位类型名称
            String stypeId = tzAdmin.getSlot_type();
            adminClientIndexDTO.setSlot_type(stypeId);
            String slot_type_name = adminNameClient.adminSelectSlotTypeName(adminClientIndexDTO);
            tbr.setSlotType(slot_type_name);//广告位类型

            tbr.setSlotTypeId(tzAdmin.getSlot_type());//广告位类型id

            //获取广告位名称
            String sId = tzAdmin.getPos_id();
            adminClientIndexDTO.setSlot_id(sId);
            String slot_name = adminNameClient.adminSelectSlotName(adminClientIndexDTO);
            tbr.setSlotName(slot_name);//广告位

            tbr.setSlotId(tzAdmin.getPos_id());//广告位id

            //获取联盟名称
            String dspId = tzAdmin.getDsp_id();
            adminClientIndexDTO.setDsp_id(dspId);
            String dsp_name = adminNameClient.adminSelectUnionName(adminClientIndexDTO);
            tbr.setDspName(dsp_name);//联盟名称

            //获取联盟媒体名称
            String dspMediaId = tzAdmin.getDsp_media_id();
            adminClientIndexDTO.setDsp_media(dspMediaId);
            List<String> dsp_media = adminNameClient.adminSelectUnionMediaName(adminClientIndexDTO);
            for (int j = 0; j < dsp_media.size(); j++){
                tbr.setDspMedia(dsp_media.get(j));//联盟媒体
            }

            //获取联盟广告位名称
            String dspSlotId = tzAdmin.getDsp_pos_id();
            adminClientIndexDTO.setDsp_slot(dspSlotId);
            List<String> dsp_slot = adminNameClient.adminSelectUnionSlotName(adminClientIndexDTO);
            for (int j = 0; j < dsp_slot.size(); j++) {
                tbr.setDspSlot(dsp_slot.get(j));//联盟广告
            }

            tbr.setNums(tzAdmin.getNum());//预估收入(总收入)
            tbr.setCpm(tzAdmin.getCpm());//eCPM(元)
            String req = dff.format(tzAdmin.getReqs());
            tbr.setDownstream_req(req);//广告位请求量
            String fill = dff.format(tzAdmin.getFills());
            tbr.setDownstream_fill(fill);//广告位返回量
            String fillOs = df.format(tzAdmin.getFillOs());
            tbr.setDownstream_fillOs(fillOs);//广告位填充率
            String pv = dff.format(tzAdmin.getPvs());
            tbr.setPv(pv);//曝光量
            String adExs = df.format(tzAdmin.getAdEx());
            tbr.setDownstream_pv(adExs);//广告位曝光率
            String click = dff.format(tzAdmin.getCk());
            tbr.setClick(click);//点击量
            String ckTr = df.format(tzAdmin.getCkTr());
            tbr.setCkTr(ckTr);//点击率
            tbr.setDownstream_dspMedia_fillOs(fillOs);//媒体广告位填充率
            tbr.setDownstream_dsp_req("0");//媒体广告请求量
            tbr.setDownstream_dsp_fill("0");//媒体广告返回量
            tbr.setDownstream_dsp_fillOs("0");//媒体广告填充率
            tbr.setUpper_reaches_ckPrice(tzAdmin.getCkPrice());//媒体点击成本
            tbr.setDownload_start(tzAdmin.getDownload_start());//下载开始
            tbr.setDownload_end(tzAdmin.getDownload_end());//下载结束
            tbr.setDeeplink(tzAdmin.getDeeplink());//唤醒成功
            tbr.setIdeeplink(tzAdmin.getIdeeplink());//唤醒失败
            tbr.setInstall_start(tzAdmin.getInstall_start());//开始安装
            tbr.setInstall_end(tzAdmin.getInstall_end());//安装成功
            tbr.setActivation(tzAdmin.getActivation());//激活
            list.add(tbr);
        }

        //表头信息
        String [] arr  = new String[]{"日期","时间","公司简称","账户id","媒体","媒体id","广告位类型","广告位类型id","广告位名称","广告位ID","广告联盟","联盟媒体","联盟广告位","总收入(元)","eCPM(元)","请求量","返回量","广告填充率","展示量","广告曝光率","点击量","广告点击率","媒体广告位填充率","媒体广告请求量","媒体广告返回量","媒体广告填充率","媒体点击成本","下载开始","下载结束","唤醒成功","唤醒失败","开始安装","安装成功","激活"};

        ExcelExport.export(response,list,arr);

    }




}
