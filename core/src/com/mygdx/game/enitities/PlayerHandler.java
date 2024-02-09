package com.mygdx.game.enitities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class PlayerHandler{

   PlayerBody pBody;
   PlayerSprites pSprites;
   World world;

   public static PlayerState pState = PlayerState.IDLE;

   public PlayerHandler (World world){
      this.world = new World(new Vector2(0f, -20f), false);
      this.pBody = new PlayerBody(world);
      this.pSprites = new PlayerSprites(pBody);
   }
   public void update (){
      if (Gdx.input.isKeyPressed(Input.Keys.D)){
         pState = PlayerState.RUNNING;
         if (pBody.body.getLinearVelocity().x < pBody.maxSpeed){
            pBody.body.applyForceToCenter(50f, 0, false);
         }
      } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
         pState = PlayerState.RUNNING;
         if (pBody.body.getLinearVelocity().x > -pBody.maxSpeed){
            pBody.body.applyForceToCenter(-50f, 0, false);
         }
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !pBody.onAir()){
         pBody.body.applyForceToCenter(0, 2500, false);
         pState = PlayerState.JUMPING;
      } else if (!pBody.onAir() && pState != PlayerState.RUNNING) {
         pState = PlayerState.IDLE;
      }
   }
   public void draw (){
      pSprites.draw();
   }
   public void dispose (){
      world.dispose();
      pSprites.dispose();
   }
}
enum PlayerState {
   IDLE,
   JUMPING,
   RUNNING
}
