import java.util.Date;
import java.util.Scanner;

public class main {

    private static final int SALDOINICIAL=1000;
    private static final int CANTIDADRUEDAS=3;

    public static void main(String[] args){
        tragamonedas();
    }

    private static void tragamonedas() {
        int saldoActual=SALDOINICIAL;
        int apuesta=0;
        int condicion=1;
        int premio=0;

        mensaje(1, saldoActual,0);
        while (saldoActual>0 && condicion==1){
            apuesta=ingresarApuesta(saldoActual);
            saldoActual=saldoActual-apuesta;
            if(apuesta==0){
                condicion=0;
            }else{
                premio=girarRueda(apuesta);
                mensaje(3,saldoActual,premio);
                saldoActual=saldoActual+premio;
            }
        }
        if(saldoActual==0) mensaje(4,saldoActual,0);
        else mensaje(5,saldoActual,0);

    }

    private static int girarRueda(int apuesta) {
        String margen="+";
        String display="|";
        int valor=0;
        int igual=1;
        int zeros=0;
        int last=-1;
        for (int i=0;i<3;i++){
            valor= (int) (10*Math.random());
            if(last!=-1 && last!=valor) igual=0;
            last=valor;
            switch (valor){
                case 0:
                    display=display+" * |";
                    zeros++;
                    break;
                default:
                    display=display+" "+valor+" |";
                    break;
            }
            margen=margen+"---+";
        }
        System.out.println("\n"+margen);
        System.out.println(display);
        System.out.println(margen+"\n");

        switch (zeros){
            case 1:
                return 50;
            case 2:
                return 300;
            case 3:
                return 500;
            default:
                if(igual==1) return valor*apuesta;
                else return 0;
        }
    }

    private static int ingresarApuesta(int saldoActual) {
        Scanner sc=new Scanner(System.in);
        int apuesta;
        do {
            mensaje(2,saldoActual,0);
            while (!sc.hasNextInt()) {
                System.out.println("Eso no es una cantidad!");
                sc.next();
            }
            apuesta = sc.nextInt();
        } while (apuesta < 0 || apuesta>saldoActual);
        return apuesta;
    }

    private static void mensaje(int i, int saldoActual, int premio) {
        switch (i){
            case 1:
                System.out.println("Bienvenidos al Tragamonedas de Ing. de Software");
                System.out.println("===============================================");
                break;
            case 2:
                System.out.println("Su saldo actual es de $"+saldoActual+". ¿Cuánto desea apostar?");
                break;
            case 3:
                System.out.println("Ud. obtiene $"+premio+"!\n");
                break;
            case 4:
                System.out.println("Muchas Gracias por jugar. Mejor suerte la próxima vez.");
                break;
            case 5:
                System.out.println(saludo()+", gracias por jugar. Su saldo final es de $"+saldoActual);
                break;
        }
    }

    private static String saludo() {
        Date date = new Date();
        switch (date.getHours()) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return "Buenos dias";
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return "Buenas tardes";
            default:
                return "Buenas noches";
        }
    }

}
