package bl4ckscor3.mod.cookieblock;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ServerConfig {
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final ServerConfig CONFIG;
	public IntValue eatingSpeed;

	static {
		Pair<ServerConfig, ForgeConfigSpec> serverSpecPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);

		CONFIG_SPEC = serverSpecPair.getRight();
		CONFIG = serverSpecPair.getLeft();
	}

	ServerConfig(ForgeConfigSpec.Builder builder) {
		eatingSpeed = builder.comment("How long it takes to eat the cookie block, in ticks (20 ticks = 1 second). The default eating speed of food in Minecraft is 32").defineInRange("eating_speed", 192, 0, Integer.MAX_VALUE);
	}
}