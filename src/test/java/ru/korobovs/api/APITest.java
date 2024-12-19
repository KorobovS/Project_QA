package ru.korobovs.api;

import com.google.common.net.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import ru.korobovs.project.ProjectUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APITest {

    private static final Logger log = LoggerFactory.getLogger(APITest.class);

    @Test
    public void testHttp(Method method, ITestResult testResult) throws URISyntaxException, IOException, InterruptedException {
        ProjectUtils.logf("Запускается %s.%s", this.getClass().getName(), method.getName());

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://pokeapi.co/api/v2/pokemon"))
                .headers(HttpHeaders.USER_AGENT, "Googlebot")
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        String body = httpResponse.body();
        Assert.assertNotNull(body);

        ProjectUtils.logf("Время выполнения %.3f sec", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0);
    }

    @Test
    public void testSWapi(Method method, ITestResult testResult) throws URISyntaxException, IOException, InterruptedException {
        ProjectUtils.logf("Запускается %s.%s", this.getClass().getName(), method.getName());

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://www.swapi.tech/api/planets/1/"))
                .headers(HttpHeaders.USER_AGENT, "Googlebot")
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        String body = httpResponse.body();
        Assert.assertTrue(body.startsWith("{\"message\":\"ok\""));

        ProjectUtils.logf("Время выполнения %.3f sec", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0);
    }
}
