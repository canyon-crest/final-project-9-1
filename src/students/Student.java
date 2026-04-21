package students;


import java.util.*;

public abstract class Student{
	protected String name;
	protected int cost;
	protected int health;
	protected int cooldown;
	protected int row;
	protected int col;

    public Student(String name, int cost, int health, int cooldown, int row, int col) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.cooldown = cooldown;
        this.row = row;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    
    public void setRow(int row) {
    	this.row = row;
    }
    
    public void setCol(int col) {
    	this.col = col;
    }
    
    public int getRow() {
    	return row;
    }
    
    public int getCol() {
    	return col;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public abstract void act();
}