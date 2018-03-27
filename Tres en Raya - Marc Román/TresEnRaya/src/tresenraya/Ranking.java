package tresenraya;

public class Ranking {

    private int empats;
    private int guanyatsHuma;
    private int partidasJugadas;

    public Ranking() {
        this.partidasJugadas=0;
        this.empats=0;
        this.guanyatsHuma=0;
        
    }

    public void empatar() {
        
        this.partidasJugadas++;
        this.empats++; 
    }

    public void guanyar(boolean victoriaJugador) {

        this.partidasJugadas++;

        if (victoriaJugador) {
           this.guanyatsHuma++;
        }
    }
    
    public void mostrar() {
        
        System.out.println("Partidas jugadas: " + this.partidasJugadas +"\n"+
                            "Victorias del jugador: " + this.guanyatsHuma + "\n"+   
                            "Empates: "+ this.empats+ "\n"); 
    }
    
}
