package tresenraya;

import java.util.ArrayList;
import java.util.Scanner;

public class Sessio {

    private ArrayList<Partida> partidas;
    private IA0 ia;
    private Jugador player;
    private Ranking ranking;
    private String horaInici;

    public Sessio() {
        //this.horaInici=sysdate;
        this.partidas = new ArrayList();
        ranking = new Ranking();
    }

    private void actualizarRanking(Partida p) {

        if (p.getTaulell().comprobarEmpat()) {
            //Empate
            System.out.println("Has empatado!!");
            this.ranking.empatar();

        } else {

            //Alguien gana 
            if (p.victoriaJugador()) {
                this.ranking.guanyar(true);
                System.out.println("\n¡¡Has ganado!!\n");

            } else {
                this.ranking.guanyar(false);
                System.out.println("\n¡¡Has perdido!!\n");

            }
        }
    }

    public void crearHumano() {
        System.out.println("Introduce tu nombre");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        this.player = new Jugador(name);
    }

    public void crearPartida() {
        Partida p;

        int sorteo;
        sorteo = this.sorteigTorn();

        if (sorteo == 0) {
            p = new Partida(this.player, this.ia);
            System.out.println("Juegas con las blancas");
        } else {
            p = new Partida(this.ia, this.player);
            System.out.println("Juegas con las negras");
        }

        this.partidas.add(p);
        p.jugar();

        this.actualizarRanking(p);
    }

    public void iniciarSessio() {
        this.crearHumano();
        this.seleccionarDificultad();
        int opcion = 0;
        do {
            opcion = this.menu();
            switch (opcion) {

                case 1:
                    //jugar
                    crearPartida();
                    break;

                case 2:
                    //Mostrar ranking
                    this.ranking.mostrar();
                    break;

                case 3:
                    //cambiar dificultad
                    this.seleccionarDificultad();
                    break;
            }

        } while (opcion != 4);

    }

    public int menu() {

        System.out.println("\nPulse 1 para jugar contra la " + this.ia.getName()+".\n"
                + "Pulse 2 para ver el ranking. \n"
                + "Pulse 3 para cambiar la dificultad.\n"
                + "Pulse 4 para salir.\n");

        Scanner sc = new Scanner(System.in);
        int opcion = this.pedirOpcion();

        return opcion;

    }

    public int pedirOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true) {
            try {
                opcion = sc.nextInt();
                return opcion;
            } catch (Exception e) {
                sc.next();
                System.out.println("Error, inserte un número");
            }
        }
    }

    public void seleccionarDificultad() {
        System.out.println("Seleccione una dificultad\n");
        System.out.println("\nPulse 0 para IA0. \n"
                + "Pulse 1 para IA1. \n"
                + "Pulse 2 para IA2. \n"
                + "Pulse 3 para IA3. \n"
                + "Pulse 4 para IA4. \n");

        Scanner sc = new Scanner(System.in);
        int opcion = this.pedirOpcion();

        switch (opcion) {
            case 0:
                //IA0
                this.ia = new IA0("IA0");
                break;
            case 1:
                //IA1
                this.ia = new IA1("IA1");
                break;
            case 2:
                //IA2
                this.ia = new IA2("IA2");
                break;
            case 3:
                //IA3
                this.ia = new IA3("IA3");
                break;
            case 4:
                //IA4
                this.ia = new IA4("IA4");
                break;
        }

    }

    public int sorteigTorn() {
        int sorteo;

        sorteo = (int) (Math.random() * 2);

        return sorteo; // 0 blancas jugador, 1 blancas IA
    }

    public static void main(String[] args) {
        Sessio sessio;
        sessio = new Sessio();

        sessio.iniciarSessio();
    }
}
