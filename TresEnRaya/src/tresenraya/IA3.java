
package tresenraya;

public class IA3 extends IA2 {

    public IA3() {
        super();
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
            return m;   // Mvimiento ganador ==================================>
        }        
        
        //Posibilidad derrota
        ficha = Math.abs(ficha - 1);
        movDestacado = movimientoGanador(ficha);
        if (movDestacado != -1) {
            m.setFil(movDestacado / 3);
            m.setCol(movDestacado % 3);
            return m;   // Mvimiento evita derrota ============================>
        }
        
        //movimiento dependiendo de los valores de las posiciones
        posicion=casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }
    
}