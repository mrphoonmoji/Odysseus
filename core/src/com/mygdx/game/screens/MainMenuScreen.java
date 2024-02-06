package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenuScreen extends GameInterface {

   SpriteBatch batch;
   ShapeRenderer shape;
   FreeTypeFontGenerator generator;
   FreeTypeFontParameter parameter;
   BitmapFont font;
   float width;
   float height;
   
   public boolean startGame = false;

   public MainMenuScreen (SpriteBatch batch){
      this.batch = new SpriteBatch();
      create();
   }
   @Override
   public void dispose(){
      generator.dispose();
      batch.dispose();
      font.dispose();
   }
   @Override
   public void update(){
      if(Gdx.input.getX()>=738-width/2 && Gdx.input.getX()<= 738+width/2 &&
         Gdx.input.getY()>=480-height/2 && Gdx.input.getY() <= 480+height/2
         && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            
         startGame = true;
      }
   }
   @Override
   public void draw(){
      batch.begin();
      font.draw(batch, "Start", 738-width/2, 480+height/2);
      batch.end();
   }
   @Override
   public void create(){
      generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/GameFont.ttf"));
      parameter = new FreeTypeFontParameter();
      parameter.size = 100;
      parameter.color = Color.WHITE;
      font = generator.generateFont(parameter);
      width = 275f;
      height = 68f;
   }
}
