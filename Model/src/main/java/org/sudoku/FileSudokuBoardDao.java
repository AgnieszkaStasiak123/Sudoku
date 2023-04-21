package org.sudoku;

import org.sudoku.exceptions.ExceptionDao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String fileName;
    private ResourceBundle listBundle = ResourceBundle.getBundle("org.example.Language");
    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName + ".txt";
    }

    @Override
    public SudokuBoard read() throws ExceptionDao {
        SudokuBoard obj;

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            obj = (SudokuBoard) objectInputStream.readObject();

        } catch (ClassNotFoundException e) {

            throw new ExceptionDao(listBundle.getObject("_classError").toString());

        } catch (IOException e) {
            throw new ExceptionDao(listBundle.getObject("_fileError").toString());

        }

        return obj;
    }

    @Override
    public void write(SudokuBoard obj) throws RuntimeException, ExceptionDao {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(obj);

        } catch (IOException e) {

            throw new ExceptionDao(listBundle.getObject("_fileError").toString());

        }
    }

    @Override
    public void close() throws Exception {

    }
}
