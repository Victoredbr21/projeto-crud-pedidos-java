import java.util.Scanner;

import entities.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite seu email: ");
        String email = scan.nextLine();
        System.out.println("Digite sua data de aniversário");
        String data = scan.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = null;
        try {
            dataConvertida = formato.parse(data);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
        }

        Client Client = new Client(nome, email, dataConvertida);

        System.out.println("Qual o status do produto? ");
        String statusDigitado = scan.nextLine();
        OrderStatus status = OrderStatus.valueOf(statusDigitado);
        System.out.println("Quantos itens terá no pedido ?");
        Integer Itens = scan.nextInt();
        scan.nextLine();
        Date moment = new Date();

        

        }// essa chave fecha a main
    } // essa chave fecha a classe
