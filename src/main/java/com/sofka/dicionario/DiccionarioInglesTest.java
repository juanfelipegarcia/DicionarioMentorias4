package com.sofka.dicionario;

public class DiccionarioInglesTest {
    public static void main(String[] args) {
        DiccionarioIngles diccionarioIngles = new DiccionarioIngles();
        short opcion = Menu.show();

        do{
            switch (opcion){
                case 1: diccionarioIngles.adjuntarPalabra(); break;
                case 2: diccionarioIngles.listarContenido();break;
                case 3: diccionarioIngles.buscarPalabra();break;
                case 4: Reader.close(); System.exit(0);
            }
            System.out.println();
            opcion = Menu.show();
        }while (opcion !=4);
    }
}
