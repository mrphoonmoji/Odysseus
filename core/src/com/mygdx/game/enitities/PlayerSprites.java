package com.mygdx.game.enitities;

import static com.mygdx.game.util.Constants.SCALED_VALUE;
import static com.mygdx.game.util.Constants.TILESIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerSprites{

   Texture img;
   TextureRegion [] idleSprites, runSprites, jumpSprites;
   Animation idleAnimation, runAnimation, jumpAnimation;
   SpriteBatch batch;
   PlayerBody pBody;

   float stateTime;
   public PlayerSprites (PlayerBody pBody) {
      this.pBody = pBody;
      create();
   }
   public void create () {
      img = new Texture("player/PlayerSpriteSheet.png");

      jumpSprites = new TextureRegion[8];
      idleSprites = new TextureRegion[6];
      runSprites = new TextureRegion[6];

      TextureRegion [][] tmpFrames = TextureRegion.split(img, img.getWidth()/6, img.getHeight()/17);   

      int index = 0;

      for(int i = 0; i < 6; i++){
          idleSprites[index++] = tmpFrames[0][i];
       }

      index = 0;
      jumpSprites[0] = tmpFrames[6][5];

      for(int i = 0; i < 6; i++){
         jumpSprites[index++]= tmpFrames[7][i];
      }

      jumpSprites[7] = tmpFrames[8][0];
      index = 0;

      for(int i = 0; i < 6; i++){
         runSprites[index++] = tmpFrames[1][i];
      }

      idleAnimation = new Animation<TextureRegion>(0.15f, idleSprites);
      jumpAnimation = new Animation<TextureRegion>(0.1f, jumpSprites);
      runAnimation = new Animation<TextureRegion>(0.1f, runSprites);

      stateTime = 0f;
   }
   public void draw () {
      stateTime  += Gdx.graphics.getDeltaTime();
      
      switch(PlayerHandler.pState){
         case IDLE:
            TextureRegion currentFrame = (TextureRegion) idleAnimation.getKeyFrame(stateTime, true);
            batch.draw(currentFrame, pBody.body.getPosition().x - SCALED_VALUE(TILESIZE)/2, pBody.body.getPosition().y - SCALED_VALUE(TILESIZE) / 2, SCALED_VALUE(TILESIZE), SCALED_VALUE(TILESIZE));
            break;
         case JUMPING:
            TextureRegion jumpFrame = (TextureRegion) jumpAnimation.getKeyFrame(stateTime, true);
            batch.draw(jumpFrame, pBody.body.getPosition().x - SCALED_VALUE(TILESIZE)/2, pBody.body.getPosition().y - SCALED_VALUE(TILESIZE) / 2, SCALED_VALUE(TILESIZE), SCALED_VALUE(TILESIZE));
            break;
         case RUNNING:
            TextureRegion runFrame = (TextureRegion) runAnimation.getKeyFrame(stateTime, true);
            batch.draw(runFrame, pBody.body.getPosition().x - SCALED_VALUE(TILESIZE)/2, pBody.body.getPosition().y - SCALED_VALUE(TILESIZE) / 2, SCALED_VALUE(TILESIZE), SCALED_VALUE(TILESIZE));
            break;
      }
   }
   public void dispose () {

      img.dispose();
      batch.dispose();

   }
}
