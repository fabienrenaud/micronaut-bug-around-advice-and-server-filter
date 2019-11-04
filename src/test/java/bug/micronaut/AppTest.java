package bug.micronaut;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class AppTest {

  @Inject EmbeddedServer server;

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void testMockBean() {
    String res = client.toBlocking().retrieve("/example/bug");
    System.out.println("Response: " + res);
  }
}
