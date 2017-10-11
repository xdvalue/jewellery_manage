package com.els.jewellery.manage.modular.geminfo.service;

import com.els.jewellery.manage.modular.geminfo.entity.Batch;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 批次表 服务类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-08
 */
public interface BatchService extends IService<Batch> {
	
	Batch addBatch(Batch batch);
	
}
