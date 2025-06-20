package info.u_team.attack_speed_enchantment.init;

import info.u_team.attack_speed_enchantment.AttackSpeedEnchantmentMod;
import info.u_team.attack_speed_enchantment.enchantment.FasterAttackSpeedEnchantment;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

import static info.u_team.attack_speed_enchantment.enchantment.FasterAttackSpeedEnchantment.getHolder;

@EventBusSubscriber(modid = AttackSpeedEnchantmentMod.MODID, value = Dist.CLIENT)
public class AttackSpeedEnchantmentClientEvents {

	private static final MutableComponent NONE_COMPONENT = Component.translatable(AttackSpeedEnchantmentMod.MODID + ".faster_attack_speed.none", 0)
					.withStyle(ChatFormatting.DARK_PURPLE);

	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		Player player = event.getEntity();
		if (player == null) return;
		ItemStack stack = event.getItemStack();
		List<Component> tooltip = event.getToolTip();

		if (stack.isEmpty()) return;

		Holder<Enchantment> holderFasterAttackSpeed = getHolder(player.level(), FasterAttackSpeedEnchantment.FASTERATTACKSPEED);
		int enchantmentLevel  = stack.getEnchantmentLevel(holderFasterAttackSpeed);

				if (enchantmentLevel < 1) return;

				if (enchantmentLevel >= 10) {
					tooltip.add(NONE_COMPONENT);
				} else {
					tooltip.add(Component.translatable(AttackSpeedEnchantmentMod.MODID + ".faster_attack_speed.faster", (enchantmentLevel * 10) + "%")
									.withStyle(ChatFormatting.DARK_GREEN));
				}

			}


}

