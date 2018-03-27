package tresenraya;

public class IA1 extends IA0 {

    private int[] valorCasilla = {1, 0, 1, 0, 2, 0, 1, 0, 1}; // 0 < 1 < 2

    public IA1(String name) {

        super(name);
    }

    //ens torna la casella amb el valor més gran
    public int casillaMaxValor() {
        int maxValorDisponible = -1; // -1 cap casella
        int posicion = 0;
        Taulell t;
        t = new Taulell();

        t = this.getTaulell();

        for (int i = 0; i < 9; i++) {
            if (t.validarCasellaBuida(i / 3, i % 3)) {
                if (valorCasilla[i] > maxValorDisponible) {
                    maxValorDisponible = valorCasilla[i];
                    posicion = i;
                }
            }
        }
        return posicion;
    }

    public int getValorCasilla(int pos) {
        return this.valorCasilla[pos];
    }

    //incremennta en un, el valor de la casella indicada
    public void incrementarValorCasilla(int posicion) {

        this.valorCasilla[posicion]++;

    }

    @Override
    public Moviment moviment() {
        Moviment m;
        m = new Moviment();

        int posicion = 0;

        if (this.getTaulell().comprovarPle()) {
            return null; //Taulell ple =======================================>
        }

        m.setBlancas(this.getBlancas());
        m.setJugador(this);

        //movem a la posició on el valor es màxim
        posicion = casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }

    //Estableix el valor indicat a la casella indicada
    public void setValorCasilla(int valor, int posicion) {

        this.valorCasilla[posicion] = valor;

    }

}
