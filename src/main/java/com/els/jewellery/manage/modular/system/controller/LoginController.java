package com.els.jewellery.manage.modular.system.controller;

import static com.els.jewellery.manage.core.support.HttpKit.getIp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.els.jewellery.manage.common.controller.BaseController;
import com.els.jewellery.manage.common.exception.InvalidKaptchaException;
import com.els.jewellery.manage.common.node.MenuNode;
import com.els.jewellery.manage.common.persistence.dao.UserMapper;
import com.els.jewellery.manage.common.persistence.model.User;
import com.els.jewellery.manage.core.log.LogManager;
import com.els.jewellery.manage.core.log.factory.LogTaskFactory;
import com.els.jewellery.manage.core.shiro.ShiroKit;
import com.els.jewellery.manage.core.shiro.ShiroUser;
import com.els.jewellery.manage.core.support.HttpKit;
import com.els.jewellery.manage.core.util.ToolUtil;
import com.els.jewellery.manage.modular.system.dao.MenuDao;
import com.google.code.kaptcha.Constants;

/**
 * 登录控制器
 *
 * @author portal
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	MenuDao menuDao;

	@Autowired
	UserMapper userMapper;

	/**
	 * 跳转到主页
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		// 获取菜单列表
		List<Integer> roleList = ShiroKit.getUser().getRoleList();
		if (roleList == null || roleList.size() == 0) {
			ShiroKit.getSubject().logout();
			model.addAttribute("tips", "该用户没有角色，无法登陆");
			return "/login.html";
		}
		List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
		List<MenuNode> titles = MenuNode.buildTitle(menus);
		model.addAttribute("titles", titles);

		// 获取用户头像
		Integer id = ShiroKit.getUser().getId();
		User user = userMapper.selectById(id);
		String avatar = user.getAvatar();
		model.addAttribute("avatar", avatar);

		return "/index.html";
	}

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		setAdminSessionInfo(null, null);
		if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
			return REDIRECT + "/";
		} else {
			return "/login.html";
		}
	}

	/**
	 * 点击登录执行的动作
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginVali() {

		String username = super.getPara("username").trim();
		String password = super.getPara("password").trim();

		// 验证验证码是否正确
		if (ToolUtil.getKaptchaOnOff()) {
			String kaptcha = super.getPara("kaptcha").trim();
			String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
			if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)) {
				setAdminSessionInfo(username, password);
				throw new InvalidKaptchaException();
			}
		}

		Subject currentUser = ShiroKit.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
		token.setRememberMe(true);

		currentUser.login(token);

		ShiroUser shiroUser = ShiroKit.getUser();
		super.getSession().setAttribute("shiroUser", shiroUser);
		super.getSession().setAttribute("username", shiroUser.getAccount());

		LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

		ShiroKit.getSession().setAttribute("sessionFlag", true);

		return REDIRECT + "/";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut() {
		LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
		ShiroKit.getSubject().logout();
		return REDIRECT + "/login";
	}

	private void setAdminSessionInfo(String username, String password) {
		HttpSession session = HttpKit.getRequest().getSession();
		session.setAttribute("adminAccount", username);
		session.setAttribute("adminPwd", password);
	}

}
