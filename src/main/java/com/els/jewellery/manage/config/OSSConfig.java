package com.els.jewellery.manage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * OSS阿里云资源配置
 * @author chenyd
 *
 */
@Configuration
@ConfigurationProperties(prefix = "oss") // 接收application.yml中的oss下面的属性
public class OSSConfig {

	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String accessUrl;
	private String private_host;
	private String public_host;
	private String dir;
	private Long expireTime;
	private String sts_region;
	private String sts_servion;
	private String sts_accessKeyId;
	private String sts_accessKeySecret;
	private String sts_roleArn;
	
	private String maxConnections;
    private String connectionTimeout;
    private String socketTimeout;
    private String maxErrorRetry;
    
    private String openBucketName;
    private String openAccessUrl;
    
    private String fileCatalog;
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	public String getPrivate_host() {
		return private_host;
	}
	public void setPrivate_host(String private_host) {
		this.private_host = private_host;
	}
	public String getPublic_host() {
		return public_host;
	}
	public void setPublic_host(String public_host) {
		this.public_host = public_host;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public Long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	public String getSts_region() {
		return sts_region;
	}
	public void setSts_region(String sts_region) {
		this.sts_region = sts_region;
	}
	public String getSts_servion() {
		return sts_servion;
	}
	public void setSts_servion(String sts_servion) {
		this.sts_servion = sts_servion;
	}
	public String getSts_accessKeyId() {
		return sts_accessKeyId;
	}
	public void setSts_accessKeyId(String sts_accessKeyId) {
		this.sts_accessKeyId = sts_accessKeyId;
	}
	public String getSts_accessKeySecret() {
		return sts_accessKeySecret;
	}
	public void setSts_accessKeySecret(String sts_accessKeySecret) {
		this.sts_accessKeySecret = sts_accessKeySecret;
	}
	public String getSts_roleArn() {
		return sts_roleArn;
	}
	public void setSts_roleArn(String sts_roleArn) {
		this.sts_roleArn = sts_roleArn;
	}
	public String getMaxConnections() {
		return maxConnections;
	}
	public void setMaxConnections(String maxConnections) {
		this.maxConnections = maxConnections;
	}
	public String getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(String connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public String getSocketTimeout() {
		return socketTimeout;
	}
	public void setSocketTimeout(String socketTimeout) {
		this.socketTimeout = socketTimeout;
	}
	public String getMaxErrorRetry() {
		return maxErrorRetry;
	}
	public void setMaxErrorRetry(String maxErrorRetry) {
		this.maxErrorRetry = maxErrorRetry;
	}
	public String getFileCatalog() {
		return fileCatalog;
	}
	public void setFileCatalog(String fileCatalog) {
		this.fileCatalog = fileCatalog;
	}
	public String getOpenBucketName() {
		return openBucketName;
	}
	public void setOpenBucketName(String openBucketName) {
		this.openBucketName = openBucketName;
	}
	public String getOpenAccessUrl() {
		return openAccessUrl;
	}
	public void setOpenAccessUrl(String openAccessUrl) {
		this.openAccessUrl = openAccessUrl;
	}

}
