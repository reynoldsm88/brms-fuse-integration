package com.redhat.drools.camel.api;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Ignore;
import org.junit.Test;

@Ignore ( "renable when resolution to DROOLS-962/DROOLS-937 is available")
public class DroolsBRMSServiceTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/brms-service.xml";
    }

    @Test
    public void test() {

    }

}
