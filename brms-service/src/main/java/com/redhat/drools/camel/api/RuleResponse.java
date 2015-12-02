package com.redhat.drools.camel.api;

import java.util.Collection;

public abstract class RuleResponse {

    public abstract Collection<Object> getResult( String label );

    public abstract void process( Collection<Object> ruleResults );

}
