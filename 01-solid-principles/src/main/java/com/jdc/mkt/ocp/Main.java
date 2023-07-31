package com.jdc.mkt.ocp;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Type room name !");
		Room room = setRoom(name);
		double charges = room.getCharges();
		JOptionPane.showMessageDialog(null, charges);
		//System.out.println(charges);
	}
	
	static Room setRoom(String type) {
		switch (type) {
		case"double":
			return new DoubleRoom();
		case "family":
			return new FamilyRoom();
			default:
				return new SingleRoom();
		}
	}
}


abstract class Room{
	 double charges = 10000;
	public static Room getRoom(Room room) {
		return room;
	}
	
	double getCharges() {
		return charges;
	}
	
//	double getRoomCharges() {
//		if(room instanceof FamilyRoom) {
//			return room.getCharges()*3.0;
//		}else if(room instanceof DoubleRoom) {
//			return room.getCharges()*2.0;
//		}else if(room instanceof SingleRoom) {
//			return room.getCharges();
//		}
//		return 0;
//	}
}

class OtherRoom extends Room{
	@Override
	double getCharges() {
		
		return charges*4;
	}
}
class FamilyRoom extends Room{
	@Override
	double getCharges() {
		return charges*3;
	}
}
class DoubleRoom extends Room{
	@Override
	double getCharges() {
		return charges*2;
	}
}
class MasterRoom extends Room{
	@Override
	double getCharges() {
		return charges*3.5;
	}
}
class SingleRoom extends Room{
	
}