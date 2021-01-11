package com.fnkee.solidrocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fnkee.solidrocks.setup.Registration;
import com.fnkee.solidrocks.util.handlers.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SolidRocks.MOD_ID)
public class SolidRocks {
	
	public static final String MOD_ID = "solidrocks";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public SolidRocks() {
		Registration.register();
		EventHandler.register();
		
		// Register ourselves for server and other game events we are interested in
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetupEvent);
	}
	
	private void clientSetupEvent(final FMLClientSetupEvent event) {
        EventHandler.clientRegister();
    }
}

//=============Things to add===============
//Stronger dynamites - combining redstone with gunpowder? combine 5 dynamite + wood = tnt?
//Add loot tables for all ores
//Make guaranteed gunpowder drop from creepers?
//Emerald needs a block
//Lava on water turns water to Old Stone
//Fix states in chain explosion, and ensure explosion even though block breaks behind dynamite
//Monster in the deep?
//Find a way to break tools earlier. Change how long they last.