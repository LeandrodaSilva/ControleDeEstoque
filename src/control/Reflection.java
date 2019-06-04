/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.Teste.getAttributesMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leandro
 */
public class Reflection {

    public static Map<String, Object> getAttributesMap(Object obj) {

        Map<String, Object> attributesMap = new HashMap<String, Object>();

        Class<?> objClass = obj.getClass();
        Method[] methods = objClass.getMethods();
        Field[] fields = objClass.getFields();
        
        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }
        
        
        
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getReturnType() != void.class) {
                String attributeName = getAttributeName(method.getName());
                try {
                    Object value = method.invoke(obj);
                    attributesMap.put(attributeName, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return attributesMap;
    }
    
    public static String prepareLine(Object obj) {
        Map<String, Object> attributes = getAttributesMap(obj);
        String line = "";
        for (String key : attributes.keySet()) {
            if (!key.equals("Class")) {
               line +=  attributes.get(key) + ",";
            }
        }
        String result = line.substring(0, line.lastIndexOf(",")) + ";"
                + System.getProperty("line.separator");
        System.out.println("Linha:"+result);
        return result;
    }
    
    private static String getAttributeName(String name) {
        return name.substring(3);
    }
}
