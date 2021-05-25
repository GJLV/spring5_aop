package com.sap.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class [] interfaces = {UserDao.class};
        UserDao userDao = new UserDaoImpl();
        UserDao o = (UserDao) Proxy.newProxyInstance(JDKProxy.class.
                getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = o.add(1,2);
        System.out.println(add);
    }
}
class UserDaoProxy implements InvocationHandler{
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //enhance before
        System.out.println("before execute...." + method.getName()+"..." + Arrays.toString(args));
        Object invoke = method.invoke(obj, args);
        System.out.println(obj);
        return invoke;
    }
}