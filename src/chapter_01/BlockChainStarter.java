package chapter_01;

public class BlockChainStarter {
	public static void main(String[] args) {
	    
		//01.데이터 해
		System.out.println(Util.getHash("0"));
		
		//02.nonce값 변경을 통한 채굴 
		int nonce = 0;
	    while(true) {
	        if(Util.getHash(String.valueOf(nonce)).substring(0, 6).equals("000000")) {
	            System.out.println("정답 : " + nonce);
	            break;
	        }
	        nonce++;
	    }
	}
}
