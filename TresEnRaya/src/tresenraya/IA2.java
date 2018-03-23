package tresenraya;

public class IA2 extends IA1 {

    public IA2() {
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
        
        //movimiento dependiendo de los valores de las posiciones
        posicion=casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }

    public int movimientoGanador(int ficha) {
        
        int movimiento;
        
        //Comprovar horizontals
        movimiento=comprovarFilas(ficha);
        if(movimiento !=-1) return movimiento;
        
        //comprovar verticals
        movimiento=comprovarColumnas(ficha);
        if(movimiento !=-1) return movimiento;
        
        //comprovar 1a diagonal
        movimiento=comprovar1aDiagonal(ficha);
        if(movimiento !=-1) return movimiento;
        
        //comprovar 2a diagonal
        movimiento=comprovar2aDiagonal(ficha);
        if(movimiento !=-1) return movimiento;
        
        return -1;
    }

    private int comprovarFilas(int ficha){

        int col;
        int fil;
        
        Taulell t;
        t = new Taulell();
        t = this.getTaulell();
        
        for (fil = 0; fil < 3; fil++) {

            for (col = 0; col < 3; col++) {
                if (t.getCasella(fil, col)
                        == t.getCasella(fil, ((col + 1) % 3))) {

                    if (t.getCasella(fil, col) == ficha) {
                        if(t.validarCasellaBuida(fil, (col + 2) % 3))
                        return fil * 3 + (col + 2) % 3; // Moviment guanyador =========>
                    }
                }
            }
        }
            
        return -1;
    }
    
    private int comprovarColumnas(int ficha){
        int col;
        int fil;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();
        
        for (col = 0; col < 3; col++) {

            for (fil = 0; fil < 3; fil++) {
                if (t.getCasella(fil, col)
                        == t.getCasella(((fil + 1) % 3), col)) {

                    if (t.getCasella(fil, col) == ficha) {
                        if(t.validarCasellaBuida(((fil + 2) % 3), col))
                        return ((fil + 2) % 3) * 3 + col; //Moviment guanyador===========>
                    }
                }
            }

        }
        return -1;
    }
    
    private int comprovar1aDiagonal(int ficha){
        int col;
        int fil;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();
        
        for (col = 0, fil = 0; col < 3; col++, fil++) {
            if (t.getCasella(fil, col)
                    == t.getCasella(((fil + 1)%3), (col + 1 % 3))) {
                if (t.getCasella(fil, col) == ficha) {
                    if(t.validarCasellaBuida(((fil + 2) % 3), (col+2)%3))   
                    return ((fil + 2) % 3) * 3 + (col+2)%3; //Moviment guanyador===========>
                }
            }
        }
        
        return -1;
    }
        
    private int comprovar2aDiagonal(int ficha){
        int col;
        int fil;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();
        
        for (col = 2, fil = 0; fil < 3; col--, fil++) {
            if (t.getCasella(fil, col)
                    == t.getCasella(((fil + 1 )%3), ((col + 2) % 3))) {
                if (t.getCasella(fil, col) == ficha) {
                    if(t.validarCasellaBuida(((fil + 2) % 3), (col+1)%3))   
                    return ((fil + 2) % 3) * 3 + (col+1)%3; //Moviment guanyador===========>
                }
            }
        }
        return -1;
    }
}

