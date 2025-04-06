/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJE3;

import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class QuickSelect {
    public static int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);
    }
    
    private static int quickSelectHelper(int[] arr, int left, int right, int k) {
        if (left == right) { //si solo queda un elemento
            return arr[left];
        }

        // Escoge pivote aleatoriamente
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k]; //Si el pivote está en la posición k
        } else if (k < pivotIndex) { //Si k está a la izquierda del pivote, buscamos en la mitad izquierda
            return quickSelectHelper(arr, left, pivotIndex - 1, k);
        } else { //Si k está a la derecha del pivote, buscamos en la mitad derecha
            return quickSelectHelper(arr, pivotIndex + 1, right, k);
        }
    }
    
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        // Mover pivote al final
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {  //Reordenar los elementos menores al pivote a la izquierda
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        // Mover pivote a su lugar final
        swap(arr, right, storeIndex);
        return storeIndex;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 7, 10, 4, 17};
        System.out.println(quickSelect(arr1, 3)); // Salida esperada: 4

        int[] arr2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println(quickSelect(arr2, 5)); // Salida esperada: 6

        int[] arr3 = {4, 2, 7, 1, 4, 6};
        System.out.println(quickSelect(arr3, 1)); // Salida esperada: 1

        int[] arr4 = {9, 2, 7, 1, 7};
        System.out.println(quickSelect(arr4, 4)); // Salida esperada: 7
    }
    
}
