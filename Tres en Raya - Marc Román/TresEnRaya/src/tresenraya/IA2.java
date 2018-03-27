package tresenraya;

public class IA2 extends IA1 {

    public IA2(String name) {

        super(name);
    }

    //Comprova si hi ha moviment gunyador en les columnes
    private int comprovarColumnas(int ficha) {
        int col;
        int fil;
        int nFichesIA;
        int posicio;
        boolean fichaRival; //ens indica si hem trobat una ficha rival

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        for (col = 0; col < 3; col++) {
            nFichesIA = 0;
            posicio = -1;
            fichaRival = false;
            //Comprovam si hi ha 2 fiches de la IA i una casella buida 
            for (fil = 0; fil < 3 && !fichaRival; fil++) {

                if (t.getCasella(fil, col) == ficha) {
                    nFichesIA++;
                } else {
                    if (t.validarCasellaBuida(fil, col)) {
                        posicio = fil * 3 + col;
                    } else {
                        fichaRival = true;
                    }
                }
            }

            //Si hi son, retornam la posicio
            if (nFichesIA == 2 && posicio != -1) {
                return posicio;
            }
        }
        return -1;
    }

    //Comprova si hi ha moviment gunyador en les files
    private int comprovarFilas(int ficha) {

        int col;
        int fil;
        int nFichesIA;
        int posicio;
        boolean fichaRival; //ens indica si hem trobat una ficha rival

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        for (fil = 0; fil < 3; fil++) {

            nFichesIA = 0;
            posicio = -1;
            fichaRival = false;

            for (col = 0; col < 3; col++) {

                if (t.getCasella(fil, col) == ficha) {
                    nFichesIA++;
                } else {
                    if (t.validarCasellaBuida(fil, col)) {
                        posicio = fil * 3 + col;
                    } else {
                        fichaRival = true;
                    }
                }
            }

            //Si hi son, retornam la posicio
            if (nFichesIA == 2 && posicio != -1) {
                return posicio;
            }
        }

        return -1;
    }

    //Comprova si hi ha moviment gunyador en la diagonal
    private int comprovar1aDiagonal(int ficha) {
        int col;
        int fil;
        int nFichesIA;
        int posicio;
        boolean fichaRival; //ens indica si hem trobat una ficha rival

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        nFichesIA = 0;
        posicio = -1;
        fichaRival = false;

        for (col = 0, fil = 0; col < 3; col++, fil++) {

            if (t.getCasella(fil, col) == ficha) {
                nFichesIA++;
            } else {
                if (t.validarCasellaBuida(fil, col)) {
                    posicio = fil * 3 + col;
                } else {
                    fichaRival = true;
                }
            }
        }

        //Si hi son, retornam la posicio
        if (nFichesIA == 2 && posicio != -1) {
            return posicio;
        }

        return -1;
    }

    //Comprova si hi ha moviment gunyador en la diagonal
    private int comprovar2aDiagonal(int ficha) {
        int col;
        int fil;
        int nFichesIA;
        int posicio;
        boolean fichaRival; //ens indica si hem trobat una ficha rival

        Taulell t;
        t = new Taulell();
        t = this.getTaulell();

        nFichesIA = 0;
        posicio = -1;
        fichaRival = false;

        for (col = 2, fil = 0; fil < 3; col--, fil++) {
            if (t.getCasella(fil, col) == ficha) {
                nFichesIA++;
            } else {
                if (t.validarCasellaBuida(fil, col)) {
                    posicio = fil * 3 + col;
                } else {
                    fichaRival = true;
                }
            }
        }

        //Si hi son, retornam la posicio
        if (nFichesIA == 2 && posicio != -1) {
            return posicio;
        }
        return -1;
    }

    //Ens torna la casella on hi ha un posible moviment guanyador per la ficha introduida
    public int movimientoGanador(int ficha) {

        int movimiento;

        //Comprovar horizontals
        movimiento = comprovarFilas(ficha);
        if (movimiento != -1) {
            return movimiento;  // Movimiento ganador en filas ================>
        }

        //comprovar verticals
        movimiento = comprovarColumnas(ficha);
        if (movimiento != -1) {
            return movimiento;  // Movimiento ganador en columnas==============>
        }

        //comprovar 1a diagonal
        movimiento = comprovar1aDiagonal(ficha);
        if (movimiento != -1) {
            return movimiento;  // Movimiento ganador en diagonal==============>
        }

        //comprovar 2a diagonal
        movimiento = comprovar2aDiagonal(ficha);
        if (movimiento != -1) {
            return movimiento;  // Movimiento ganador en diagonal==============>
        }

        return -1;
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

        //Comprueba que ficha es el
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

        //movimiento dependiendo de los valores de las posiciones
        posicion = casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }

}
