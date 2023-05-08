package bl4ckscor3.mod.cookieblock.fabric;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.fabricmc.api.ModInitializer;

public class CookieBlockFabric implements ModInitializer {
  @Override
  public void onInitialize() {
    CookieBlock.init();
    CookieBlock.postInit();
  }
}
