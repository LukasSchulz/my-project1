import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;

public class HelloServerPlugin extends Plugin implements CommandListener {
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
	@Command(aliases = {"helloServer"},
			description = "Sends a greeting at the Server",
			permissions = {""},
			toolTip = "/helloServer <name>",
			min = 2)
	public void helloServer(MessageReceiver caller, String[] parameter){
		String playerName = parameter[1];
		Canary.instance().getServer().broadcastMessage("Hello " + playerName + "!");
	}
}