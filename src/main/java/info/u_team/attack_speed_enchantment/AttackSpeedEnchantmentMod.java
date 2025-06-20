package info.u_team.attack_speed_enchantment;


import info.u_team.attack_speed_enchantment.config.AttackSpeedConfig;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(AttackSpeedEnchantmentMod.MODID)
public class AttackSpeedEnchantmentMod {
	
	public static final String MODID = "attackspeedenchantment";
	
	public AttackSpeedEnchantmentMod (ModContainer modContainer) {
			modContainer.registerConfig(ModConfig.Type.COMMON, AttackSpeedConfig.SPEC,"AttackSpeedEnchantmentConfig.toml");
		}

}
