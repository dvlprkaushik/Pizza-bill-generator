public class One {
    public static void main(String[] args) {
        try{
            int arr[] = { 20, 30 };
            System.out.println(arr[3]);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
