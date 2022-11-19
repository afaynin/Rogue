package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {

			up1 = ImageIO.read(getClass().getResource("/player/JackUp1.png"));
			up2 = ImageIO.read(getClass().getResource("/player/JackUp2.png"));
			down1 = ImageIO.read(getClass().getResource("/player/JackDown1.png"));
			down2 = ImageIO.read(getClass().getResource("/player/JackDown2.png"));
			right1 = ImageIO.read(getClass().getResource("/player/JackRight1.png"));
			right2 = ImageIO.read(getClass().getResource("/player/JackRight2.png"));
			left1 = ImageIO.read(getClass().getResource("/player/JackLeft1.png"));
			left2 = ImageIO.read(getClass().getResource("/player/JackLeft2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {
			if (keyH.upPressed) {
				direction = "up";
				y -= speed;
			}
			if (keyH.downPressed) {
				direction = "down";
				y += speed;
			}
			if (keyH.leftPressed) {
				direction = "left";
				x -= speed;
			}
			if (keyH.rightPressed) {
				direction = "right";
				x += speed;
			}

			spriteCounter++;
			if (spriteCounter > 15) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;

		case "down":
			if (spriteNum == 1) {
				image = down2;
			}
			if (spriteNum == 2) {
				image = down1;
			}
			break;

		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;

		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

	}
}
