package com.els.jewellery.manage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "els") // 接收application.yml中的custom下面的属性
public class ElsConfig {

	private String elsSubaccount;
	
	private String elsStation;
	
	private String elsIsadmin;
	
	private String elsRoute;
	
	private String elsFrozenFlag;
	
	private String elsAccountvaliditydate;
	
	private String elsIsdel;
	
	private String elsAdminCode;
	
	private String elsAdminName;
	
	private String elsAppAccount;
	
	private String elsAppRole;

	public String getElsSubaccount() {
		return elsSubaccount;
	}

	public void setElsSubaccount(String elsSubaccount) {
		this.elsSubaccount = elsSubaccount;
	}

	public String getElsStation() {
		return elsStation;
	}

	public void setElsStation(String elsStation) {
		this.elsStation = elsStation;
	}

	public String getElsIsadmin() {
		return elsIsadmin;
	}

	public void setElsIsadmin(String elsIsadmin) {
		this.elsIsadmin = elsIsadmin;
	}

	public String getElsRoute() {
		return elsRoute;
	}

	public void setElsRoute(String elsRoute) {
		this.elsRoute = elsRoute;
	}

	public String getElsFrozenFlag() {
		return elsFrozenFlag;
	}

	public void setElsFrozenFlag(String elsFrozenFlag) {
		this.elsFrozenFlag = elsFrozenFlag;
	}

	public String getElsAccountvaliditydate() {
		return elsAccountvaliditydate;
	}

	public void setElsAccountvaliditydate(String elsAccountvaliditydate) {
		this.elsAccountvaliditydate = elsAccountvaliditydate;
	}

	public String getElsIsdel() {
		return elsIsdel;
	}

	public void setElsIsdel(String elsIsdel) {
		this.elsIsdel = elsIsdel;
	}

	public String getElsAdminCode() {
		return elsAdminCode;
	}

	public void setElsAdminCode(String elsAdminCode) {
		this.elsAdminCode = elsAdminCode;
	}

	public String getElsAdminName() {
		return elsAdminName;
	}

	public void setElsAdminName(String elsAdminName) {
		this.elsAdminName = elsAdminName;
	}

	public String getElsAppAccount() {
		return elsAppAccount;
	}

	public void setElsAppAccount(String elsAppAccount) {
		this.elsAppAccount = elsAppAccount;
	}

	public String getElsAppRole() {
		return elsAppRole;
	}

	public void setElsAppRole(String elsAppRole) {
		this.elsAppRole = elsAppRole;
	}
	
	
}
