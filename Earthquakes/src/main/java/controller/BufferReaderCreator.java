package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BufferReaderCreator {

    public BufferedReader createBufferReader(String generatedUrl) {
        URL url;
        BufferedReader bufferedReader = null;
        try {
            url = new URL(generatedUrl);
            URLConnection conn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }
}
