package org.sudoku;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName + ".txt";
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard obj;

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            obj = (SudokuBoard) objectInputStream.readObject();

        } catch (ClassNotFoundException | IOException e) {

            throw new RuntimeException(e);

        }

        return obj;
    }

    @Override
    public void write(SudokuBoard obj) throws RuntimeException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(obj);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public void close() throws Exception {

    }
}
