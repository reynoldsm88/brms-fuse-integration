package com.redhat.test.application.parser;

import org.apache.camel.Body;

import com.redhat.drools.camel.model.MyModelObj;

public class CustomFormatParser {

    public MyModelObj parse( @Body String inboundMessage ) {
        return null;
    }

}
