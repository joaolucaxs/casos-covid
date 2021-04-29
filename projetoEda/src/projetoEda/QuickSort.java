
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class QuickSort {

    static void swap(String matriz[][], int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        for(int k = 0; k<16; k++){
            String temp1 = matriz[i][k];
            matriz[i][k] = matriz[j][k];
            matriz[j][k] = temp1;
        }
    }

    static int partition(String matriz[][], int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swap(matriz,arr, i, j);
            }
        }
        swap(matriz,arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(String matriz[][], int arr[], int low, int high) {
        
        
        if (low < high) {

            int pi = partition(matriz, arr, low, high);

            quickSort(matriz,arr, low, pi - 1);
            quickSort(matriz,arr, pi + 1, high);
        }
    }

    static void printArray(String matriz[][], int[] arr, int size) {
    
        for (int k=0;k<size;k++){
            
                for(int j=0;j<16;j++){
                    System.out.printf(matriz[k][j]+ "  ");
                }
                System.out.println("\n");
            }
        System.out.println();
    }

    public static void main(String[] args) {

        try (FileInputStream inputStream1 = new FileInputStream("C:\\Users\\JOAO-LUCAS\\Desktop\\PLANILHA FEITA\\planilhaislast.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            sc1.nextLine();

            String matriz[][] = new String[5616][16];
            String[] lista = new String[16];
            while (sc1.hasNext()) {
                //cont++;
                String line = sc1.nextLine();
                lista = line.split(",");
                matriz[cont] = lista;
                cont++;
            }
         
            int listaInt[] = new int[5616];
            for (int i = 1; i < cont; i++) {
                listaInt[i] = Integer.parseInt(matriz[i][10]);
               
            }
            
            int tamanho = listaInt.length;
            quickSort(matriz, listaInt, 1, tamanho - 1);

            try (FileOutputStream gerador = new FileOutputStream("qSort_ordena_obitos.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
            ) {
                PrintStream pr = new PrintStream(gerador); // AQUI UTILIZO O OBJETO PRINTSTREAM
                for (int k=0;k<listaInt.length;k++){
                    
                    for(int j=0;j<16;j++){
                        pr.print(matriz[k][j]+",");
                    }
                    pr.print("\n");
                }   pr.close(); // FECHAR
                // FECHAR
            } // AQUI UTILIZO O OBJETO PRINTSTREAM
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
