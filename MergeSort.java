package mergesort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class MergeSort {

    void merge(String matriz[][], int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        String matrizL[][] = new String[n1][16];
        String matrizR[][] = new String[n2][16];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            for (int k = 0; k < 16; k++) {
                matrizL[i][k] = matriz[l + i][k];
            }
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            for (int p = 0; p < 16; p++) {
                matrizR[j][p] = matriz[m + 1 + j][p];
            }
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                for (int q = 0; q < 16; q++) {
                    matriz[k][q] = matrizL[i][q];
                }
                i++;

            } else {
                arr[k] = R[j];
                for (int v = 0; v < 16; v++) {
                    matriz[k][v] = matrizR[j][v];
                }
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            for (int z = 0; z < 16; z++) {
                matriz[k][z] = matrizL[i][z];
            }
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            for (int t = 0; t < 16; t++) {
                matriz[k][t] = matrizR[j][t];
            }
            j++;
            k++;
        }
    }

    void sort(String matriz[][], int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(matriz, arr, l, m);
            sort(matriz, arr, m + 1, r);

            merge(matriz, arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) throws FileNotFoundException {

        try (FileInputStream inputStream1 = new FileInputStream("C:\\Users\\JOAO-LUCAS\\Desktop\\PLANILHA FEITA\\planilhaislast.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista = new String[16];
            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(",");
                matriz[cont] = lista;
                cont++;
            }

            int listaInt[] = new int[cont];
            for (int i = 1; i < cont; i++) {
                listaInt[i] = Integer.parseInt(matriz[i][10]);
            }

            MergeSort ob = new MergeSort();

            ob.sort(matriz, listaInt, 1, listaInt.length - 1);

            try (FileOutputStream gerador = new FileOutputStream("mergeSort_ordena_obitos.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
                    ) {
                PrintStream pr = new PrintStream(gerador); // AQUI UTILIZO O OBJETO PRINTSTREAM
                pr.print(matriz[0][0]);
                for (int k = 0; k < listaInt.length; k++) {
                    for (int j = 0; j < 16; j++) {
                        pr.print(matriz[k][j] + ",");
                    }
                    pr.print("\n");
                }
                pr.close(); // FECHAR
            }

        } catch (IOException e) {
        }

    }
}
