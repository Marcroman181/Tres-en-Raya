package tresenraya;

import java.util.ArrayList;

public class Partida {

    private int jugadaActual;

    private Jugador jugadores[];
    private Taulell t;
    private int victoriaJugador = -1; // Valor para indicar si un jugador ha indicado una casilla invalida
                                     //-1 nadie, 0 victoria blancas 1 victoria negras
    
    public Partida(Jugador blancas, Jugador negras) {

        this.jugadores = new Jugador[2];
        jugadores[0] = blancas;
        jugadores[1] = negras;

        jugadores[0].setBlancas(true);
        jugadores[1].setBlancas(false);

        t = new Taulell();
        this.victoriaJugador = -1;
        
        //pasamos tablero a la IA
        if (jugadores[0] instanceof IA0) {
            ((IA0) jugadores[0]).setTaulell(this.t);
        } else {
            ((IA0) jugadores[1]).setTaulell(this.t);
        }
        
    }

    public Taulell getTaulell() {
        return t;
    }

    
    public void jugar() {

        Moviment m;
        int turnoJugador; // 0 blancas 1 negras

        //Bucle per controlar la partida
        for (this.jugadaActual = 0; !t.comprovarPle() && t.comprovarGuanyador() == -1; this.jugadaActual++) {

            turnoJugador = this.jugadaActual % 2;

            if (turnoJugador == 0) {
                System.out.println("\nMueven blancas");
            } else {
                System.out.println("\nMueven negras");
            }

            m = jugadores[turnoJugador].moviment();

            if (!t.validarCasellaBuida(m.getFil(), m.getCol())) {
                //casella ocupada --> Perd
                victoriaJugador = Math.abs(turnoJugador - 1);
                break;
            }

            t.moure(m);
            this.t.mostrar();
        }
    }

    //Este metodo devuelve al final de la partida si el jugador ha ganado
    public boolean victoriaJugador() {
        if (victoriaJugador!=-1) {
            System.out.print("\nError: Casilla no válida");
            if (jugadores[victoriaJugador] instanceof IA0) {
                return false;// Jugador Perd ==================================>
            }else{
                return true;//IA perd =========================================>
            }
        }
        if (jugadores[t.comprovarGuanyador()] instanceof IA0) {
            return false;   // Juagodor Perd ==================================>

        }
        return true;
    }
}
