package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final Game game = null;
    private List<Car> cars;

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

    public void start() {
        inputCarNames();
    }

}
