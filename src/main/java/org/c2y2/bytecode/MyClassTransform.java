package org.c2y2.bytecode;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyClassTransform implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(className.equalsIgnoreCase("burp/afp")){
            int i=0;
            for (int[] arrayOfInt = {31264, 0, 31265, 3, 31292, 0, 31293, 3, 31379, 167, 31380, 90, 31381, 36}; i < arrayOfInt.length; ) {
                classfileBuffer[arrayOfInt[i]] = (byte) arrayOfInt[i + 1];
                i += 2;
            }
            return classfileBuffer;
        }
        System.out.println(String.format("-----classloader [%s] className[%s]--------",loader.getClass().getName(),className));
        return null;
    }
}
