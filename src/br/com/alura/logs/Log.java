package br.com.alura.logs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {
    public String salvar(double valorInicial, double valorConverdito, String txt) {
        String texto = String.format("""
                Valor inicial: %.2f
                Valor convertido: %.2f
                Conversão: %s
                """, valorInicial, valorConverdito, txt);

        String caminho = "C:\\Users\\Usuario\\IdeaProjects\\ConversorDeMoedas + challenge\\logs\\log.txt";

        try{
            Files.write (Paths.get(caminho), texto.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return txt;
    }
}
