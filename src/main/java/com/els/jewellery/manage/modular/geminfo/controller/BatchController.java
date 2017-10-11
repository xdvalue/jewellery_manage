package com.els.jewellery.manage.modular.geminfo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.els.jewellery.manage.common.annotion.Permission;
import com.els.jewellery.manage.common.constant.factory.PageFactory;
import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.data.Constant;
import com.els.jewellery.manage.common.data.IsEnable;
import com.els.jewellery.manage.common.data.ResponseCode;
import com.els.jewellery.manage.common.model.ResponseResult;
import com.els.jewellery.manage.modular.geminfo.dao.BatchMapper;
import com.els.jewellery.manage.modular.geminfo.entity.Batch;
import com.els.jewellery.manage.modular.geminfo.service.BatchService;

/**
 * <p>
 * 批次表 前端控制器
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/geminfo/batch")
public class BatchController extends BaseController {
	
	private static String PREFIX = "/batch";
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private BatchMapper batchMapper;
	
	/**
	 * 中转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String gemController() {
		return PREFIX + "/batch.html";
	}
	
	/**
	 * 跳转到新增页面
	 */
	@RequestMapping("/addPage")
	@Permission
	public String toAdd(String batchCode, Model model) {
		model.addAttribute("batchCode", batchCode);
		return PREFIX + "/add.html";
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping("/list")
	@Permission
	@ResponseBody
	public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
			@RequestParam(required = false) String batchCode) {
		
		Page<Batch> page = new PageFactory<Batch>().defaultPage();
		List<Batch> result = batchMapper.getBatchList(page, beginTime, endTime,
				batchCode, page.getOrderByField(), page.isAsc());
		page.setRecords(result);
		return super.packForBT(page);
	}
	
	/**
	 * 新增批次
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult<Batch> add(@RequestBody Batch batch) {
		ResponseResult<Batch> res = ResponseCode.Success.toResponseResult();
		res.setData(batchService.addBatch(batch));
		return res;
	}
	
	/**
	 * 查询所有批次
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public ResponseResult<List<Batch>> queryAll() {
		ResponseResult<List<Batch>> res = ResponseCode.Success.toResponseResult();
		EntityWrapper<Batch> wrapper = new EntityWrapper<>();
		wrapper.where(String.format("%s = {0}", Constant.COLUMN_LOGIC_DELETE), IsEnable.Yes.getId()); // 软删除字段
		res.setData(batchService. selectList(wrapper));
		return res;
	}
	
	/**
	 * 查询详情
	 */
	@RequestMapping("/detailByPrint")
	@Permission
	@ResponseBody
	public ResponseResult<Batch> detailByPrint(@RequestBody Batch batch) {
		String id = batch.getId();
		ResponseResult<Batch> res = ResponseCode.Success.toResponseResult();
		res.setData(batchService.selectById(id));
		return res;
	}
	
	/**
	 * 跳转到打印页面
	 */
	@RequestMapping("/print")
	public String draw(String id, Model model) {
		model.addAttribute("id", id);
		return PREFIX + "/print.html";
	}
	
}
