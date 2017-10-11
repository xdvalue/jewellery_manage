package com.els.jewellery.manage.modular.geminfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.util.IdGenerator;
import com.els.jewellery.manage.modular.geminfo.dao.BatchMapper;
import com.els.jewellery.manage.modular.geminfo.dao.ReportcodeMapper;
import com.els.jewellery.manage.modular.geminfo.entity.Batch;
import com.els.jewellery.manage.modular.geminfo.entity.Reportcode;
import com.els.jewellery.manage.modular.geminfo.service.BatchService;

/**
 * <p>
 * 批次表 服务实现类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-08
 */
@Service
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {

	@Autowired
	private BatchMapper batchMapper;
	@Autowired
	private ReportcodeMapper reportcodeMapper;
	
	@Override
	public Batch addBatch(Batch batch) {
		String maxNumber = batchMapper.selectMaxNum();
		if (maxNumber == null){
			maxNumber = "100000000";
		}
		String serialNumber = String.valueOf(Integer.parseInt(maxNumber.trim()) +1);
		String batchCode = Constant.PREFIX_BATCH + serialNumber.substring(1);
		String id = IdGenerator.createDateTimeAndRandomIdByPrefix(null,null, Constant.PREFIX_BATCH);
		int num = batch.getGemNum();
		batch.setId(id);
		batch.setBatchCode(batchCode);
		batch.setSerialNumber(serialNumber);
		batchMapper.insert(batch);
		for(int i = 0 ; i < num ; i++){
			String reMaxNumber = reportcodeMapper.selectMaxNum();
			if (reMaxNumber == null){
				reMaxNumber = "1000000000";
			}
			String reSerialNumber = String.valueOf(Integer.parseInt(reMaxNumber.trim()) +1);
			String reportCode = Constant.PREFIX_GEM + reSerialNumber.substring(1);
			String reid = IdGenerator.createDateTimeAndRandomIdByPrefix(null,null, Constant.PREFIX_REPORT);
			Reportcode reportCodeEn = new Reportcode();
			reportCodeEn.setId(reid);
			reportCodeEn.setBatchId(id);
			reportCodeEn.setReportCode(reportCode);
			reportCodeEn.setSerialNumber(reSerialNumber);
			reportcodeMapper.insert(reportCodeEn);
		}
		
		return batchMapper.selectById(id);
	}
	
}
