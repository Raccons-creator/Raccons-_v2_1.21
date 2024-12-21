package net.racconscreator.RacconsModdingv2;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsModCreativeTabs;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;
import net.racconscreator.RacconsModdingv2.effect.Raccons_Effects;
import net.racconscreator.RacconsModdingv2.enchantment.Raccons_Enchantments_Effects;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;
import net.racconscreator.RacconsModdingv2.entity.client.RacconRenderer;
import org.slf4j.Logger;

@Mod(RacconsModdingv2.MODID)
public class RacconsModdingv2
{
    public static final String MODID = "racconsmodid";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RacconsModdingv2()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        RacconsItems.register(modEventBus);
        RacconsBlocks.register(modEventBus);
        RacconsModCreativeTabs.register(modEventBus);
        Raccons_Sounds.register(modEventBus);
        Raccons_Effects.register(modEventBus);
        Raccons_Enchantments_Effects.register(modEventBus);
        Raccons_Entities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(RacconsItems.RACCONS_FUR);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(RacconsItems.CLAM);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(RacconsItems.SCYTHEOFINK);
            event.accept(RacconsItems.SWORDOFINK);
            event.accept(RacconsItems.THESHEFER);
            event.accept(RacconsItems.THE_BIG_CANNON);

        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(RacconsBlocks.INK_PORTAL);
            event.accept(RacconsBlocks.INK_SLIDE);
            event.accept(RacconsBlocks.INK_MELT);

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents

    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            EntityRenderers.register(Raccons_Entities.RACCON.get(), RacconRenderer::new);
        }
    }
}
