package com.els.jewellery.manage.modular.geminfo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.data.IsEnable;
import com.els.jewellery.manage.common.exception.BizExceptionEnum;
import com.els.jewellery.manage.common.exception.BussinessException;
import com.els.jewellery.manage.modular.geminfo.dao.GemParmKeyMapper;
import com.els.jewellery.manage.modular.geminfo.entity.GemParmKey;
import com.els.jewellery.manage.modular.geminfo.service.GemParmKeyService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-25
 */
@Service
public class GemParmKeyServiceImpl extends ServiceImpl<GemParmKeyMapper, GemParmKey> implements GemParmKeyService {

	@Override
	public GemParmKey selectByKey(GemParmKey gemParmKey) {
		String key = gemParmKey.getParmKey();
		EntityWrapper<GemParmKey> wrapper = new EntityWrapper<>();
		wrapper.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
		wrapper.andNew("PARM_KEY={0}", key);
		List<GemParmKey> gemParmKeyList= this.selectList(wrapper);
		if(gemParmKeyList.size() < 1){
			throw new BussinessException(BizExceptionEnum.RECORD_NOT_EXIST);
		}
		return gemParmKeyList.get(0);
	}
	
}
