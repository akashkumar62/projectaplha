package com.pricecomparator.catalog.entity;

import org.hibernate.usertype.UserType;

public class JsonBinaryType implements UserType {
    @Override
    public int getSqlType() {
        return 0;
    }

    @Override
    public Class returnedClass() {
        return null;
    }

    @Override
    public Object deepCopy(Object o) {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }
}
