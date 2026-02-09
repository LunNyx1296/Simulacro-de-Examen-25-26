package principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorFicheros {

    public static void guardarMotores(List<Motor> motores, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Motor m : motores) {
                bw.write(m.getMarca() + ";" + m.getReparaciones().size());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }
}
