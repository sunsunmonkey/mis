import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class proxytest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Human ph = (Human) ProxyFactory.getProxyInstance(superman);
        ph.say();
        ph.eat();
        Function<Object,Object> function = (a)->{
            System.out.println(a.getClass());
            System.out.println("函数就是爹");
            return null;
        };
        Consumer<String> s = System.out::println;
        s.accept("hhh");
        function.apply(123);



    }

}
interface Human{
    void say();
    void eat();
}
class Superman implements Human{

    @Override
    public void say() {
        System.out.println("hello");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

class ProxyFactory {

    public static Object getProxyInstance(Object obj) {
        MyInvocation handler = new MyInvocation();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocation implements InvocationHandler{
    private Object obj;
    public void  bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj,args);
        return returnValue;
    }
}
