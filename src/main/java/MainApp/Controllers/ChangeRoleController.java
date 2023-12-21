package MainApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MainApp.Constants.Constants;
import MainApp.Model.User.AccessLevel;
import MainApp.Model.User.User;
import MainApp.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class ChangeRoleController
{
	@GetMapping(Constants.EndPoints.CHANGE_ROLE)
	public String changeUserRoleForm(Model model, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (user == null || !user.isOperator())
		{
			return Constants.Redirects.LOGIN;
		}
		List<User> users = userRepository_.findAll();
		model.addAttribute(Constants.Attributes.USERS, users);
		return Constants.EndPoints.CHANGE_ROLE;
	}
	
	@PostMapping(Constants.EndPoints.CHANGE_ROLE)
	public String changeUserRole(@RequestParam(Constants.RequestParameters.SELECTED_USER) String username,
	                             @RequestParam(value = Constants.RequestParameters.IS_OPERATOR,
	                             defaultValue = "false") boolean isOperator)
	{
	    Optional<User> optionalUser = userRepository_.findByUsername(username);
	    if (optionalUser.isPresent())
	    {
	        User existingUser = optionalUser.get();
	        existingUser.setAccessLevel(isOperator ? AccessLevel.OPERATOR : AccessLevel.VISITOR);
	        userRepository_.save(existingUser);
	    }
	    return Constants.Redirects.HOME;
	}
	
	@Autowired
	private UserRepository userRepository_;
}