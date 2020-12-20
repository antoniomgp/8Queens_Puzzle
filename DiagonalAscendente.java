public class DiagonalAscendente implements Fila {
    int tamanho;
    int pos_l;
    int pos_c;
    Peca [][] tab;
    String diagonalAscendente;
    
    DiagonalAscendente (String diagonalAscendente, int temp_l, int temp_c, Peca[][] tab) {
        this.tamanho = diagonalAscendente.length();
        this.diagonalAscendente = diagonalAscendente;
        this.pos_l = temp_l;
        this.pos_c = temp_c;
        this.tab = tab;
    }
    
    public int comprimento() {
        return tamanho;
    }

    public int pecas() {
        int contador = 0;
        for(int i = 0; i<tamanho;i++) {
            if(diagonalAscendente.charAt(i) == 'D') {
                contador ++;
            }
        }
        return contador;
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException{

        if(pos < tamanho && pos >= 0){
            return tab[pos_l - pos][pos_c + pos];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}