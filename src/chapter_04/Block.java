package chapter_04;

import java.util.ArrayList;

public class Block {
	 
    private int blockID;
    private int nonce;
    //private String data;
    private ArrayList<Transaction> transactionList;
    
    
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
	
	//트랜잭션 관련 변경 
	 public String getTransaction() {
	        String transactionInformations = "";
	        
	        for(int i=0;i<transactionList.size();i++) {
	            transactionInformations += transactionList.get(i).getInformation();
	        }
	        
	        return transactionInformations;
	    }
	    public void addTransaction(Transaction transaction) {
	        transactionList.add(transaction);
	    }
	
	
    
	    public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
	        this.blockID = blockID;
	        this.previousBlockHash = previousBlockHash;
	        this.nonce = nonce;
	        this.transactionList = transactionList;
	    }
    
	    public String getBlockHash() {
	        return Util.getHash(nonce + getTransaction() + previousBlockHash);
	    }
	    
	    public void showInformation() {    
	        System.out.println("---------------------------");
	        System.out.println("블록 번호: " + getBlockID());
	        System.out.println("이전 해시: " + getPreviousBlockHash());
	        System.out.println("채굴 변수 값: " + getNonce());
	        System.out.println("블록 데이터: ");
	        for(int i=0;i<transactionList.size();i++) System.out.println(transactionList.get(i).getInformation());
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
