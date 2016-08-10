import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.entity.living.humanoid.Player;

abstract class Viereckig{
	protected int height;
	protected int width;
	protected BlockType material;
	
	public Viereckig(int height, int width, BlockType material){
		this.height = height;
		this.width = width;
		this.material = material;
	}
	
	abstract void build(Player player);
	
}