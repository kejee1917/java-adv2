package network.tcp.autoclosable;

public class ResourceCloseMainV4 {

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
        try (ResourceV2 r1 = new ResourceV2("R1");
            ResourceV2 r2 = new ResourceV2("R2")) {

            r1.call();
            r2.callEx(); // CallEx

        }catch (CallException e) {
            System.out.println("ex : " + e);
            throw e;
        }
    }
}
