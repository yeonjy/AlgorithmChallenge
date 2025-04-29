import java.util.*;

public class Solution {
    static class Job implements Comparable<Job> {
        int num;
        int request;
        int time;

        public Job(int num, int request, int time) {
            this.num = num;
            this.request = request;
            this.time = time;
        }

        @Override
        public int compareTo(Job job) {
            if (this.time != job.time) {
                return Integer.compare(this.time, job.time);
            }
            if (this.request != job.request) {
                return Integer.compare(this.request, job.request);
            }
            return Integer.compare(this.num, job.num);
        }
    }

    public int solution(int[][] jobs) {
    // jobs를 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<Job> availableQueue = new PriorityQueue<>();
        int currentTime = 0;
        int totalTurnaround = 0;
        int index = 0;

        while (index < jobs.length || !availableQueue.isEmpty()) {
            // 현재 시간 이전에 요청된 작업을 큐에 추가
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                availableQueue.add(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
            }

            if (availableQueue.isEmpty()) {
                // 처리할 작업이 없으면 다음 작업의 요청 시간으로 이동
                currentTime = jobs[index][0];
            } else {
                Job job = availableQueue.poll();
                currentTime += job.time;
                totalTurnaround += currentTime - job.request;
            }
        }

        return totalTurnaround / jobs.length;
    }
}