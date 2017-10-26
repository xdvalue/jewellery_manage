package com.els.jewellery.manage.modular.geminfo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-29
 */
@TableName("T_BASE_GEM_HC")
public class GemHc extends Model<GemHc> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableField("ID")
	private String id;
    /**
     * 火彩快捷键
     */
	@TableField("HC_KEY")
	private String hcKey;
    /**
     * 火彩级别名称
     */
	@TableField("HC_NAME")
	private String hcName;
    /**
     * 火彩图片
     */
	@TableField("HC_IMG")
	private String hcImg;
    /**
     * 创建时间
     */
	@TableField("CERAT_TIME")
	private Date ceratTime;
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

	public String getHcKey() {
		return hcKey;
	}

	public void setHcKey(String hcKey) {
		this.hcKey = hcKey;
	}

	public String getHcName() {
		return hcName;
	}

	public void setHcName(String hcName) {
		this.hcName = hcName;
	}

	public String getHcImg() {
		return hcImg;
	}

	public void setHcImg(String hcImg) {
		this.hcImg = hcImg;
	}

	public Date getCeratTime() {
		return ceratTime;
	}

	public void setCeratTime(Date ceratTime) {
		this.ceratTime = ceratTime;
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
		return "GemHc{" +
			"id=" + id +
			", hcKey=" + hcKey +
			", hcName=" + hcName +
			", hcImg=" + hcImg +
			", ceratTime=" + ceratTime +
			", updateTime=" + updateTime +
			", isEnable=" + isEnable +
			"}";
	}
}
