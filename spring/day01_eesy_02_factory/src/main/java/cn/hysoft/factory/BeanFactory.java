package cn.hysoft.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建一个bean对象
 * bean:可重用组件的含义（计算机英语）
 */
public class BeanFactory {

    private static Properties props;
    private static Map<String,Object> beans;

    static {
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans= new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }

}
