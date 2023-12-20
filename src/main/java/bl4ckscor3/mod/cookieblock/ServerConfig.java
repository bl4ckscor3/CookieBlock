package bl4ckscor3.mod.cookieblock;

import org.apache.commons.lang3.tuple.Pair;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;

public class ServerConfig {
	public static final ModConfigSpec CONFIG_SPEC;
	public static final ServerConfig CONFIG;
	public IntValue eatingSpeed;

	static {
		Pair<ServerConfig, ModConfigSpec> serverSpecPair = new ModConfigSpec.Builder().configure(ServerConfig::new);

		CONFIG_SPEC = serverSpecPair.getRight();
		CONFIG = serverSpecPair.getLeft();
	}

	ServerConfig(ModConfigSpec.Builder builder) {
		eatingSpeed = builder.comment("How long it takes to eat the cookie block, in ticks (20 ticks = 1 second). The default eating speed of food in Minecraft is 32").defineInRange("eating_speed", 192, 0, Integer.MAX_VALUE);
	}
}