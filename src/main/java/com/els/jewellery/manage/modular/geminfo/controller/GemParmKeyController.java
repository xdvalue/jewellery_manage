package com.els.jewellery.manage.modular.geminfo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.data.ResponseCode;
import com.els.jewellery.manage.common.model.ResponseResult;
import com.els.jewellery.manage.modular.geminfo.entity.GemParmKey;
import com.els.jewellery.manage.modular.geminfo.service.GemParmKeyService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-25
 */
@Controller
@RequestMapping("/geminfo/gemParmKey")
public class GemParmKeyController extends BaseController {
	
	@Autowired
	private GemParmKeyService gemParmKeyService;
	
	/**
	 * 查询所有批次
	 */
	@RequestMapping("/queryByKey")
	@ResponseBody
	public ResponseResult<GemParmKey> queryByKey(@RequestBody GemParmKey gemParmKey) {
		ResponseResult<GemParmKey> res = ResponseCode.Success.toResponseResult();
		res.setData(gemParmKeyService.selectByKey(gemParmKey));
		return res;
	}
	
}
