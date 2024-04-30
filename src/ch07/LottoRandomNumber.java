package ch07;

import java.util.Arrays;
import java.util.Random;

public class LottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;

	public int[] createNumber() {

		int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();

		for (int i = 0; i < lottoWinNum.length; i++) {
			lottoWinNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if(lottoWinNum[j] == lottoWinNum[i]) {
					i--;
				}
			}
		}
		Arrays.sort(lottoWinNum);//오름 차순 자동 정렬
		return lottoWinNum;
	}

	// 코드 테스트
	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();
		int[] resultArray = randomNumber.createNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}

}
