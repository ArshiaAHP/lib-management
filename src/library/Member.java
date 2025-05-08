package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    private CustomStack<Transaction> memberTransactions;
    private static final int MAX_TRANSACTIONS = 100;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.memberTransactions = new CustomStack<>(MAX_TRANSACTIONS);
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        memberTransactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        return memberTransactions.peek();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
