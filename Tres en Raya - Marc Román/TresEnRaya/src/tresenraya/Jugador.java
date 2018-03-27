package tresenraya;

import java.util.Scanner;

public class Jugador {

    private String nombre;
    private boolean blancas; // true blancas, false negras

    public Jugador(String n) {
        this.nombre = n;
    }

    public boolean getBlancas() {
        return this.blancas;
    }
    
    public String getName(){
        return this.nombre;
    }

    public Moviment moviment() {
        int posicion;
        Moviment m;
        m = new Moviment();

        m.setBlancas(this.blancas);
        m.setJugador(this);

        //Obtenir fila
        System.out.println("Introduce a que fila quiere mover (numero entre 0 y 2");
        do {
            posicion = this.pedirMovimiento();
        
        }while (!m.setFil(posicion)); 

        //Obtenir columna
        System.out.println("Introduce a que columna quiere mover (numero entre 0 y 2");
        do{
            posicion = this.pedirMovimiento();
        
        }while (!m.setCol(posicion));

        return m;
    }

    public int pedirMovimiento() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        while (true) {
            try {
                opcion = sc.nextInt();
                if (opcion >= 0 && opcion <= 2) {
                    return opcion;// numero introducido correctamente==========>
                } else {
                    System.out.println("Error, ha de ser un numero entre 0 y 2");
                }
            } catch (Exception e) {
                sc.next();
                System.out.println("Error, inserte un número");
            }
        }

    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }
}
