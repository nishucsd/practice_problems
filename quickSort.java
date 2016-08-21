package ucsd;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={4,5,7,3,6,2,77,25,6,7,35,4,654,363,6,764,5};
		quick(arr,0,arr.length-1);
		for(int i:arr){
			System.out.println(i);
		}
		

	}
	public static int partition(int[] arr, int beg, int l){
		
		int i=beg-1;
		int j = arr[l];
		for(int k=beg;k<l;k++){
			if(arr[k]<=j){
				int temp=arr[k];
				i++;
				arr[k]=arr[i];
				arr[i]=temp;
			}
		}
		int temp=arr[l];
		i++;
		arr[l]=arr[i];
		arr[i]=temp;
		
		return i;
	}
	
	public static void quick(int[] arr, int beg, int l){
		if(beg<l){
		int par = partition(arr,beg,l);
		quick(arr,beg,par-1);
		quick(arr,par+1,l);
		}
	}
	
}
