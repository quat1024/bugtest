package com.example.examplemod;

import net.minecraft.state.EnumProperty;
import net.minecraft.util.Direction;

public class UnrelatedClass {
	//This access gets remapped correctly too
	public static final EnumProperty<Direction> FACING = Superclass.FACING;
}
