package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public abstract class Superclass extends DirectionalBlock {
	public Superclass(Properties props) {
		super(props);
		
		registerDefaultState(defaultBlockState()
			.setValue(FACING, Direction.UP)
			.setValue(POWERED, false));
	}
	
	//Field with the same name as a remapped field from the superclass.
	public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
	
	//Field with the same name as a remappable field, but doesn't shadow it since it's in a different class.
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		//Both of these field accesses remap correctly.
		builder.add(FACING, POWERED);
	}
}
