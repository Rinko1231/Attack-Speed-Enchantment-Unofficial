package info.u_team.attack_speed_enchantment.mixin;

import info.u_team.attack_speed_enchantment.enchantment.FasterAttackSpeedEnchantment;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

import static info.u_team.attack_speed_enchantment.enchantment.FasterAttackSpeedEnchantment.getHolder;

@Mixin(Player.class)
public class PlayerMixin {
	
	@Inject(method = "getCurrentItemAttackStrengthDelay", cancellable = true, at = @At("RETURN"))
	private void getCurrentItemAttackStrengthDelayWithFasterAttackSpeed(CallbackInfoReturnable<Float> callback) {
		Holder<Enchantment> holderFasterAttackSpeed = getHolder(((Player) (Object) this).level(), FasterAttackSpeedEnchantment.FASTERATTACKSPEED);
		final int level = Mth.clamp(EnchantmentHelper.getTagEnchantmentLevel(holderFasterAttackSpeed, ((Player) (Object) this).getMainHandItem()),  0, 10);
		if (level > 0) {
			callback.setReturnValue(callback.getReturnValueF() * (1 - (level * 0.1F)));
		}
	}
}
