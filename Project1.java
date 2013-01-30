package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Project1.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Project1 implements GLEventListener {

    private float rotateT = 0.0f;

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Project1());
        frame.add(canvas);
        frame.setSize(600, 600);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });

        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);

        // Front Of House
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
            gl.glVertex3f(1.0f, -1.0f, 0.0f);
            gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        gl.glEnd();

        // Front Left Window
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.0f, 0.0f);
            gl.glVertex3f(-0.75f, 0.25f, 0.0f);
            gl.glVertex3f(-0.25f, 0.25f, 0.0f);
            gl.glVertex3f(-0.25f, 0.75f, 0.0f);
            gl.glVertex3f(-0.75f, 0.75f, 0.0f);
        gl.glEnd();

        // Front Right Window
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.0f, 0.0f);
            gl.glVertex3f(0.75f, 0.25f, 0.0f);
            gl.glVertex3f(0.25f, 0.25f, 0.0f);
            gl.glVertex3f(0.25f, 0.75f, 0.0f);
            gl.glVertex3f(0.75f, 0.75f, 0.0f);
        gl.glEnd();

        // Door
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glVertex3f(-0.25f, -1.0f, 0.0f);
            gl.glVertex3f(0.25f, -1.0f, 0.0f);
            gl.glVertex3f(0.25f, -0.25f, 0.0f);
            gl.glVertex3f(-0.25f, -0.25f, 0.0f);
        gl.glEnd();

        // Right Side of house
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(1.0f, -1.0f, 0.0f);
            gl.glVertex3f(2.0f, -1.0f, -1.0f);
            gl.glVertex3f(2.0f, 1.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();

        // Right Side of roof
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
            gl.glVertex3f(2.0f, 1.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.75f, -1.0f);
            gl.glVertex3f(0.0f, 2.0f, -1.0f);
        gl.glEnd();

        // Roof
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);
            gl.glVertex3f(0.0f, 2.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();

        // Front Side Of House Outline
        gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
            gl.glVertex3f(1.0f, -1.0f, 0.0f);
            gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        gl.glEnd();

        // Right Side of house outline
        gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(1.0f, -1.0f, 0.0f);
            gl.glVertex3f(2.0f, -1.0f, -1.0f);
            gl.glVertex3f(2.0f, 1.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();

        // Roof Outline
        gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);
            gl.glVertex3f(0.0f, 2.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();

        // Right Side of roof Outline
        gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(1.0f, 1.0f, 0.0f);
            gl.glVertex3f(2.0f, 1.0f, -1.0f);
            gl.glVertex3f(1.0f, 1.75f, -1.0f);
            gl.glVertex3f(0.0f, 2.0f, -1.0f);
        gl.glEnd();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
