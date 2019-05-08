package sandbox;


public class Sandbox {

    public static int search (String[] a, int low, int high, String item) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int result = item.compareTo(a[mid]);
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                return search(a, mid+1, high, item);
            } else {
                return search(a, low, mid-1, item);
            }
        }
        return -1;
    }

    public static int add(int a, int b) {
        return (b > 0) ? add(a+1, b-1) : a;
    }

    public static int mpy(int a, int b) {
        return (b > 0) ? a + mpy(a, b-1) : 0;
    }

    public static String list(int i) {
        if (i > 0) return i + list(i - 1);
        return "";
    }

    public static void main (String args[]) {
        
    }

}