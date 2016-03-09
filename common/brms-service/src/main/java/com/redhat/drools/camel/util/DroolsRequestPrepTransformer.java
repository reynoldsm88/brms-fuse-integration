package com.redhat.drools.camel.util;

import org.apache.camel.Body;

import com.redhat.drools.camel.api.RulesRequest;


/**
 * We can probably make a generic one like this using reflection
 *
 */
public class DroolsRequestPrepTransformer {

    public RulesRequest prepareRequest( @Body Object body ) {
        return null;
    }

}
