import java.util.*;

public class Main {
    static int ladoIzq[] = { 1, 1, 1, 1 };
    static int ladoDer[] = { 0, 0, 0, 0 };
    static String personajes[] = { "caballero ", "caperucita", "lobo      ", "uvas      " };
    static String vacio[]={"          ","          ","          ","          "};

    // Función para ingresar un numero en la consola
    public static int eleccionPersonajes() {
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
    
    // Función que permite navegar en el bote con el caballero
    public static void navegar() { 
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
    
    // Función que verifica los casos posibles, en la derecha e izquierda, comparando los arreglos de casos con lo de los lados
    public static void verificarReglas() {
        int casos[][] = {{ 0, 1, 1, 1 },{ 0, 1, 0, 1 },{ 0, 1, 1, 0 },{ 1, 1, 1, 1 }};
        for (int i = 0; i < 3; i++) {
            if (Arrays.equals(ladoIzq, casos[i]) || Arrays.equals(ladoDer, casos[i])) {
                System.out.println((i==0)?"el lobo se comio a caperusita || caperusita se comio a las uvas\nHAZ PERDIDO\n":(i==1)?"Caperusita se comio a las uvas\nHAZ PERDIDO\n":"el lobo se comio a caperusita\nHAZ PERDIDO\n");
                System.exit(0);
            }
        }    
        if (Arrays.equals(ladoDer, casos[3])) {
            imprimir();
            System.out.println("Gano!!!!");
            System.exit(0);
        }        
    }

    //Funcion que imprimir en consola la iteraccion de los personajes al cruzar de un lado al 
    public static void imprimir() {
        System.out.print("\033[H\033[2J");
        System.out.println("");
        for (int i = 0; i < ladoIzq.length; i++) 
            System.out.println(((ladoIzq[i]==1)? personajes[i]:vacio[i]) +" |~~~~~| "+ ((ladoDer[i]==1)? personajes[i]:vacio[i]));
        System.out.println("");
    }
    
    //Función de ejecución
    public static void main(String[] args) {
        System.out.println("Bienvenido");
        System.out.println("Recuerde que el caballero siempre está en el bote y solo puede llevar a alguien desde su posición");
        while (true)
            navegar();
    }
}