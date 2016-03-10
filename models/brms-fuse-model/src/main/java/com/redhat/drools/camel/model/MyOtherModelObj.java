package com.redhat.drools.camel.model;

import java.io.Serializable;

public class MyOtherModelObj implements Serializable {

    private static final long serialVersionUID = 3884511990848967492L;

    private final String value;
    private String status;

    public MyOtherModelObj( String value ) {
        this.value = value;
        this.status = "Neutral";
    }

    public MyOtherModelObj( String value, String status ) {
        this.value = value;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }  

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( status == null ) ? 0 : status.hashCode() );
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
        if ( status == null ) {
            if ( other.status != null )
                return false;
        }
        else if ( !status.equals( other.status ) )
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
        return "MyOtherModelObj [value=" + value + ", status=" + status + "]";
    }

}
