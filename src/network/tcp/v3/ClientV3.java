package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라 시작");
        Socket socket = new Socket("localhost", PORT);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓연결: " + socket);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송 문자: ");
            String toSend = scanner.nextLine();

            // 서버에게 문자 보내기
            output.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")) {
                break;
            }

            String received = input.readUTF();
            log("server -> client: " + received);
        }


        // 자원 정리
        input.close();
        output.close();
    }
}
