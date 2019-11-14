package com.example.helloworld.cli;

import com.example.helloworld.HelloWorldConfiguration;
import com.example.helloworld.core.Template;
import io.dropwizard.cli.ConfiguredCommand;
import io.dropwizard.setup.Bootstrap;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Slf4j
public class RenderCommand extends ConfiguredCommand<HelloWorldConfiguration> {

    public RenderCommand() {
        super("render", "Render the template data to console");
    }

    @Override
    public void configure(Subparser subparser) {
        super.configure(subparser);
        subparser.addArgument("-i", "--include-default")
                 .action(Arguments.storeTrue())
                 .dest("include-default")
                 .help("Also render the template with the default name");
        subparser.addArgument("names").nargs("*");
    }

    @Override
    protected void run(Bootstrap<HelloWorldConfiguration> bootstrap,
                       Namespace namespace,
                       HelloWorldConfiguration configuration) throws Exception {
        final Template template = configuration.buildTemplate();

        if (namespace.getBoolean("include-default")) {
            log.info("DEFAULT => {}", template.render(Optional.empty()));
        }

        for (String name : namespace.<String>getList("names")) {
            for (int i = 0; i < 1000; i++) {
                log.info("{} => {}", name, template.render(Optional.of(name)));
                Thread.sleep(1000);
            }
        }
    }
}
