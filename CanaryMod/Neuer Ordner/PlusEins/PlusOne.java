import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;

public class PlusOne extends Plugin implements CommandListener{
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
	
	@Command(aliases = {"plusOne"},
		description = "Adds 1 to the Number used",
		permissions = {""},
		toolTip = "/plusOne <number>",
		min = 2)
	public void plusOne(MessageReceiver caller, String[] parameter){
		String input = parameter[1];
		long number = Long.valueOf(input);
		number += 1;
		
		Canary.instance().getServer().broadcastMessage(String.valueOf(number));
	}
}