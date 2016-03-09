package com.redhat.test.application.xlate.util;

import org.apache.camel.Body;

import com.google.common.collect.Lists;
import com.redhat.drools.camel.api.RulesRequest;
import com.redhat.drools.camel.model.MyModelObj;
import com.redhat.test.application.drools.request.TestAppDroolsRequest;

public class TestAppDroolsRequestHelper {

    public RulesRequest prepare( @Body MyModelObj request ) {
        return new TestAppDroolsRequest( "test-ksession", Lists.newArrayList( request ) );
    }
    
    

}
