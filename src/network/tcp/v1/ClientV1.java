package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라 시작");
        Socket socket = new Socket("localhost", PORT);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓연결: " + socket);

        // 서버에게 문자 보내기
        String toSend = "hello";
        output.writeUTF(toSend);
        log("client -> server: " + toSend);

        String received = input.readUTF();
        log("server -> client: " + received);

        // 자원 정리
        input.close();
        output.close();
    }
}
