import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;

public class HelloWorldPlugin extends Plugin{
	@Override
	public boolean enable(){
		getLogman().info("Hello World!");
		return true;
		}
		
		@Override
	
		public void disable(){
		getLogman().info("Bye World!");
		}
	}