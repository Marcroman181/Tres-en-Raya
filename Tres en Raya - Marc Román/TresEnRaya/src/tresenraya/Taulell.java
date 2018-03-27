package tresenraya;


public class Taulell {
    
   
    private int casella[];  //-1 vacio 0 blanca 1 negra
    
    public Taulell(){
        casella = new int[9];
       
        for(int i=0; i<9; i++){
            casella[i]=-1;
        }
    }
    
    public boolean comprobarEmpat() {
      
        if(!this.comprovarPle()) return false;//no empat=======================>
        
        if(casella[0]==casella[1] && casella[1]==casella[2]){
            return false; //No empat ==========================================>
        }
        if(casella[3]==casella[4] && casella[4]==casella[5]){
            return false; //No empat ==========================================>
        }  
        if(casella[6]==casella[7] && casella[7]==casella[8]){
            return false; //No empat ==========================================>
        }
        if(casella[0]==casella[4] && casella[4]==casella[8]){
            return false; //No empat ==========================================>
        }
        if(casella[2]==casella[4] && casella[4]==casella[6]){
            return false; //No empat ==========================================>
        }  
        if(casella[0]==casella[3] && casella[3]==casella[6]){
            return false; //No empat ==========================================>
        }
        if(casella[1]==casella[4] && casella[4]==casella[7]){
            return false; //No empat ==========================================>
        }  
        if(casella[2]==casella[5] && casella[5]==casella[8]){
            return false; //No empat ==========================================>
        }
      
        return true;//Empat
        
    }
    
    public int comprovarGuanyador(){  // -1 nadie 0 blancas 1 negras
        
        if(casella[0]==casella[1] && casella[1]==casella[2] && casella[1]!=-1){
            return casella[0]; //No empat ==========================================>
        }
        if(casella[3]==casella[4] && casella[4]==casella[5] && casella[4]!=-1){
            return casella[3]; //No empat ==========================================>
        }  
        if(casella[6]==casella[7] && casella[7]==casella[8] && casella[7]!=-1){
            return casella[6]; //No empat ==========================================>
        }
        if(casella[0]==casella[4] && casella[4]==casella[8] && casella[4]!=-1){
            return casella[0]; //No empat ==========================================>
        }
        if(casella[2]==casella[4] && casella[4]==casella[6] && casella[4]!=-1){
            return casella[2]; //No empat ==========================================>
        }  
        if(casella[0]==casella[3] && casella[3]==casella[6] && casella[3]!=-1){
            return casella[6]; //No empat ==========================================>
        }
        if(casella[1]==casella[4] && casella[4]==casella[7] && casella[4]!=-1){
            return casella[1]; //No empat ==========================================>
        }  
        if(casella[2]==casella[5] && casella[5]==casella[8] && casella[5]!=-1){
            return casella[2]; //No empat ==========================================>
        }
        
        return -1;
    }
    
    public boolean comprovarPle() {
        
        int i;
        for(i=0;i<9;i++){
            if(casella[i]==-1){
                return false;   //casella buida=================================>  
            }
        }
        return true;    //taulell ple
    }
    
    public int getCasella(int fil, int col) {
        
        return this.casella[fil*3 + col];    
    }
    
    public void mostrar() {
        
        for(int i=0; i<9; i++){
            
            if(i%3==0) {
                System.out.println();
            }
            
            if(this.casella[i]!=-1){
                
                if(this.casella[i]==1){
                    System.out.print("X ");
                }else{
                    System.out.print("O ");
                }
            }else{
                System.out.print("- ");
            }    
        }
        System.out.println("\n");
        
    }
    
    public boolean moure(Moviment m) {
        
        if(m==null) return false;// moviment buit==============================>
        
        int posicion;
        posicion= m.getFil()*3 + m.getCol();
        
        if(m.getBlancas()){
            casella[posicion]=0;
        }else{
            casella[posicion]=1;
        }
        
        return true;    
    }
    
    public boolean validarCasellaBuida(int fil, int col){
        if(this.casella[fil*3 + col]!=-1){
            return false;   //casella ocupada==================================> 
        }
        return true;
    }
    
    public boolean validarMoviment(Moviment m) {
        
        int posicio;
        posicio=m.getFil()*3 + m.getCol();
        
        if(casella[posicio]!=-1){
            return false;  //casella ocupada===================================>  
        }
        
        return true;
    }
    
}
