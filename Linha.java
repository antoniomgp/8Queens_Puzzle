public class Linha implements Fila {
    int tamanho;
    int linha_num;
    String linha;
    Peca [][] tab;

    Linha (String linha, Peca[][] tab, int linha_num) {
        this.tamanho = linha.length();
        this.linha = linha;
        this.tab = tab;
        this.linha_num = linha_num;
    }
    
    public int comprimento() {
        return tamanho;
    }
    public int pecas() {
        int contador = 0;
        for(int i = 0; i<tamanho;i++) {
            if(linha.charAt(i) == 'D') {
                contador ++;
            }
        }
        return contador;
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException{

        if(pos < tamanho && pos >= 0){
            return tab[linha_num][pos];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

}