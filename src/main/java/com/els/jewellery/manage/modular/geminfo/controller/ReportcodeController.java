package com.els.jewellery.manage.modular.geminfo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.data.IsEnable;
import com.els.jewellery.manage.common.data.ResponseCode;
import com.els.jewellery.manage.common.model.ResponseResult;
import com.els.jewellery.manage.modular.geminfo.entity.Batch;
import com.els.jewellery.manage.modular.geminfo.entity.Reportcode;
import com.els.jewellery.manage.modular.geminfo.service.ReportcodeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-23
 */
@Controller
@RequestMapping("/geminfo/reportcode")
public class ReportcodeController extends BaseController {
	@Autowired
	private ReportcodeService reportcodeService;
	
	/**
	 * 查询所有批次
	 */
	@RequestMapping("/queryByBatch")
	@ResponseBody
	public ResponseResult<List<Reportcode>> queryByBatch(@RequestBody Batch batch) {
		ResponseResult<List<Reportcode>> res = ResponseCode.Success.toResponseResult();
		EntityWrapper<Reportcode> wrapper = new EntityWrapper<>();
		wrapper.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
		wrapper.andNew("BATCH_ID={0}",batch.getId());
		res.setData(reportcodeService.selectList(wrapper));
		return res;
	}
	
}
