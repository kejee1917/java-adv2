package network.exception.close.reset;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결:" + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        // client <- server : FIN 패킷
        Thread.sleep(1000); // 서버가 close() 호출할때까지 잠시 대가

        // client -> server : FIN 패킷을 날려야 하는데, 그냥 데이터를 보내버린다면?
        output.write(1);

        // TCP/IP 규약을 벗어나면? 잘못된거다라고 인지하면서 당장 RST 보내버림
        // client <- server : RST
        Thread.sleep(1000); // RST 메시지 전송 대기
        try {
            int read = input.read();
            System.out.println("read = " + read);
        }catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        log("연결 종료: " + socket.isClosed());
    }

}
