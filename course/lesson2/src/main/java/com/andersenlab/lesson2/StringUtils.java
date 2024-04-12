package com.andersenlab.lesson2;

public final class StringUtils {

  public static boolean isBlank(String input) {
    return input == null || input.trim().isEmpty();
  }

  public static boolean isPalindrome(String input) {
    return new StringBuilder(input).reverse().toString().equals(input);
  }

}
