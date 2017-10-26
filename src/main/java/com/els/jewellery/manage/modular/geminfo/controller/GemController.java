package com.els.jewellery.manage.modular.geminfo.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.els.jewellery.manage.common.annotion.Permission;
import com.els.jewellery.manage.common.constant.factory.PageFactory;
import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.data.ResponseCode;
import com.els.jewellery.manage.common.model.ResponseResult;
import com.els.jewellery.manage.modular.geminfo.dao.GemMapper;
import com.els.jewellery.manage.modular.geminfo.entity.Gem;
import com.els.jewellery.manage.modular.geminfo.service.GemService;
import com.els.jewellery.manage.modular.geminfo.vo.GemPrintVo;
import com.els.jewellery.manage.modular.utils.ImageHandleHelper;
import com.els.jewellery.manage.modular.utils.SFtpUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 宝石信息表 前端控制器
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-07
 */
@Controller
@RequestMapping("/geminfo/gem")
public class GemController extends BaseController {
	
	private static String PREFIX = "/gem";
	
	@Autowired
	private GemMapper gemMapper;
	@Autowired
	private GemService gemService;
	
	/**
	 * 中转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String gemController() {
		return PREFIX + "/gem.html";
	}
	
	/**
	 * 跳转到企业详情页面
	 */
	@RequestMapping("/viewDetail")
	@Permission
	public String viewDetail(String id, Model model) {
		model.addAttribute("id", id);
		return PREFIX + "/viewDetail.html";
	}
	
	/**
	 * 跳转到企业详情页面
	 */
	@RequestMapping("/copy")
	@Permission
	public String copy(String id, Model model) {
		model.addAttribute("id", id);
		return PREFIX + "/copy.html";
	}
	
	/**
	 * 跳转到企业详情页面
	 */
	@RequestMapping("/draw")
	public String draw(String id, Model model) {
		model.addAttribute("id", id);
		return PREFIX + "/draw.html";
	}
	
	/**
	 * 跳转到企业详情页面
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
		
		Page<Gem> page = new PageFactory<Gem>().defaultPage();
		List<Gem> result = gemMapper.getGemList(page, beginTime, endTime,
				batchCode, page.getOrderByField(), page.isAsc());
		page.setRecords(result);
		return super.packForBT(page);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping("/add")
	@Permission
	@ResponseBody
	public ResponseResult<String> add(@RequestBody Gem gem) {
		ResponseResult<String> res = ResponseCode.Success.toResponseResult();
		gemService.addGemInfo(gem);
		return res;
	}
	
	/**
	 * 查询详情
	 */
	@RequestMapping("/detail")
	@Permission
	@ResponseBody
	public ResponseResult<Gem> detail(String id) {
		ResponseResult<Gem> res = ResponseCode.Success.toResponseResult();
		EntityWrapper<Gem> wrapper = new EntityWrapper<>();
		wrapper.where("ID={0}", id);
		res.setData(gemService.selectOne(wrapper));
		return res;
	}
	
