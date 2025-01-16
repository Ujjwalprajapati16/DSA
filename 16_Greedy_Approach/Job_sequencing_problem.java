
import java.util.ArrayList;
import java.util.Collections;

public class Job_sequencing_problem {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[][] jobInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // sort by profit in descending order

        ArrayList<Job> selectedJobs = new ArrayList<>();
        int time = 0;
        int profit = 0;

        for (Job job : jobs) {
            if (job.deadline > time) {
                selectedJobs.add(job);
                time++;
                profit += job.profit;
            }
        }

        // print selected jobs
        System.out.println("Maximum jobs that can be scheduled: " + selectedJobs.size());
        System.out.println("Maxmimum profit: " + profit);
        for (Job job : selectedJobs) {
            System.out.println("Job " + job.id + " " + job.profit + " ");
        }
    }
}
