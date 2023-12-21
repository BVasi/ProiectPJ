package MainApp.Controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MainApp.Constants.Constants;
import MainApp.Model.User.User;
import MainApp.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController
{
	public RegisterController()
	{
		super();
	}
	
	@GetMapping(Constants.EndPoints.REGISTER)
	public String registerForm(Model model, HttpSession session)
	{
		session.invalidate();
	    model.addAttribute(Constants.Attributes.USER, new User());
	    return Constants.EndPoints.REGISTER;
	}
	
	@PostMapping(Constants.EndPoints.REGISTER)
	public String registerUser(@ModelAttribute(Constants.Attributes.USER) User user, @RequestParam(Constants.RequestParameters.CONFIRM_PASSWORD) String confirmPassword, Model model)
	{
	    if (!user.hasPassword(confirmPassword))
	    {
	    	model.addAttribute(Constants.Attributes.PASSWORD_MISMATCH, true);
	    	return Constants.EndPoints.REGISTER;
	    }
	    if (userRepository_.findByUsername(user.getUsername()).isPresent())
	    {
	    	model.addAttribute(Constants.Attributes.USERNAME_TAKEN, true);
	    	return Constants.EndPoints.REGISTER;
	    }
	    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
	    userRepository_.save(user);
	    return Constants.Redirects.LOGIN;
	}

	@Autowired
	private UserRepository userRepository_;
}