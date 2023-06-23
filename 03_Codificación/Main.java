import java.util.*;
public class Main {
    static int ladoIzq[] = { 1, 1, 1, 1 };
    static int ladoDer[] = { 0, 0, 0, 0 };
    static String personajes[] = { "caballero ", "caperucita", "lobo      ", "uvas      " };
    static String vacio[]={"          ","          ","          ","          "};
    public static int eleccionPersonajes() {// metodo para ingresar un numero
        Scanner sc = new Scanner(System.in);
        int opc = -1;
        System.out.println("");
        for (int i = 0; i < personajes.length; i++) 
            System.out.println(i + " " + personajes[i]);
        do {
            try {
                System.out.print("\nDigita el numero del peronaje para que viaje en el bote con el caballero: ");
                opc = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("valor no numerico");
            }
        } while (opc < 0 || opc > 3);
        return opc;
    }
    public static void navegar() { // metodo para navegar en el bote con el caballero
        int indice = eleccionPersonajes();
        if (ladoDer[indice] == 1 ) {
            if(indice==0){
                ladoDer[indice] = ladoDer[0] = 0;
                ladoIzq[indice] = ladoIzq[0] = 1;
            }
            if(ladoDer[indice]==1 && ladoDer[0]==1){
                ladoDer[indice] = ladoDer[0] = 0;
                ladoIzq[indice] = ladoIzq[0] = 1;
            }
            verificarReglas();
        } else if (ladoIzq[indice] == 1 ) {
            if(indice==1){
                ladoDer[indice] = ladoDer[0] = 1;
                ladoIzq[indice] = ladoIzq[0] = 0;
            }
            if(ladoDer[indice]==0 && ladoDer[0]==0){
                ladoDer[indice] = ladoDer[0] = 1;
                ladoIzq[indice] = ladoIzq[0] = 0;
            }
            verificarReglas();
        }
        imprimir();
    }
    // verifica los casos posibles, en la derecha e izquierda, comparando los arreglos de casos con lo de los lados
    public static void verificarReglas() {
        int caso1[] = { 0, 1, 1, 1 };
        int caso2[] = { 0, 1, 0, 1 };
        int caso3[] = { 0, 1, 1, 0 };
        int caso4[] = { 1, 1, 1, 1 };
        if (Arrays.equals(ladoIzq, caso1) || Arrays.equals(ladoDer, caso1)) {
            System.out.println("el lobo se comio a caperusita || caperusita se comio a las uvas ");
            System.exit(0);
        }
        if (Arrays.equals(ladoIzq, caso2) || Arrays.equals(ladoDer, caso2)) {
            System.out.println("Caperusita se comio a las uvas");
            System.exit(0);
        }
        if (Arrays.equals(ladoIzq, caso3) || Arrays.equals(ladoDer, caso3)) {
            System.out.println("el lobo se comio a caperusita");
            System.exit(0);
        }        
        if (Arrays.equals(ladoDer, caso4)) {
            imprimir();
            System.out.println("Gano!!!!");
            System.exit(0);
        }        
    }
    public static void imprimir() {
        System.out.println("");
        for (int i = 0; i < ladoIzq.length; i++) 
            System.out.println(((ladoIzq[i]==1)? personajes[i]:vacio[i]) + "|" + ((ladoDer[i]==1)? personajes[i]:vacio[i]));
        System.out.println("");
    }
    public static void main(String[] args) {
        System.out.println("Bienvenido");
        System.out.println("Recuerde que el caballero siempre está en el bote y solo puede llevar a alguien desde su posición");
        do {
            navegar();
        } while (true);
    }
}