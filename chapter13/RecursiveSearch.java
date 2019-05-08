package chapter13;

public class RecursiveSearch {

    public static final boolean find(String text, String str) {
        if (text.length() < str.length()) return false;
        if (text.substring(0, str.length()).equals(str)) return true;
        return find(text.substring(1), str);
    }

    public static final int indexOf(String text, String str) {
        return indexOf(text, str, 0);
    }

    private static final int indexOf(String text, String str, int i) {
        if (text.length() < str.length()) return -1;
        if (text.substring(0, str.length()).equals(str)) return i;
        return indexOf(text.substring(1), str, i + 1);
    }

}
