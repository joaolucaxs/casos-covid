package projetoEda;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int arr[], int low, int high) {
        System.out.println("Entrou no quicksort");
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {
    	int i = 0;
    	
    	
        try(FileInputStream csvFile = new FileInputStream("C:\\Users\\Elioenai Roberto\\Desktop\\projeto leda\\caso.csv")) {
        	Scanner scr = new Scanner(csvFile);
        	String fileLine = new String();
        	String[] newList = new String[5616];
        	Casos[] caso = new Casos[5616];

            scr.nextLine();
            
            while (scr.hasNext()) {
            	//recebe cada linha do arquivo
                fileLine = scr.nextLine();
                
                //separa os campos entre as virgulas de cada linha
                String[] valoresEntreVirgulas = fileLine.split(",");
                
                //imprime a coluna is_last se for true
                if(valoresEntreVirgulas[7].equals("True")) {
                	newList[i] = fileLine;
                	i++;
                	//System.out.println(i + " " + newList[i-1]);
                }
            }
            
            
            String newListLine = newList[0];
            String [] valoresEntreVirgulas1;
            
            for(int z = 0; z < caso.length; z++) {
            	newListLine = newList[z];
            	valoresEntreVirgulas1 = newListLine.split(",");
            
            	caso[z] = new Casos();
            	
            	caso[z].setDate(valoresEntreVirgulas1[0]);
            	caso[z].setState(valoresEntreVirgulas1[1]);
            	caso[z].setCity(valoresEntreVirgulas1[2]);
            	caso[z].setPlaceType(valoresEntreVirgulas1[3]);
            	caso[z].setConfirmed(valoresEntreVirgulas1[4]);
            	caso[z].setDeaths(valoresEntreVirgulas1[5]);
            	caso[z].setOrderForPlace(valoresEntreVirgulas1[6]);
            	caso[z].setIsLast(valoresEntreVirgulas1[7]);
            	System.out.println(caso[z].toString());
            	System.out.println("oxe: "+valoresEntreVirgulas1[8]);
            	caso[z].setEstimatedPop(valoresEntreVirgulas1[8]);
            	caso[z].setEstimatedPopNow(valoresEntreVirgulas1[9]);
            	caso[z].setCityIbgeCode(valoresEntreVirgulas1[10]);
            	caso[z].setConfirmedHundred(valoresEntreVirgulas1[11]);
            	caso[z].setDeathRate(valoresEntreVirgulas1[12]);
            	caso[z].toString();
            }
            /*
            System.out.println(newList[0]);
            System.out.println(valoresEntreVirgulas1[6]);
            */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
    }
    
}
}