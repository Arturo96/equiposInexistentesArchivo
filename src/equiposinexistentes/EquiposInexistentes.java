package equiposinexistentes;

import java.io.*;

public class EquiposInexistentes {

    public static void main(String[] args) {
        
        String path = "C:\\archivosJava\\Equipos inexistentes.txt";
        
        File fileInput = new File(path);
        File fileOutput = new File("resultado.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(fileInput));
            String linea = entrada.readLine();
            
            PrintWriter salida = new PrintWriter(new FileWriter(fileOutput));
            while(linea != null) {
                if(linea.contains("Unable to resolve host")) {
                    salida.println(linea.substring(linea.indexOf("\"") + 1).replace("\"!", ""));
                }
                linea = entrada.readLine();
            }
            entrada.close();
            salida.close();
            System.out.println("Archivo creado exitosamente.");
        } catch (FileNotFoundException ex) {
            System.err.println("Error: Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo");
        }
        
    }
    
}
