import java.util.Scanner;
public class BusquedaLineal
{
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int[] numeros = new int[5];
        for(int i =0;i < numeros.length;i++){
            numeros [i]= (int)(Math.random()*20)+1;
        }
        for(int i =0;i < numeros.length;i++){
            System.out.print(numeros [i]+ " ");
        }
        System.out.println("\n Ingrese número a buscar");
        int valor = sc.nextInt();
        Secuencial (numeros,valor);
    }

    public static void Secuencial (int [] numeros,int valor){
        boolean encontrado= false;
        for(int i= 0;i<numeros.length;i++){
            if(numeros[i]== valor){
                encontrado = true;
                System.out.println(valor + " encontrado en la posición : "+ i);
            }
        }
        if(!encontrado){
            System.out.println(valor + " no encontrado");
        }
    }
}
