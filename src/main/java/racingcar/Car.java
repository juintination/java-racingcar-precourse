package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

}
