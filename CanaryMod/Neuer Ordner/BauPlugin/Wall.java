import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.World;

class Wall extends Viereckig{
	public Wall(int height, int width, BlockType material){
		super(height, width, material);
	}
	
	public void build(Player player){
		Location position = player.getLocation();
		World world = player.getWorld();
		
		double yStart = position.getY();
		double zStart = position.getZ();
		
		position.setX(position.getX() + 2);
		
		for(int y = 0; y < this.height; y++){
			position.setY(yStart + y);
			
			for(int z = 0; z< this.width; z++){
				position.setZ(zStart + z);
				world.setBlockAt(position, this.material);
			}
		}
	}
}