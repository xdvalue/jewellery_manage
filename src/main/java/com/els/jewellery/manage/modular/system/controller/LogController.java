package com.els.jewellery.manage.modular.system.controller;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.plugins.Page;
import com.els.jewellery.manage.common.annotion.Permission;
import com.els.jewellery.manage.common.annotion.log.BussinessLog;
import com.els.jewellery.manage.common.constant.Const;
import com.els.jewellery.manage.common.constant.factory.PageFactory;
import com.els.jewellery.manage.common.constant.state.BizLogType;
import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.core.support.BeanKit;
import com.els.jewellery.manage.modular.system.dao.LogDao;
import com.els.jewellery.manage.modular.system.warpper.LogWarpper;
import com.els.jewellery.manage.common.persistence.dao.OperationLogMapper;
import com.els.jewellery.manage.common.persistence.model.OperationLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 日志管理的控制器
 *
 * @author portal
 * @Date 2017年4月5日 19:45:36
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

	private static String PREFIX = "/system/log/";

	@Resource
	private OperationLogMapper operationLogMapper;

	@Resource
	private LogDao logDao;

	/**
	 * 跳转到日志管理的首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "log.html";
	}

	/**
	 * 查询操作日志列表
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
			@RequestParam(required = false) String logName, @RequestParam(required = false) Integer logType) {
		Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
		List<Map<String, Object>> result = logDao.getOperationLogs(page, beginTime, endTime, logName,
				BizLogType.valueOf(logType), page.getOrderByField(), page.isAsc());
		page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
		return super.packForBT(page);
	}

	/**
	 * 查询操作日志详情
	 */
	@RequestMapping("/detail/{id}")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object detail(@PathVariable Integer id) {
		OperationLog operationLog = operationLogMapper.selectById(id);
		Map<String, Object> stringObjectMap = BeanKit.beanToMap(operationLog);
		return super.warpObject(new LogWarpper(stringObjectMap));
	}

	/**
	 * 清空日志
	 */
	@SuppressWarnings("static-access")
	@BussinessLog(value = "清空业务日志")
	@RequestMapping("/delLog")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object delLog() {
		SqlRunner.db().delete("delete from operation_log");
		return super.SUCCESS_TIP;
	}
}
