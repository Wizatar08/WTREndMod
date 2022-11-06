package dev.wizatar08.wtrendmod;

import dev.wizatar08.wtrendmod.init.BlockInit;
import dev.wizatar08.wtrendmod.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WTREndMod.MODID)
public class WTREndMod {
    public static final String MODID = "wtrendmod";

    public WTREndMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
    }
}
