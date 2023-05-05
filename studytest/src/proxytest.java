import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxytest {

}
interface human{
    void say();
    void eat();
}
class Superman implements human{

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
