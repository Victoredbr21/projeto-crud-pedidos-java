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

        

        }// essa chave fecha a main
    } // essa chave fecha a classe
