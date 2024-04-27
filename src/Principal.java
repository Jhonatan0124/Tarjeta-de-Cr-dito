import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el limite de tu targeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito targeta  = new TarjetaDeCredito(limite);

        int salir = 3;
        while(salir != 0) {
            System.out.println("Escriba la Descripcion de la Compra: ");
            String Descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra");
            double valor = Double.valueOf(lectura.next());

            String descripcion = "";
            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = targeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada");
                System.out.println("Escriba 0 para salir o 1 para Continuar");
                salir = lectura.nextInt();
            } else {
                System.out.println("Saldo Insuficiente");
                salir=0;
            }
        }
            System.out.println("***********************************");
            System.out.println("Compras Realizadas: \n");
            Collections.sort(targeta.getListDeCompras());
            for (Compra compra : targeta.getListDeCompras()) {
                System.out.println(compra.getDescripcion() + "-" +compra.getValor());
            }

            System.out.println("***********************************");
            System.out.println("\nSaldo de la targeta:" + targeta.getSaldo());

    }
}