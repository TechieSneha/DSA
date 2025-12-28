class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap of available rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Min heap of busy rooms: [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            // Free rooms that have completed meetings
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Assign meeting to a free room
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            } else {
                // Delay meeting until earliest room is free
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + (end - start);
                int room = (int) earliest[1];

                busyRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        // Find room with maximum meetings
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }

        return result;
    }
}