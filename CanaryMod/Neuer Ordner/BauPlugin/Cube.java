import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.World;

class Cube extends Viereckig{
	private int depth;
	
	public Cube(int height, int width, int depth, BlockType material){
		super(height, width, material);
		this.depth = depth;
	}
	
	public void build(Player player){
		Location position = player.getLocation();
		World world = player.getWorld();
		
		double yStart = position.getY();
		double xStart = position.getX() + 2;
		double zStart = position.getZ();
		
		for(int x = 0; x< this.depth; x++){
			position.setX(xStart + x);
			
			for(int y = 0; y < this.height ; y++){
				position.setY(yStart + y);
				
				for(int z = 0; z < this.width ; z++){
					position.setZ(zStart + z);
					world.setBlockAt(position, this.material);
				}
			}
		}
	}
}