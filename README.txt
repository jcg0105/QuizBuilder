Title: GRE Practice
Authors: Julia Griner and Sarah Gillespie
Class: csc212 Fall 2020 Smith College


Questions? Reach out to:
https://github.com/SarahGillespie Smith College, Class of 2022J
https://github.com/jcg0105 Hampshire College, 18F


ABSTRACT
The goal of this program is to help the user study for the general GRE with preloaded CSV and vocabulary questions. This program is not a full computer-based general GRE: it is instead a tool to do quizzes with the user having the ability to customize their CSV of quiz questions. Therefore, this program can be used for any multiple choice practice, including CSC212 quiz questions.


When a user adds questions to a CSV, the user should open the CSV in a program such as Excel and follow the structure of the question in column 1, five answer choices in columns 2 to 5, and the corresponding letter of the correct answer in column 6. When a user adds questions into the CSV, the question cannot have any commas. See the KNOWN BUGS section for more details.


Future work on this project may include incorporating image-based questions and randomizing the question order for each quiz. Future work may also include adding a new Questions class to better incorporate the CSC212 quiz files, as the CSC212 quizzes currently only have four answer choices rather than five.


PROJECT FILES
GREpractice_JGSG.java
test_GRE_questions.csv (math questions)
test_GRE_questions_vocab.csv (vocabulary definitions)
numbersJavaQuiz.csv (CSC212 quizzes)
README.txt
This program does not produce any files on your computer.


The software you need on your computer:
This software was produced on Java SE Runtime Environment 8, but is compatible with Java SE Runtime Environment 7 as well. The user needs to be able to access their computer’s console in order to run the .java file


HOW TO RUN
Download a .zip folder of all the project files from https://github.com/jcg0105/QuizBuilder/ and extract the files.The question CSV file paths do not need to be edited as long as the CSVs are in the same folder as the GREpractice_JGSG.java file. In your java terminal, run the “GREpractice_JGSG.java” file. 


COPYING / LICENSE
All question sources are cited.


This software is provided under the MIT open source license.


Copyright (c) 2020 Sarah Gillespie and Julia Griner
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions.


THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


BUGS
When a user adds questions into the CSV, the question cannot have any commas because the “public ArrayList<Question> process_the_CSV()” function reads in the CSV and considers each comma to be a break to the next cell and answer choice. This means that a question with a comma would be read into the program with the first half as a question and the second half as the first answer option. The creators decided the ease of use of a common file time, the CSV, was worth the hassle of not including commas in questions and answers compared to using a less common file type,  such as a TSV, a tab-delimited file, where each question and answer option is separated by a tab. The creators may switch to a TSV file after this Fall 2020 semester concludes to allow greater question type and content flexibility.


This program does not display images. Therefore, the math questions are a biased representation of the math GRE questions since only text questions are able to be displayed rather than questions involving geometry figures or other visuals. The creators may incorporate visual questions after this Fall 2020 semester concludes.


REFERENCES
Sample math GRE questions were adapted from:
https://www.ets.org/gre/revised_general/prepare/quantitative_reasoning/multiple_choice_one/sample_questions


Barron's 6 GRE Practice Tests (2105 edition)


Sample CSC212 questions are sourced from Professor Mihaela Malita in the Smith College Fall 2020 CSC212 class.


Vocabulary GRE definitions are sourced from around the web and my own creation. Main definition sources are primarily Lexico.com (www.lexico.com/en) and online Merriam-Webster dictionary (www.merriam-webster.com/)