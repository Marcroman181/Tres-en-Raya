package tresenraya;

public class IA1 extends IA0 {

    private int[] valorCasilla = {1, 0, 1, 0, 2, 0, 1, 0, 1}; // 0 < 1 < 2

    public IA1() {
        super();
    }

    public int getValorCasilla(int pos) {
        return this.valorCasilla[pos];
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

        posicion = casillaMaxValor();

        m.setFil(posicion / 3);
        m.setCol(posicion % 3);
        return m;

    }

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

    public void setValorCasilla(int valor, int posicion) {
        
        this.valorCasilla[posicion] = valor;

    }
    
    public void incrementarValorCasilla(int posicion) {
        
        this.valorCasilla[posicion]++;

    }
}
