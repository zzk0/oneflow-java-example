package com.example;

import org.oneflow.core.job.Env.EnvProto;
import org.oneflow.core.job.Env.Machine;
import org.oneflow.env.Env;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EnvProto envProto = EnvProto.newBuilder()
                                .addMachine(Machine.newBuilder().setId(0)
                                .setAddr("127.0.0.1"))
                                .setCtrlPort(8888)
                                .build();
        System.out.println(envProto.toString());
        if (Env.isEnvInited()) {
            System.out.println("env inited");
        }
        else {
            System.out.println("try init");
            Env.initEnv(envProto.toString());
        }

        // check it
        if (Env.isEnvInited()) {
            System.out.println("ok");
        }
        else {
            System.out.println("no");
        }
    }
}