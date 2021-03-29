package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class ColorBox extends Entity implements Interactable {

	private boolean activeBool;

	public ColorBox(boolean activeBox) {
		// TODO Auto-generated constructor stub
		this.activeBool = activeBox;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (GameController.getGameSwitchStatus() == this.activeBool) {
			return super.move(e.getDirection());
		}
		return false;
	}

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (this.activeBool == true) {
			return Sprites.BOX_RED;
		}
		return Sprites.BOX_BLUE;
	}

	public boolean isActiveBool() {
		return activeBool;
	}

	public void setActiveBool(boolean activeBool) {
		this.activeBool = activeBool;
	}

}
