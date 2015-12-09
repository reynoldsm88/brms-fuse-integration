package com.redhat.drools.camel.request;

import java.util.Arrays;

import com.redhat.drools.camel.MyDroolsRequest;
import com.redhat.drools.camel.api.RulesRequest;
import com.redhat.drools.camel.model.MyModelObj;

public class DroolsRequestPrepBean {

    public RulesRequest prepareDroolsRequest( String value ) {
        MyModelObj obj = new MyModelObj( value );
        MyDroolsRequest request = new MyDroolsRequest( "test-ksession", Arrays.asList( obj ) );
        return request;
    }

}
