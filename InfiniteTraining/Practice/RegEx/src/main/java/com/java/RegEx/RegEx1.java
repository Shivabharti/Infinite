package com.java.RegEx;

import java.util.regex.Pattern;

public class RegEx1 {

	public static void main(String[] args) {
		System.out.println(Pattern.matches(".h", "ch"));
		System.out.println(Pattern.matches("..f..i..", "infinite"));
		System.out.println(Pattern.matches("[aeiou]", "a"));
		System.out.println(Pattern.matches("[aeiou]", "s"));
		//write a program contains 2 words starts with pqr and next char is vowel
		System.out.println(Pattern.matches("[^aeiou]", "a"));
		System.out.println(Pattern.matches("[^aeiou]", "z"));
		System.out.println(Pattern.matches("[abcd]", "abccddd"));
		System.out.println(Pattern.matches("[a-zA-Z]+", "Prasanna"));
		System.out.println(Pattern.matches("[a-zA-Z]+", "Prasanna1234"));
		
		//Validate mobile number
		
		System.out.println(Pattern.matches("[0-9]{10}", "1234567890"));
		System.out.println(Pattern.matches("[0-9]{10}", "54372547"));
		System.out.println(Pattern.matches("[0-9]{10}", "ABCD6754"));
//		System.out.println(Pattern.matches("[0-9]{4}\s[0-9]{4}\s[0-9]{4}", "1216521635435"));
//		System.out.println(Pattern.matches("[0-9]{4}\s[0-9]{4}\s[0-9]{4}", "123 123 123"));
		
		System.out.println(Pattern.matches("[+][9][1]-[0-9]{10}", "+91-1234567890"));
		System.out.println(Pattern.matches("\\d{5}", "53452")); //for digits
		System.out.println(Pattern.matches("\\D+", "763256534")); //for non digit
		System.out.println(Pattern.matches("\\D+", "ABCD@#$$%"));
		System.out.println(Pattern.matches("\\S+", "dghs hgdsh")); //for non spaces
		System.out.println(Pattern.matches("\\S+", "dhgshfd"));
		String regex= "^(?=.*[0-9])"
				+"(?=.*[a-z])"
				+"(?=.*[A-Z])"
				+"(?=.*[@#$%^&*_+-=])"
				+"(?=\\S+$).{8,20}";
		System.out.println(Pattern.matches(regex, "@Shivangi1!"));
	}
}
