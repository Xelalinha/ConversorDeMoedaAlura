import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public String converterMoeda(String moedaPadrao, String moedaConvertida, Double valor){
        URI moedaLink = URI.create("https://v6.exchangerate-api.com/v6/a4ecb9058acc86e1767b1f66/latest/" + moedaPadrao);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(moedaLink)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Moeda moeda = new Gson().fromJson(response.body(), Moeda.class);
            Double taxa = moeda.conversion_rates().get(moedaConvertida);

            if (taxa == null) {
                throw new RuntimeException("Moeda de destino não encontrada nas taxas de conversão.");
            }

            Double valorConvertido = valor * taxa;

            return String.format("Valor: %.2f [%s] corresponde ao valor final de %.2f [%s]", valor, moedaPadrao, valorConvertido, moedaConvertida);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Erro ao realizar a conversão.";
        }
    }
}
