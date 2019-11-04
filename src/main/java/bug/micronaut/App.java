package bug.micronaut;

import io.micronaut.context.annotation.Factory;
import io.micronaut.runtime.Micronaut;

import javax.inject.Singleton;

public class App {

  public static void main(String[] args) {
    Micronaut.run(App.class, args);
  }
}
