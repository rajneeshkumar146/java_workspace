package DynamicProgramming.Intermediate_Problems;

public class Minimum_Cost_To_Make_Two_Strings_Identical {

	public static void main(String[] args) {
		System.out.println(MinCost("abcd", 10, "acdb", 20));
	}

	public static int lcss(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}

			}

		}
		return strg[0][0];
	}

	public static int MinCost(String s1, int costX, String s2, int costY) {
		int lcss=lcss(s1, s2);
		
		int cos1=costX*(s1.length()-lcss);
		int cos2=costY*(s2.length()-lcss);
		return cos1+cos2;
	}

}
