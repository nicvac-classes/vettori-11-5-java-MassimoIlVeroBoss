import java.util.Scanner;

class Esercizio {
    static int ELiminaElemento(int[] V, int N, int ie) {
        int N2 = N - 1;
        for (int i = ie; i < N2; i++) {
            V[i] = V[i + 1];
        }
        return N2;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N;
        int coppie = 0;
        int i , j;
        boolean trovato;

        do {
            System.out.print("Inserire Dimensione vettore: ");
            N = in.nextInt();
            if (N <= 0) {
                System.out.println("Inserire un numero maggiore di 0!");
            }
        } while (N <= 0);

        int[] V = new int[N];

        for(i = 0; i < N; i++){
            V[i] = 4 + (int)(Math.random() * 7);
            System.out.println(i + "°numero: " + V[i]);
        }

        i = 0;
        while(i < N - 1){
            j = i + 1;
            trovato = false;
            while(j < N && !trovato){
                if(V[i] == V[j]){
                    trovato = true;
                    N = ELiminaElemento(V, N, j);
                    N = ELiminaElemento(V, N, i);
                    coppie ++;
                    i = -1;
                }else{
                    j++;
                }
            }
            i++;
        }

        coppie = coppie / 2;

        System.out.println("Possono essere realizzate massimo " + coppie + " cornici");
    }
}