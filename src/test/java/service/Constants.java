package service;

import cw_2.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Constants {

    public static final Question Q1 = new Question("Сколькол будет 2 + 2?", "Четыре");

    public static final String S1_1 = "Сколькол будет 2 + 2?";

    public static final String S1_2 = "Четыре";

    public static final Question Q2 = new Question("Какого цвета зебра?", "Черно-белая");
    public static final Question Q3 = new Question("Какой цвет огурца?", "Зеленый");
    public static final Question Q4 = new Question("Сколько лепестков в счастливом клевере?", "Четыре");
    public static final Question Q5 = new Question("Сколько лап у кошки?", "Четыре!");

    public static final Collection<Question> QUEST_LIST = new ArrayList<>(Arrays.asList(Q1,Q2));
    public static final Collection<Question> QUEST_LIST2 = new ArrayList<>(Arrays.asList(Q1,Q2,Q3,Q4,Q5));
}
