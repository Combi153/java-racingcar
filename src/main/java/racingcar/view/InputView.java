package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final OutputView outputView;

    public InputView(Scanner scanner, OutputView outputView) {
        this.scanner = scanner;
        this.outputView = outputView;
    }

    public List<String> readCars() {
        outputView.printNames();
        String line = scanner.nextLine();
        validateLine(line);
        String[] splitLine = line.split(",");
        return Arrays.asList(splitLine);
    }


    public int readGameRound() {
        outputView.printGameRoundGuide();
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    private void validateLine(String line) {
        isBlank(line);
        String format = "[a-zA-z][2]+";
    }

    private void isBlank(String line) {
        if (line.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }
}
