package com.main;

public class PromotionWinner {

	public static void main(String[] args) {
		String[][] codeList = { { "apple", "apple" }, { "banana", "anything", "banana" } };
		String[] shoppingcart = { "orange", "apple", "apple", "banana", "banana", "orange", "banana" };
		System.out.println(findWinner(codeList, shoppingcart));
	}

	private static int findWinner(String[][] codeList, String[] shoppingcart) {

		if (codeList == null || codeList.length == 0)
			return 1;
		if (shoppingcart == null || codeList.length == 0)
			return 0;

		int i = 0, j = 0;

		while (i < codeList.length && j + codeList[i].length <= shoppingcart.length) {
			boolean match = true;

			for (int k = 0; k < codeList[i].length; k++) {
				if (!codeList[i][k].equals("anything") && !shoppingcart[j + k].equals(codeList[i][k])) {
					match = false;
					break;
				}
			}

			if (match) {
				j += codeList[i].length;
				i++;
			} else {
				j++;
			}
		}

		return (i == codeList.length) ? 1 : 0;
	}

}
