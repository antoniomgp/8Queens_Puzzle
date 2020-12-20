public abstract class Peca {

    Tabuleiro tab;
    int linha;
    int coluna;
    boolean isNada;
    public Peca(Tabuleiro tab, int linha, int coluna) { 
        this.tab = tab;
        this.linha = linha;
        this.coluna = coluna;  

    }
    
    int linha(){
        return this.linha;
    }

    int coluna(){
        return this.coluna;
    }

    boolean vazia() {
        return isNada;
    }
    

    boolean podeIrPara(int linha, int coluna){

        if(linha < 0 || coluna < 0 || linha > tab.tamanho_sqrt_in || coluna > tab.tamanho_sqrt_in){
            return false;
        }

        if(linha == this.linha || coluna == this.coluna){
            return true;
        }

        int temp_C;

        if(this.linha > linha){

            temp_C = this.coluna - (this.linha - linha);

            if(temp_C != coluna){
                temp_C = temp_C + 2 * (this.linha - linha);
            }else{
                return true;
            }

            if(temp_C != coluna){
                return false;
            }else{
                return true;
            }
        }else{

            temp_C = this.coluna - (linha - this.linha);

            if(temp_C != coluna){
                temp_C = temp_C + 2 * (linha - this.linha);
            }else{
                return true;
            }

            if(temp_C != coluna){
                return false;
            }else{
                return true;
            }
        }
    }

    final boolean ataca (Peca vitima){
        return podeIrPara(vitima.linha(), vitima.coluna());
    }

}