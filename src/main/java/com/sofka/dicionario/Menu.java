package com.sofka.dicionario;

import java.util.Scanner;

public class Menu {
    public static byte show() {
        byte opcion = 0;
        try  {
            Scanner entrada = Reader.get();
            do {
                System.out.println("***************************************");
                System.out.println("|           Elegir opción             |");
                System.out.println("|                                     |");
                System.out.println("| 1. Adjuntar palabra al Dicionario   |");
                System.out.println("| 2. Mostrar Palabras del dicionario  |");
                System.out.println("| 3. Buscar traduccion palabra        |");
                System.out.println("| 4. Salir                            |");
                System.out.println("|                                     |");
                System.out.println("***************************************");
                opcion = entrada.nextByte();
                entrada.nextLine();
                if(opcion < 1 || opcion > 4) {
                    System.out.println("Opción inválida");
                }
            } while (opcion < 1 || opcion > 4);
        } catch(NumberFormatException e) {
            System.out.println("Opción inválida");
            Menu.show();
        }
        return opcion;
    }
}
