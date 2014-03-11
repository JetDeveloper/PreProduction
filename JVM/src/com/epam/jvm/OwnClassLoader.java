package com.epam.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Own class loader which compiles and loads up-to-date version of class
 *
 * @author Dmytro_Svynarenko
 */
public class OwnClassLoader extends ClassLoader {

    private Map classesHash = new HashMap();
    private String[] classPathes;
    private File File;

    public OwnClassLoader(String[] classPathes) {
        this.classPathes = classPathes;
    }

    @Override
    protected synchronized Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {

        Class result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        Class result;
        // if standart class load it with system class loader
        if (name.startsWith("java.")) {
            result = super.findSystemClass(name);
        } else {
            result = (Class) classesHash.get(name);
        }
        // if class is loaded	
        if (result != null) {
            return result;
        } else {
            try {
                File javaFile = findFile(name.replace('.', '/'), ".java");
                File classFile = compileJavaFile(javaFile.getCanonicalPath());
                /*System.out.println("% Class " + name + (classFile == null ? " not found"
                 : " found in " + classFile));*/
                if (classFile == null) {
                    return findSystemClass(name);
                }

                byte[] classBytes = loadFileAsBytes(classFile);
                result = defineClass(name, classBytes, 0, classBytes.length);
            } catch (IOException e) {
                throw new ClassNotFoundException("Cannot load class " + name
                        + ": " + e);
            } catch (ClassFormatError e) {
                throw new ClassNotFoundException("Format of class file incorrect"
                        + " for class " + name + ": " + e);
            }
            classesHash.put(name, result);
            return result;
        }


    }

    /**
     * Find file in file system
     *
     * @param name Class file name
     * @param extension file extension of class
     * @return File if class is founded or null if not
     */
    private File findFile(String name, String extension) {
        for (String currentFile : classPathes) {
            String pathFile = (new File(currentFile)).getPath()
                    + File.separatorChar + name.replace('/', File.separatorChar)
                    + extension;
            File resultFile = new File(pathFile);
            if (resultFile.exists()) {
                return resultFile;
            }
        }
        return null;
    }

    /**
     * Load file as array of bytes
     *
     * @param file file to load
     * @return byte array of file
     * @throws IOException if an error has occurred while working with file
     */
    public static byte[] loadFileAsBytes(File file) throws IOException {

        byte[] result = new byte[(int) file.length()];
        try (InputStream inputFileSteam = new FileInputStream(file)) {
            inputFileSteam.read(result, 0, result.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Spawn a process to compile the java source code file specified in the
     * 'javaFile' parameter. Return a true if the compilation worked, false
     * otherwise
     *
     * @param javaFile java file to compile
     * @return true - compilation success
     * @throws IOException
     */
    private File compileJavaFile(String javaFile) throws IOException {
        // Let the user know what's going on 
        //System.out.println("CCL: Compiling " + javaFile + "...");
        // Start up the compiler 
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        // Wait for it to finish running
        try {
            p.waitFor();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        // Check the return code, in case of a compilation error 
        int ret = p.exitValue();
        //System.out.println("CCL: Compilation " +((ret == 0)?"success":"failed"));
        // Tell whether the compilation worked 
        File classFile = findFile(javaFile.replaceAll(".java", ""), ".class");
        return classFile;
    }
}
