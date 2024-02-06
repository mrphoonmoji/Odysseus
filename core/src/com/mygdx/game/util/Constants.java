package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;

public class Constants{
   public static final float WIDTH = (float)Gdx.graphics.getWidth();
   public static final float HEIGHT = (float)Gdx.graphics.getHeight();
   public static final float TILESIZE = 96;
   public static final float SCALE = 48;
   public static final float SCALED_VALUE (float ValueToScale){
      return ValueToScale/SCALE;
   }
}
