package Homework02;

public class Process implements Comparable<Process> {
    private String processName;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getProcessName() {
        return processName;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Override // we are overriding this method from Comparable interface tj. implements Comparable<Process>
    public int compareTo(Process other) {

        if (this.priority == other.priority) {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        return Integer.compare(this.priority, other.priority);

        //Integer compare returns 3 results based on result : -1, 0 and 1
    }
}