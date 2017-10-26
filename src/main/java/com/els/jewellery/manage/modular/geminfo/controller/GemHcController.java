package com.els.jewellery.manage.modular.geminfo.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.data.IsEnable;
import com.els.jewellery.manage.common.data.ResponseCode;
import com.els.jewellery.manage.common.exception.BizExceptionEnum;
import com.els.jewellery.manage.common.exception.BussinessException;
import com.els.jewellery.manage.common.model.ResponseResult;
import com.els.jewellery.manage.modular.geminfo.dao.GemHcMapper;
import com.els.jewellery.manage.modular.geminfo.entity.GemHc;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-29
 */
@Controller
@RequestMapping("/geminfo/gemHc")
public class GemHcController extends BaseController {
	
	@Resource
	private GemHcMapper gemHcMapper;
	
	/**
	 * 根据KEY查询火彩质量信息
	 */
	@RequestMapping("/queryByKey")
	@ResponseBody
	public ResponseResult<GemHc> queryByKey(@RequestBody GemHc gemHc) {
		if(gemHc.getHcKey() == null){
			throw new BussinessException(BizExceptionEnum.KEY_IS_NOT_NULL);
		}
		ResponseResult<GemHc> res = ResponseCode.Success.toResponseResult();
		EntityWrapper<GemHc> wrapper_hc = new EntityWrapper<>();
		wrapper_hc.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
		wrapper_hc.andNew("HC_KEY={0}", gemHc.getHcKey());
		List<GemHc> list= gemHcMapper.selectList(wrapper_hc);
		if(list.size() < 1){
			throw new BussinessException(BizExceptionEnum.HC_IS_NOT_FOUNT);
		}
		res.setData(list.get(0));
		return res;
	}
}
