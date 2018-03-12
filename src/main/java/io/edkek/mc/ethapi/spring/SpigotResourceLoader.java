package io.edkek.mc.ethapi.spring;

import io.edkek.mc.ethapi.McEthereum;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class SpigotResourceLoader implements ResourceLoader {
    private final ResourceLoader delegate;

    public SpigotResourceLoader(ResourceLoader delegate) {
        this.delegate = delegate;
    }

    @Override
    public Resource getResource(String s) {
        return delegate.getResource(s);
    }

    @Override
    public ClassLoader getClassLoader() {
        return McEthereum.getSpigotClassLoader();
    }
}
