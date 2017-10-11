package com.els.jewellery.manage.modular.geminfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.els.jewellery.manage.modular.geminfo.entity.Batch;

/**
 * <p>
  * 批次表 Mapper 接口
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-08
 */
public interface BatchMapper extends BaseMapper<Batch> {
	
	String selectMaxNum();

	List<Batch> getBatchList(@Param("page") Page<Batch> page, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("batchCode") String batchCode, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);
}