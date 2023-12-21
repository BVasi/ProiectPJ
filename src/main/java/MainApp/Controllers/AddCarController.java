package MainApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import MainApp.Constants.Constants;
import MainApp.Model.Car.Car;
import MainApp.Model.User.User;
import MainApp.Repositories.CarRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class AddCarController
{
	@GetMapping(Constants.EndPoints.ADD_CAR)
	public String addCarForm(Model model, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (user == null || !user.isOperator())
		{
			return Constants.Redirects.LOGIN;
		}
		model.addAttribute(Constants.Attributes.CAR, new Car());
	    return Constants.EndPoints.ADD_CAR;
	}
	
	@PostMapping(Constants.EndPoints.ADD_CAR)
	public String addCar(@ModelAttribute(Constants.Attributes.CAR) Car car, Model model,
    		HttpSession session, RedirectAttributes redirectAttributes) 
	{
		String registrationNumber = car.getRegistrationNumber().toUpperCase();
		if (carRepository_.findById(registrationNumber).isPresent())
		{
	        redirectAttributes.addFlashAttribute(Constants.Attributes.REGISTRATION_EXISTS, true);
	        return Constants.Redirects.HOME;
	    }
        User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
        car.setUser(user);
        car.setRegistrationNumber(registrationNumber);
        carRepository_.save(car);
        return Constants.Redirects.HOME;
    }

	@Autowired
	private CarRepository carRepository_;
}
