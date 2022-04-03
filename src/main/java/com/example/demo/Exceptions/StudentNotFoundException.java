package com.example.demo.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id) {
        super("Not found this student" + id);
    }
}
