package com.els.jewellery.manage.modular.geminfo.service;

import com.els.jewellery.manage.modular.geminfo.entity.Gem;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 宝石信息表 服务类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-07
 */
public interface GemService extends IService<Gem> {
	
	Integer addGemInfo(Gem gem);
	
}
