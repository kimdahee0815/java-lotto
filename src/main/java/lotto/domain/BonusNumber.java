package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class BonusNumber {
	private int bonusNumber = 0;

	public BonusNumber(String stringBonusNumber, List<Integer> inputNumbers) {
		validateBonusNumber(stringBonusNumber);

		bonusNoRepeat(inputNumbers);

		this.bonusNumber = Integer.parseInt(stringBonusNumber);
	}

	public void validateBonusNumber(String stringBonusNumber) {
		String pattern = "^[0-9]{1,2}$";

		if (!Pattern.matches(pattern, stringBonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
		}

		if (Integer.parseInt(stringBonusNumber) < 1 || Integer.parseInt(stringBonusNumber) > 45) {
			throw new IllegalArgumentException("[ERROR] 1-45사이의 입력하세요.");
		}
	}

	public void bonusNoRepeat(List<Integer> inputNumbers) {
		HashSet<Integer> inputNumbersSet = new HashSet<>();
		inputNumbersSet.addAll(inputNumbers);
		inputNumbersSet.add(bonusNumber);

		if (inputNumbersSet.size() != 7) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호가 입력된 당첨 번호 6개와 중복됩니다.");
		}
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}
}
