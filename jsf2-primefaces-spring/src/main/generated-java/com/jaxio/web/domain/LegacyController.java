/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Controller.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.repository.LegacyRepository;
import com.jaxio.web.conversation.Conversation;
import com.jaxio.web.conversation.ConversationFactory;
import com.jaxio.web.domain.support.GenericController;

/**
 * Stateless controller for {@link Legacy}.
 */
@Named
@Singleton
public class LegacyController extends GenericController<Legacy, LegacyPk> implements ConversationFactory {

    @Inject
    public LegacyController(LegacyRepository legacyRepository) {
        super(legacyRepository);
    }

    // --------------------------------------------
    // ConversationFactory impl
    // --------------------------------------------

    @Override
    public boolean canCreateConversation(HttpServletRequest request) {
        return LegacyContext.selectUri.equals(request.getServletPath());
    }

    @Override
    public Conversation createConversation(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (LegacyContext.selectUri.equals(uri)) {
            Conversation conversation = Conversation.newInstance(request);
            LegacyContext ctx = new LegacyContext();
            ctx.setLabelWithKey("legacy");
            ctx.setViewUri(LegacyContext.selectUri);
            conversation.push(ctx);
            return conversation;
        }

        throw new IllegalStateException("Unexpected conversation creation demand");
    }

    protected final LegacyContext legacyContext() {
        return conversation().getCurrentContext();
    }
}