package com.sofka.dicionario;

import java.util.Scanner;

public class Reader {
    private static final Scanner reader = new Scanner(System.in);

    public static Scanner get() {
        return reader;
    }

    public static void close() {
        reader.close();
    }
}
