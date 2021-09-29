package com.kodilla.testing.forum.statistics;

public class ForumStatisticsCalculator {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averageQuantityOfPostsPerUser;
    private double averageQuantityOfCommentsPerUser;
    private double averageQuantityOfCommentsPerPost;

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAverageQuantityOfPostsPerUser() {
        return averageQuantityOfPostsPerUser;
    }

    public double getAverageQuantityOfCommentsPerUser() {
        return averageQuantityOfCommentsPerUser;
    }

    public double getAverageQuantityOfCommentsPerPost() {
        return averageQuantityOfCommentsPerPost;
    }

    private  double calculateAveragePostsPerUser() {
        if (usersQuantity > 0) {
            return (double) postsQuantity/usersQuantity;
        } else {
            return 0;
        }
    }

    private double calculateAverageCommentsPerUser() {
        if (usersQuantity > 0) {
            return (double) commentsQuantity/usersQuantity;
        } else {
            return 0;
        }
    }

    private double calculateAverageCommentsPerPost() {
        if (postsQuantity > 0) {
            return (double) commentsQuantity/postsQuantity;
        } else {
            return 0;
        }
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        averageQuantityOfPostsPerUser = calculateAveragePostsPerUser();
        averageQuantityOfCommentsPerUser = calculateAverageCommentsPerUser();
        averageQuantityOfCommentsPerPost = calculateAverageCommentsPerPost();
    }

    public void showStatistics() {
        System.out.println(usersQuantity);
        System.out.println(postsQuantity);
        System.out.println(commentsQuantity);
        System.out.println(averageQuantityOfPostsPerUser);
        System.out.println(averageQuantityOfCommentsPerPost);
        System.out.println(averageQuantityOfCommentsPerUser);
    }
}
