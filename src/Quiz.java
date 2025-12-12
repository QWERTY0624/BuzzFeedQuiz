
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Category answer = new Category("Answer.java",
                                "Efficient, you may not be the most complex file but without you everything would fall apart");
                Category category = new Category("Category.java",
                                "Your greatest strength is your personality, and you being unapologetically yourself inspires those around you");
                Category question = new Category("Question.java",
                                "A calm and intelligent mind, you question the world around you and seek out knowledge in everything");
                Category quiz = new Category("Quiz.java",
                                "You are a leader, the backbone of any group. When you speak, everyone listens.");

                // Create Questions
                Question q1 = new Question("What is your favorite color?");
                q1.possibleAnswers[0] = new Answer("Red", answer);
                q1.possibleAnswers[1] = new Answer("Yellow", category);
                q1.possibleAnswers[2] = new Answer("Blue", question);
                q1.possibleAnswers[3] = new Answer("Green", quiz);

                Question q2 = new Question("What do you do when starting to write an essay?");
                q2.possibleAnswers[0] = new Answer("Outline", answer);
                q2.possibleAnswers[1] = new Answer("Brainstorm", answer);
                q2.possibleAnswers[2] = new Answer("Skip the planning stage and go straight into writing", category);
                q2.possibleAnswers[3] = new Answer("Think deeply about the essay topic", question);

                Question q3 = new Question(
                                "If you could be anywhere(out of these options) right now, where would you be?");
                q3.possibleAnswers[0] = new Answer("library", answer);
                q3.possibleAnswers[1] = new Answer("Some place I’ve never been before", quiz);
                q3.possibleAnswers[2] = new Answer("Home", answer);
                q3.possibleAnswers[3] = new Answer("Right here!", category);

                Question q4 = new Question("If you could have a super power, what would it be?");
                q4.possibleAnswers[0] = new Answer("Flight", answer);
                q4.possibleAnswers[1] = new Answer("Mind reading", question);
                q4.possibleAnswers[2] = new Answer("Invincibility", answer);
                q4.possibleAnswers[3] = new Answer("Force fields", quiz);

                Question q5 = new Question("If you had infinite money, what would be the first thing you would buy?");
                q5.possibleAnswers[0] = new Answer("a lab for science experiments", answer);
                q5.possibleAnswers[1] = new Answer("A new house", answer);
                q5.possibleAnswers[2] = new Answer("a cool car", category);
                q5.possibleAnswers[3] = new Answer("a buisness", quiz);

                Question q6 = new Question("If faced with a lion, what do you do?");
                q6.possibleAnswers[0] = new Answer("Run away screaming", answer);
                q6.possibleAnswers[1] = new Answer("lure it away", question);
                q6.possibleAnswers[2] = new Answer("back away slowly", quiz);
                q6.possibleAnswers[3] = new Answer("try to tame it", category);

                Question q7 = new Question("What do you do in your free time?");
                q7.possibleAnswers[0] = new Answer("read a book", answer);
                q7.possibleAnswers[1] = new Answer("play a sport", answer);
                q7.possibleAnswers[2] = new Answer("practice a skill", quiz);
                q7.possibleAnswers[3] = new Answer("hang out with friends", category);

                Question q8 = new Question("When do you go to bed each night?");
                q8.possibleAnswers[0] = new Answer("once I finish the book Iam reading", answer);
                q8.possibleAnswers[1] = new Answer("once I finish all the work I am doing", quiz);
                q8.possibleAnswers[2] = new Answer("after all of my friends go to sleep", category);
                q8.possibleAnswers[3] = new Answer("8 hours before I wake up", answer);

                // For each question, ask, read input, store answer.1
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { answer, category, question, quiz };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("If you were a BuzzFeedQuiz.java file, you would be " + cList[index].label + ". ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which BuzzFeedQuiz file Are You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
