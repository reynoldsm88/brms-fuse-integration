package com.redhat.test.application.type.converters;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConversionException;
import org.apache.camel.support.TypeConverterSupport;

import com.redhat.drools.camel.model.MyModelObj;

@Converter
public class StringToModelTypeConverter extends TypeConverterSupport {

    @Override
    public <T> T convertTo( Class<T> type, Exchange exchange, Object value ) throws TypeConversionException {
        return (T) new MyModelObj( (String) value );
    }

}
