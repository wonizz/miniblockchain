package chapter_03;

public class Block {
	 
    private int blockID;
    private int nonce;
    private String data;
    
    //이전 해시값. 
    private String previousBlockHash;
    
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
    
    public Block(int blockID, String previousBlockHash, int nonce, String data) {
        this.blockID = blockID;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
        this.data = data;
    }
    
    public String getBlockHash() {
        return Util.getHash(nonce + data + previousBlockHash);
    }
    
    public void getInformation() {
        System.out.println("---------------------------");
        System.out.println("블록 번호: " + getBlockID());
        System.out.println("이전 해시: " + getPreviousBlockHash());
        System.out.println("채굴 변수 값: " + getNonce());
        System.out.println("블록 데이터: " + getData());
        System.out.println("블록 해시: " + getBlockHash());
        System.out.println("---------------------------");
    }
    
    
    
    //채굴을 수행하기 위한 함수. 
    public void mine() {
        while(true) {
            if(getBlockHash().substring(0, 4).equals("0000")) {
                System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
                break;
            }
            nonce++;
        }
    }

    

}
