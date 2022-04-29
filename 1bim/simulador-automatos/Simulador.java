import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
        automato.txt
        0 1   # o alfabeto
        q0 q1 # os estados
        q0    # estado inicial
        q1    # estados finais
        q0 q1 # matriz
        q1 q0


        entradas.txt
        0 1 0 1 1 1 0 0 # sequencia 1
        0 1 0 1 1 1 0 0 # sequencia 2
        0 1 0 1 1 1 0 0 # sequencia 3

        saida.txt
        RECUSADO # resultado da sequencia 1
        ACEITE   # resultado da sequencia 2
        ACEITE   # resultado da sequencia 3
*/

public class Simulador {
    public static void main(String[] args) {
        String[] alfabeto = {};
        String[] estados = {};
        String estadoInicial;
        String estadoFinal;
        String[] matriz;

        Transicao[] matrizDeTransicoes = {};
        
        try {
            File myObj = new File("./entrada.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.length() > 0) {
                    String significado = data.substring(0, 2);
                    String valor = data.substring(3, data.length() - 1);
                    switch (significado) {
                        case "-a": 
                            alfabeto = valor.split(" ");
                            break;
                        case "-e":
                            estados =  valor.split(" ");
                            break;
                        case "-i":
                            estadoInicial = valor;
                            break;
                        case "-f":
                            estadoFinal = valor;
                            break;
                        case "-t":
                            matriz =  valor.split(" ");
                        break;
                        default:
                            System.out.println("Linha sem significado para o programa> " + data);
                        }
                }
            }
            for (int i=0; i < alfabeto.length; i++) {
                System.out.println("alfabeto> " + alfabeto[i]);
            }

            myReader.close();

          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
}