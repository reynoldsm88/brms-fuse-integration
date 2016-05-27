package com.redhat.test.application.inbound.routes;

import org.apache.camel.builder.RouteBuilder;

import com.redhat.drools.camel.model.MyModelObj;
import com.redhat.test.application.type.converters.StringToModelTypeConverter;

public class InboundRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        getContext().getTypeConverterRegistry().addTypeConverter( MyModelObj.class, String.class, new StringToModelTypeConverter() );

        //@formatter:off
        from("amq:queue:test-application-inbound").routeId( "test-application-inbound" ).id( "test-application-inbound" )
                .convertBodyTo( MyModelObj.class )
                .log( "${body}" )
            .to( "amq:queue:xlate" );
        //@formatter:on

    }
}
