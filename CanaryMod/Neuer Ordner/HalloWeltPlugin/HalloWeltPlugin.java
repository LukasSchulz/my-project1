import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;

public class HalloWeltPlugin extends Plugin {
    @Override
    public boolean enable() {
        getLogman().info("Hallo Welt!");
        return true;
    }

    @Override
    public void disable() {
        getLogman().info("Tschüss Welt!");
    }
}