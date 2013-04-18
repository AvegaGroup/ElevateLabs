package com.avega.kata;
public class BowlingCalculator {

    public static final int TEN = 10;

    public static int calculateScore(int[][] scores) {
        int totalScore = 0;
        int currentFrame = 0;
        for (int[] frame : scores) {
            int frameScore = getFrameScore(frame);
            int bonus = calculateBonusForStrikeOrSpare(scores, currentFrame);
            totalScore += frameScore + bonus;
            currentFrame++;
        }
        return totalScore;
    }

    private static int calculateBonusForStrikeOrSpare(int[][] scores, int currentFrame) {
        if (isSpare(scores[currentFrame]) && !isLastFrame(currentFrame)) {
            return scores[currentFrame + 1][0];
        } else if (isStrike(scores[currentFrame][0]) && !isLastFrame(currentFrame)) {
           return calculateStrikeBonus(scores, currentFrame);
        }
        return 0;
    }

    private static boolean isSpare(int[] frame) {
        return getFrameScore(frame) == TEN && frame[0] < TEN;
    }

    private static boolean isLastFrame(int currentFrameIndex) {
        return currentFrameIndex == 9;
    }

    private static int calculateStrikeBonus(int[][] scores, int current) {
        if (isStrike(scores[current + 1][0]) && !isLastFrame(current + 1)) {
            return scores[current + 1][0] + scores[current + 2][0];
        } else {
            return scores[current + 1][0] +scores[current + 1][1] ;
        }
    }

    private static boolean isStrike(int roll) {
        return roll == TEN;
    }

    private static int getFrameScore(int[] frame) {
        int frameScore = 0;
        for (int roll : frame) {
            frameScore += roll;
        }
        return frameScore;
    }
}