package com.redhat.drools.camel.api.test.route;

import java.util.Arrays;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.redhat.drools.camel.api.RulesService;
import com.redhat.drools.camel.api.TestRuleRequest;

public class DroolsServiceTestRouteBuilder extends RouteBuilder {

    private RulesService rulesService;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from( "direct:start" )
                .process( new Processor(){
                        @Override
                        public void process( Exchange exchange ) throws Exception {
                            TestRuleRequest request = new TestRuleRequest( "test-ksession", Arrays.asList( exchange.getIn().getBody() ) );
                            exchange.getIn().setBody( request );
                        }
                    }   )
                .bean( rulesService )
                .setBody( simple( "${body.myOtherModelObjResults}" ) )
                .to( "log:test-results-exchange" )
            .to( "mock:result" );
        //@formatter:on
    }

    public void setRulesService( RulesService rulesService ) {
        this.rulesService = rulesService;
    }

}
