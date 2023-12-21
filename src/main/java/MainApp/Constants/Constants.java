package MainApp.Constants;

public final class Constants
{
	public final class EndPoints
	{
		public final static String DEFAULT = "/";
		public final static String REGISTER = "/register";
		public final static String LOGIN = "/login";
		public final static String LOGOUT = "/logout";
		public final static String ADD_CAR = "/addCar";
		public final static String UPDATE_CAR = "/updateCar";
		public final static String HOME = "/home";
		public final static String DELETE_CAR = "/deleteCar";
		public final static String CHANGE_ROLE = "/changeRole";
	}
	
	public final class Redirects
	{
		public final static String REGISTER = "redirect:" + EndPoints.REGISTER;
		public final static String LOGIN = "redirect:" + EndPoints.LOGIN;
		public final static String ADD_CAR = "redirect:" + EndPoints.ADD_CAR;
		public final static String UPDATE_CAR = "redirect:" + EndPoints.UPDATE_CAR;
		public final static String HOME = "redirect:" + EndPoints.HOME;
	}
	
	public final class Attributes
	{
		public final static String ERROR = "error";
		public final static String USERNAME_TAKEN = "usernameTaken";
		public final static String PASSWORD_MISMATCH = "passwordMissmatch";
		public final static String USER = "user";
		public final static String LOGGED_USER = "authenticatedUser";
		public final static String USERS = "users";
		public final static String USERNAME = "username";
		public final static String CAR = "car";
		public final static String CARS = "cars";
		public final static String REGISTRATION_EXISTS = "registrationExists";
		public final static String IS_OPERATOR = "isOperator";
		public final static String DISTINCT_BRANDS = "distinctBrands";
		public final static String DISTINCT_MODELS = "distinctModels";
		public final static String DISTINCT_CYLINDRICAL_CAPACITIES = "distinctCylindricalCapacities";
	}
	
	public final class RequestParameters
	{
		public final static String SELECTED_USER = "selectedUser";
		public final static String IS_OPERATOR = "isOperator";
		public final static String REGISTRATION_NUMBER = "registrationNumber";
		public final static String BRAND = "brand";
		public final static String MODEL = "model";
		public final static String CYLINDRICAL_CAPACITY = "cylindricalCapacity";
		public final static String CONFIRM_PASSWORD = "confirmPassword";
	}
	
	public final class Tables
	{
		public final static String USERS = "users";
		public final static String CARS = "cars";
	}
	
	public final class UserFields
	{
		public final static String ID = "id";
		public final static String USERNAME = "username";
		public final static String PASSWORD = "password";
		public final static String ACCESS_LEVEL = "access_level";
		
		public final static int USERNAME_LENGTH = 30;
		public final static int PASSWORD_LENGTH = 60;
	}
	
	public final class CarFields
	{
		public final static String ID = "registration_number";
		public final static String USER_ID = "user_id";
		public final static String BRAND = "brand";
		public final static String MODEL = "model";
		public final static String COLOR = "color";
		public final static String FABRICATION_YEAR = "fabrication_year";
		public final static String CYLINDRICAL_CAPACITY = "cylindrical_capacity";
		public final static String FUEL_TYPE = "fuel_type";
		public final static String POWER = "power";
		public final static String TORQUE = "torque";
		public final static String TRUNK_VOLUME = "trunk_volume";
		public final static String PRICE = "price";
		
		public final static int ID_LENGTH = 7;
	}
	
	public final class Nullable
	{
		public final static boolean YES = true;
		public final static boolean NO = false;
	}
}