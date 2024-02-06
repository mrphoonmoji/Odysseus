package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
public class MyGame extends Game{

   MainGameScreen gScreen;
   MainMenuScreen mScreen;
   SpriteBatch batch;
   ScreenSwitcher switcher = new ScreenSwitcher();
	@Override
	public void create () {
      gScreen = new MainGameScreen(batch);
      mScreen = new MainMenuScreen(batch);
	}

	@Override
	public void render () {
      Gdx.gl.glClearColor(0,0,0,0);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      switcher.update(mScreen, gScreen);
      switcher.draw(mScreen, gScreen);
	}
	
	@Override
	public void dispose () {
      gScreen.dispose();
      mScreen.dispose(); 
	}
}
class ScreenSwitcher {
   ScreenState state = ScreenState.MENU;
   public void update(MainMenuScreen mScreen, MainGameScreen gScreen){
      if(mScreen.startGame){
         state = ScreenState.GAME;
      }
   }
   public void draw(MainMenuScreen mScreen, MainGameScreen gScreen){
      switch(state){
         case MENU:
            mScreen.update();
            mScreen.draw();
            break;
         case GAME:
            gScreen.update();
            gScreen.draw();
            break;
         default:
            System.out.printf("%s%n","Unknown state.");
            break;
      }
   }
}
enum ScreenState {
   GAME,
   MENU,
}
