package MainApp.Model.Car;

import java.math.BigDecimal;

import MainApp.Model.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import MainApp.Constants.Constants;

@Entity
@Table(name = Constants.Tables.CARS)
public class Car 
{
	public Car()
	{
		
	}
	
	public String getRegistrationNumber()
	{
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(final User user)
    {
        this.user = user;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(final String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(final String model)
    {
        this.model = model;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(final Color color)
    {
        this.color = color;
    }

    public int getFabricationYear()
    {
        return fabricationYear;
    }

    public void setFabricationYear(final int fabricationYear)
    {
        this.fabricationYear = fabricationYear;
    }

    public int getCylindricalCapacity()
    {
        return cylindricalCapacity;
    }

    public void setCylindricalCapacity(final int cylindricalCapacity)
    {
        this.cylindricalCapacity = cylindricalCapacity;
    }

    public FuelType getFuelType()
    {
        return fuelType;
    }

    public void setFuelType(final FuelType fuelType)
    {
        this.fuelType = fuelType;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(final int power)
    {
        this.power = power;
    }

    public int getTorque()
    {
        return torque;
    }

    public void setTorque(final int torque)
    {
        this.torque = torque;
    }

    public int getTrunkVolume()
    {
        return trunkVolume;
    }

    public void setTrunkVolume(final int trunkVolume)
    {
        this.trunkVolume = trunkVolume;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(final BigDecimal price)
    {
        this.price = price;
    }
	
	@Id
	@Column(name = Constants.CarFields.ID, length = Constants.CarFields.ID_LENGTH, nullable = Constants.Nullable.NO)
	private String registrationNumber;
	@ManyToOne
	@JoinColumn(name = Constants.CarFields.USER_ID, nullable = Constants.Nullable.NO)
	private User user;
	@Column(name = Constants.CarFields.BRAND, nullable = Constants.Nullable.NO, length = 255)
	private String brand;
	@Column(name = Constants.CarFields.MODEL, nullable = Constants.Nullable.NO, length = 255)
	private String model;
	@Column(name = Constants.CarFields.COLOR, nullable = Constants.Nullable.NO)
	@Enumerated(EnumType.STRING)
	private Color color;
	@Column(name = Constants.CarFields.FABRICATION_YEAR, nullable = Constants.Nullable.NO)
	private int fabricationYear;
	@Column(name = Constants.CarFields.CYLINDRICAL_CAPACITY, nullable = Constants.Nullable.NO)
	private int cylindricalCapacity;
	@Column(name = Constants.CarFields.FUEL_TYPE, nullable = Constants.Nullable.NO)
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	@Column(name = Constants.CarFields.POWER, nullable = Constants.Nullable.NO)
	private int power;
	@Column(name = Constants.CarFields.TORQUE, nullable = Constants.Nullable.NO)
	private int torque;
	@Column(name = Constants.CarFields.TRUNK_VOLUME, nullable = Constants.Nullable.NO)
	private int trunkVolume;
	@Column(name = Constants.CarFields.PRICE, precision = 10, scale = 2, nullable = Constants.Nullable.NO)
	private BigDecimal price;
}