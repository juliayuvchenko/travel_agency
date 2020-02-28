package com.softserve.dao.interfaces;

import java.util.Optional;
import java.util.Set;

public interface Read<T> {
    Set<T> finalAll();
    Optional<T> findById(long id);
}
