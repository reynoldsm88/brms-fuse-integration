package com.redhat.drools.camel.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;

public abstract class RulesResponse {

    protected Set<Class<?>> resultsClasses = new HashSet<Class<?>>();

    private Map<Class<?>, Collection<Object>> results = new HashMap<Class<?>, Collection<Object>>();

    public Collection<Object> getResults( Class<?> clazz ) {
        return results.get( clazz );
    }

    protected void addResultClass( Class<?> clazz ) {
        this.resultsClasses.add( clazz );
        results.put( clazz, new ArrayList<Object>() );
    }

    public void processResults( KieSession session ) {
        for ( Class<?> clazz : resultsClasses ) {
            Collection droolsResult = session.getObjects( new ClassObjectFilter( clazz ) );

            Iterator i = droolsResult.iterator();
            while ( i.hasNext() ) {
                results.get( clazz ).add( i.next() );
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for ( Class<?> clazz : resultsClasses ) {
            buffer.append( clazz.getName() + " : " );
            for ( Object o : results.get( clazz ) ) {
                buffer.append( "Result[ " + o.toString() + " ] " );
            }
        }

        return buffer.toString();
    }

}
