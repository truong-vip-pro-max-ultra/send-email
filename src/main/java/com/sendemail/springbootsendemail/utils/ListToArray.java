package com.sendemail.springbootsendemail.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListToArray {
    public static <T> T[] to(List<T> list,Class<T> tClass){
        T types[] = (T[]) Array.newInstance(tClass, list.size());
        int i=0;
        for(T t : list){
            types[i++] = t;
        }
        return types;
    }

}
