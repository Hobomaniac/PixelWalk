package com.jalenwinslow.game.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraHandler {
    public static final int CAMERA_WIDTH = 7, CAMERA_HEIGHT = 7;

    public static OrthographicCamera cam;

    public static void moveRight() {
        cam.position.x += CAMERA_WIDTH;
    }
    public static void moveLeft() {
        cam.position.x -= CAMERA_WIDTH;
    }
    public static void moveUp() {
        cam.position.y += CAMERA_HEIGHT;
    }
    public static void moveDown() {
        cam.position.y -= CAMERA_HEIGHT;
    }
}
