package br.com.alura.logs;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Leitura {
    public void leituralog(String caminho) {
        File arquivo = new File(caminho);
        try {
            Scanner scanner = new Scanner(arquivo);
            if (arquivo.exists() && arquivo.length() > 0) {
                System.out.println();
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    System.out.println(linha);
                }
                System.out.println("-------------------------------------------");
                System.out.println();
            } else {
                System.out.println();
                    System.out.println("Não há histórico de conversão.");
                System.out.println("-------------------------------------------");
                System.out.println();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado." + e.getMessage());
        }
    }
}