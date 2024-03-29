package com.me.touchfootball2.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Draw {
	private OrthographicCamera camera;
	private GL10 gl = Gdx.graphics.getGL10();
	
	/**
	 * Creates the projection view for the items to be drawn
	 * @param camera the orthographic camera that the drawings will be projected to
	 */
	public Draw(OrthographicCamera camera){
		this.camera = camera;
		gl.glEnable(GL10.GL_BLEND);
	}
	
	public void drawLine(float x1, float y1, float x2, float y2, Color color, int size){
		ShapeRenderer s = new ShapeRenderer();
		camera.update();
		s.setProjectionMatrix(camera.combined);
		gl.glLineWidth(size);
		s.begin(ShapeType.Line);
		s.setColor(color);
		s.line(x1, y1, x2, y2);
		s.end();
	}
	
	public void drawLine(float x1, float y1, float x2, float y2, Color color) {
		drawLine(x1, y1, x2, y2, color, 1);
	}
	
	public void drawRect(float x, float y, float width, float height, Color color){
		this.drawRectRotate(x, y, width, height, color, 0);
	}
	
	public void drawRectRotate(float x, float y, float width, float height, Color color, float angle) {
		ShapeRenderer s = new ShapeRenderer();
		s.begin(ShapeType.FilledRectangle);
		s.setProjectionMatrix(camera.combined);
		s.setColor(color);
		s.rotate(0, 0, 1, angle);
		s.filledRect(x, y, width, height);
		s.end();
	}
	
	public void drawTriangle(float x1, float y1, float x2, float y2, float x3, float y3, Color color){
		this.drawTriangleRotate(x1, y1, x2, y2, x3, y3, color, 0);
	}
	
	public void drawTriangleRotate(float x1, float y1, float x2, float y2, float x3, float y3, Color color, float angle){
		ShapeRenderer s = new ShapeRenderer();
		s.begin(ShapeType.FilledTriangle);
		s.setProjectionMatrix(camera.combined);
		s.setColor(color);
		s.rotate(0, 0, 1, angle);
		s.filledTriangle(x1, y1, x2, y2, x3, y3);
		s.end();
	}
	
	public void drawArrow(float x, float y, float width, float height, Color color){
		float base = width + width;
		float heightT = (float) ((base / 2) * Math.pow(1, (1/3)));
		drawTriangle((x + width/2), y + height, x - (base - width)/2, y + height - heightT, x + width + (base - width)/2, y + height - heightT, color);
		drawRect(x, y, width, y + height - heightT, color);
	}
	
	public void drawArrowRotate(float x, float y, float width, float height, Color color, float angle){
		float base = width + width;
		float heightT = (float) ((base / 2) * Math.pow(1, (1/3)));
		drawTriangleRotate((x + width/2), y + height, x - (base - width)/2, y + height - heightT, x + width + (base - width)/2, y + height - heightT, color,angle);
		drawRectRotate(x, y, width, y + height - heightT, color,angle);
	}

	public void drawCircle(float x, float y, float radius, Color color){
		this.drawCircleRotate(x, y, radius, color, 0);
	}
	
	public void drawCircleRotate(float x, float y, float radius, Color color, float angle){
		ShapeRenderer s = new ShapeRenderer();
		s.begin(ShapeType.FilledCircle);
		s.setProjectionMatrix(camera.combined);
		s.setColor(color);
		s.rotate(0, 0, 1, angle);
		s.filledCircle(x, y, radius, 30);
		s.end();
	}
	
	
}
