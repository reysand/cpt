public class	Palindrome {
	public static void		main(String[] args) {
		for (int i = 0; i < args.length; ++i) {
			String s = args[i];
			System.out.println(isPalindrome(s));
		}
	}

	/*
	** Checks if the given string is palindrome.
	*/
	public static boolean	isPalindrome(String s) {
		String rev = reverseString(s);

		return s.equals(rev);
	}

	/*
	** Get an inverted string
	*/
	public static String	reverseString(String s) {
		StringBuilder rev = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; --i) {
			rev.append(s.charAt(i));
		}
		return rev.toString();
	}
}
