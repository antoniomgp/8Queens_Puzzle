public class DiagonalDescendente implements Fila {
    int tamanho;
    int pos_l;
    int pos_c;
    Peca [][] tab;
    String diagonalDescendente;
    
    DiagonalDescendente (String diagonalDescendente, int temp_l, int temp_c, Peca[][] tab) {
        this.tamanho = diagonalDescendente.length();
        this.diagonalDescendente = diagonalDescendente;
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
            if(diagonalDescendente.charAt(i) == 'D') {
                contador ++;
            }
        }
        return contador;
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException{

        if(pos < tamanho && pos >= 0){
            return tab[pos_l + pos][pos_c + pos];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}