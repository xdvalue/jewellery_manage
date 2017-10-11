package com.els.jewellery.manage.core.log;

import com.els.jewellery.manage.core.util.SpringContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * 被修改的bean临时存放的地方
 *
 * @author portal
 * @date 2017-03-31 11:19
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable {

	private static final long serialVersionUID = 8681820400491232160L;

	private Object object = null;

	public void set(Object obj) {
		this.object = obj;
	}

	public Object get() {
		return object;
	}

	public static LogObjectHolder me() {
		LogObjectHolder bean = SpringContextHolder.getBean(LogObjectHolder.class);
		return bean;
	}
}
