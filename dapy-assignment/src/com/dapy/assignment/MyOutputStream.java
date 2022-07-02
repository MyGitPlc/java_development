package com.dapy.assignment;
import java.io.*;
// Importing utility classes
import java.util.*;

// Class 1
// helper class
class MyOutputStream extends ObjectOutputStream {

    // Constructor of this class
    // 1. Default
    MyOutputStream() throws IOException
    {
        // Super keyword refers to parent class instance
        super();
    }
    // Constructor of this class
    // 1. Parameterized constructor
    MyOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}
