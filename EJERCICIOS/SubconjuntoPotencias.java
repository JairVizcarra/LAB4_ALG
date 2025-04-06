/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJE1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 *
 * @author USUARIO
 */
public class SubconjuntoPotencias {
    public static boolean esPotenciaDe2(int n) {
        return (n & (n - 1)) == 0;
    }
    public static boolean puedeFormarSuma(int[] arr, int objetivo) {
        int n = arr[0];
        int[] numeros = Arrays.copyOfRange(arr, 1, n + 1);
        boolean[] obligatorios = new boolean[n];
        List<Integer> obligatoriosIncluidos = new ArrayList<>();
        List<Integer> elegibles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = numeros[i];

            if (esPotenciaDe2(num)) {
                obligatorios[i] = true;
                obligatoriosIncluidos.add(num);
            } else if (num % 5 == 0 && i + 1 < n && numeros[i + 1] % 2 != 0) {
                continue; // se salta este número porque la regla 2 lo impide
            } else {
                elegibles.add(num);
            }
        }

        int sumaObligatoria = obligatoriosIncluidos.stream().mapToInt(Integer::intValue).sum();
        int restante = objetivo - sumaObligatoria;

        if (restante < 0) return false;
        return puedeSumar(elegibles, restante);
    }

    private static boolean puedeSumar(List<Integer> nums, int objetivo) {
        int n = nums.size();
        boolean[][] dp = new boolean[n + 1][objetivo + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            int num = nums.get(i - 1);
            for (int j = 1; j <= objetivo; j++) {
                if (j >= num)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][objetivo];
    }

    public static void main(String[] args) {
        int[][] entradas = {
            {5, 4, 8, 10, 3, 5, 27},
            {5, 4, 8, 10, 3, 6, 27},
            {6, 2, 16, 7, 10, 3, 5, 33},
            {6, 2, 16, 5, 10, 3, 13, 33},
            {6, 2, 5, 1, 6, 13, 7, 26}
        };

        for (int[] entrada : entradas) {
            int objetivo = entrada[entrada[0] + 1]; //Ultimo valor
            boolean resultado = puedeFormarSuma(entrada, objetivo);
            System.out.println("Entrada: " + Arrays.toString(entrada) + " => Resultado: " + resultado);
        }
    }
}
