/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventura_Marvel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alumno5
 */
public class Rifa {
    Jugadores jugador= new Jugadores();
    int[] numerosPremiados =new int[5] ;
    ArrayList<Jugadores> baseDatos = new ArrayList<Jugadores>();
    int bote=0;
    int aciertosTotales=0;
    
    public Rifa() {//lo que programo aqui dentro se quedara por defecto
        //por ejemplo para generar el carton ganador lo puedo generar aqui
        
    }

    
    
    public void IniciarRifa(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Elija una opcion: \n 1. Añadir jugadores.\n 2. Empezar rifa.");
            opcion=sc.nextInt();
            
            switch (opcion) {
                case 1:
                    AniadirJugador();
                    break;
                case 2: 
                    TotalJugadores();
                    GenerarPremiados();
                    ContarAciertos();
                    RepartirPremio();
                    break;
            }
        } while (opcion!=2);
        
    }
    
    public void AniadirJugador(){
        Scanner sc=new Scanner(System.in);
        String nombreAuxiliar;
        
        System.out.println("Dime tu nombre");
        nombreAuxiliar=sc.nextLine();
        
        baseDatos.add(new Jugadores(nombreAuxiliar));//tambien se puede hacer asi
        this.bote+=10;
    }
    
    public void TotalJugadores(){
        for (int i = 0; i < baseDatos.size(); i++) {
            System.out.println("Jugador " + i + ": " + baseDatos.get(i).nombre);
        }
    }
    
    public void GenerarPremiados(){
        System.out.println("Numeros premiados: ");
        this.numerosPremiados= generarCarton();
        
        for (int numeros : numerosPremiados) {
            System.out.println(" (" + numeros + ") ");
        }
        System.out.println();
        //System.out.println(Arrays.toString(this.numerosPremiados));
        
    }
    
    public void ContarAciertos(){
        for (int i = 0; i < baseDatos.size(); i++) {//por cada jugador
            System.out.print(baseDatos.get(i).nombre + " | ");
            System.out.print(Arrays.toString(baseDatos.get(i).carton));
            
            //recorre por cada numero premiado los numeros del carton de ese jugador
            for (int j = 0; j < this.numerosPremiados.length; j++) {
                for (int k = 0; k < baseDatos.get(i).carton.length; k++) {
                    if(this.numerosPremiados[j]==baseDatos.get(i).carton[k]){
                        baseDatos.get(i).aciertos++;
                        aciertosTotales++;
                    }
                }
            }
            System.out.println(" | , " + baseDatos.get(i).aciertos + " aciertos.");

        }

    }
    
    public void RepartirPremio(){
        //(numero de aciertos del jugador*bote total)/numero de aciertos de todos los jugadores
        //despues, mostrar todos los jugadores y sus premios
        
        for (int i = 0; i < baseDatos.size(); i++) {
            int premio=0;
            if(aciertosTotales==0){
                System.out.println("Jugador " + baseDatos.get(i).nombre + ": 0€");
            }else{
                premio=(baseDatos.get(i).aciertos*bote)/aciertosTotales;
                System.out.println("Jugador " + baseDatos.get(i).nombre + ": " + premio + "€");
            }
            
        }

    }
    
    public int[] generarCarton(){
        int[] cartonGenerado=new int[5];
        for (int i = 0; i < 5; i++) {
            cartonGenerado[i]=(int)(Math.random()*100+1);
            
        }
        return cartonGenerado;
    }
    
}
