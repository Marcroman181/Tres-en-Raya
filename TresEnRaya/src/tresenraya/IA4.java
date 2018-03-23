package tresenraya;

public class IA4 extends IA3 {

    public IA4() {
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

        recalcularValores();

        //movimiento dependiendo de los valores de las posiciones
        posicion = casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }

    private void recalcularValores() {

        inicialitzarValors();

        recalcularHorizontales();

        recalcularVerticales();

        recalcular1aDiagonal();

        recalcular2aDiagonal();
    }

    private void recalcularHorizontales() {

        int fichaContraria;
        int posicion;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        if (!this.getBlancas()) {
            fichaContraria = 0;
        } else {
            fichaContraria = 1;
        }

        //recalcular files
        boolean fichaContEncontrada; // Ficha contraria encontrada 

        for (int fil = 0; fil < 3; fil++) {

            fichaContEncontrada = false;
            for (int col = 0; col < 3 && !fichaContEncontrada; col++) {

                if (t.getCasella(fil, col) == fichaContraria) {
                    fichaContEncontrada = true;
                }
            }

            if (!fichaContEncontrada) {
                for (int col = 0; col < 3; col++) {

                    if (t.validarCasellaBuida(fil, col)) {
                        incrementarValorCasilla(fil * 3 + col);
                    }

                }
            }

        }

    }

    private void recalcularVerticales() {

        int fichaContraria;
        int posicion;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        if (!this.getBlancas()) {
            fichaContraria = 0;
        } else {
            fichaContraria = 1;
        }

        //recalcular files
        boolean fichaContEncontrada;

        for (int col = 0; col < 3; col++) {

            fichaContEncontrada = false;

            for (int fil = 0; fil < 3 && !fichaContEncontrada; fil++) {

                if (t.getCasella(fil, col) == fichaContraria) {
                    fichaContEncontrada = true;
                }
            }

            if (!fichaContEncontrada) {
                for (int fil = 0; fil < 3; fil++) {
                    if (t.validarCasellaBuida(fil, col)) {
                        incrementarValorCasilla(fil * 3 + col);
                    }
                }
            }

        }

    }

    private void recalcular1aDiagonal() {

        int fichaContraria;
        int posicion;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        if (!this.getBlancas()) {
            fichaContraria = 0;
        } else {
            fichaContraria = 1;
        }

        //recalcular files
        boolean fichaContEncontrada = false;
        int col;
        int fil;

        for (fil = 0, col = 0; fil < 3 && !fichaContEncontrada; fil++, col++) {

            if (t.getCasella(fil, col) == fichaContraria) {
                fichaContEncontrada = true;
            }

        }

        if (!fichaContEncontrada) {

            for (fil = 0, col = 0; fil < 3; fil++, col++) {

                if (t.validarCasellaBuida(fil, col)) {

                    incrementarValorCasilla(fil * 3 + col);

                }
            }
        }

    }

    private void recalcular2aDiagonal() {

        int fichaContraria;
        int posicion;

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        if (!this.getBlancas()) {
            fichaContraria = 0;
        } else {
            fichaContraria = 1;
        }

        //recalcular files
        boolean fichaContEncontrada = false;
        int col;
        int fil;

        for (fil = 0, col = 2; fil < 3 && !fichaContEncontrada; fil++, col--) {

            if (t.getCasella(fil, col) == fichaContraria) {
                fichaContEncontrada = true;
            }

        }
        if (!fichaContEncontrada) {

            for (fil = 0, col = 2; fil < 3; fil++, col--) {

                if (t.validarCasellaBuida(fil, col)) {

                    incrementarValorCasilla(fil * 3 + col);

                }
            }
        }

    }

    private void inicialitzarValors() {

        Taulell t;
        t = new Taulell();
        t = getTaulell();

        for (int i = 0; i < 9; i++) {
            if (t.validarCasellaBuida(i / 3, i % 3)) {
                setValorCasilla(0, i);
            } else {
                setValorCasilla(-1, i);
            }
        }
    }
}
