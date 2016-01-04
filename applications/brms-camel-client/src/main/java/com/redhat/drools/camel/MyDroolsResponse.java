package com.redhat.drools.camel;

import java.util.ArrayList;
import java.util.Collection;

import com.redhat.drools.camel.api.RulesResponse;
import com.redhat.drools.camel.model.MyOtherModelObj;

public class MyDroolsResponse extends RulesResponse {

    public MyDroolsResponse() {
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
