package MainApp.Controllers;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import MainApp.Constants.Constants;
import MainApp.Model.User.User;
import MainApp.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
	public LoginController()
	{
		super();
	}
	
	@GetMapping({Constants.EndPoints.DEFAULT, Constants.EndPoints.LOGIN})
	public String loginForm(Model model, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (user == null)
		{
			model.addAttribute(Constants.Attributes.USER, new User());
		    return Constants.EndPoints.LOGIN;
		}
		return Constants.Redirects.HOME;
	}
	
	@PostMapping(Constants.EndPoints.LOGIN)
    public String login(@ModelAttribute(Constants.Attributes.USER) User user, Model model, HttpSession session) 
	{
		Optional<User> optionalUser = userRepository_.findByUsername(user.getUsername());
        if (optionalUser.isEmpty() || (!BCrypt.checkpw(user.getPassword(), optionalUser.get().getPassword())))
        {
        	model.addAttribute(Constants.Attributes.ERROR, true);
        	return Constants.EndPoints.LOGIN;
        }
        session.setAttribute(Constants.Attributes.LOGGED_USER, optionalUser.get());
        return Constants.Redirects.HOME;
    }
	
	@Autowired
	private UserRepository userRepository_;
}