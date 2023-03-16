import java.util.*;

public class Trapping_Rainwater 
{
    public static int Trap_Water(int arr[] , int size)
    {
        int water_level = 0;
        int leftmax[] = new int[size];
        int rightmax[] = new int[size];

        //Edge case for single bar
        if(size == 1)
        {
            return 0;
        }

        //Edge case for asc and desc bar
        for(int i = 0 ; i < size ; i++)
        {
            if(arr[i] > arr[i+1])
            {
                break;
            }
            else if(arr[i] < arr[i+1])
            {
                break;
            }
            return 0;
        }
        // Calculating max left boundary
        leftmax[0] = arr[0];
        for(int i = 1 ; i < size ; i++)
        {
            leftmax[i] = Math.max(arr[i] , leftmax[i-1]);
        }

        // Calculating max right boundary
        rightmax[size-1] = arr[size-1];
        for(int i = (size-2) ; i >=0 ; i--)
        {
            rightmax[i] = Math.max(arr[i] , rightmax[i+1]);
        }
        //for loop
        for(int i = 0 ; i < size ; i++)
        {
            //calculating trapped water
            int TP = (Math.min(leftmax[i] , rightmax[i]) - arr[i]);
            water_level += TP;
        }
        return water_level;

    }
    public static void main(String args[])    
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of array");
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = Trap_Water(arr , size);
        System.out.println("Trapped water = " +ans);
    }
}
