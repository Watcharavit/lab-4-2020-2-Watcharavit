package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class TrashCompactor extends Entity implements Interactable, Consumable, Updatable {
	private int cooldown;

	public TrashCompactor() {
		this.cooldown = 0;
	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (super.isBox(e) && this.cooldown == 0) {
			setCooldown(GameController.MAX_COOLDOWN_TIME);
			return true;
		}
		return false;
	}

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (this.cooldown > 0) {
			return Sprites.COMPACTOR_OFF;
		}
		return Sprites.COMPACTOR_ON;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (super.isBox(e) && this.cooldown == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void update() throws IllegalValueException {
		// TODO Auto-generated method stub
		if (this.cooldown < 0) {
			throw new IllegalValueException();
		}
		setCooldown(this.cooldown - 1);
		;
	}

	@Override
	public void valueCorrection() {
		setCooldown(0);

	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		if (cooldown > 0) {
			this.cooldown = cooldown;
		} else {
			this.cooldown = 0;
		}
	}

}
