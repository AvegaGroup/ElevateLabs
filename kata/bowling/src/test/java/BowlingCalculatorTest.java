import com.avega.kata.BowlingCalculator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class BowlingCalculatorTest {

    @Test
    public void shouldCalculateGameOfOnesTo10() {
        int[][] rolls = new int[][]{
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0},
                new int[]{1, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(10));

    }

    @Test
    public void shouldCalculateBonusForASpare() {
        int[][] rolls = new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{5, 5},
                new int[]{5, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(20));

    }

    @Test
    public void shouldCalculateBonusForASpareWithZeroTenCombination() {
        int[][] rolls = new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 10},
                new int[]{5, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(20));

    }


    @Test
    public void shouldCalculateBonusForAStrike() {
        int[][] rolls = new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{10, 0},
                new int[]{5, 2},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(24));

    }


    @Test
    public void lastFrameShouldHandleThreeRolls() {
        int[][] rolls = new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{5, 5, 5}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(15));
    }

    @Test
    public void doubleStrikeShouldCalculateBonusFromNextTwoFrames() {
        int[][] rolls = new int[][]{
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{5, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(25 + 15 + 5));
    }

    @Test
    public void strikeInFrame9ShouldCalculateBonusFromFrame10() {
        int[][] rolls = new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{10, 0},
                new int[]{10, 10, 0}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(30 + 20));
    }


    @Test
    public void allStrikesResultsIn300() {
        int[][] rolls = new int[][]{
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 0},
                new int[]{10, 10, 10}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(300));
    }

    @Test
    public void uncleBobsAcceptanceCriteria() {
        int[][] rolls = new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
                new int[]{6, 4},
                new int[]{5, 5},
                new int[]{10, 0},
                new int[]{0, 1},
                new int[]{7, 3},
                new int[]{6, 4},
                new int[]{10, 0},
                new int[]{2, 8, 6}

        };
        int score = BowlingCalculator.calculateScore(rolls);
        Assert.assertThat(score, Is.is(133));
    }


}



