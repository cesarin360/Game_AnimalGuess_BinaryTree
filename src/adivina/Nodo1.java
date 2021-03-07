/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author cesar
 */
public class Nodo1 {
    //Construye el arbol a partir de lo que hay en el archivo de texto
     public Nodo desNodo(String filename) {
		Nodo add = null;
                    //crea el nodo
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {
			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			add = (Nodo) ois.readObject();
                        //escribe cada linea del archivo, y crea un nodo nuevo con esos datos.

		} catch (Exception ex) {
                    System.out.println("$Error. "+ex.getMessage());
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
                                    System.out.println("Error. "+ e.getMessage());
                                    e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
			              System.out.println("Error. "+e.getMessage());
                                      e.printStackTrace();
				}
			}

		}

		return add;

	}
}
