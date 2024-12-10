package net.racconscreator.RacconsModdingv2.RacconsSound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

public class Raccons_Sounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RacconsModdingv2.MODID);


    // ITEMS SOUNDS
    public static final RegistryObject<SoundEvent> SCYTHEOFINK_USE = registerSoundEvent("scytheofink_use");




    //BLOCKS SOUNDS
    public static final ForgeSoundType INK_PORTAL_SOUNDS = new ForgeSoundType(2f,2f,
            Raccons_Sounds.INK_PORTAL_BREAK, Raccons_Sounds.INK_PORTAL_STEP, Raccons_Sounds.INK_PORTAL_PLACE,
            Raccons_Sounds.INK_PORTAL_HIT, Raccons_Sounds.INK_PORTAL_FALL);

    //INK_PORTAL SOUNDS
    public static final RegistryObject<SoundEvent> INK_PORTAL_BREAK = registerSoundEvent("ink_portal_break");
    public static final RegistryObject<SoundEvent> INK_PORTAL_STEP = registerSoundEvent("ink_portal_step");
    public static final RegistryObject<SoundEvent> INK_PORTAL_PLACE = registerSoundEvent("ink_portal_place");
    public static final RegistryObject<SoundEvent> INK_PORTAL_HIT = registerSoundEvent("ink_portal_hit");
    public static final RegistryObject<SoundEvent> INK_PORTAL_FALL = registerSoundEvent("ink_portal_fall");

    public static final ForgeSoundType INK_SLIDE_SOUNDS = new ForgeSoundType(2f,2f,
            Raccons_Sounds.INK_SLIDE_BREAK, Raccons_Sounds.INK_SLIDE_STEP, Raccons_Sounds.INK_SLIDE_PLACE,
            Raccons_Sounds.INK_SLIDE_HIT, Raccons_Sounds.INK_SLIDE_FALL);

    //INK_SLIDE SOUNDS
    public static final RegistryObject<SoundEvent> INK_SLIDE_BREAK = registerSoundEvent("ink_slide_break");
    public static final RegistryObject<SoundEvent> INK_SLIDE_STEP = registerSoundEvent("ink_slide_step");
    public static final RegistryObject<SoundEvent> INK_SLIDE_PLACE = registerSoundEvent("ink_slide_place");
    public static final RegistryObject<SoundEvent> INK_SLIDE_HIT = registerSoundEvent("ink_slide_hit");
    public static final RegistryObject<SoundEvent> INK_SLIDE_FALL = registerSoundEvent("ink_slide_fall");

    public static final ForgeSoundType INK_MELT_SOUNDS = new ForgeSoundType(2f,2f,
            Raccons_Sounds.INK_MELT_BREAK, Raccons_Sounds.INK_MELT_STEP, Raccons_Sounds.INK_MELT_PLACE,
            Raccons_Sounds.INK_MELT_HIT, Raccons_Sounds.INK_MELT_FALL);

    //INK_MELT SOUNDS
    public static final RegistryObject<SoundEvent> INK_MELT_BREAK = registerSoundEvent("ink_melt_break");
    public static final RegistryObject<SoundEvent> INK_MELT_STEP = registerSoundEvent("ink_melt_step");
    public static final RegistryObject<SoundEvent> INK_MELT_PLACE = registerSoundEvent("ink_melt_place");
    public static final RegistryObject<SoundEvent> INK_MELT_HIT = registerSoundEvent("ink_melt_hit");
    public static final RegistryObject<SoundEvent> INK_MELT_FALL = registerSoundEvent("ink_melt_fall");


//Songs =3
    public static final RegistryObject<SoundEvent> Surrounded_by_Ink = registerSoundEvent("surrounded_by_ink");
    public static final ResourceKey<JukeboxSong> Surrounded_by_Ink_key = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "surrounded_by_ink"));





    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name,
        () -> SoundEvent.createVariableRangeEvent
                (ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
