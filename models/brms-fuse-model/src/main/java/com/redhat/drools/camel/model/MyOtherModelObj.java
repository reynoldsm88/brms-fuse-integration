package com.redhat.drools.camel.model;

import java.io.Serializable;

public class MyOtherModelObj implements Serializable {

    private static final long serialVersionUID = 3884511990848967492L;
    
    private final String value;
    private int number;

    public MyOtherModelObj( String value ) {
        this.value = value;
    }

    public MyOtherModelObj( String value, int number ) {
        this.value = value;
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber( int number ) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        result = prime * result + ( ( value == null ) ? 0 : value.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        MyOtherModelObj other = (MyOtherModelObj) obj;
        if ( number != other.number )
            return false;
        if ( value == null ) {
            if ( other.value != null )
                return false;
        }
        else if ( !value.equals( other.value ) )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MyOtherModelObj [value=" + value + ", number=" + number + "]";
    }

}
