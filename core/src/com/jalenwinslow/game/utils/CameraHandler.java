package com.jalenwinslow.game.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraHandler {
    public static final int CAMERA_WIDTH = 10, CAMERA_HEIGHT = 10;
    public static int unitX = 0, unitY = 0;

    public static OrthographicCamera cam;

    public static void updateCam(float px, float py) {
        unitX = (int) px / CAMERA_WIDTH;
        unitY = (int) py / CAMERA_HEIGHT;
        cam.position.x = cam.viewportWidth / 2f + CAMERA_WIDTH * unitX;
        cam.position.y = cam.viewportHeight / 2f + CAMERA_HEIGHT * unitY;
    }

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
