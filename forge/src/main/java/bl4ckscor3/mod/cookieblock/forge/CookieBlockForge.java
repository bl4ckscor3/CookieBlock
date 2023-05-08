package bl4ckscor3.mod.cookieblock.forge;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(CookieBlock.MOD_ID)
public class CookieBlockForge {
  public CookieBlockForge() {
    CookieBlock.init();
  }

  private static void init(FMLCommonSetupEvent event) {
    event.enqueueWork(CookieBlock::postInit);
  }
}
