import java.util.Random;

import java.util.ArrayList;

public class APA
{
    class StepTracker
    {
        private int DailySteps;
        private int TotalDays;
        private int ActiveDays;
        private int AverageSteps;
        private int RequiredSteps;

        public StepTracker(int requiredSteps)
        {
            RequiredSteps = requiredSteps;
            DailySteps = 0;
            AverageSteps = 0;
            ActiveDays = 0;
            TotalDays = 0;
        }

        public int activeDays()
        {
            return ActiveDays;
        }

        public int averageSteps()
        {
            AverageSteps = DailySteps / TotalDays;
            return AverageSteps;
        }

        public void addDailySteps(int steps)
        {
               if (steps < RequiredSteps)
                   System.out.println("Error: Too little steps to be considered active!");
               else
                   ActiveDays++;

            TotalDays++;
            DailySteps += steps;
        }
    }

    class Delimiters
    {
        private String openDel;
        private String closeDel;

        public Delimiters(String open, String close)
        {
            openDel = open;
            closeDel = close;
        }

        private ArrayList<String> delimiters = new ArrayList<String>();

        public ArrayList<String> getDelimitersList(String[] tokens)
        {
            for (String element: tokens)
            {
                if (element.equals(openDel) || element.equals(closeDel))
                    delimiters.add(element);
            }
            return delimiters;
        }

        public boolean isBalanced(ArrayList<String> list)
        {
            int open = 0;
            int close = 0;

            if (list.size() % 2 != 0)
                return false;

            for (String element: list)
            {
                if (element.equals(openDel))
                    if (++open >= close) continue;
                    else return false;

                if (element.equals(closeDel))
                    if (open < ++close) return false;
            }

            return (open == close);
        }
    }

    class LightBoard
    {
        private Random random = new Random();
        private boolean[][] lights;

        public LightBoard(int numRows, int numCols)
        {
            lights = new boolean[numRows][numCols];

            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < numCols; j++)
                {
                    lights[i][j] = (random.nextInt(10) <= 3);
                }
            }
        }

        public boolean evaluateLight(int row, int col)
        {
            return lights[row][col];
        }
    }
}
