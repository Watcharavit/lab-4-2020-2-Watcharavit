package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class Coin extends Entity implements Interactable {

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.COIN;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		remove();
		GameController.addCoinCount(1);
		return true;
	}

}
