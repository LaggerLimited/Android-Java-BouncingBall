package edu.owens.lagger.joshua.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * <h1>BouncingBall</h1>
 * This is an Android application that draws a ball to
 * the screen and bounces it with using a basic algorithm.
 *
 * @author Joshua Lagger
 * @version 1.0
 * @since 2016-02-18
 */
public class BouncingBallView extends View {
    // This view's bounds
    private int xMin = 0;
    private int xMax;
    private int yMin = 0;
    private int yMax;
    private float ballRadius = 80;
    // Ball's center (x,y)
    private float ballX = ballRadius + 20;
    private float ballY = ballRadius + 40;
    // Ball's speed (x,y)
    private float ballSpeedX = 5;
    private float ballSpeedY = 3;
    private RectF ballBounds;
    private Paint paint;

    public BouncingBallView(Context context) {
        super(context);
        ballBounds = new RectF();
        paint = new Paint();
    }

    // Called back to draw the view. Also called by invalidate()
    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the ball
        ballBounds.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius);
        paint.setColor(Color.GREEN);
        canvas.drawOval(ballBounds, paint);

        // Update the position of the ball, including collision detection and reaction
        update();

        // Delay 30 frames per second
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
        }
        // Force a re-draw
        invalidate();
    }

    // Detect collision and update the position of the ball
    private void update() {
        // Get new (x,y) position
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        // Detect collision and react
        if (ballX + ballRadius > xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = xMax - ballRadius;
        } else if (ballX - ballRadius < xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = xMin + ballRadius;
        }
        if (ballY + ballRadius > yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = yMax - ballRadius;
        } else if (ballY - ballRadius < yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = yMin + ballRadius;
        }
    }

    // Called back when the view is first created or its size changes
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        xMax = w - 1;
        yMax = h - 1;
    }
}
