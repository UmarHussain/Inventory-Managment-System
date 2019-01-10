package com.okta.developer.ims.utils;

import org.dozer.DozerBeanMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Adapter {

    public static Adapter adapter = new Adapter();
    private DozerBeanMapper mapper;

    private Adapter(){
        List<String> list = new ArrayList<>();
        list.add("mapping.xml");
        mapper = new DozerBeanMapper(list);
    }

    public static Adapter getInstance(){
        return adapter;
    }


    public <T, F> Collection<T> convert(Collection<F> from, Class<T> t) {
        return (Collection)from.stream().map((f) -> {
            return this.mapper.map(f, t);
        }).collect(Collectors.toList());
    }

    public <T, F> T convert(F f, Class<T> t) {
        return this.mapper.map(f, t);
    }

    public <T, F> void convert(F f, T t) {
        this.mapper.map(f, t);
    }

}
