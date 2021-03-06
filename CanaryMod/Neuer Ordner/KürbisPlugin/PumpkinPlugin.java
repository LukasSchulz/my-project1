import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.World;

public class PumpkinPlugin extends Plugin implements CommandListener{
	@Override
	public boolean enable(){
		try{
			Canary.commands().registerCommands(this, this, false);
		}
		catch(Exception e){
			getLogman().error("Command could not be registered!");
		}
		return true;
	}
	@Override
	public void disable(){
		
	}
	
	@Command(aliases = {"pumpkin"},
		description = "Places a pumpkin in Front of the Player",
		permissions = {""},
		toolTip = "/pumpkin")
	public void placePumpkin(MessageReceiver caller, String[] parameter){
		Player player = (Player) caller;
		
		Location location = player.getLocation();
		location.setX(location.getX()+2);
		World world = player.getWorld();
		world.setBlockAt(location, BlockType.Pumpkin);
	}
}