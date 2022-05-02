import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        String estadoInicial = "";
        String estadoFinal = "";
        String[] automatosParaTestar = {};
        ArrayList<Transicao> matrizDeTransicoes = new ArrayList<Transicao>();
        
        try {
            File myObj = new File("./entrada.txt");
            Scanner myReader = new Scanner(myObj);

            System.out.println("\n-----------------------------  leitura do arquivo -----------------------------\n");


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
                            estadoInicial = valor.trim();
                            break;
                        case "-f":
                            estadoFinal = valor.trim();
                            break;
                        case "-t":
                            String[] str = valor.split(" "); 
                            Transicao novaTransicao = new Transicao(str[0], str[1], str[2]);
                            matrizDeTransicoes.add(novaTransicao);
                        break;
                        case "-r":
                            automatosParaTestar = valor.split(" ");
                        break;
                        default:
                            System.out.println("Linha sem significado para o programa> " + data);
                        }
                }
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        System.out.println("\n-----------------------------  definições do autômato -----------------------------\n");
            System.out.println("Alfabeto => " + toString(alfabeto));
            System.out.println("Estados => " + toString(estados));
            System.out.println("Estado inicial => " + estadoInicial);
            System.out.println("Estado final => " + estadoFinal);
            System.out.println("Matriz => " + matrizDeTransicoes.toString() + "\n");
    
        System.out.println("\n-----------------------------  rodando o autômato -----------------------------\n");
        

        for (int i=0; i < automatosParaTestar.length; i++) {
            System.out.println("Simulando o automato => " + automatosParaTestar[i] + "\n");

            for(int j=0; j < automatosParaTestar[i].strip().length(); j++) {
                String valorPassoAtual = automatosParaTestar[i].substring(j, j+1);
                String estadoAtual = "";
                System.out.println("\t" + valorPassoAtual);

                for (Transicao transicao : matrizDeTransicoes) {
                    // tratar o passo inicial
                    if (i == 0 && transicao.getOrigem() == estadoInicial) {
                        estadoAtual = transicao.getOrigem();
                    } else if (true) {


                    }
                }
            }
        }
    }

    public static String toString(String[] lista) {
        String listaString = "[ ";
        for (int i=0; i < lista.length; i++) {
            listaString+= lista[i] + ", ";
        }

        listaString += "]";

        return listaString;
    }
}
