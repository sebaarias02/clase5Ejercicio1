/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censo;
import java.util.Scanner;
/**
 *
 * @author Seba y Mauro
 */
public class Censo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int num = 0;
    
    do{
    // Menu 
    System.out.println("\nMenu\n1-Funcion fecha\n2-Funcion edad\n3-Funcion nombre\n4-Funcion edades\n0-Salir\n"); 
    num = entrada.nextInt();
    
    switch(num){
    case 1: 
    int fecha = 0;
    do{
    System.out.println("\nIngrese fecha");
    fecha = entrada.nextInt();
    }while(fecha<1900 || fecha>2020); // Repetir si no se cumple la condicion
    
    System.out.println("\n"+decada(fecha));
    break;
    case 2: 
    int edad = 0;
    do{
    System.out.println("\nIngrese edad");
    edad = entrada.nextInt();
    }while(edad<=0 || edad>120);
    System.out.println("\n"+esMayor(edad));
    break;
    case 3: 
    String nombre;
    String apellido;
    boolean sw;
    do{
    sw = true;
    System.out.println("\nIngrese nombre");
    nombre = entrada.next();
    System.out.println("\nIngrese apellido");
    apellido = entrada.next();
    char nombre2[] = nombre.toCharArray();
    char apellido2[] = apellido.toCharArray();
    for(int i=0;i<nombre2.length;i++){
        if(Character.isDigit(nombre2[i])){
        sw = false;
        break;
        }
    }
    if(sw){
     for(int i=0;i<apellido2.length;i++){
        if(Character.isDigit(apellido2[i])){
        sw = false;
        break;
        }
    }
    }
    }while(nombre.length()>10 || apellido.length()>10 || sw==false);
    
    System.out.println("\n"+nombreCompleto(nombre,apellido));
    break;
    case 4: 
    int edades[];
    int i,j = 0;
    do{
    System.out.println("\nIngrese numero de edades a cargar");
    i = entrada.nextInt();
    }while(i<1 || i>100);
    edades = new int[i];
    while(i>j){
    System.out.println("Edad "+(j+1));
    edades[j] = entrada.nextInt();
    j++;
    }
    System.out.println("\n"+cantidadMayores(edades));
    break;
    }
        
    }while(num!=0);
   
    }

        public static int decada(int fecha){
        return (fecha % 100);
        }
        
        public static boolean esMayor(int edad){
        return edad >= 18;
        }

        public static String nombreCompleto(String nombre,String apellido){
        return nombre+" "+apellido;
        }
        
        public static int cantidadMayores(int edades[]){
        int cant = 0;
        for(int i=0;i<edades.length;i++){
        if(edades[i]>=18){
        cant++;
        }
        }
        return cant;
        }
}
