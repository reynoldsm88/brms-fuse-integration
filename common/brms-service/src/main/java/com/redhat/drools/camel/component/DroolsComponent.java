package com.redhat.drools.camel.component;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.UriEndpointComponent;

public class DroolsComponent extends UriEndpointComponent {

    public DroolsComponent( CamelContext context, Class<? extends Endpoint> endpointClass ) {
        super( context, endpointClass );
    }

    @Override
    protected Endpoint createEndpoint( String uri, String remaining, Map<String, Object> parameters ) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
