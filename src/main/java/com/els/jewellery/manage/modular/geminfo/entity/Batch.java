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
 * 批次表
 * </p>
 *
 * @author jewellery_manage
 * @since 2017-09-23
 */
@TableName("T_BASE_BATCH")
public class Batch extends Model<Batch> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ID", type = IdType.INPUT)
	private String id;
    /**
     * 批次编码
     */
	@TableField("BATCH_CODE")
	private String batchCode;
    /**
     * 批次备注
     */
	@TableField("BATCH_REMARL")
	private String batchRemarl;
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
	@TableField("SERIAL_NUMBER")
	private String serialNumber;
    /**
     * 委托方名称
     */
	@TableField("CLIENT_NAME")
	private String clientName;
    /**
     * 委托方联系电话
     */
	@TableField("CLIENT_PHONE")
	private String clientPhone;
    /**
     * 样品数量
     */
	@TableField("GEM_NUM")
	private Integer gemNum;
    /**
     * 送检时间
     */
	@TableField("INSPECTION_TIME")
	private Date inspectionTime;
    /**
     * 取样时间
     */
	@TableField("SAMPLING_TIME")
	private Date samplingTime;
    /**
     * 采用标准
     */
	@TableField("STANDARD_NAME")
	private String standardName;
    /**
     * 收样电话
     */
	@TableField("RECEIVED_PHONE")
	private String receivedPhone;
    /**
     * 委托方要求
     */
	@TableField("CLIENT_ASK")
	private String clientAsk;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getBatchRemarl() {
		return batchRemarl;
	}

	public void setBatchRemarl(String batchRemarl) {
		this.batchRemarl = batchRemarl;
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getGemNum() {
		return gemNum;
	}

	public void setGemNum(Integer gemNum) {
		this.gemNum = gemNum;
	}

	public Date getInspectionTime() {
		return inspectionTime;
	}

	public void setInspectionTime(Date inspectionTime) {
		this.inspectionTime = inspectionTime;
	}

	public Date getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(Date samplingTime) {
		this.samplingTime = samplingTime;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getReceivedPhone() {
		return receivedPhone;
	}

	public void setReceivedPhone(String receivedPhone) {
		this.receivedPhone = receivedPhone;
	}

	public String getClientAsk() {
		return clientAsk;
	}

	public void setClientAsk(String clientAsk) {
		this.clientAsk = clientAsk;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Batch{" +
			"id=" + id +
			", batchCode=" + batchCode +
			", batchRemarl=" + batchRemarl +
			", creatTime=" + creatTime +
			", updateTime=" + updateTime +
			", isEnable=" + isEnable +
			", serialNumber=" + serialNumber +
			", clientName=" + clientName +
			", clientPhone=" + clientPhone +
			", gemNum=" + gemNum +
			", inspectionTime=" + inspectionTime +
			", samplingTime=" + samplingTime +
			", standardName=" + standardName +
			", receivedPhone=" + receivedPhone +
			", clientAsk=" + clientAsk +
			"}";
	}
}
