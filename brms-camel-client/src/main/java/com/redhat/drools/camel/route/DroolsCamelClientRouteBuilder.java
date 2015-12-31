package com.redhat.drools.camel.route;

import org.apache.camel.builder.RouteBuilder;

import com.redhat.drools.camel.api.RulesService;
import com.redhat.drools.camel.request.DroolsRequestPrepBean;

public class DroolsCamelClientRouteBuilder extends RouteBuilder {

    private RulesService rulesService;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from("activemq:queue:myQueue")
                .bean( new DroolsRequestPrepBean() )
                .bean(rulesService, "execute" )
                .setBody( simple( "${body.getMyOthjerModelObjResults}" ) )
                .log( "${body}" )
            .to("mock:end");
        //@formatter:on
    }

    public RulesService getRulesService() {
        return rulesService;
    }

    public void setRulesService( RulesService rulesService ) {
        this.rulesService = rulesService;
    }

}
