package equiposinexistentes;

import java.io.*;
import java.util.*;

public class EquiposInexistentes {

    public static void main(String[] args) {
        
        // Modifica la dirección donde se encuentra el archivo
        
        String path = "C:\\archivosJava\\Equipos inexistentes.txt";
        
        File fileInput = new File(path);
        File fileOutput = new File("Equipos organizados.txt");
        
        List<String> equipos = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(fileInput));
            String linea = entrada.readLine();
            
            PrintWriter salida = new PrintWriter(new FileWriter(fileOutput));
            while(linea != null) {
                if(linea.contains("Unable to resolve host")) {
                    equipos.add(linea.substring(linea.indexOf("\"") + 1).replace("\"!", ""));
                }
                linea = entrada.readLine();
            }
            
            entrada.close();
            
            Collections.sort(equipos); // Organizamos la lista de equipos alfabéticamente
            
            for (String equipo : equipos) {
                salida.println(equipo); // Agregamos la lista de equipos al archivo
            }
            salida.close();
            System.out.println("Archivo creado exitosamente.");
        } catch (FileNotFoundException ex) {
            System.err.println("Error: Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo");
        }
        
    }
    
}
