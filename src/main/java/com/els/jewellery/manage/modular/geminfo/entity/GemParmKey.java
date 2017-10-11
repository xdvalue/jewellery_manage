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
 * 
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-25
 */
@TableName("T_BASE_GEM_PARM_KEY")
public class GemParmKey extends Model<GemParmKey> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
	private String id;
    /**
     * 快捷键KEY
     */
	@TableField("PARM_KEY")
	private String parmKey;
    /**
     * 宝石名称
     */
	@TableField("GEM_COLOUR")
	private String gemColour;
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
     * 宝石鲜艳度
     */
	@TableField("GEM_VIBRANCE")
	private String gemVibrance;
    /**
     * 宝石图片
     */
	@TableField("GEM_IMG")
	private String gemImg;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getParmKey() {
		return parmKey;
	}

	public void setParmKey(String parmKey) {
		this.parmKey = parmKey;
	}

	

	public String getGemColour() {
		return gemColour;
	}

	public void setGemColour(String gemColour) {
		this.gemColour = gemColour;
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

	public String getGemVibrance() {
		return gemVibrance;
	}

	public void setGemVibrance(String gemVibrance) {
		this.gemVibrance = gemVibrance;
	}

	public String getGemImg() {
		return gemImg;
	}

	public void setGemImg(String gemImg) {
		this.gemImg = gemImg;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "GemParmKey{" +
			"id=" + id +
			", parmKey=" + parmKey +
			", gemColour=" + gemColour +
			", gemParamHue=" + gemParamHue +
			", gemParamConcent=" + gemParamConcent +
			", gemParamFinish=" + gemParamFinish +
			", gemVibrance=" + gemVibrance +
			", gemImg=" + gemImg +
			", creatTime=" + creatTime +
			", updateTime=" + updateTime +
			", isEnable=" + isEnable +
			"}";
	}
}
