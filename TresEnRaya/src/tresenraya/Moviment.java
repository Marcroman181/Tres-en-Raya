package tresenraya;


public class Moviment {
        
    private boolean blancas;    
    private int fil;    
    private int col;
    private Jugador jugador; 
 
    public Moviment(){
        
    }
    
    public Moviment(int fil, int col, boolean blancas, Jugador j){
        
        this.fil=fil;
        this.col=col;
        this.blancas=blancas;
        this.jugador=j;
    }
    
    public boolean getBlancas(){
        return this.blancas;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public int getFil(){
        return this.fil;
    }

    public Jugador getJugador(){
        return this.jugador;
    }
    
    public void setBlancas(boolean blancas){
        
        this.blancas=blancas;
    }
    
    public boolean setCol(int col){
       if(col<0 || col>2){
           return false; //columna no valida ==================================>
       } 
       
       this.col=col;
       return true;
    }
    
    public boolean setFil(int fil){
       if(fil<0 || fil>2){
           return false;    //fila no valida ==================================>
       }
       
       this.fil=fil;
       return true;
    }    
    
    public void setJugador(Jugador j){
      
       if(j!=null){
            this.jugador = j;
       }
    }

}
