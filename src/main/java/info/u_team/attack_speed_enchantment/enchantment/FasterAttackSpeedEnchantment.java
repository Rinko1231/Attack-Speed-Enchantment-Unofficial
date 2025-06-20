package info.u_team.attack_speed_enchantment.enchantment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.u_team.attack_speed_enchantment.AttackSpeedEnchantmentMod;
import info.u_team.attack_speed_enchantment.config.AttackSpeedConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;


public class FasterAttackSpeedEnchantment  {

	public static Holder<Enchantment> getHolder(Level level, ResourceKey<Enchantment> enchantment) {
		return level.holderLookup(enchantment.registryKey()).getOrThrow(enchantment);
	}

	public static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> enchantment, Enchantment.Builder builder) {
		context.register(enchantment, builder.build(enchantment.location()));
	}

	public static ResourceKey<Enchantment> createResourceKey(String path) {
		return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(AttackSpeedEnchantmentMod.MODID, path));
	}

	public static final Map<ResourceKey<?>, List<ICondition>> conditions = new HashMap<>();
	public static ResourceKey<Enchantment> FASTERATTACKSPEED = createResourceKey("fasterattackspeed");


	public static void bootstrap(BootstrapContext<Enchantment> context) {

		HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);

		registerFasterAttackSpeed(context, itemsRegistry);


	}

	private static void registerFasterAttackSpeed(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {

		Enchantment.EnchantmentDefinition definition = Enchantment.definition(
				itemsRegistry.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
				itemsRegistry.getOrThrow(ItemTags.AXES),
				5,
				5,
				Enchantment.dynamicCost(1,10),
				Enchantment.constantCost(80),
				1,
				EquipmentSlotGroup.MAINHAND
		);

		Enchantment.Builder builder = Enchantment.enchantment(definition);

		register(context, FASTERATTACKSPEED, builder);
	}



	private static ResourceKey<Enchantment> key(String pName) {
		return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(AttackSpeedEnchantmentMod.MODID, pName));
	}

}