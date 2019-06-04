/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

/**
 *
 * @author leandro
 */
public class Teste {

    public static void main(String[] args) {

        Login user = new Login("leleo", "salt", "hash");
        test(user);
        System.out.println("Preparado: " + prepareLine(user));

    }

    public ArrayList attributeList(Object obj) {
        try {
            ArrayList list = new ArrayList();
            
            Map<String, Object> attributes = getAttributesMap(obj);
            for (String key : attributes.keySet()) {
                if (!key.equals("Class")) {
                    list.add(new String(key.substring(0, 1).toLowerCase() + key.substring(1)));
                }
            }
            
            return list;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            return null;
        }
    }

    public static String prepareLine(Object obj) {
        try {
            Map<String, Object> attributes = getAttributesMap(obj);
            String line = "";
            for (String key : attributes.keySet()) {
                if (!key.equals("Class")) {
                    System.out.println("atributo: " + key);
                    line += new String(key.substring(0, 1).toLowerCase() + key.substring(1)) + "," + attributes.get(key) + ",";
                }
            }
            String result = line.substring(0, line.lastIndexOf(",")) + ";"
                    + System.getProperty("line.separator");
            System.out.println("Linha:" + result);
            return result;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void imprime(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<String, Object> attributes = getAttributesMap(obj);
        String line = "";
        for (String key : attributes.keySet()) {
            if (!key.equals("Class")) {
                line += attributes.get(key) + ",";
            }
        }
        String result = line.substring(0, line.lastIndexOf(",")) + ";"
                + System.getProperty("line.separator");
        System.out.println("Linha:" + result);
    }

    public static void test(Object panel) {
//        for (Object obj : panel()) {
//             
//            Class cls = obj.getClass();
//            try{
//                Method mtd = cls.getMethod("setSelected", new Class[] 
//        {boolean.class} );
//                mtd.invoke(obj, new Object[] {true});
//                 
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }

        /*
         * Carregamos a classe Arquivo através do Class.forName que nos possibilita
         * carregar uma classe através de uma dada string que deve corresponder ao local
         * onde a classe está, além disso, por padrão a classe é carregada no ClassLoader
         * que está sendo utilizado pela classe que está executando o comando.
         * */
        String className = panel.getClass().getName();
        Object arquivoFromReflection = null;
        try {
            arquivoFromReflection = Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String name = "";
        String upCase = "";
        for (Field f : arquivoFromReflection.getClass().getDeclaredFields()) {
            name = f.getName();
            upCase = name.substring(0, 1).toUpperCase();
            upCase += name.substring(1, name.length());
            System.out.println(upCase);
            upCase = "";
            name = "";
        }
//
//        // TODO Auto-generated catch block
//        // TODO Auto-generated catch block
//        //Recupera o nome da classe
//        System.out.println("Nome da Classe: " + arquivoFromReflection.getClass().getName());
//        /*
//         * A Classe Method do Reflection nos da a possibilidade de manusear
//         * todos os métodos dentro do objeto carregado 
//         * */
//        System.out.println("");
//        System.out.println("Métodos: ");
//        for (Method m : arquivoFromReflection.getClass().getMethods()) {
//            System.out.print(m.getName() + ", ");
//        }
//
//        /*
//         * Vamos agora capturar os atributos da classe. Temos agora outra classe 
//         * muito importante para uso do Reflection, a classe Field. Esta nos permite
//         * manusear os campos/fields da nossa classe carregada.
//         * */
//        System.out.println("");
//        System.out.println("Atributos: ");
//        for (Field f : arquivoFromReflection.getClass().getDeclaredFields()) {
//            System.out.print(f.getName() + ", ");
//        }
//
//        /*
//         * Perceba que nossa abordagem é bem simples, ou seja, estamos capturando apenas
//         * os nomes dos métodos e atributos, mas você pode ir muito além, capturando os modificadores, 
//         * tipos, retorno e etc.
//         * */
    }

    public static Map<String, Object> getAttributesMap(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Map<String, Object> attributesMap = new HashMap<String, Object>();

        Class<?> objClass = obj.getClass();
        Method[] methods = objClass.getMethods();
        Field[] fields = objClass.getFields();

        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

//        try {
//            Method me = objClass.getMethod("getUserName", null);
//            Object valor = me.invoke(obj);
//            System.out.println("VAlor obtido:"+valor.toString());
//            me = objClass.getMethod("setUserName");
//            me.invoke(obj, "leandro");
//            me = objClass.getMethod("getUserName", null);
//            valor = me.invoke(obj);
//            System.out.println("VAlor obtido2:"+valor.toString());
//        } catch (NoSuchMethodException ex) {
//            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
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

    private static String getAttributeName(String name) {
        return name.substring(3);
    }
}
