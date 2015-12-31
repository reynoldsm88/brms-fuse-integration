package com.redhat.drools.camel.api;

import java.util.List;

public class TestRuleRequest extends RulesRequest{

    public TestRuleRequest( String kieSession, List<? extends Object> facts ) {
        super( kieSession, null, facts );
        this.setResponse( new TestRuleResponse() );
    }
}
