package MainApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MainApp.Constants.Constants;
import MainApp.Model.User.User;
import MainApp.Repositories.CarRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class DeleteCarController
{
	@PostMapping(Constants.EndPoints.DELETE_CAR)
	public String deleteCar(@RequestParam(Constants.RequestParameters.REGISTRATION_NUMBER) String registrationNumber, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (user == null || !user.isOperator())
		{
			return Constants.Redirects.HOME;
		}
		carRepository_.deleteById(registrationNumber);
		return Constants.Redirects.HOME;
	}

	@Autowired
    private CarRepository carRepository_;
}