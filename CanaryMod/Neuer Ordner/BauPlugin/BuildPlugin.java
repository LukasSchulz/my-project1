import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.BlockType;

public class BuildPlugin extends Plugin implements CommandListener{
	@Override
	public boolean enable(){
		try{
			Canary.commands().registerCommands(this,this,false);
		}
		catch(Exception e){
			getLogman().error("Command could not be registered");
		}
		getLogman().info("loading of BuildPlugin finished");
		return true;
	}
	
	@Override
	public void disable(){
	}
	
	@Command(aliases = {"build"},
		description = "Builds a wall or a cube",
		permissions = {""},
		toolTip = "/build <height> <width> (<depth>)",
		min = 3)
	public void build(MessageReceiver caller , String[] parameter){
		if(caller instanceof Player){
			Viereckig v;
			int height = Integer.valueOf(parameter[1]);
			int width = Integer.valueOf(parameter[2]);
			Player player = (Player) caller;
			
			if(parameter.length < 4){
				v = new Wall(height, width, BlockType.Pumpkin);
			}
			else{
				int depth = Integer.valueOf(parameter[3]);
				v = new Cube(height, width, depth, BlockType.Pumpkin);
			}
			v.build(player);
		}
		else{
			getLogman().info("This Command could only be used by a player");
		}
	}
}