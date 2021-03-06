package com.semantive.generator;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.RoundRobinPolicy;
import com.semantive.generator.threads.InsertThread;
import com.semantive.generator.threads.SelectThread;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {

        if(args.length != 2) {
            System.out.println("Parameters: <host> <keyspace>");
            return;
        }

        String host = args[0];
        String keyspace = args[1];

        Cluster cluster = null;
        Session session = null;

        try {
            cluster = Cluster.builder()
                    .addContactPoint(host)
                    .withLoadBalancingPolicy(new RoundRobinPolicy())
                    .build();

            session = cluster.connect(keyspace);

            System.out.println("Connected to C* server");

            SelectThread selectThread = new SelectThread(session);
            InsertThread insertThread = new InsertThread(session);

            insertThread.start();
            selectThread.start();

            insertThread.join();
            selectThread.join();
        }
        catch(Exception any) {
            System.out.println("Error happened: " + any.getMessage());
            exit(1);
        }
        finally {
            if(cluster != null)
                cluster.close();
        }
    }
}
