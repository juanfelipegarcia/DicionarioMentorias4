package com.sofka.dicionario;

import java.io.*;
import java.util.Scanner;

public class DiccionarioIngles {

    public void adjuntarPalabra(){
        try{
            Scanner sc = new Scanner(System.in);
            String palabra = "";
            String significado = "";
            String dato= "";
            int cant=0;
            int cont=0;
            FileWriter fw = new FileWriter("diccionario.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println("***************************************");
            System.out.println("|                                     |");
            System.out.println("|  Digita la cantidad de palabras que |");
            System.out.println("|  quieras agregar al Diccionario     |");
            System.out.println("|                                     |");
            System.out.println("***************************************");
            cant=sc.nextInt();
            while (cont<cant){
                System.out.println("***************************************");
                System.out.println("|                                     |");
                System.out.println("|  Digita la palabra en Español       |");
                System.out.println("|                                     |");
                System.out.println("***************************************");
                palabra=sc.next();
                System.out.println("***************************************");
                System.out.println("|                                     |");
                System.out.println("|   Digita El significado de la       |");
                System.out.println("|   palabra en Ingles                 |");
                System.out.println("|                                     |");
                System.out.println("***************************************");
                significado=sc.next();

                palabra=palabra.toLowerCase();
                significado=significado.toLowerCase();
                dato = palabra.concat(" "+significado);

                if (palabra != null && significado !=null){
                    pw.println(dato);
                    cont++;
                }else{
                    System.out.println("Falta por ingresar la palabra, el significado o ambos");
                }
                pw.flush();

            }
            pw.close();

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());

        }

    }

    public void listarContenido(){
        System.out.println("***************************************");
        try{
            File fl = new File("diccionario.txt");
            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            String lectura = br.readLine();
            while (lectura!=null){
                System.out.println("|  "+lectura);
                lectura = br.readLine();
            }
            try{
                if (null!=fr){
                    fr.close();
                }
            }catch (Exception e){
                System.out.println("Error: "+e.getMessage());
            }

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("***************************************");
    }

    public void buscarPalabra(){
        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("|                                     |");
        System.out.println("|     Digita Palabra a traducir:      |");
        System.out.println("|                                     |");
        System.out.println("***************************************");
        String texto = sc.nextLine();
        texto = texto.toLowerCase();

        try {
            File f = new File("diccionario.txt");
            entrada = new Scanner(f);
            //System.out.println("Archivo: " + f.getName());
            //System.out.println("Palabra a traducir: " + texto);
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                if (linea.contains(texto)) {
                    String[] separacionPalabra = new String[2];
                    separacionPalabra = linea.split(" ");
                    System.out.println("***************************************");
                    System.out.println("La traducion es: " + separacionPalabra[1]);
                    contiene = true;
                    System.out.println("***************************************");
                }
                numeroDeLinea++;
            }
            if(!contiene){
                System.out.println(texto + " no se ha encontrado en el Diccionario");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }

    }
}
