package action;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("myLoginAction")
//struts注解  不可省路径
public class MyLoginAction extends ActionSupport {
	private String username;
	private String password;
  
	@Override
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		if("123".equals(username)&&"123".equals(password)){
			ctx.getSession().put("user", "123");
			return SUCCESS;
		}else {
			addActionError("用户名或者密码不正确");
			return INPUT;
		}
	}
     
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
