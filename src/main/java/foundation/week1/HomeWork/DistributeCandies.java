package foundation.week1.HomeWork;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candyType = {1,1,2,2,3,3};
		System.out.println(distributeCandy(candyType));
		
		int[] candyType1 = {1,1,2,3};
		System.out.println(distributeCandy(candyType1));
		
		int[] candyType2 = {6,6,6,6};
		System.out.println(distributeCandy(candyType2));
	}
	
	public static int distributeCandy(int[] candyType) {
		int noOfCandy = candyType.length/2;
        String uniqueCandy = "";
        for(int i=0;i<candyType.length;i++){
            if(!uniqueCandy.contains(Character.toString((candyType[i])))){
                uniqueCandy = uniqueCandy+candyType[i]+",";
            }
        }
        String[] split = uniqueCandy.split(",");
        if(split.length<=noOfCandy)
        return split.length;
        else
        return noOfCandy;
	}

}
