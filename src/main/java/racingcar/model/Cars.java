package racingcar.model;

import racingcar.utils.RandomForwardJudgment;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forward() {
        for (Car car : cars) {
            car.forward(RandomForwardJudgment.canForward());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int farthestPosition = getFarthestPosition();

        for (Car car : cars) {
            addWinners(winners, farthestPosition, car);
        }
        return winners;
    }

    private void addWinners(List<String> winners, int farthestPosition, Car car) {
        if (car.isSamePositionWith(farthestPosition)) {
            winners.add(car.getName());
        }
    }

    private int getFarthestPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElse(-1);
    }
}