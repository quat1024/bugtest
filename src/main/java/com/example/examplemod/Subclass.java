package com.example.examplemod;

import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;

import javax.annotation.Nullable;

public class Subclass extends Superclass {
	public Subclass(Properties props) {
		super(props);
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		return defaultBlockState()
			.setValue(FACING, ctx.getClickedFace().getOpposite())
			.setValue(POWERED, false); //obvs you wouldnt do this in a real mod, but it's to demonstrate the field access
	}
}
