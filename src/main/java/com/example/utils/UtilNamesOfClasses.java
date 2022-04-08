package com.java.example.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UtilNamesOfClasses {

    public static List<String> fileNames(String directoryName) {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        String name = "";
        List<String> list = new ArrayList<>();

        for (File f : fList) {
            if (f.isFile()) {
                name = f.getName();
                name = name.substring(0, name.length() - 5);
                list.add(name);
            } else if (f.isDirectory()) {
                // recursion for sub-directories
                fileNames(directoryName);
            }
        }
        return list;
    }


}
