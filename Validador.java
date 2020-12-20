import java.util.Scanner;

public class Validador {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean validity = true;

        if(args.length == 0) {

            String board = s.nextLine();
            s.close();

            board = board.replaceAll(" ","");

            if(Math.sqrt(board.length()) != (int) Math.sqrt(board.length())){
                validity = false;
            }else{

                for(int i = 0; i < Math.sqrt(board.length()); i++){
                    if(board.charAt(i) != 'D' && board.charAt(i) != '-'){
                        validity = false;
                    }
                }

                if(validity = true){

                    Tabuleiro tab = new Tabuleiro(board);

                    for(int line = 0; line < tab.tamanho_sqrt_in; line++){

                        DiagonalAscendente da = tab.diagonalAscendente(line, 0);
                        DiagonalDescendente dd = tab.diagonalDescendente(line, 0);
                        DiagonalAscendente dA = tab.diagonalAscendente(line, tab.tamanho_sqrt_in - 1);
                        DiagonalDescendente dD = tab.diagonalDescendente(line, tab.tamanho_sqrt_in - 1);

                        Linha l = tab.linha(line);

                        if(da.pecas() > 1 || dd.pecas() > 1 || dA.pecas() > 1 || dD.pecas() > 1 || l.pecas() > 1){
                            validity = false;
                        }
                    }

                    for(int collumn = 0; collumn < tab.tamanho_sqrt_in; collumn++){

                        Coluna c = tab.coluna(collumn);
                        if(c.pecas() > 1){
                            validity = false;
                        }
                    }
                }
            }

            if(validity){
                System.out.println("VALIDA");
            }else{
                System.out.println("INVALIDA");
            }

        }else if (args[0].equals("filtro")) {

            String board = s.nextLine();

            while(board != null){

                Tabuleiro tab = new Tabuleiro(board);

                for(int line = 0; line < tab.tamanho_sqrt_in; line++){

                    DiagonalAscendente da = tab.diagonalAscendente(line, 0);
                    DiagonalDescendente dd = tab.diagonalDescendente(line, 0);
                    DiagonalAscendente dA = tab.diagonalAscendente(line, tab.tamanho_sqrt_in - 1);
                    DiagonalDescendente dD = tab.diagonalDescendente(line, tab.tamanho_sqrt_in - 1);

                    Linha l = tab.linha(line);

                    if(da.pecas() > 1 || dd.pecas() > 1 || dA.pecas() > 1 || dD.pecas() > 1 || l.pecas() > 1){
                        validity = false;
                    }
                }

                for(int collumn = 0; collumn < tab.tamanho_sqrt_in; collumn++){

                    Coluna c = tab.coluna(collumn);
                    if(c.pecas() > 1){
                        validity = false;
                    }
                }

                if(validity){
                    System.out.println(board);
                }

                if(s.hasNextLine()){
                    board = s.nextLine();
                }else{
                    board = null;
                }
            }
        
        }
    }
}