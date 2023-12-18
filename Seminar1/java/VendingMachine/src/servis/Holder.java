package servis;

import java.util.concurrent.TimeUnit;

public class Holder {
    private static boolean proof = false;
    protected void proofInWork(boolean dispenserPay){
        this.proof = dispenserPay;
    }
    public int work(int count){
        if (proof) {
            if (count > 0) {
                System.out.println("Гудение....");
                count--;
                try {
                    // TimeUnit.SECONDS.sleep(1);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                return work(count);
            } else {
                System.out.println("Выдача продукта!\nПоздравляем с покупкой!");
                return 0;
            }
        }
        return 0;
    }
    public int work() {
        int count = 5;
        return work(count);
    }
}
