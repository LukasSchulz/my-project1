import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.World;

public class PumpkinWallPlugin extends Plugin implements CommandListener{
	@Override
	public boolean enable(){
		try{
			Canary.commands().registerCommands(this, this, false);
		}
		catch(Exception e){
			getLogman().error("Command could not be registered!");
		}
		getLogman().info("PumpkinWallPlugin- loading finished");
		return true;
		
	}
	@Override
	public void disable(){
		
	}
	
	@Command(aliases = {"pumpkinwall"},
		description = "Places a tower of pumpkins in Front of the Player",
		permissions = {""},
		toolTip = "/pumpkinwall <height> <lenght>",
		min = 3)
	public void placePumpkin(MessageReceiver caller, String[] parameter){
		Player player = (Player) caller;

			 long height = Long.valueOf(parameter[1]);

			 long lenght = Long.valueOf(parameter[2]);

		
		
		
		Location location = player.getLocation();
		location.setX(location.getX()+2);
		
		World world = player.getWorld();
		for(int i = 0; i<height; i++){
			double z = 1;
			for(int l = 0; l<lenght; l++){
				
				
				location.setZ(location.getZ()+1);
				
			
				world.setBlockAt(location, BlockType.Pumpkin);
				
			}
			location.setZ(location.getZ()-lenght);
			location.setY(location.getY()+z);
			z++;
		}
	}
}