package library;

import datastructures.lists.CustomArrayList;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    private CustomArrayList<Member> waitingList;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.waitingList = new CustomArrayList<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void addToWaitlist(Member member) {
        waitingList.add(member);
    }

    public Member getNextInWaitlist() {
        if(!waitingList.isEmpty()){
            return waitingList.get(waitingList.size() - 1);
        }
        return null;
    }

    public boolean hasWaitlist() {
        return !waitingList.isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}