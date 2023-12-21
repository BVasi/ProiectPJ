package MainApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MainApp.Constants.Constants;
import MainApp.Model.Car.Car;
import MainApp.Model.User.User;
import MainApp.Repositories.CarRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateCarController
{
	@GetMapping(Constants.EndPoints.UPDATE_CAR)
    public String updateCarForm(@RequestParam String registrationNumber, Model model, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (user == null || !user.isOperator())
		{
			return Constants.Redirects.HOME;
		}
		Optional<Car> optionalCar = carRepository_.findById(registrationNumber);
		if (optionalCar.isPresent())
		{
            Car car = optionalCar.get();
            List<Car> cars = carRepository_.findAll();
            model.addAttribute(Constants.Attributes.CAR, car);
            model.addAttribute(Constants.Attributes.CARS, cars);
            return Constants.EndPoints.UPDATE_CAR;
        }
        return Constants.Redirects.HOME;
    }
	
	@PostMapping(Constants.EndPoints.UPDATE_CAR)
    public String updateCar(@ModelAttribute(Constants.Attributes.CAR) Car updatedCar, HttpSession session)
	{
		User user = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		updatedCar.setUser(user);
		carRepository_.save(updatedCar);
		return Constants.Redirects.HOME;
	}
	
	@Autowired
	private CarRepository carRepository_;
}