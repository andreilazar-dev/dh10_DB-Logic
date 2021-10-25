package com.dh10.stringchecker.model.dao;

import com.dh10.stringchecker.model.beans.Synonymus;

import java.util.List;
import java.util.Optional;

public class SynonymusDao implements Dao<Synonymus>{
    @Override
    public Optional<Synonymus> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Synonymus> getAll() {
        return null;
    }

    @Override
    public void save(Synonymus synonymus) {

    }

    @Override
    public void update(Synonymus synonymus, String[] params) {

    }

    @Override
    public void delete(Synonymus synonymus) {

    }
}
