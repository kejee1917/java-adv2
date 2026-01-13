package network.tcp.autoclosable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("callEx 예외처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("closeEx 예외처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CloseException, CallException {
        ResourceV1 r1 = new ResourceV1("R1");
        ResourceV1 r2 = new ResourceV1("R2");

        r1.call();
        r2.callEx();

        System.out.println("자원 정리"); // 호출 안됨
        r2.closeEx();
        r1.closeEx();
    }
}
