/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author josue
 */
public class menu {

    public static Nodo root;
    private Scanner s;
    static Nodo2 a = new Nodo2();
    /**
     * Constructor Crea el nodo raiz con un Perro
     */
   public menu() {
        root = new Nodo("Elefante");  //El arbol se iniciará con un animal
        Nodo1 n = new Nodo1();
        root = n.desNodo("C:\\Users\\josue\\Desktop\\Universidad\\5to. ciclo\\Programación III\\ProyectoArbol\\datos.txt");
        s = new Scanner(System.in); //Scanner para pedir que ingresen los animales
    }
    public void game() {
        char resp = ' ';
        String c;
        boolean z, loop = true;
        BufferedReader type = new BufferedReader(
                new InputStreamReader(System.in));

        while (loop) {
            System.out.println("Si desea salir, por favor presione 'S'- ");
            try {
                do {
                    System.out.println("\t\t A - Empezar el juego -");
                    System.out.println("\t\t R - Ver Arbol -");
                    System.out.println("\t\t ___________________.");
                    c = type.readLine();
                    resp = c.charAt(0);
                    resp = Character.toUpperCase(resp);
                    z = ((c.length() == 1) && (resp == 'A' || resp == 'R'));
                } while (!z);

                if (resp == 'A') {

                    System.out.println("VAMOS ADIVINAR TU ANIMAL!!!");
                    boolean R = true;
                    do {

                        jugar();
                        System.out.println("Jugamos otra vez?");
                        R = respuesta();
                    } while (R);

                }
                if (resp == 'R') {
                    Nodo1 d = new Nodo1();
                    Nodo nodo = d.desNodo("C:\\Users\\josue\\Desktop\\Universidad\\5to. ciclo\\Programación III\\ProyectoArbol\\datos.txt");
                    System.out.println("----");
                    Tree a = new Tree();
                    System.out.println(a.rc(a.level1(nodo), "ARBOL BINARIO"));
                    System.out.println("----");
                }
                

            } catch (Exception e) {
                
                System.out.println(" Error. "+e.getMessage());
            }
            loop = !(resp == 'S');
        }
        System.out.println(":::::::::::::::");

    }
     
    private boolean respuesta() {

        while (true) {
            System.out.println("-. ");
            String resp = s.nextLine().toLowerCase().trim();
            if (resp.equals("si")) return true;
            if (resp.equals("no")) return false;
            System.out.println("La respuesta debe ser si o no");
        }
    }

    public void jugar() {
        System.out.println("\n");
        Nodo nodo = root;
        Tree m = new Tree();
        //System.out.println(m.rc(m.level1(nodo), "ARBOL BINARIO"));
        System.out.println(":::::::::::::::");
        while (nodo != null) {

            if (nodo.izquierda != null) {   
                System.out.println(nodo.dato); 
                
                nodo = (respuesta()) ? nodo.izquierda : nodo.derecha; 
            } else {  
                System.out.println("-. Ya sé, es un(a) " + nodo.dato);  
                if (respuesta()) {
                    
                    System.out.println("-. Al parecer Gane :) ");
                } else {
                    animalNuevo(nodo);
                }
                
                a.itNodo(root);
                
                return;
            }
        }
    }

    public void visualizar(Nodo nodo) {
        System.out.println(nodo.dato);
    }

    public void desplegar(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato.toString() + " ");
            desplegar(raiz.izquierda);
            desplegar(raiz.derecha);
        }
    }

   //Ingresamos un nuevo animal
    private void animalNuevo(Nodo nodo) {
        String animalNodo = (String) nodo.dato; //jala al animal de las patas 
        System.out.println("-. ¿Como se llama tu animal?");
        String nuevoA = s.nextLine(); 
        System.out.println("-. Qué pregunta con respuesta si/no puedo hacer" + " para poder decir que es un(a) " + nuevoA);
        String pregunta = s.nextLine(); 
        Nodo nodo1 = new Nodo(animalNodo); 
        Nodo nodo2 = new Nodo(nuevoA); 
        System.out.println("-. Para un(a) " + nuevoA + " la respuesta es si/no?");
        nodo.dato = "-. ¿" + pregunta + "?\n"; 
        System.out.println(":::::::::::::::");
        if (respuesta()) { 
            nodo.izquierda = nodo2; 
            nodo.derecha = nodo1; 

        } else {
            nodo.izquierda = nodo1; 
            nodo.derecha = nodo2; 
        }
        a.itNodo(nodo);
    }

}
