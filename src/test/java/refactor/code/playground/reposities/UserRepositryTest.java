package refactor.code.playground.reposities;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import refactor.code.playground.Application;
import refactor.code.playground.domain.Car;
import refactor.code.playground.domain.CarType;
import refactor.code.playground.mapper.CarMapper;
import refactor.code.playground.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"dev"})
public class UserRepositryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_findById() {
        System.out.println(userRepository.findById(1L));
    }


    @Test
    public void test_findAllSort() {
        userRepository.findAll(Sort.by("id").descending()).forEach(System.out::println);
    }

    @Test
    public void test_mapperParse() {
        Car car = Car.builder().make("make").carType(CarType.PO_CHE).numberOfSeats(4).build();
        System.out.println(CarMapper.INSTANCE.carToCarDto(car));
    }
}
