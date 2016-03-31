package com.redhat.drools.camel.api;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

import com.redhat.drools.camel.model.MyModelObj;
import com.redhat.drools.camel.model.MyOtherModelObj;

public class DroolsBRMSServiceTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/brms-service.xml,OSGI-INF/blueprint/test-camel-context.xml";
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void test() throws InterruptedException {
        ProducerTemplate template = context.createProducerTemplate();

        MockEndpoint mock = getMockEndpoint( "mock:result" );
        mock.setExpectedMessageCount( 1 );

        template.sendBody( "direct:start", new MyModelObj( "value" ) );

        Exchange recieved = mock.assertExchangeReceived( 0 );

        ArrayList<MyOtherModelObj> results = (ArrayList<MyOtherModelObj>) recieved.getIn().getBody();
        MyOtherModelObj expected = new MyOtherModelObj( "value", "Normal" );
        assertTrue( results.contains( expected ) );

        mock.assertIsSatisfied();
    }

}
