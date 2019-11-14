package com.example.helloworld.tasks;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.PostBodyTask;

import javax.inject.Inject;
import java.io.PrintWriter;

public class EchoTask extends PostBodyTask {

    @Inject
    public EchoTask() {
        super("echo");
    }

    @Override
    public void execute(ImmutableMultimap<String, String> parameters, String body, PrintWriter output) throws Exception {
        output.print(body);
        output.flush();
    }
}
