package com.mygdx.game.enitities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import static com.mygdx.game.util.Constants.SCALED_VALUE;
import static com.mygdx.game.util.Constants.TILESIZE;

public class PlayerBody{

   World world;
   Body body;
   Vector2 pos = new Vector2(15f,32f);

   public final float maxSpeed = 5f;
   public PlayerBody (World world){
      this.world = world;
      this.body = createBody(world);

   }
   public Body createBody(World world){
      Body body;
      
      BodyDef def = new BodyDef();
      def.type = BodyType.DynamicBody;
      def.position.set(pos);
      def.fixedRotation = true;

      body = world.createBody(def);
      PolygonShape shape = new PolygonShape();
      shape.setAsBox(SCALED_VALUE(TILESIZE) / 2, SCALED_VALUE(TILESIZE) / 2);
      body.createFixture(shape, 1f);

      return body;
   }
   public boolean onAir(){
      if(body.getLinearVelocity().y > 0){
         return true;
      } else {
         return false;
      }
   }
} 
