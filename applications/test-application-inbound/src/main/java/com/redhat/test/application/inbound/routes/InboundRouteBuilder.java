package com.redhat.test.application.inbound.routes;

import org.apache.camel.builder.RouteBuilder;

import com.redhat.test.application.parser.CustomFormatParser;

public class InboundRouteBuilder extends RouteBuilder {

    private CustomFormatParser parser;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from("activemq:queue:test-application-inbound")
                .routeId( "test-application-inbound" )
                .id( "test-application-inbound" )
                .bean( parser )
                .log( "${body}" )
            .to( "vm:test-application-xlate" );
        //@formatter:on

    }

    public CustomFormatParser getParser() {
        return parser;
    }

    public void setParser( CustomFormatParser parser ) {
        this.parser = parser;
    }

}