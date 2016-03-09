package com.redhat.test.application.drools.request;

import java.util.ArrayList;
import java.util.Collection;

import com.redhat.drools.camel.api.RulesResponse;
import com.redhat.drools.camel.model.MyOtherModelObj;

public class TestAppDroolsResponse extends RulesResponse {

    public TestAppDroolsResponse() {
        this.addResultClass( MyOtherModelObj.class );
    }

    public Collection<MyOtherModelObj> getMyOtherModelObjResults() {
        Collection<MyOtherModelObj> myOtherModelObjResults = new ArrayList<MyOtherModelObj>();
        for ( Object o : results.get( MyOtherModelObj.class ) ) {
            myOtherModelObjResults.add( (MyOtherModelObj) o );
        }

        return myOtherModelObjResults;
    }

}
