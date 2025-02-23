package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.racconscreator.RacconsModdingv2.effect.Raccons_Effects;

import java.util.List;
import java.util.Map;

public class Raccons_ArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(Raccons_Armor_Materials.RACCONS_Mask,
                            List.of(new MobEffectInstance(Raccons_Effects.Raccoons_Curse.getHolder().get(), 200, 1, false, false)))

                    .put(Raccons_Armor_Materials.RACCONS_Mask_Glowing,
                            List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 500, 1, false, false, false),
                                    new MobEffectInstance(Raccons_Effects.Raccoons_Curse.getHolder().get(), 200, 1, false, false, false)))

                    .build();

    public Raccons_ArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        return !helmet.isEmpty();
    }
}
