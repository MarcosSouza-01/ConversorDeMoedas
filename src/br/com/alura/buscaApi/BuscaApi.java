package br.com.alura.buscaApi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApi {
    private Gson gson = new Gson();
    private final String chaveAPI = System.getenv("EXCHANGERATE_API_KEY");

    public Double conversao(String converterDe, String converterPara, double valor)
        throws IOException, InterruptedException {
        String URL = "https://v6.exchangerate-api.com/v6/" + this.chaveAPI + "/latest/" + converterDe;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        if (!jsonObject.has("conversion_rates")) {
            throw new IOException("Resposta inesperada da API: " + json);
        }
        JsonObject taxas = jsonObject.getAsJsonObject("conversion_rates");
        if (!taxas.has(converterPara)) {
            throw new IOException("Moeda de destino não encontrada: " + converterPara);
        }
        double taxa = taxas.get(converterPara).getAsDouble();
        return valor * taxa;

    }
}
