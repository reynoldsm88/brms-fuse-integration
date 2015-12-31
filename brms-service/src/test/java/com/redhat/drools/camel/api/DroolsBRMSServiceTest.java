package com.redhat.drools.camel.api;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.camel.util.KeyValueHolder;
import org.junit.Test;

import com.redhat.drools.camel.api.impl.DroolsBRMSRulesService;
import com.redhat.drools.camel.beans.KieSessionService;
import com.redhat.drools.camel.model.MyModelObj;
import com.redhat.drools.camel.model.MyOtherModelObj;

public class DroolsBRMSServiceTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/brms-service.xml,OSGI-INF/blueprint/test-camel-context.xml";
    }

    @Override
    @SuppressWarnings ( "rawtypes")
    protected void addServicesOnStartup( Map<String, KeyValueHolder<Object, Dictionary>> services ) {
        // this is ridiculous that you cannot wire it in with blueprint itself
        KieSessionService kieSessionService = new KieSessionService( "com.redhat", "test-kjar", "0.0.1-SNAPSHOT" );
        DroolsBRMSRulesService service = new DroolsBRMSRulesService();
        service.setKieSessionService( kieSessionService );

        KeyValueHolder serviceHolder = new KeyValueHolder( service, null );
        services.put( RulesService.class.getName(), serviceHolder );
    }

    @Test
    @SuppressWarnings ( "unchecked")
    public void test() throws InterruptedException {
        ProducerTemplate template = context.createProducerTemplate();

        MockEndpoint mock = getMockEndpoint( "mock:result" );
        mock.setExpectedMessageCount( 1 );

        template.sendBody( "direct:start", new MyModelObj( "value" ) );

        Exchange recieved = mock.assertExchangeReceived( 0 );
        
        ArrayList<MyOtherModelObj> results = (ArrayList<MyOtherModelObj>) recieved.getIn().getBody();
        MyOtherModelObj expected = new MyOtherModelObj( "value" );
        assertTrue( results.contains( expected ) );

        mock.assertIsSatisfied();
    }

}
