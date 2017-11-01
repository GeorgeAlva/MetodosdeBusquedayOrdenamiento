
import java.util.Scanner;
public class BusquedaIterativa
{

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);

        int[] numeros = new int[5];
        int max = numeros.length -1, min =0, m;
        for(int i =0;i < numeros.length;i++){
            numeros [i]= (int)(Math.random()*20)+1;;
        }
        for(int i =0;i < numeros.length;i++){
            System.out.print(numeros [i]+ " ");
        }
        BurbujaSimple(numeros);
        System.out.println("\n");
        for(int i =0;i < numeros.length;i++){
            System.out.print(numeros [i]+ " ");
        }
        System.out.println("\n Ingrese número a buscar");
        int valor = sc.nextInt();
        System.out.println("\n Por el método binario Iterativo");
        BinarioIterativo(numeros, valor);
        System.out.println("\n Por el método binario Recursivo");
        BinarioRecursivo(numeros, valor, min, max);
    }

    public static int BinarioIterativo(int [] numeros, int valor){
        int max = numeros.length -1, min =0, m;
        while (min <=max){
            m= (min + max)/2;
            if (numeros[m]== valor){
                System.out.println("\n" + valor + " encontrado en la posición : " + m);
                return m;
            }
            if ( valor < numeros[m])  {
                max= m-1;
            }  else{
                min =m +1;
            }
        }
        System.out.println("No se ha encontrado");
        return -1;
    }

    public static int BinarioRecursivo(int [] numeros, int valor,int min ,int max){
        int m= (min +max)/2;
        if (min >max){
            System.out.println(valor + " NO Ha SIDO ENCONTRADO");
            return -1;
        }
        if (numeros [m]== valor){
            System.out.println(valor + " Encontrado en la posición "+ m);
            return m;
        }
        if (valor < numeros[m]){
        return BinarioRecursivo(numeros, valor, min, max-1);
        }else{
            BinarioRecursivo(numeros, valor, min+1, max);
        }
        return -1;
     }

    public  static int[] BurbujaSimple(int[] numeros) {
        int temp = 0;
        for (int i=1; i<numeros.length; i++){
            for (int j=0 ; j< numeros.length - 1; j++){
                if (numeros[j] > numeros[j + 1]) {
                    temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        return  numeros;
    }

}
