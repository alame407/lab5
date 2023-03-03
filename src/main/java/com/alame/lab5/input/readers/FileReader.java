package com.alame.lab5.input.readers;

import java.io.*;

public class FileReader {
    private final BufferedInputStream bufferedInputStream;
    private final String fileName;
    private boolean hasNextLine = true;
    public FileReader(String path) throws IOException {
        bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        fileName = path;
    }
    public FileReader(File file) throws IOException{
        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        fileName = file.getName();
    }
    public void close() throws IOException{
        bufferedInputStream.close();
    }
    public String getFileName(){
        return fileName;
    }
    public boolean hasNextLine(){
        return hasNextLine;
    }
    public String getNextLine() throws IOException {
        if (!hasNextLine) throw new IOException("File is end");
        StringBuilder result = new StringBuilder();
        int symbol = bufferedInputStream.read();
        while (symbol != -1){
            result.append((char) symbol);
            if (result.toString().endsWith(System.lineSeparator())){
                return result.substring(0, result.length()-System.lineSeparator().length());
            }
            symbol = bufferedInputStream.read();
        }
        hasNextLine = false;
        return result.toString();
    }
}
