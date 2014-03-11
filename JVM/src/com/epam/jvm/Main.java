package com.epam.jvm;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {

    public static void main(String[] args) throws Exception {
        for (;;) {
            //own class loader with class pathes for run in NetBeans
            ClassLoader loader = new OwnClassLoader(new String[]{".", "", 
                "C:\\Users\\Dmytro_Svynarenko\\Documents\\NetBeansProjects\\JVM\\src"});
            Class clas = Class.forName("com.epam.jvm.TestModule", true, loader);
            Object object = clas.newInstance();
            System.out.println(object);
            Thread.sleep(500);
        }
    }
}
