/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.util.ArrayList;

/**
 *
 * @author cesar
 */

public class Tree {

    public int tall = 0;
    
    //Aqui delvemos la altura del árbol
    public int retornaT(Nodo nodo) {
        tall = 0;
        altura(nodo, 1);
        return tall;
    }

    private void altura(Nodo rr, int nivel) {
        if (rr != null) {
            altura(rr.izquierda, nivel + 1);
            if (nivel > tall) {
                tall = nivel;
            }
            altura(rr.derecha, nivel + 1);
        }
    }
    String[] n$;
    public ArrayList level1(Nodo nodo) {
        n$ = new String[retornaT(nodo) + 1];
        ArrayList array = new ArrayList();
        level(nodo, 0);
        for (int i = 0; i < n$.length; i++) {
            array.add(n$[i] + " ");
        }
        return array;
    }

    //Almacenamos en un array
    public void level(Nodo pv, int nn) {
        if (pv != null) {
            n$[nn] = pv.dato + ", " + ((n$[nn] != null) ? n$[nn] : "");
            level(pv.derecha, nn + 1);
            level(pv.izquierda, nn + 1);
        }
    }

//retornamos los valores
    public String rc(ArrayList arr, String message) {
        int i = 0;
        String r = message + 
                "\n";
        while (i < arr.size()) {
            r += "\n" + arr.get(i).toString();
            i++;
        }
        return (r);
    }

}
