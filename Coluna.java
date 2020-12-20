public class Coluna implements Fila {
    int tamanho;
    int coluna_num;
    String coluna;
    Peca [][] tab;

    Coluna (String coluna, Peca[][] tab, int coluna_num) {
        this.tamanho = coluna.length();
        this.coluna = coluna;
        this.tab = tab;
        this.coluna_num = coluna_num;
    }

    public int comprimento() {
        return tamanho;
    }

    public int pecas() {
        int contador = 0;
        for (int i = 0; i < tamanho; i++) {
            if (coluna.charAt(i) == 'D') {
                contador++;
            }
        }
        return contador;
    }

    public Peca peca(int pos) throws IndexOutOfBoundsException{

        if(pos < tamanho && pos >= 0){
            return tab[pos][coluna_num];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}