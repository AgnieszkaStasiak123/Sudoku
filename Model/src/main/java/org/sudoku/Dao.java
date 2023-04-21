package org.sudoku;

import org.sudoku.exceptions.ExceptionDao;

import java.io.IOException;

public interface Dao<T> extends  AutoCloseable {
    T read() throws ExceptionDao;

    void write(T obj) throws ExceptionDao;
}
