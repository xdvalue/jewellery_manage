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
 * @since 2017-09-23
 */
@TableName("T_BASE_REPORTCODE")
public class Reportcode extends Model<Reportcode> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
	private String id;
    /**
     * 证书编号
     */
	@TableField("REPORT_CODE")
	private String reportCode;
    /**
     * 批次ID
     */
	@TableField("BATCH_ID")
	private String batchId;
    /**
     * 流水号
     */
	@TableField("SERIAL_NUMBER")
	private String serialNumber;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
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

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		return "Reportcode{" +
			"id=" + id +
			", reportCode=" + reportCode +
			", batchId=" + batchId +
			", serialNumber=" + serialNumber +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", isEnable=" + isEnable +
			"}";
	}
}
