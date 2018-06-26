package com.newsSystem.NewsSystemWithSpring.service;

import java.util.List;

public interface ServiceInterface<T> {

    //TODO CRUD

    T create(T obj);

    List<T> getAll();

    T findObjectById(String id);

    T update(T obj);

    void delete (T obj);


}
