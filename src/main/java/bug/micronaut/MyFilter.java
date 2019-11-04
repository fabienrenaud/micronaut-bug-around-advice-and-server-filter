package bug.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Filter("/**")
public class MyFilter implements HttpServerFilter {

  @Override
  public Publisher<MutableHttpResponse<?>> doFilter(
      HttpRequest<?> request, ServerFilterChain chain) {
    System.out.println("doFilter");
    Publisher<MutableHttpResponse<?>> p = chain.proceed(request);
    p.subscribe(
        new Subscriber<>() {
          @Override
          public void onSubscribe(Subscription s) {
            System.out.println("  filter - onSubscribe");
            s.request(1);
          }

          @Override
          public void onNext(MutableHttpResponse<?> mutableHttpResponse) {
            System.out.println("  filter - onNext");
          }

          @Override
          public void onError(Throwable t) {
            System.out.println("  filter - onError");
          }

          @Override
          public void onComplete() {
            System.out.println("  filter - onComplete");
          }
        });
    return p;
  }
}
