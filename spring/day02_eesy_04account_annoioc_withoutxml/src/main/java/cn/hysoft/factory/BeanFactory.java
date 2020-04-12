package cn.hysoft.factory;

import cn.hysoft.service.IAccoutService;
import cn.hysoft.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {
    @Autowired
    private IAccoutService accoutService;
    @Autowired
    private TransactionManager txManager;
    @Bean("proxyAccoutService")
    public IAccoutService getAccoutService (){
        return (IAccoutService)Proxy.newProxyInstance(accoutService.getClass().getClassLoader(),
                accoutService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            txManager.beginTransaction();
//                            List<Account> accounts=accoutDao.findAllAccount();
                            rtValue = method.invoke(accoutService,args);
                            txManager.commit();
                            return rtValue;
                        }catch (Exception e){
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            txManager.release();
                        }
                    }
                });

    }

}
