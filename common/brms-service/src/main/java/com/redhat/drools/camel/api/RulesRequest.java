package com.redhat.drools.camel.api;

import java.util.ArrayList;
import java.util.List;

public abstract class RulesRequest {

    protected String kieSession;
    protected String processName;
    protected List<Object> facts;
    protected RulesResponse response;

    protected RulesRequest( String kieSession, String processName, List<? extends Object> facts ) {
        this.facts = new ArrayList<Object>();
        this.kieSession = kieSession;
        this.processName = processName;

        for ( Object o : facts ) {
            this.facts.add( o );
        }
    }

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

    public RulesResponse getResponse() {
        return response;
    }

    protected void setResponse( RulesResponse response ) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RulesRequest [kieSession=" + kieSession + ", processName=" + processName + ", facts=" + facts + ", response=" + response + "]";
    }

}
