package bug.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@MyAnot
@Controller("/example/bug")
public class MyController {

  @Get
  public String get() {
    return "yes";
  }
}
