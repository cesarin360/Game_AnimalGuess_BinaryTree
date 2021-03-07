package adivina;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *
 * @author cesar
 */

public class Nodo2 {
    public void itNodo(Nodo nodo) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream("C:\\Users\\josue\\Desktop\\Universidad\\5to. ciclo\\Programación III\\ProyectoArbol\\datos.txt");
                        //Se crea el archivo  
			oos = new ObjectOutputStream(fout);
			oos.writeObject(nodo);
                        fout.close();
			System.out.println("Listo:::");

		} catch (Exception ex) {
                    
	               System.out.println("Error. "+ex.getMessage()); 
                       ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
