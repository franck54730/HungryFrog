package fr.univ_lorraine.hungry_frog.model;

import java.util.ArrayList;
import java.util.Iterator;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.bloc.Bloc;
import fr.univ_lorraine.hungry_frog.model.bloc.BlocGrass;
import fr.univ_lorraine.hungry_frog.model.bloc.BlocLine;
import fr.univ_lorraine.hungry_frog.model.bloc.BlocRoad;
import fr.univ_lorraine.hungry_frog.model.bloc.BlocTree;
import fr.univ_lorraine.hungry_frog.model.car.Car;
import fr.univ_lorraine.hungry_frog.model.car.CarBlue;
import fr.univ_lorraine.hungry_frog.model.car.CarRed;
import fr.univ_lorraine.hungry_frog.model.car.CarYellow;


public class Level implements Iterable<Car> {
	protected int nbInput = 0;
	protected ArrayList<Bloc> background;
	protected ArrayList<Car>[] route;
	protected int level = 0;
	protected Frog frog;
	protected Fly fly;
	protected int life = 5;
	
	protected boolean flyEaten = false;
	
	public Level(){
		background = new ArrayList<Bloc>();
		route = new ArrayList[10];
		frog = new Frog();
		fly = new Fly();
		route[0] = new ArrayList<Car>();
		route[0].add(new CarRed(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[0].add(new CarRed(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[0].add(new CarRed(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[0].add(new CarRed(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[1] = new ArrayList<Car>();
		route[1].add(new CarYellow(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[1].add(new CarRed(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[1].add(new CarYellow(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[1].add(new CarRed(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[2] = new ArrayList<Car>();
		route[2].add(new CarYellow(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[2].add(new CarYellow(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[2].add(new CarYellow(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[2].add(new CarYellow(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[3] = new ArrayList<Car>();
		route[3].add(new CarBlue(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[3].add(new CarYellow(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[3].add(new CarBlue(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[3].add(new CarYellow(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[4] = new ArrayList<Car>();
		route[4].add(new CarBlue(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[4].add(new CarBlue(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[4].add(new CarBlue(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[4].add(new CarBlue(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[5] = new ArrayList<Car>();
		route[5].add(new CarRed(200, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[5].add(new CarRed(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[5].add(new CarYellow(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[5].add(new CarRed(200, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[5].add(new CarRed(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[5].add(new CarYellow(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[6] = new ArrayList<Car>();
		route[6].add(new CarYellow(200, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[6].add(new CarYellow(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[6].add(new CarBlue(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[6].add(new CarYellow(200, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[6].add(new CarYellow(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[6].add(new CarBlue(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[7] = new ArrayList<Car>();
		route[7].add(new CarBlue(200, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[7].add(new CarBlue(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[7].add(new CarBlue(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[7].add(new CarBlue(200, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[7].add(new CarBlue(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[7].add(new CarBlue(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[8] = new ArrayList<Car>();
		route[8].add(new CarYellow(200, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[8].add(new CarYellow(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[8].add(new CarYellow(100, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[8].add(new CarBlue(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[8].add(new CarYellow(200, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[8].add(new CarYellow(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[8].add(new CarYellow(300, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		route[8].add(new CarBlue(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		
		route[9] = new ArrayList<Car>();
		route[9].add(new CarBlue(200, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[9].add(new CarBlue(500, Constantes.ROAD1, DIRECTION.LEFT, 500));
		route[9].add(new CarBlue(100, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[9].add(new CarBlue(400, Constantes.ROAD2, DIRECTION.LEFT, 500));
		route[9].add(new CarBlue(200, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[9].add(new CarBlue(400, Constantes.ROAD3, DIRECTION.RIGHT, 500));
		route[9].add(new CarBlue(300, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		route[9].add(new CarBlue(500, Constantes.ROAD4, DIRECTION.RIGHT, 500));
		/*
		for(int height = 0; height < Constantes.LEVEL_NB_BLOC_HEIGHT; height++){
			for(int width = 0; width < Constantes.LEVEL_NB_BLOC_WIDTH; width++){
				Bloc b = null;
				switch(Constantes.LEVEL_BACKGROUND_INT[height][width]){
					case Constantes.BLOC_GRASS : b = new BlocGrass(width*Constantes.BLOC_DIMENSION, height*Constantes.BLOC_DIMENSION);
													 break;
					case Constantes.BLOC_LINE : b = new BlocLine(width*Constantes.BLOC_DIMENSION, height*Constantes.BLOC_DIMENSION);
					 								break;
					case Constantes.BLOC_ROAD : b = new BlocRoad(width*Constantes.BLOC_DIMENSION, height*Constantes.BLOC_DIMENSION);
					 								break;
				}
				background.add(b);
			}
		}*/
		// ajout des arbres dans le niveau (de facon logique il ne seront pas afficher, il font partie de background.png)
		/*Bloc b = new BlocTree(300, 200);
		background.add(b);
	    b = new BlocTree(500, 200);
		background.add(b);
	    b = new BlocTree(50, 200);
		background.add(b);
	    b = new BlocTree(150, 0);
		background.add(b);
	    b = new BlocTree(450, 0);
		background.add(b);
	    b = new BlocTree(400, 400);
		background.add(b);
	    b = new BlocTree(200, 400);
		background.add(b);
	    b = new BlocTree(100, 450);
		background.add(b);*/
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return route[level].iterator();
	}
	
	public Bloc get(int i) {
		return background.get(i);
	}
	
	public Frog getFrog(){
		return frog;
	}
	
	public Fly getFly(){
		return fly;
	}
	
	public void incNbInput(){
		nbInput++;
	}

	public void decNbInput(){
		nbInput--;
	}
	
	public int getNbInput(){
		return nbInput;
	}
	
	public void eatFly(){
		life++;
		flyEaten = true;
	}
	
	public boolean isFlyEaten(){
		return flyEaten;
	}
	
	public void hitCar(){
		life--;
		frog.setX(Constantes.POS_X_START_FROG);
		frog.setY(Constantes.POS_Y_START_FROG);
	}
	
	public boolean loose(){
		return life == 0;
	}
	
	public int getLife(){
		return life;
	}
	
	public void levelUp(){
		//si il y a encore un level prochaine sinon on refait le dernier
		if(level < Constantes.NB_LEVEL-1)
			level++;
		
		flyEaten = false;
		fly.setX(Constantes.POS_X_START_FLY);
		fly.setY(Constantes.POS_Y_START_FLY);
		frog.setX(Constantes.POS_X_START_FROG);
		frog.setY(Constantes.POS_Y_START_FROG);
	}
	
	public int getLevel() {
		// TODO Stub de la méthode généré automatiquement
		return level+1;
	}
}
