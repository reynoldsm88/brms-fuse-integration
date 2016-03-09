package com.redhat.test.application.xlate.routes;

import org.apache.camel.builder.RouteBuilder;

import com.redhat.drools.camel.api.RulesService;
import com.redhat.test.application.drools.request.TestAppDroolsResponse;
import com.redhat.test.application.xlate.util.TestAppDroolsRequestHelper;

public class XlateRouteBuilder extends RouteBuilder {

    private TestAppDroolsRequestHelper droolsPrepBean;
    private RulesService rulesService;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from( "vm:test-application-xlate" ).id( "test-application-xlate" ).routeId( "test-application-xlate" )
                .setHeader( "com.redhat.drools.camel.rules.response" ).constant( new TestAppDroolsResponse() ) 
                .setHeader( "com.redhat.drools.camel.ksession", simple( "test-ksession" ) )
                .bean( rulesService, "executeNew" ).log( "2) ${body}" )
                .setBody( simple( "${body.getMyOtherModelObjResults}" ) )
                .log( "3) ${body}" )
            .to( "vm:test-application-outbound" );
//            .to( "vm:test-application-outbound" );
        //@formatter:on
    }

    public TestAppDroolsRequestHelper getDroolsPrepBean() {
        return droolsPrepBean;
    }

    public void setDroolsPrepBean( TestAppDroolsRequestHelper droolsPrepBean ) {
        this.droolsPrepBean = droolsPrepBean;
    }

    public RulesService getRulesService() {
        return rulesService;
    }

    public void setRulesService( RulesService rulesService ) {
        this.rulesService = rulesService;
    }

}
