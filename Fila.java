interface Fila {
    int comprimento(); //retorna o numero de posicoes nessa fila
    int pecas(); // para retornar o número de peças (isto é, posições ocupadas) nessa fila.
    Peca peca(int pos) throws IndexOutOfBoundsException;
}