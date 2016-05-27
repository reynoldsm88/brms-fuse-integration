package com.redhat.test.application.outbound.routes;

import org.apache.camel.builder.RouteBuilder;

public class OutboundRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from( "amq:queue:outbound" ).id( "test-application-outbound" ).routeId( "test-application-outbound" )
                .log( "Message is off to topic" )
            .to( "log:test-application-outbound-exchange-log" )
                .split().body()
            .to( "amq:topic:test-topic" );
        
        from("amq:topic:test-topic").id( "dummy-topic-consumer" ).routeId( "dummy-topic-consumer" )
                .log( "picked up off the topic : ${body}" );
//            .to( "mock:end" );
        //@formatter:on
    }

}
