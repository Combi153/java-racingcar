package racingcar.domain.cars;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int MINIMUM_SIZE = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validate(List<Car> cars) {
        if (isOutOfSize(cars)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
        }
        if (hasDuplication(cars)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isOutOfSize(List<Car> cars) {
        return cars.size() < MINIMUM_SIZE;
    }

    private boolean hasDuplication(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public void moveBy(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}