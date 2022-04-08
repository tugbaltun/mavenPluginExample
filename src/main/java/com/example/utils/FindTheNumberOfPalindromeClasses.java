package com.java.example.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class FindTheNumberOfPalindromeClasses {

    private List<String> list=new ArrayList<>();
    private int numberOfClasses;
    private int numberOfPalindromeClasses;
    private String palindromeWord;

    public FindTheNumberOfPalindromeClasses(String path) {
        this.list = UtilNamesOfClasses.fileNames(path);
        this.numberOfClasses = list.size();
        this.numberOfPalindromeClasses= findPalindromeClasses();
    }

    // Returning number of palindrome classes
    private int findPalindromeClasses()  {
        int counter = 0;
        for(String name:list){
            if(isPalindrome(name))
                counter++;
        }
        return counter;
    }

    // Returning true if string is palindrome
    static boolean isPalindrome(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        str = str.toLowerCase();
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}
