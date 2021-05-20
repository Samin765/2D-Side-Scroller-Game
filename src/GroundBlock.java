
public class GroundBlock extends WorldBlocks{
    public GroundBlock(int id){
        super(Resources.tileSet, id, 200, 200);
    }

  
    public boolean isSolid(){
        return true;
    }


}



