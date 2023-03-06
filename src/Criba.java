import java.util.Scanner;


public class Criba {

    public static int[] generarPrimos(int max) {

        // 0 y 1 no son números primos
        if (max >= 2) {
            // Inicializo el array
            boolean[] esPrimo = new boolean[max];
            for (int i = 2; i < max; i++) {
                esPrimo[i] = true;
            }
            //Criba
            for (int i = 2; i < Math.sqrt(max) + 1; i++) {
                if (esPrimo[i]) {
                    // Elimina los múltiplos de i
                    for (int j = 2 * i; j < max; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }
            // Cantidad de números primos
            int cuenta = 0;
            for (int i = 2; i < max; i++) {
                if (esPrimo[i]) {
                    cuenta = cuenta + 1;
                }
            }

            // Rellena el vector de numeros primos
            int[] primos = new int[cuenta];
            int j = 0;
            for (int i = 2; i < max; i++) {
                if (esPrimo[i]) {
                    primos[j++] = i;
                }
            }
            return primos;
        } else {
            return new int[0];   // Vector vacío
        }
    }


    public static void main(String[] args) {
        int max;
        //Solicita dato por teclado y lo registra
        System.out.print("\tIntroduce el número para la criba de Erastótenes:");
        Scanner teclado = new Scanner(System.in);
        max = teclado.nextInt();

        //Genera todos los número desde el 1 hasta max y los imprime
        System.out.print("\n\tVector inicial hasta " + max + " :");
        int[] vector = new int[max];
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }

        //Genera solo los números primos que hay entre 1 y max , y los imprime
        System.out.print("\n\n\tVector de primos hasta " + max + " :");
        vector = generarPrimos(max);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");


        }
    }
}