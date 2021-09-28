/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventura_Marvel;
//funcion para generar cartones

import java.util.Scanner;

/**
 *
 * @author Alumno5
 */
public class Sergio_programasIniciales {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean salir=false;
        
        Rifa rifa = new Rifa();
        Aventura aventura = new Aventura();
        
        
        do {
            System.out.println("Elige entre rifa (1), aventura(2), (3) salir");
            int opcion=sc.nextInt();
            //int opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1: 
                    rifa.IniciarRifa();
                    
                    break;
                case 2: 
                	//aventura.IniciarAventura();
                    break;
                case 3: 
                    salir=true;
                    break;
                default:
                    System.out.println("Elija una opcion correcta");
                    break;
            }
        } while (!salir);
        
        
    }
    
}
