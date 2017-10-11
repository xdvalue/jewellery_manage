package com.els.jewellery.manage.modular.geminfo.service;

import com.els.jewellery.manage.modular.geminfo.entity.GemParmKey;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-25
 */
public interface GemParmKeyService extends IService<GemParmKey> {
	
	GemParmKey selectByKey(GemParmKey gemParmKey);
	
}