	/**
	 * 查询详情
	 */
	@RequestMapping("/detailByPrint")
	@Permission
	@ResponseBody
	public ResponseResult<GemPrintVo> detailByPrint(@RequestBody Gem gem) {
		String id = gem.getId();
		ResponseResult<GemPrintVo> res = ResponseCode.Success.toResponseResult();
		EntityWrapper<Gem> wrapper = new EntityWrapper<>();
		wrapper.where("ID={0}", id);
		Gem tempGem= gemService.selectOne(wrapper);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		Date time = tempGem.getGemAssessmentTime();
		String date = sdf.format(time);
		GemPrintVo gemVo = new GemPrintVo();
		gemVo.setReportCode(tempGem.getReportCode() + "%&250,408.667");
		gemVo.setGemNameAndWeight(tempGem.getGemName()+","+tempGem.getGemWeight() + "%&180,438.667");
		gemVo.setGemColourAndVibrance(tempGem.getGemColour()+",鲜艳度为" + tempGem.getGemVibrance() + "%&180,468.333");
		gemVo.setGemQuality(tempGem.getGemQuality() + "%&180,500.333");
		gemVo.setGemStampAndNameAndWeight(tempGem.getGemName() + "壹颗，"+tempGem.getGemStamp() + ","+tempGem.getGemWeight() + "%&170,552");
		gemVo.setGemAssessmentTime(date + "%&170,581");
		gemVo.setGemAccBodyAndCode(tempGem.getGemAccBody() + "," + tempGem.getGemAccCode() + "%&186.667,608.667");
		gemVo.setGemRemark(tempGem.getGemRemark() + "%&130,641");
		gemVo.setColourAndLevel(tempGem.getGemColour() + "%&851.333,153.667");
		gemVo.setGemVibrance(tempGem.getGemVibrance() + "%&1080,153.333");
		gemVo.setGemParamHue(tempGem.getGemParamHue() + "%&726.667,227");
		gemVo.setGemParamConcent(tempGem.getGemParamConcent() + "%&726.667,287");
		gemVo.setGemParamFinish(tempGem.getGemParamFinish() + "%&726.667,345");
		gemVo.setGemParamRemark(tempGem.getGemParamRemark() + "%&713.334,401");
		gemVo.setGemColourImg(tempGem.getGemParamImg1() + "%&839.328,152");
		gemVo.setGemHcImg(tempGem.getGemParamImg2() + "%&841.328,380.656");
		gemVo.setGemImg(tempGem.getGemImg() + "%&116.667,183.334");
		gemVo.setGemQRImg(tempGem.getGemQrcode() + "%&394.656,226.328");
		if(StringUtils.isNotBlank(tempGem.getGemLogo())){
			gemVo.setLogImg(tempGem.getGemLogo() +"%&0,0" );
		}
		res.setData(gemVo);
		return res;
	}
	

	/**
	 * 批量打印
	 * @throws InterruptedException 
	 */
	@RequestMapping("/batchPrint")
	@Permission
	@ResponseBody
	public ResponseResult<String> batchPrint(@RequestBody Gem gem) throws InterruptedException {
		Thread.currentThread().sleep(700000);
		ResponseResult<String> res = ResponseCode.Success.toResponseResult();
		res.setData("生成批量打印PDF文件失败，生成超时！");
		return res;
	}
	
	/**
	 * 查询详情
	 * @throws IOException 
	 */
	@RequestMapping("/getImg")
	public void getImg(@RequestBody GemPrintVo gem,HttpServletResponse response) throws IOException {
		ImageHandleHelper imgHe = new ImageHandleHelper();
		BufferedImage img = imgHe.creatImg(gem);
		response.setContentType("image/jpeg");
	    OutputStream os = response.getOutputStream();  
	    ImageIO.write(img, "jpg", os);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping("/img")
	@Permission
	public Object img() {	
		
		return null;
	}
	
	/**
	 * 文件上传
	 * @param files
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "文件上传", notes = "文件上传接口", httpMethod = "POST")
	@RequestMapping("/fileUpload/{fileType}")
	@ResponseBody
	public ResponseResult<String> fileUpload(@RequestParam("file") MultipartFile[] files,@ApiParam("文件类型：0:宝石照片： 1：Logo") @PathVariable String fileType) throws Exception {
		ResponseResult<String> res = ResponseCode.Success.toResponseResult();
		if (files.length > 0) {
			MultipartFile file = files[0];
			if (file.getContentType().contains("image")) {
				ClassLoader classLoader = GemController.class.getClassLoader();  
		        URL resource = classLoader.getResource("");  
		        String path = resource.getPath();  
		        String imgUrl = "";
		        if(fileType.equals("0")){
		        	path += "/mnt/local/apps/tomcat/tomcat-img/tomcat-8.0.44/webapps/jeimg/gem/";
		        	imgUrl = "http://39.108.169.195:10000/jeimg/gem/";
		        }else if(fileType.equals("1")){
		        	path += "/mnt/local/apps/tomcat/tomcat-img/tomcat-8.0.44/webapps/jeimg/logo/";
		        	imgUrl = "http://39.108.169.195:10000/jeimg/logo/";
		        }
		        // 获取图片的文件名
		        String fileName = file.getOriginalFilename();
		        SFtpUtil sftp = new SFtpUtil();
		        String newFileName = fileName;
		        String name = sftp.upload2(path, file.getInputStream(), sftp.connectSFTP(),newFileName) ;
		        res.setData(imgUrl + name);
			}
		}
		
		return res;
	}

}
