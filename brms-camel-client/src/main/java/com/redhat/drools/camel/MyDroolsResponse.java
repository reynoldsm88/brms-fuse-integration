package com.redhat.drools.camel;

import com.redhat.drools.camel.api.RulesResponse;
import com.redhat.drools.camel.model.MyOtherModelObj;

public class MyDroolsResponse extends RulesResponse {

    public MyDroolsResponse() {
        this.addResultClass( MyOtherModelObj.class );
    }
}
