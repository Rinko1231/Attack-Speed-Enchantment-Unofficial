package info.u_team.attack_speed_enchantment.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AttackSpeedConfig {

        public static final ModConfigSpec SPEC;
        public static ModConfigSpec.IntValue maxEnchantmentLevel;


        static
        {
            ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
            BUILDER.push("Attack Speed Enchantment Config");

            maxEnchantmentLevel = BUILDER
                    .comment("mojang ruined it, so you need to modify data\\attackspeedenchantment\\enchantment\\fasterattackspeed.json")
                    .defineInRange("Max Level of Faster Attack Speed Enchantment", 5,1,10);


            SPEC = BUILDER.build();
        }


    }
