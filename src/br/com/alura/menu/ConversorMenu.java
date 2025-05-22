package br.com.alura.menu;

import br.com.alura.buscaApi.BuscaApi;
import br.com.alura.logs.Leitura;
import br.com.alura.logs.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class ConversorMenu {
    public void menu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BuscaApi buscaApi = new BuscaApi();
        Log log = new Log();
        List<String> listaDeLog = new ArrayList<>();

        while (true) {
            try{
                System.out.println("============================================");
                System.out.println("[1] - (USD) Dólar para (BRL) Real Brasileiro");
                System.out.println("[2] - (BRL) Real Brasileiro para (USD) Dólar");
                System.out.println("[3] - (USD) Dólar para (ARS) Peso Argentino");
                System.out.println("[4] - (ARS) Peso Argentino para (USD) Dólar");
                System.out.println("[5] - (USD) Dólar para (EUR) Euro");
                System.out.println("[6] - (EUR) Euro para (USD) Dólar");
                System.out.println("[7] - (USD) Dólar para (GBP) Libras");
                System.out.println("[8] - (GBP) Libras para (USD) Dólar");
                System.out.println("============================================");
                System.out.println("[9] - Mostrar histórico de conversão");
                System.out.println("[10] - Sair da aplicação");
                System.out.print("Digite a opção ==> ");

                String opcao = scanner.next();
                int opcaoInt = Integer.parseInt(opcao);

                if (opcaoInt == 10 ) {
                    System.out.println();
                    System.out.println("Saindo da aplicação...");
                    System.out.println("Até logo!");
                    break;
                } else if(opcaoInt <= 0 || opcaoInt > 10) {
                    System.out.println();
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println();
                    continue;
                } else if ( opcaoInt == 9){
                    if (listaDeLog.isEmpty()){
                        String caminho = "C:\\Users\\Usuario\\IdeaProjects\\ConversorDeMoedas + challenge\\logs\\log.txt";

                        Leitura leitura = new Leitura();
                        leitura.leituralog(caminho);
                        continue;

                    } else {
                        System.out.println();
                        for (String logItem : listaDeLog) {
                            System.out.println(logItem);
                        }
                        System.out.println();
                        continue;
                    }
                }
                System.out.println();
                System.out.println("Digite o valor a ser convertido: ");

                String valor = scanner.next();
                double valorDouble = Double.parseDouble(valor);

                System.out.println();

                switch (opcaoInt){
                    case 1:
                        System.out.println(String.format("""
                            Valor convertido: R$ %.2f
                            """, buscaApi.conversao("USD", "BRL", valorDouble)));
                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("USD", "BRL", valorDouble),
                                "Dólar ==> Real"
                        ));
                        break;

                    case 2:
                        System.out.println(String.format("""
                            Valor convertido: $ %.2f
                            """ ,buscaApi.conversao("BRL", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("BRL", "USD", valorDouble),
                                "Real Brasileiro ==> Dólar"
                        ));
                        break;
                    case 3:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, buscaApi.conversao("USD", "ARS", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("USD", "ARS", valorDouble),
                                "Dólar ==> Peso Argentino"
                        ));
                        break;
                    case 4:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, buscaApi.conversao("ARS", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("ARS", "USD", valorDouble),
                                "Peso Argentino ==> Dólar"
                        ));
                        break;
                    case 5:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, buscaApi.conversao("USD", "EUR", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("USD", "EUR", valorDouble),
                                "Dólar ==> Euro"
                        ));
                        break;
                    case 6:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, buscaApi.conversao("EUR", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("EUR", "USD", valorDouble),
                                "Euro ==> Dólar"
                        ));
                        break;
                    case 7:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, buscaApi.conversao("USD", "GBP", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("USD", "GBP", valorDouble),
                                "Dólar ==> Libras"
                        ));
                        break;
                    case 8:
                        System.out.println(String.format("""
                                Valor convertido: £%.2f
                                """, buscaApi.conversao("GBP", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, buscaApi.conversao("GBP", "USD", valorDouble),
                                "Libras ==> Dólar"
                        ));
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Digite um valor inteiro!");
                System.out.println();
            }
        }
    }
}
