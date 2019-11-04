package bug.micronaut;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;

import javax.inject.Singleton;

@Singleton
public class MyAnotInterceptor implements MethodInterceptor<Object, Object> {

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    System.out.println("around advice invoked");
    return context.proceed();
  }
}
