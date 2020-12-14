package org.acme.commandmode;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusMain
public class HelloCommando {
    private static final Logger LOG = LoggerFactory.getLogger(HelloCommando.class);

    public static void main(String... args) {
        Quarkus.run(Application.class, args);
    }

    public static class Application implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            LOG.info("Start Up");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
