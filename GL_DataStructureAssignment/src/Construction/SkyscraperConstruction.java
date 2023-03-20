package Construction;

import java.util.Scanner;

public class SkyscraperConstruction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building: ");
        int num = sc.nextInt();

        int days[] = new int[num+1];

        for (int i = 1; i <= num; i++) {
            System.out.println("enter the floor size given on day : " + i );
            int d = sc.nextInt();
            if(d > num)
            {
                System.out.println("Please enter valid floor number.");
                return;
            }
            days[d] = i;
        }
        int j = num;
        boolean flag;

        System.out.println("The order of construction is as follows");
        for (int i = 1; i <= num; i++) {
            flag = false;
            System.out.println("Day " + i);
            while (j >= 1 && days[j] <= i) {
                flag = true;
                System.out.print(j + " ");
                j--;
            }
            if (flag == true) {
                System.out.println();
            }
            System.out.println();
        }
        sc.close();

	}

}
