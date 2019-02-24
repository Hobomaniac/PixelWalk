package com.jalenwinslow.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class MapReader {


    public static int[][] readMap(String file) {
        int[][] map;
        FileHandle handle = Gdx.files.internal(file);
        String text = handle.readString();
        String[] s = text.split("\n");
        map = new int[s.length][s[0].split(" ").length];
        for (int j = 0; j < s.length; j++) {
            for (int i = 0; i < s[j].split(" ").length; i++) {
                map[j][i] = Integer.parseInt(s[j].split(" ")[i]);
            }
        }
        return map;
    }
}
