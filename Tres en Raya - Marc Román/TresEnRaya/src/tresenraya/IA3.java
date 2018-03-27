
package tresenraya;

public class IA3 extends IA2 {

    public IA3(String name) {

        super(name);
    }
    
    @Override
    public Moviment moviment() {
        Moviment m;
        m = new Moviment();

        int maxValorDisponible = -1; // -1 cap casella
        int posicion = 0;
        int movDestacado;
        int ficha;
                
        if (this.getTaulell().comprovarPle()) {
            return null; //Taulell ple =======================================>
        }

        m.setBlancas(this.getBlancas());
        m.setJugador(this);

        //comprueba que ficha es
        if (this.getBlancas()) {
            ficha = 0;
        } else {
            ficha = 1;
        }

        //Posibilidad victoria
        movDestacado = movimientoGanador(ficha);
        if (movDestacado != -1) {
            m.setFil(movDestacado / 3);
            m.setCol(movDestacado % 3);
            return m;   // Movimiento ganador ==================================>
        }        
        
        //Posibilidad derrota
        ficha = Math.abs(ficha - 1);    //Tranforma la ficha en la contraria para comprobar un movimiento perdedor
        movDestacado = movimientoGanador(ficha);
        if (movDestacado != -1) {
            m.setFil(movDestacado / 3);
            m.setCol(movDestacado % 3);
            return m;   // Movimiento evita derrota ============================>
        }
        
        //movimiento dependiendo de los valores de las posiciones
        posicion=casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }
    
}