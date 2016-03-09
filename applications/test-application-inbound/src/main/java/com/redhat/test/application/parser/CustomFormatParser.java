package com.redhat.test.application.parser;

import org.apache.camel.Body;

import com.redhat.drools.camel.model.MyModelObj;

public class CustomFormatParser {

    /**
     * Message format is delimited by the '-' character and [0] is the value [1] is the number
     * 
     */
    public MyModelObj parse( @Body String inboundMessage ) throws IllegalArgumentException {
        String[] input = inboundMessage.split( "-" );
        if ( input.length < 2 ) {
            throw new IllegalArgumentException( "The inbound message " + inboundMessage + " is malformed" );
        }

        for ( String string : input ) {
            System.err.println( string );
        }

        return new MyModelObj( input[ 0 ], Integer.parseInt( input[ 1 ] ) );
    }

}
