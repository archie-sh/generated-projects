package com.jaxio.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class LocaleResolverRequestFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(LocaleResolverRequestFilter.class);

    /** Well-known name for the LocaleResolver object in the bean factory for this namespace. */
    public static final String LOCALE_RESOLVER_BEAN_NAME = "localeResolver";

    private LocaleResolver localeResolver;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (context == null) {
            useDefaultLocaleResolver();
        } else {
            initLocaleResolver(context);
        }
    }

    /**
     * Initialize the LocaleResolver used by this class.
     * <p>
     * If no bean is defined with the given name in the BeanFactory for this namespace, we default to AcceptHeaderLocaleResolver.
     */
    private void initLocaleResolver(ApplicationContext context) {
        try {
            this.localeResolver = context.getBean(LOCALE_RESOLVER_BEAN_NAME, LocaleResolver.class);
            log.debug("Using LocaleResolver {}", this.localeResolver);
        } catch (NoSuchBeanDefinitionException ex) {
            useDefaultLocaleResolver();
        }
    }

    private void useDefaultLocaleResolver() {
        // We need to use the default, retrieve locale from request.
        this.localeResolver = new AcceptHeaderLocaleResolver();
        log.debug("Unable to locate LocaleResolver with name '{}': using default {}", LOCALE_RESOLVER_BEAN_NAME, this.localeResolver);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LocaleContextHolder.setLocale(localeResolver.resolveLocale(request));
        filterChain.doFilter(request, response);
    }
}
