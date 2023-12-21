package MainApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import MainApp.Constants.Constants;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController
{
	@GetMapping(Constants.EndPoints.LOGOUT)
	public String loginForm(Model model, HttpSession session)
	{
		session.invalidate();
		return Constants.Redirects.LOGIN;
	}
}