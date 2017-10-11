package com.els.jewellery.manage.modular.geminfo.dao;

import com.els.jewellery.manage.modular.geminfo.entity.Reportcode;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-23
 */
public interface ReportcodeMapper extends BaseMapper<Reportcode> {
	
	String selectMaxNum();

}