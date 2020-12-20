import java.util.*;
public class Gerador{
	static List<String> random(int m, int q, int n){
        List<String> output = new ArrayList<>();

        if(q <= m){
            String str = new String();
            char[] tab = new char[m * m];
            Random r = new Random();
            
            for(int i = 0; i < n; i++){

                str = "";
                
                int max = m * m;

                for(int x = 0; x < q; x++) {
                    int pos;
                    do{
                       pos = r.nextInt(max);
                    }while(tab[pos] == 'D');
                    tab[pos] = 'D';
                }

                for(int x = 0; x < max; x++){

                    if(tab[x] == 'D'){
                        str = str + 'D';
                    }else{
                        str = str + '-';
                    }

                }
                if(!output.contains(str)){
                    output.add(str);
                }else{
                    i--;
                }
            }
        }

        return output;
    }

    static List<String> all(int m) {
        List<String> output = new ArrayList<>();
        boolean end = false;
        double nF = 1;
        double rF = 1;
        double nR = 1;
        
        for(int i = 1; i <= m * m; i++){
            nF = nF * i;
        }

        for(int i = 1; i <= m; i++){
            rF = rF * i;
        }

        for(int i = 1; i <= m * m - m; i++){
            nR = nR * i;
        }

        double nCr = nF / (rF * nR);
        String str = new String();

        while(!end){
            char[] tab = new char[m * m];
            Random r = new Random();
            int max = m * m;
            str = "";

            for(int i = 0; i < m; i++){
                int pos;

                do{
                    pos = r.nextInt(max);
                }while(tab[pos] == 'D');

                tab[pos] = 'D';
            }

            for(int x = 0; x < max; x++){

                if(tab[x] == 'D'){
                    str = str + 'D';
                }else{
                    str = str + '-';
                }
            }

            if(!output.contains(str)){
                output.add(str);
                nCr--;
            }

            if(nCr == 0){
                end = true;
            }
        }

        return output;

    }


    static List<String> allValid(int m) {
        List<String> output = new ArrayList<>();
        List <String> options = Gerador.all(m);
        boolean validity;
        String str = new String();

        for(int i = 0; i < options.size(); i++){
            str = options.get(i);
            validity = true;

                //line
            for(int x = 0; x < str.length(); x = x + ((int) Math.sqrt(str.length()))){

                int counter = 0;

                for(int j = x; j < x + Math.sqrt(str.length()); j++){

                    if(str.charAt(j) == 'D'){
                        counter++;
                    }

                }

                if(counter > 1){
                    validity = false;
                }

            }

                //collumn
            for(int j = 0; j < Math.sqrt(str.length()); j++){

                int l = j;
                int counter = 0;

                for(int x = 0; x < Math.sqrt(str.length()); x++){

                    if(str.charAt(l) == 'D'){
                        counter++;
                    }

                    l = l + ((int) Math.sqrt(str.length()));

                }

                if(counter > 1){
                    validity = false;
                }

            }

            for(int c = 0; c < Math.sqrt(str.length()); c++){

                int col = c;
                int pos = c;
                int counter = 0;
                do{
                    if(str.charAt(pos) == 'D'){
                        counter++;
                    }

                    pos = pos + ((int) Math.sqrt(str.length())) + 1;
                    col++;

                }while(pos < str.length() && col < Math.sqrt(str.length()));

                if(counter > 1){
                    validity = false;
                }

                col = c;
                int l = ((int) Math.sqrt(str.length())) - 1;
                counter = 0;
                pos = col + (l * ((int) Math.sqrt(str.length())));

                do{
                    if(str.charAt(pos) == 'D'){
                        counter++;
                    }

                    pos = pos - (((int) Math.sqrt(str.length())) + 1);
                    col--;
                    l--;

                }while(pos >= 0 && l >= 0 && col >= 0);

                if(counter > 1){
                    validity = false;
                }

                col = c;
                l = 0;
                pos = c;
                counter = 0;

                do{
                    if(str.charAt(pos) == 'D'){
                        counter++;
                    }

                    pos = pos + (((int) Math.sqrt(str.length())) - 1);
                    col--;
                    l++;

                }while(pos < str.length() && l < Math.sqrt(str.length()) && col >= 0);

                if(counter > 1){
                    validity = false;
                }

                counter = 0;
                col = c;
                l = ((int) Math.sqrt(str.length())) - 1;
                pos = col + (l * ((int) Math.sqrt(str.length())));

                do{
                    if(str.charAt(pos) == 'D'){
                        counter++;
                    }

                    pos = pos - (((int) Math.sqrt(str.length())) - 1);
                    col++;
                    l--;

                }while(pos >= 0 && col < Math.sqrt(str.length()) && l >= 0);

                if(counter > 1){
                    validity = false;
                }



            }

            if(validity){
                output.add(str);
            }
        }

        return output;
    }
}
