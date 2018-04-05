package ncu.zp.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Component;

import ncu.zp.entity.User;
import ncu.zp.service.UserService;
import ncu.zp.util.SuperAction;

@Component
@Action(value = "UserAction", results = { @Result(name = "loginSuccess", location = "/jsp/user/UserLoginSuccess.jsp"),
		@Result(name = "loginFailer", location = "/loginFailer.jsp") })
public class UserAction extends SuperAction {
	@Resource
	private UserService userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() {
		System.out.print(user.toString());
		boolean flag = userService.isExitByNameAndPass(user);
		if (flag) {
			return "loginSuccess";
		}
		System.out.println("fail");
		return "loginFailer";
	}
}
