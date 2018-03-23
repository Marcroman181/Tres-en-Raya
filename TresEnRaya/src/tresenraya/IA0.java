package tresenraya;


public class IA0 extends Jugador {
   
    private Taulell taulell;
  
    public IA0(){
        
        super("IA");
        
    }
    
    @Override
    public Moviment moviment() {
        Moviment m;
        m = new Moviment();
           
        if(this.taulell.comprovarPle()){
            return null; //Taulell ple =======================================>
        }
        
        m.setBlancas(this.getBlancas());
        m.setJugador(this);
        
        
        for(int i=0; i<9;i++){
            if(this.taulell.validarCasellaBuida(i/3, i%3)){
                m.setFil(i/3);
                m.setCol(i%3);
                return m; //Tornam moviment =================================>
            }
        }
        return null;
    }
    
    public Taulell getTaulell(){
        return this.taulell;
    }
    
    public void setTaulell(Taulell t){
        if(t!=null){
            this.taulell=t;
        }
    }
}
