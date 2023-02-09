package racingcar.domain.carfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.carrepository.CarRepository;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @ParameterizedTest
    @MethodSource("getCarNames")
    void createCarRepository(List<String> carNames) {
        CarRepository carRepository = carFactory.createCarRepository(carNames);

        assertThat(carRepository).isInstanceOf(CarRepository.class);
    }

    static Stream<Arguments> getCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("poy", "joy", "kane"))
        );
    }
}