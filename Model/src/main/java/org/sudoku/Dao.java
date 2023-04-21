package org.sudoku;

import org.sudoku.exceptions.ExceptionDao;

public interface Dao<T> extends  AutoCloseable {
    T read() throws ExceptionDao;

    void write(T obj) throws ExceptionDao;
}
