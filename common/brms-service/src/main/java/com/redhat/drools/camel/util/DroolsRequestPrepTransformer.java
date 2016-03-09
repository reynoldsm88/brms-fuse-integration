package com.redhat.drools.camel.util;

import java.util.Collection;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Headers;

import com.redhat.drools.camel.api.RulesRequest;

/**
 * We can probably make a generic one like this using reflection
 *
 */
public class DroolsRequestPrepTransformer {

    public RulesRequest prepareRequest( @Body Object body, @Headers Map<String, Object> headers ) {
        String requestClassName = (String) headers.get( "com.redhat.drools.camel.request.class" );
        String ksession = (String) headers.get( "com.redhat.drools.camel.ksession" );
        String process = (String) headers.get( "com.redhat.drools.camel.process" );
        RulesRequest request = null;
        try {
            Class<?> responseClass = this.getClass().getClassLoader().loadClass( requestClassName );
            request = (RulesRequest) responseClass.newInstance();
            addFacts( request, body );
            request.setKieSession( ksession );
            request.setProcessName( process );
        }
        catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch ( InstantiationException e ) {
            e.printStackTrace();
        }
        catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings( "unchecked" )
    private void addFacts( RulesRequest request, Object body ) {
        if ( body instanceof Collection ) {
            Collection<Object> collection = (Collection<Object>) body;
            for ( Object o : collection ) {
                request.addFact( o );
            }
        }
        else {
            request.addFact( body );
        }
    }

}
