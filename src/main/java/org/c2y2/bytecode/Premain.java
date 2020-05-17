package org.c2y2.bytecode;

import java.lang.instrument.Instrumentation;

public class Premain {
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException {
        inst.addTransformer(new MyClassTransform());
    }
}
