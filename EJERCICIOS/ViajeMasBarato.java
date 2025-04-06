/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJE2;

/**
 *
 * @author USUARIO
 */
public class ViajeMasBarato {
    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        
        // Inicializar la matriz de costos mínimos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0;
                } else if (i < j) {
                    C[i][j] = T[i][j]; // Costo directo inicial
                } else {
                    C[i][j] = Integer.MAX_VALUE; // No se puede ir río arriba
                }
            }
        }
        
        //programación dinámica
        for (int l = 2; l <= n; l++) { // l es la longitud del recorrido
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i + 1; k < j; k++) {
                    if (C[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        int costoViaK = C[i][k] + C[k][j];
                        if (costoViaK < C[i][j]) {
                            C[i][j] = costoViaK;
                        }
                    }
                }
                // Comparar con el costo directo
            }
        }
        
        return C;
    }
    
    public static void main(String[] args) {
        
        int[][] T = {
            {0, 5, 10, 20},    // Desde 0
            {0, 0, 3, 15},       // Desde 1
            {0, 0, 0, 5},        // Desde 2
            {0, 0, 0, 0}         // Desde 3
        };
        
        int[][] costosMinimos = calcularCostosMinimos(T);
        
        
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < costosMinimos.length; i++) {
            for (int j = 0; j < costosMinimos[i].length; j++) {
                if (i <= j) {
                    System.out.print(costosMinimos[i][j] + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
        
        
        System.out.println("\nCosto mínimo de 0 a 3: " + costosMinimos[0][3]);
    }
}
