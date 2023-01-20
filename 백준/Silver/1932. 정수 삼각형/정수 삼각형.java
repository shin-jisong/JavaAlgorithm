import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr[0][0] = tri[0][0];
		
		for(int i = 1; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j == 0)
					arr[i][j] = arr[i-1][j] + tri[i][j];
				else
					arr[i][j] = tri[i][j] + Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		
		int max = 0;
		for(int j = 0; j < n; j++)
			max = Math.max(max, arr[n-1][j]);
		
		System.out.print(max);

	}

}