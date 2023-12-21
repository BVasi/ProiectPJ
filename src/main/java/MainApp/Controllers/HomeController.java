package MainApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MainApp.Constants.Constants;
import MainApp.Model.Car.Car;
import MainApp.Model.User.User;
import MainApp.Repositories.CarRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController
{
	@GetMapping(Constants.EndPoints.HOME)
	public String homePage(Model model, HttpSession session,
							@RequestParam(name = Constants.RequestParameters.BRAND, required = false) String brand,
				            @RequestParam(name = Constants.RequestParameters.MODEL, required = false) String modelParam,
				            @RequestParam(name = Constants.RequestParameters.CYLINDRICAL_CAPACITY, required = false) Integer cylindricalCapacity)
	{
		User authenticatedUser = (User)session.getAttribute(Constants.Attributes.LOGGED_USER);
		if (authenticatedUser == null)
		{
			return Constants.Redirects.LOGIN;
		}
		populateSortingCriteria(model);
        boolean isOperator = authenticatedUser != null && authenticatedUser.isOperator();
        model.addAttribute(Constants.Attributes.IS_OPERATOR, isOperator);
        model.addAttribute("username", authenticatedUser.getUsername());
        populateModelWithCars(model, brand, modelParam, cylindricalCapacity);
		return Constants.EndPoints.HOME;
	}
	
	private void populateModelWithCars(Model model, String brand,
			String modelParam, final Integer cylindricalCapacity)
	{
		List<Car> cars;
        if ((brand == null || (brand.isEmpty())) &&
        	 (modelParam == null || (modelParam.isEmpty())) &&
        	 cylindricalCapacity == null)
        {
        	cars = carRepository_.findAll();
        }
        else
        {
        	if (brand.isEmpty()) brand = null;
        	if (modelParam.isEmpty()) modelParam = null;
        	cars = carRepository_.findByBrandAndModelAndCylindricalCapacity(brand, modelParam, cylindricalCapacity);
        }
        model.addAttribute(Constants.Attributes.CARS, cars);
	}
	
	private void populateSortingCriteria(Model model)
	{
		List<String> distinctBrands = carRepository_.findDistinctBrands();
        List<String> distinctModels = carRepository_.findDistinctModels();
        List<Integer> distinctCylindricalCapacities = carRepository_.findDistinctCylindricalCapacities();
        model.addAttribute(Constants.Attributes.DISTINCT_BRANDS, distinctBrands);
        model.addAttribute(Constants.Attributes.DISTINCT_MODELS, distinctModels);
        model.addAttribute(Constants.Attributes.DISTINCT_CYLINDRICAL_CAPACITIES, distinctCylindricalCapacities);
	}
	
	@Autowired
    private CarRepository carRepository_;
}