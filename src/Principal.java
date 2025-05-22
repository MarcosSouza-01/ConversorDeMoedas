import br.com.alura.menu.ConversorMenu;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException , InterruptedException {
        ConversorMenu conversorMenu = new ConversorMenu();
        System.out.println(" " +
                "-=-=-=-= Bem-vindo ao conversor de moedas! -=-=-=-=-" +
                " ");
        System.out.println("       -=-=-=-=-= Escolha uma opção: -=-=-=-=-=- ");

        conversorMenu.menu();

    }
}
