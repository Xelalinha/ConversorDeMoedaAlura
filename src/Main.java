import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        String busca = "";
        double valor;

        try{
            while(!busca.equals("7")){
                System.out.println("-----------------------------------------------------");
                System.out.println("Seja bem vindo ao programa de conversão de Moedas!\n");
                System.out.println("Escolha uma opção válida:\n");
                System.out.println("1) Dólar -> Peso Argentino");
                System.out.println("2) Peso Argentino -> Dólar");
                System.out.println("3) Dólar -> Real Brasileiro");
                System.out.println("4) Real Brasileiro -> Dólar");
                System.out.println("5) Dólar -> Peso Colombiano");
                System.out.println("6) Peso Colombiano -> Dólar");
                System.out.println("7) Sair");
                System.out.println("-----------------------------------------------------");

                busca = leitura.nextLine();

                if(busca.equals("7")){
                    break;
                }

                System.out.println("Digite o valor que deseja converter: ");
                valor = leitura.nextDouble();
                leitura.nextLine();

                switch (busca) {
                    case "1" -> System.out.println(conversor.converterMoeda("USD", "ARS", valor));
                    case "2" -> System.out.println(conversor.converterMoeda("ARS", "USD", valor));
                    case "3" -> System.out.println(conversor.converterMoeda("USD", "BRL", valor));
                    case "4" -> System.out.println(conversor.converterMoeda("BRL", "USD", valor));
                    case "5" -> System.out.println(conversor.converterMoeda("USD", "COP", valor));
                    case "6" -> System.out.println(conversor.converterMoeda("COP", "USD", valor));
                    default -> System.out.println("Numero Invalido, Tente novamente!");
                }
            }

        }catch(Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }finally{
            System.out.println("Encerrando o sistema...");
        }
    }
}