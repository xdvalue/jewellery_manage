package com.els.jewellery.manage.modular.geminfo.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.data.IsEnable;
import com.els.jewellery.manage.common.exception.BizExceptionEnum;
import com.els.jewellery.manage.common.exception.BussinessException;
import com.els.jewellery.manage.common.util.IdGenerator;
import com.els.jewellery.manage.modular.geminfo.dao.GemMapper;
import com.els.jewellery.manage.modular.geminfo.entity.Gem;
import com.els.jewellery.manage.modular.geminfo.entity.GemHc;
import com.els.jewellery.manage.modular.geminfo.entity.Reportcode;
import com.els.jewellery.manage.modular.geminfo.service.GemHcService;
import com.els.jewellery.manage.modular.geminfo.service.GemService;
import com.els.jewellery.manage.modular.geminfo.service.ReportcodeService;
import com.els.jewellery.manage.modular.utils.QRCodeUtil;

/**
 * <p>
 * 宝石信息表 服务实现类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-07
 */
@Service
public class GemServiceImpl extends ServiceImpl<GemMapper, Gem> implements GemService {
	
	@Autowired
	private GemMapper gemMapper;
	@Autowired
	private ReportcodeService reportcodeService;
	@Autowired
	private GemHcService gemHcService;

	@Override
	public Integer addGemInfo(Gem gem) {
		if(StringUtils.isBlank(gem.getId())){
			String id = IdGenerator.createDateTimeAndRandomIdByPrefix(null,null, Constant.PREFIX_BATCH);
			EntityWrapper<Reportcode> wrapper = new EntityWrapper<>();
			wrapper.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
			wrapper.andNew("REPORT_CODE={0}", gem.getReportCode());
			Reportcode reportcodeEn= reportcodeService.selectOne(wrapper);
			EntityWrapper<GemHc> wrapper_hc = new EntityWrapper<>();
			wrapper_hc.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
			wrapper_hc.andNew("HC_KEY={0}", gem.getGemQuality());
			List<GemHc> hcList= gemHcService.selectList(wrapper_hc);
			if(hcList.size() < 1 ){
				throw new BussinessException(BizExceptionEnum.HC_IS_NOT_NULL);
			}
			gem.setGemQuality(hcList.get(0).getHcName());
			gem.setGemParamImg2(hcList.get(0).getHcImg());
			QRCodeUtil qrCodeUtil = new QRCodeUtil();
			String name = null;
			try {
				name = qrCodeUtil.qRCodeCommon("http://gdgem.com/search_gs.aspx?c=" + gem.getReportCode() + "&w=" + gem.getGemWeight(), "png", 10);
			} catch (IOException e) {
				throw new BussinessException(BizExceptionEnum.QRCODE_ERROR);
			}
			gem.setGemQrcode("http://39.108.169.195:10000/jeimg/qrcode/" + name);
			gem.setId(id);
			int record = gemMapper.insert(gem);
			reportcodeEn.setIsEnable(IsEnable.No.getId());
			reportcodeService.updateById(reportcodeEn);
			return record;
		}else{
			return gemMapper.updateById(gem);
		}
		
	}
	
}
