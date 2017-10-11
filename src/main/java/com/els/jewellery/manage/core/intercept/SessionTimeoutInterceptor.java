package com.els.jewellery.manage.core.intercept;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.InvalidSessionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.core.shiro.ShiroKit;
import com.els.jewellery.manage.core.support.HttpKit;
import com.els.jewellery.manage.core.util.StringUtil;

/**
 * 验证session超时的拦截器
 *
 * @author portal
 * @date 2017年6月7日21:08:48
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "custom", name = "session-open", havingValue = "true")
public class SessionTimeoutInterceptor extends BaseController {

	@Pointcut("execution(* com.els.jewellery.manage.*..controller.*.*(..))")
	public void cutService() {
	}

	@Around("cutService()")
	public Object sessionTimeoutValidate(ProceedingJoinPoint point) throws Throwable {
		// String servletPath = HttpKit.getRequest().getServletPath();
		String requestUri = HttpKit.getRequest().getRequestURI();
		String contextPath = HttpKit.getContextPath();
		String rootPath = StringUtil.cutPrefix(requestUri, contextPath);

		int httpStatus = HttpKit.getResponse().getStatus();

		logger.info(String.format("请求路径=%s，HTTP状态码=%s", requestUri, httpStatus));

		// if (servletPath.equals("/kaptcha") || servletPath.equals("/login")
		// || servletPath.equals("/global/sessionError")) {
		if (rootPath.startsWith("/kaptcha") || rootPath.startsWith("/login")
				|| rootPath.startsWith("/global/sessionError")) {
			return point.proceed();
		} else {
			if (ShiroKit.getSession().getAttribute("sessionFlag") == null) {
				if (httpStatus == HttpServletResponse.SC_NOT_FOUND) {
					return point.proceed();
				}
				ShiroKit.getSubject().logout();
				throw new InvalidSessionException();
			} else {
				return point.proceed();
			}
		}
	}

}
