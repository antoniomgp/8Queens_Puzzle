public class Tabuleiro {

    String repr;    
    int tamanho_sqrt_in;
    public Peca[][]tab;
    

    public Tabuleiro(String repr) {
        repr = repr.replaceAll(" ", "");
        this.repr = repr;
        int tamanho_sqrt_int = (int) Math.sqrt(repr.length());
        this.tamanho_sqrt_in = tamanho_sqrt_int;
        double tamanho_sqrt_double = Math.sqrt(repr.length());
        
        if ((int) tamanho_sqrt_int == tamanho_sqrt_double) {
            // tudo bem
            tab = new Peca[tamanho_sqrt_int][tamanho_sqrt_int];
            
            int index = 0;
            for (int linha = 0; linha < tamanho_sqrt_int; linha++) {
                for (int coluna = 0; coluna < tamanho_sqrt_int; coluna++) {
                    char temp = repr.charAt(index);
                    index++;
                    if (temp == 'D') {
                        tab[linha][coluna] = new Rainha(this, linha, coluna);
                    } else if (temp == '-') {
                        tab[linha][coluna] = new Nada(this, linha, coluna);
                    }
                }
            }
        } 
    }

    public String toString() {
        return repr;
    }

    Peca peca(int linha, int coluna) {
        return tab[linha][coluna];
    }

    Linha linha(int linha) {
        String linha_string = new String();
        for (int i = tamanho_sqrt_in * linha; i < tamanho_sqrt_in + (tamanho_sqrt_in * linha); i++) {
            linha_string = linha_string + repr.charAt(i);
        }
        Linha l = new Linha(linha_string, tab, linha);
        return l;
    }

    Coluna coluna(int coluna) {
        String coluna_string = new String();

        for (int i = coluna; i <= (tamanho_sqrt_in * tamanho_sqrt_in) - (tamanho_sqrt_in - coluna); i += tamanho_sqrt_in) {
            coluna_string = coluna_string + repr.charAt(i);
        }

        Coluna c = new Coluna(coluna_string, tab, coluna);
        return c;
    }

    DiagonalDescendente diagonalDescendente(int linha, int coluna) {
        String diagonalDescendente = new String();
        int temp = coluna + tamanho_sqrt_in * linha;
        int temp_l;
        int temp_c;
        
        while (linha > 0 && coluna > 0) {
            linha--;
            coluna--;
            temp = temp - tamanho_sqrt_in - 1;
        }

        temp_l = linha;
        temp_c = coluna;

        while (linha < tamanho_sqrt_in && coluna < tamanho_sqrt_in) {
            diagonalDescendente = diagonalDescendente + repr.charAt(temp);
            coluna++;
            linha++;
            temp = temp + tamanho_sqrt_in + 1;
        }

        DiagonalDescendente dd = new DiagonalDescendente(diagonalDescendente, temp_l, temp_c, tab);
        return dd;
    }

    DiagonalAscendente diagonalAscendente(int linha, int coluna) {
        String diagonalAscendente = new String();
        int temp = coluna + tamanho_sqrt_in * linha;
        int temp_l;
        int temp_c;

        while (linha < tamanho_sqrt_in - 1 && coluna > 0) {
            linha++;
            coluna--;
            temp = temp + tamanho_sqrt_in - 1;
        }

        temp_l = linha;
        temp_c = coluna;

        while (linha >= 0 && coluna < tamanho_sqrt_in) {
            diagonalAscendente = diagonalAscendente + repr.charAt(temp);
            coluna++;
            linha--;
            temp = temp - tamanho_sqrt_in + 1;
        }

        DiagonalAscendente da = new DiagonalAscendente(diagonalAscendente, temp_l, temp_c, tab);
        return da;
    }

    boolean ameacada(int linha,int coluna) {

        Linha l = new Linha("", tab, 0);
        Coluna c = new Coluna("", tab, 0);
        DiagonalAscendente da = new DiagonalAscendente("", 0 , 0, tab);
        DiagonalDescendente dd = new DiagonalDescendente("", 0, 0, tab);

        l = linha(linha);
        c = coluna(coluna);
        da = diagonalAscendente(linha, coluna);
        dd = diagonalDescendente(linha, coluna);

        if(l.pecas() > 1 || c.pecas() > 1 || da.pecas() > 1 || dd.pecas() > 1){
            return true;
        }else{
            return false;
        }
    }
}
