package com.seven.test.es.jest;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;

/**
 * Created by seven on 02/12/15.
 */
public class ESFactory {
    private static JestHttpClient client;

    private ESFactory() {

    }

    public synchronized static JestHttpClient getClient() {
        if (client == null) {
            JestClientFactory factory = new JestClientFactory();
            factory.setHttpClientConfig(new HttpClientConfig.Builder(
                    "http://localhost:9200").multiThreaded(true).build());
            client = (JestHttpClient) factory.getObject();
        }
        return client;
    }

    public static void main(String[] args) {
        JestHttpClient client = ESFactory.getClient();
        System.out.println(client.getAsyncClient());
        System.out.println(client.getServers());
        client.shutdownClient();
    }
}
