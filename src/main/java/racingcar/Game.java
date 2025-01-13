package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final Game game = null;
    private List<Car> cars;
    private int tryCount;

    private Game() {
    }

    public static Game getGame() {
        if (game == null) {
            return new Game();
        }
        return game;
    }

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = new ArrayList<>();
        try {
            String carNames = Console.readLine();
            StringTokenizer st = new StringTokenizer(carNames, ",");
            while (st.hasMoreTokens()) {
                String carName = st.nextToken();
                validateCarName(carName);
                cars.add(new Car(carName));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarNames();
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String tryCount = Console.readLine();
            validateTryCount(tryCount);
            this.tryCount = Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputTryCount();
        }
        System.out.println();
    }

    public void validateTryCount(String tryCount) {
        if (tryCount.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void moveCars() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            car.move();
        }
    }

    public void printCars() {
        for (Car car : cars) {
            car.printPosition();
        }
    }

    public void start() {
        inputCarNames();
        inputTryCount();
    }

}
