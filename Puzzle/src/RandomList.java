import java.util.Random;

public class RandomList {
	private int[] list;
	private Random rand;
	RandomList(int max) {
		rand = new Random();
		list = new int[max];	
	}
	int[] getList(){
		int len = list.length;
		for(int i=0;i<len;i++){
			int n=0;
			while(found(n=rand.nextInt(len),i));
			list[i] = n;
			
		}
		return list;
	}
	boolean found(int value, int n){
		for(int i=0;i<n;i++){
			if(list[i]==value){
				return true;
			}
		}
		return false;
	}
}
