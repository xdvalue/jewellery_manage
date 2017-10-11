package com.els.jewellery.manage.modular.geminfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.els.jewellery.manage.modular.geminfo.entity.Gem;

/**
 * <p>
  * 宝石信息表 Mapper 接口
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-07
 */
public interface GemMapper extends BaseMapper<Gem> {
	
	List<Gem> getGemList(@Param("page") Page<Gem> page, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("batchCode") String batchCode, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

	String selectMaxNum();
}