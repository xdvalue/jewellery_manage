package com.els.jewellery.manage.modular.geminfo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 宝石信息表
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-07
 */
@TableName("T_BASE_GEM")
public class Gem extends Model<Gem> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
	private String id;
    /**
     * 批次ID
     */
	@TableField("BATCH_ID")
	private String batchId;
    /**
     * 批次编号
     */
	@TableField("BATCH_CODE")
	private String batchCode;
    /**
     * 报告编号
     */
	@TableField("REPORT_CODE")
	private String reportCode;
    /**
     * 宝石名称
     */
	@TableField("GEM_NAME")
	private String gemName;
    /**
     * 宝石重量
     */
	@TableField("GEM_WEIGHT")
	private String gemWeight;
    /**
     * 宝石颜色
     */
	@TableField("GEM_COLOUR")
	private String gemColour;
    /**
     * 宝石鲜艳度
     */
	@TableField("GEM_VIBRANCE")
	private String gemVibrance;
    /**
     * 宝石质量
     */
	@TableField("GEM_QUALITY")
	private String gemQuality;
    /**
     * 宝石印记
     */
	@TableField("GEM_STAMP")
	private String gemStamp;
    /**
     * 评定日期
     */
	@TableField("GEM_ASSESSMENT_TIME")
	private Date gemAssessmentTime;
    /**
     * 鉴定机构
     */
	@TableField("GEM_ACC_BODY")
	private String gemAccBody;
    /**
     * 证书编号
     */
	@TableField("GEM_ACC_CODE")
	private String gemAccCode;
    /**
     * 宝石备注
     */
	@TableField("GEM_REMARK")
	private String gemRemark;
    /**
     * 宝石色调参数
     */
	@TableField("GEM_PARAM_HUE")
	private String gemParamHue;
    /**
     * 宝石浓度参数
     */
	@TableField("GEM_PARAM_CONCENT")
	private String gemParamConcent;
    /**
     * 宝石修饰度参数
     */
	@TableField("GEM_PARAM_FINISH")
	private String gemParamFinish;
    /**
     * 宝石参数备注
     */
	@TableField("GEM_PARAM_REMARK")
	private String gemParamRemark;
    /**
     * 宝石参数图片1
     */
	@TableField("GEM_PARAM_IMG1")
	private String gemParamImg1;
    /**
     * 宝石参数图片2
     */
	@TableField("GEM_PARAM_IMG2")
	private String gemParamImg2;
    /**
     * 宝石火彩质量图片
     */
	@TableField("GEM_QUALITY_IMG")
	private String gemQualityImg;
    /**
     * 宝石图片
     */
	@TableField("GEM_IMG")
	private String gemImg;
    /**
     * 宝石二维码图片
     */
	@TableField("GEM_QRCODE")
	private String gemQrcode;
    /**
     * 宝石二维码备用图片
     */
	@TableField("GEM_QRCODE_B")
	private String gemQrcodeB;
    /**
     * 宝石LOGO图片
     */
	@TableField("GEM_LOGO")
	private String gemLogo;
    /**
     * 创建时间
     */
	@TableField("CREAT_TIME")
	private Date creatTime;
    /**
     * 修改时间
     */
	@TableField("UPDATE_TIME")
	private Date updateTime;
    /**
     * 是否启用：1启用，0禁用
     */
	@TableField("IS_ENABLE")
	private Integer isEnable;
    /**
     * 流水号
     */
	@TableField("SERILA_NUMBER")
	private String serilaNumber;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getGemName() {
		return gemName;
	}

	public void setGemName(String gemName) {
		this.gemName = gemName;
	}

	public String getGemWeight() {
		return gemWeight;
	}

	public void setGemWeight(String gemWeight) {
		this.gemWeight = gemWeight;
	}

	public String getGemColour() {
		return gemColour;
	}

	public void setGemColour(String gemColour) {
		this.gemColour = gemColour;
	}

	public String getGemVibrance() {
		return gemVibrance;
	}

	public void setGemVibrance(String gemVibrance) {
		this.gemVibrance = gemVibrance;
	}

	public String getGemQuality() {
		return gemQuality;
	}

	public void setGemQuality(String gemQuality) {
		this.gemQuality = gemQuality;
	}

	public String getGemStamp() {
		return gemStamp;
	}

	public void setGemStamp(String gemStamp) {
		this.gemStamp = gemStamp;
	}

	public Date getGemAssessmentTime() {
		return gemAssessmentTime;
	}

	public void setGemAssessmentTime(Date gemAssessmentTime) {
		this.gemAssessmentTime = gemAssessmentTime;
	}

	public String getGemAccBody() {
		return gemAccBody;
	}

	public void setGemAccBody(String gemAccBody) {
		this.gemAccBody = gemAccBody;
	}

	public String getGemAccCode() {
		return gemAccCode;
	}

	public void setGemAccCode(String gemAccCode) {
		this.gemAccCode = gemAccCode;
	}

	public String getGemRemark() {
		return gemRemark;
	}

	public void setGemRemark(String gemRemark) {
		this.gemRemark = gemRemark;
	}

	public String getGemParamHue() {
		return gemParamHue;
	}

	public void setGemParamHue(String gemParamHue) {
		this.gemParamHue = gemParamHue;
	}

	public String getGemParamConcent() {
		return gemParamConcent;
	}

	public void setGemParamConcent(String gemParamConcent) {
		this.gemParamConcent = gemParamConcent;
	}

	public String getGemParamFinish() {
		return gemParamFinish;
	}

	public void setGemParamFinish(String gemParamFinish) {
		this.gemParamFinish = gemParamFinish;
	}

	public String getGemParamRemark() {
		return gemParamRemark;
	}

	public void setGemParamRemark(String gemParamRemark) {
		this.gemParamRemark = gemParamRemark;
	}

	public String getGemParamImg1() {
		return gemParamImg1;
	}

	public void setGemParamImg1(String gemParamImg1) {
		this.gemParamImg1 = gemParamImg1;
	}

	public String getGemParamImg2() {
		return gemParamImg2;
	}

	public void setGemParamImg2(String gemParamImg2) {
		this.gemParamImg2 = gemParamImg2;
	}

	public String getGemQualityImg() {
		return gemQualityImg;
	}

	public void setGemQualityImg(String gemQualityImg) {
		this.gemQualityImg = gemQualityImg;
	}

	public String getGemImg() {
		return gemImg;
	}

	public void setGemImg(String gemImg) {
		this.gemImg = gemImg;
	}

	public String getGemQrcode() {
		return gemQrcode;
	}

	public void setGemQrcode(String gemQrcode) {
		this.gemQrcode = gemQrcode;
	}

	public String getGemQrcodeB() {
		return gemQrcodeB;
	}

	public void setGemQrcodeB(String gemQrcodeB) {
		this.gemQrcodeB = gemQrcodeB;
	}

	public String getGemLogo() {
		return gemLogo;
	}

	public void setGemLogo(String gemLogo) {
		this.gemLogo = gemLogo;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public String getSerilaNumber() {
		return serilaNumber;
	}

	public void setSerilaNumber(String serilaNumber) {
		this.serilaNumber = serilaNumber;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Gem{" +
			"id=" + id +
			", batchId=" + batchId +
			", batchCode=" + batchCode +
			", reportCode=" + reportCode +
			", gemName=" + gemName +
			", gemWeight=" + gemWeight +
			", gemColour=" + gemColour +
			", gemVibrance=" + gemVibrance +
			", gemQuality=" + gemQuality +
			", gemStamp=" + gemStamp +
			", gemAssessmentTime=" + gemAssessmentTime +
			", gemAccBody=" + gemAccBody +
			", gemAccCode=" + gemAccCode +
			", gemRemark=" + gemRemark +
			", gemParamHue=" + gemParamHue +
			", gemParamConcent=" + gemParamConcent +
			", gemParamFinish=" + gemParamFinish +
			", gemParamRemark=" + gemParamRemark +
			", gemParamImg1=" + gemParamImg1 +
			", gemParamImg2=" + gemParamImg2 +
			", gemQualityImg=" + gemQualityImg +
			", gemImg=" + gemImg +
			", gemQrcode=" + gemQrcode +
			", gemQrcodeB=" + gemQrcodeB +
			", gemLogo=" + gemLogo +
			", creatTime=" + creatTime +
			", updateTime=" + updateTime +
			", isEnable=" + isEnable +
			", serilaNumber=" + serilaNumber +
			"}";
	}
}
