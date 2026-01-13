package network.tcp.autoclosable;

public class ResourceCloseMainV3 {

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
                try {
                    r2.closeEx();
                }catch (CloseException e) {
                    // logging 만 해둠
                    System.out.println("close ex: " + e);
                }
            }
            if (r1 != null) {
                try {
                    r1.closeEx();
                }catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
        }

    }
}
