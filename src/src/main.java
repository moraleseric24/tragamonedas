public class main {

    private static final int SALDOINICIAL=1000;
    private static final int CANTIDADRUEDAS=3;

    public static void main(String[] args){

        tragamonedas();
    }

    private static void tragamonedas() {
        int saldoActual=SALDOINICIAL;
        mensaje(1, saldoActual);
        while (saldoActual>0){
            mensaje(2, saldoActual);

            saldoActual=-1;
        }


    }

    private static void mensaje(int i, int saldoActual) {
        switch (i){
            case 1:
                System.out.println("Bienvenidos al Tragamonedas de Ing. de Software");
                System.out.println("===============================================");
                break;
            case 2:
                System.out.println("Su saldo actual es de $"+saldoActual+". ¿Cuánto desea apostar?");
                break;
            case 3:
                System.out.println(saludo()+", gracias por jugar. Su saldo final es de $"+saldoActual);
                break;
        }

    }

    private static String saludo() {
        return null;
    }
}
