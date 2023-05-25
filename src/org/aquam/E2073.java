package org.aquam;

// 5/15/2023
public class E2073 {

    public static void main(String[] args) {

        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{5, 4, 2, 3, 5, 2}, 3));
        System.out.println(timeRequiredToBuy(new int[]{84,49,5,24,70,77,87,8}, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int kTime = 0;
        int numberOfPeople = tickets.length;
        for (int i = 0; i < numberOfPeople; i++) {
            if (i > k)
                kTime += Math.min(tickets[i], tickets[k] - 1);
            else
                kTime += Math.min(tickets[i], tickets[k]);
        }
        return kTime;
    }

    public static int timeRequiredToBuy3(int[] tickets, int k) {
        int kTime = 0;
        int numberOfPeople = tickets.length;
        for (int i = 0; i < numberOfPeople; i++) {
            if (tickets[i] < tickets[k])
                kTime += tickets[i];
            else
                kTime += i > k ? tickets[k] - 1 : tickets[k];
        }
        return kTime;
    }

    public static int timeRequiredToBuy2(int[] tickets, int k) {
        int numberOfPeople = tickets.length;
        int kTime = 0;
        int index = 0;
        while (tickets[k] != 0) {
            if (tickets[index] > 0) {
                tickets[index] = tickets[index] - 1;
                ++kTime;
            }
            ++index;
            if (index == numberOfPeople)
                index = 0;
        }
        return kTime;
    }

    public static int timeRequiredToBuy1(int[] tickets, int k) {
        int numberOfPeople = tickets.length;
        int kTime = 0;

        for (int i = 0; i < numberOfPeople; i++) {
            if (tickets[i] > 0) {
                tickets[i] = tickets[i] - 1;
                ++kTime;
            }
            if (i == k && tickets[i] == 0)
                return kTime;
            if (i == numberOfPeople - 1)
                i = -1;
        }
        return kTime;
    }
}
