package com.redhat.drools.camel.api;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Headers;

public interface RulesService {

    public RulesResponse execute( RulesRequest request );

    public Object executeNew( @Body Object body, @Headers Map<String, Object> headers ) throws Exception;

}
