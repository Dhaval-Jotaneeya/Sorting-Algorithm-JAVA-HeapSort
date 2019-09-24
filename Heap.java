
class SortHeap
{
    public void buildHeap(int A[])
    {
        int n = A.length;
        for (int i = n/2 - 1 ; i >= 0; i--) {
            heapify(A,i,n);
        }
    }

    public void heapify(int A[],int idx,int max)
    {
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int largest;
        if( left < max && A[left]>A[idx] )
        {
            largest = left;
        }
        else
        {
            largest = idx;
        }

        if ( right < max && A[right] > A[largest] ) 
        {
            largest = right;    
        }
        if( largest != idx )
        {
            int temp = A[idx];
            A[idx] = A[largest];
            A[largest] = temp;

            heapify(A,largest,max);
        }
    }

    public void Sorts(int A[])
    {
        buildHeap(A);
        int n = A.length;
        for (int i = n-1; i > 0; i--) 
        {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            
            heapify(A, 0, i);
        }
    }
}

public class Heap
{
    public static void main(String[] args) {
        SortHeap sh = new SortHeap();

        long t1 = System.currentTimeMillis();
        int Arr[] = {6,5,3,1,8,7,2,4};
        sh.Sorts( Arr );
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("\t"+Arr[i]);
        }
        long t2 = System.currentTimeMillis();


        System.out.println("Time Complexity :::"+(t2-t1));
    }
}