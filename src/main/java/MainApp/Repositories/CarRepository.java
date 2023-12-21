package MainApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import MainApp.Model.Car.Car;

public interface CarRepository extends JpaRepository<Car, String>
{
	List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByCylindricalCapacity(Integer cylindricalCapacity);
    @Query("SELECT DISTINCT c.brand FROM Car c")
    List<String> findDistinctBrands();
    @Query("SELECT DISTINCT c.model FROM Car c")
    List<String> findDistinctModels();
    @Query("SELECT DISTINCT c.cylindricalCapacity FROM Car c")
    List<Integer> findDistinctCylindricalCapacities();
    @Query("SELECT c FROM Car c WHERE " +
            "(:brand IS NULL OR c.brand = :brand) AND " +
            "(:model IS NULL OR c.model = :model) AND " +
            "(:cylindricalCapacity IS NULL OR c.cylindricalCapacity = :cylindricalCapacity)")
    List<Car> findByBrandAndModelAndCylindricalCapacity(String brand, String model, Integer cylindricalCapacity);
}