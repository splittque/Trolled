package me.splitque.trolled;

public class Utils {
    public static int getRows(int row) { return row * 9; }
    public static int getIndex(int row, int column) { return (row - 1) * 9 + column - 1; }
}
