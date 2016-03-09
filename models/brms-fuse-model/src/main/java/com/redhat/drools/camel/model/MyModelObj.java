package com.redhat.drools.camel.model;

import java.io.Serializable;

public class MyModelObj implements Serializable {

    private static final long serialVersionUID = -6867131690940238095L;
    
    private String value;
    private int number;

    public MyModelObj( String value, int number ) {
        this.value = value;
        this.number = number;
    }

    public MyModelObj( String value ) {
        this.value = value;
        this.number = Integer.MIN_VALUE;
    }

    public String getValue() {
        return value;
    }

    public void setValue( String value ) {
        this.value = value;
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
        MyModelObj other = (MyModelObj) obj;
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
        return "MyModelObj [value=" + value + ", number=" + number + "]";
    }

}
