package network.exception;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket(); // 객체만 만들면 아직 연결 안함
            
            //connect() -> 연결
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000); //1초
        }catch (SocketTimeoutException e) { //SocketTimeoutException
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
