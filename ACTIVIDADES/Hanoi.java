/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class Hanoi {
    public static void main(String[] args){
        torresHanoi(3,1,2,3);
    }
    
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3){
        //CASO BASE
        if(discos == 1){
            System.out.println("Mover disco de torre "+torre1+" a torre "+torre3);
        }else{
            //DOMINIO(PROBLEMA -1)
            torresHanoi(discos-1,torre1,torre3,torre2);
            System.out.println("Mover disco de torre "+torre1+" a torre "+torre3);
            torresHanoi(discos -1,torre2,torre1,torre3);
        }
    }
}
