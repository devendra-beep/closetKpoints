import java.io.*;
import java.util.*;
import java.lang.*;

//main class ..look that class name file name are same
public class ClosestKPoints {

    public static void main(String[] args) {
        InputStream inputStream = System.in; 
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    // data structure for containing two element .. mutable 
   	static class Pair {
    int f=0;
    int s=0;	
    public Pair(int f,int s)
    {
        this.f = f;
        this.s = s;
    }
    public Pair(){}
    public int getf() { return f; }
    public int gets() { return s; }
	}

 	// data structue for containing the distance of coordinates and coordinates itself
 	static class new_data_st {
 		double ans=0.0;
 		int x1=0;
 		int y1=0;
 		int x2=0;
 		int y2=0;

        //constructor
 		public new_data_st(double ans,int x1,int y1,int x2,int y2){
 			this.ans=ans;
 			this.x1=x1;
 			this.y1=y1;
 			this.x2=x2;
 			this.y2=y2;
 		}
 		public new_data_st(){}
 		public double rans(){return ans;}
 		public int rx1(){return x1;}
 		public int rx2(){return x2;}
 		public int ry1(){return y1;}
 		public int ry2(){return y2;}
 	}

    static class Task {
        // function to calculate euclidean distance
    	public double eucdis(Pair a,Pair b){
    		int x1=a.getf();
    		int y1=a.gets();
    		int x2=b.getf();
    		int y2=b.gets();
    		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    	}

        public void solve(InputReader in, PrintWriter out) {    
            //long startTime = System.currentTimeMillis();
            
            // 1<=n<=500 and 1<=m<=(n*(n-1))/2
            // taking standard input
            int n = in.nextInt();
            int k = in.nextInt();

            // Array to store pairs of coordinates
           	ArrayList<Pair> coordy = new ArrayList<Pair>();
           	for(int i=0;i<n;i++){
           		int x=in.nextInt();
           		int y=in.nextInt();
           		Pair pair = new Pair(x,y);
           		coordy.add(pair);
           	}

            // Array to Store distance of Coordinates and Coordinates themselves 
           	ArrayList<new_data_st> answer = new ArrayList<new_data_st>();


 			for(int i=0;i<n;i++){
 				for(int j=i+1;j<n;j++){
 					Pair x=coordy.get(i);
 					Pair y=coordy.get(j);
 					double res=eucdis(x,y);
 					new_data_st temp_ans = new new_data_st(res,x.getf(),x.gets(),y.getf(),y.gets());
 					answer.add(temp_ans);
 				}
 				//System.out.println(coordy.get(i).getf()+" "+coordy.get(i).gets());
 			}
            // inbuild sort function with little modification in comparator
            // if first distance is less than second than swap otherwise continue
 			answer.sort(new Comparator<new_data_st>(){
 				@Override
 				public int compare(final new_data_st o1,final new_data_st o2){
 					int c;
 					double d1=o1.rans();
 					double d2=o2.rans();
 					if(d1<d2){ c=-1; }
 					else if(d1==d2){ c=0; }
 					else { c=1; }
 					return c;
 				}
 			});
            int kk=0;
 			for(new_data_st objext:answer){
                kk+=1;
                if(kk>k){ break; }
 				System.out.println(objext.rans()+" distance ("+objext.rx1()+","+objext.ry1()+") ("+objext.rx2()+","+objext.ry2()+")");
 		 }
         
    /*long stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");
    */
    
    }
}

 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
}