package com.redhat.drools.camel.api;

import java.util.ArrayList;
import java.util.List;

public abstract class RuleRequest {

    private String kieSession;
    private String processName;
    private List<Object> facts = new ArrayList<Object>();

    public String getKieSession() {
        return kieSession;
    }

    public void setKieSession( String kieSession ) {
        this.kieSession = kieSession;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName( String processName ) {
        this.processName = processName;
    }

    public List<Object> getFacts() {
        return this.facts;
    }

    public void setFacts( List<Object> facts ) {
        this.facts = facts;
    }

    public void addFact( Object o ) {
        this.facts.add( o );
    }

}
