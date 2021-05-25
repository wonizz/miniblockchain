package chapter_02;

public class BlockChainStarter {
	public static void main(String[] args) {
	        // 블록 번호가 '1', 정답 값이 '0', 블록이 갖고있는 데이터가 '데이터'
	        Block block = new Block(1,0,"데이터");
	        //block.getInformation();
	        
	        
	        // 채굴 
	        block.mine();
	        block.getInformation();
	        
	        
	}
}
