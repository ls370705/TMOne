package com.hcid.tmone.tmapp.utilities;

/**
 * Get the edit distance between two string
 * Created by liusu on 4/1/17.
 */
public class EditDistance {
    public static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }

    public static String getResult(CharSequence input, CharSequence[] database){
        int currentEditDistance = input.toString().length();
        int currentRow = 0;
        for(int i = 0 ; i < database.length ; i++){
            int newED = computeLevenshteinDistance(input,database[i]);
            if(newED < currentEditDistance){
                currentEditDistance = newED;
                currentRow = i;
            }
        }
        return database[currentRow].toString();
    }
}
