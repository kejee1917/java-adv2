package network.tcp.autoclosable;

public class ResourceCloseMainV2 {

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
        ResourceV1 r1 = null;
        ResourceV1 r2 = null;

        try {
            r1 = new ResourceV1("R1");
            r2 = new ResourceV1("R2");
            r1.call();
            r2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }finally {
            if (r2 != null) {
                r2.closeEx();
            }
            if (r1 != null) {
                r1.closeEx(); // 바로 위에서 터져서 이 코드도 호출이 안됨!
            }
        }

    }
}
