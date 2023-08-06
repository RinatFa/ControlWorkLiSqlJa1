
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Nursery {

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int iNumber(String str, int max) {
        boolean flag = false;
        String sName = "";
        int n = 0;
        Scanner iScanner = new Scanner(System.in);
        while (flag == false) {
            System.out.printf(str);
            sName = iScanner.nextLine();
            flag = isNumeric(sName);
            if (flag == true) {
                n = Integer.parseInt(sName);
                if ((n < 1) || (n > max))
                    flag = false;
            } else {
                if (sName.equals("")) {
                    n = -1;
                    flag = true;
                }
            }
        }
        if (n > 1000)
            iScanner.close();
        return n;
    }

    static String sString(String str) {
        int n = 1;
        boolean flag = false;
        String sName = "";
        Scanner sScanner = new Scanner(System.in, "Cp866");
        while (flag == false) {
            System.out.printf(str);
            sName = sScanner.nextLine();
            sName = sName.trim();
            if (sName.equals("")) {
                System.out.println("Строка должна быть непустой!");
                flag = false;
            } else {
                flag = true;
            }
        }
        if (n > 1000)
            sScanner.close();
        return sName;
    }

    static Dogs AddDog(String sN, String sDate, String sComm) {
        return new Dogs(sN, sDate, sComm);
    }

    static Cats AddCat(String sN, String sDate, String sComm) {
        return new Cats(sN, sDate, sComm);
    }

    static Hamsters AddHamster(String sN, String sDate, String sComm) {
        return new Hamsters(sN, sDate, sComm);
    }

    public static void main(String[] args) {
        String commNo = "нет";
        String commDogAll = "Фу! Место! Ко_мне! Рядом! Гуляй! Сидеть! Лежать! Стоять! Голос!";
        String commCatAll = "Дай_лапу! Сидеть! Ползи! Принеси! Ко_мне! Прыжок! Голос!";
        String commHamsterAll = "Стоять! Перевернуться! Прыгай! Фу! Найти!";
        Dogs dog1 = new Dogs("Бакс", "2021-07-17", commDogAll);
        Counter.Add(1);
        Dogs dog2 = new Dogs("Тайга", "2019-02-10", commDogAll);
        Counter.Add(1);
        Cats cat1 = new Cats("Барсик", "2021-08-03", commCatAll);
        Counter.Add(2);
        Cats cat2 = new Cats("Мурка", "2020-04-14",
                "Сидеть! Ползи! Ко_мне! Прыжок! Голос!");
        Counter.Add(2);
        Hamsters hamster1 = new Hamsters("Брюс", "2023-03-09", commHamsterAll);
        Counter.Add(3);
        Hamsters hamster2 = new Hamsters("Дымка", "2021-07-16",
                "Стоять! Прыгай!");
        Counter.Add(3);
        System.out.println();
        
        Dogs[] dogsarr = new Dogs[10];
        Cats[] catsarr = new Cats[10];
        Hamsters[] hamstersarr = new Hamsters[10];
        dogsarr[0] = dog1;
        dogsarr[1] = dog2;
        dogsarr[Counter.count1] = AddDog("Найда", "2022-01-19",
                "Ко_мне! Рядом! Сидеть! Стоять! Голос!");
        Counter.Add(1);
        catsarr[0] = cat1;
        catsarr[1] = cat2;
        hamstersarr[0] = hamster1;
        hamstersarr[1] = hamster2;
        System.out.println(Counter.sCount());

        System.out.println();
        String s1 = "  Выберите действие (1-4): \n";
        s1 += "1 - Завести новое животное     ";
        s1 += "3 - Добавить команду\n";
        s1 += "2 - Показать всех животных     ";
        s1 += "4 (= <Enter>) - Выход из программы\n";

        int n = 1;
        int n2 = 1;
        int n3 = 1;
        int n4 = 1;
        int n5 = 1;
        int numb2 = 4;
        int numb3 = 1;
        int numb4 = 3;
        String sStr = "";
        String sName = "";
        String sDate = "";
        while (n > 0) {
            System.out.printf(s1);
            System.out.println();
            n = iNumber("Что выполнить? : ", numb2);
            if (n == 1) {
                n2 = iNumber("Завести новое животное? : да = 1 / отменить = <Enter>: ", numb3);
                if ((n2 == -1)) {
                } else {
                    n3 = iNumber("Выбор: Собака = 1, Кошка = 2, Хомяк = 3: ", numb4);
                    if (n3 == 1 || n3 == -1) {
                        System.out.println("Выбор: Собака");
                        n3 = 1;
                    } else if (n3 == 2) {
                        System.out.println("Выбор: Кошка");
                    } else if (n3 == 3) {
                        System.out.println("Выбор: Хомяк");
                    }
                    sName = "Введите имя: ";
                    sName = sString(sName);
                    while (true) {
                        sDate = "Введите дату рождения: ";
                        sDate = sString(sDate);
                        try {
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            df.setLenient(false);
                            df.parse(sDate);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    " !!! Неверный формат данных (дата рождения yyyy-MM-dd)");
                        }
                    }
                    try {
                        Counter.Add(n3);
                        if (sName != null && sDate != null && commNo != null) {
                            System.out.println("Успешное добавление!");
                        }
                    } catch (Exception e) {
                        System.out.println("Исключение: " + e.getClass().getSimpleName());
                    }
                    if ((n3 == 1)) {
                        int curN = Counter.count1 - 1;
                        dogsarr[curN] = AddDog(sName, sDate, commNo);
                        sStr = " *** Добавлена собака: " + Integer.toString(curN + 1) + ".  имя: " +
                                dogsarr[curN].getAnimalName() + "  дата рождения: " +
                                dogsarr[curN].getBirthdate() + "   команды: " + commNo + " *** ";
                    } else if ((n3 == 2)) {
                        int curN = Counter.count2 - 1;
                        catsarr[curN] = AddCat(sName, sDate, commNo);
                        sStr = " *** Добавлена кошка: " + Integer.toString(curN + 1) + ".  имя: " +
                                catsarr[curN].getAnimalName() + "  дата рождения: " +
                                catsarr[curN].getBirthdate() + "   команды: " + commNo + " *** ";
                    } else if ((n3 == 3)) {
                        int curN = Counter.count3 - 1;
                        hamstersarr[curN] = AddHamster(sName, sDate, commNo);
                        sStr = " *** Добавлен хомяк: " + Integer.toString(curN + 1) + ".  имя: " +
                                hamstersarr[curN].getAnimalName() + "  дата рождения: " +
                                hamstersarr[curN].getBirthdate() + "   команды: " + commNo + " *** ";
                    }
                    System.out.println();
                    System.out.println(sStr);
                    sStr = "";
                    System.out.println(Counter.sCount());
                }
            } else if ((n == 2)) {
                int iCountSp = 0;
                for (int i = 0; i < dogsarr.length; i++) {
                    if (dogsarr[i] != null) {
                        iCountSp += 1;
                        sStr = Integer.toString(iCountSp) + ". собака: " + dogsarr[i].toString();
                        System.out.println(sStr);
                    }
                }
                for (int i = 0; i < catsarr.length; i++) {
                    if (catsarr[i] != null) {
                        iCountSp += 1;
                        sStr = Integer.toString(iCountSp) + ". кошка: " + catsarr[i].toString();
                        System.out.println(sStr);
                    }
                }
                for (int i = 0; i < hamstersarr.length; i++) {
                    if (hamstersarr[i] != null) {
                        iCountSp += 1;
                        sStr = Integer.toString(iCountSp) + ". хомяк: " + hamstersarr[i].toString();
                        System.out.println(sStr);
                    }
                }
                System.out.println(Counter.sCount());
            } else if ((n == 3)) {
                n4 = iNumber("Выбрать животное: да = 1 / отменить = <Enter>: ", numb3);
                if ((n4 == -1)) {
                } else {
                    while (true) {
                        int[] iNumbArr = new int[Counter.count];
                        int iCountSp = 0;
                        for (int i = 0; i < dogsarr.length; i++) {
                            if (dogsarr[i] != null) {
                                iCountSp += 1;
                                iNumbArr[iCountSp - 1] = 101 + i;
                                sStr = Integer.toString(iCountSp) + ". собака: " + dogsarr[i].toString();
                                System.out.println(sStr);
                            }
                        }
                        for (int i = 0; i < catsarr.length; i++) {
                            if (catsarr[i] != null) {
                                iCountSp += 1;
                                iNumbArr[iCountSp - 1] = 201 + i;
                                sStr = Integer.toString(iCountSp) + ". кошка: " + catsarr[i].toString();
                                System.out.println(sStr);
                            }
                        }
                        for (int i = 0; i < hamstersarr.length; i++) {
                            if (hamstersarr[i] != null) {
                                iCountSp += 1;
                                iNumbArr[iCountSp - 1] = 301 + i;
                                sStr = Integer.toString(iCountSp) + ". хомяк: " + hamstersarr[i].toString();
                                System.out.println(sStr);
                            }
                        }

                        int imax = Counter.count + 1;
                        n5 = iNumber("Выбор животного: 1-" + Integer.toString(imax - 1) +
                                " (" + imax + ", <Enter> - выход): ", imax);
                        if (n5 == imax || n5 == -1) {
                            break;
                        }
                        int icur = iNumbArr[n5 - 1] / 100;
                        int icur2 = iNumbArr[n5 - 1] % 100 - 1;
                        if (icur == 1) {
                            System.out.println("собака: " +
                                    dogsarr[icur2].toString());
                        } else if (icur == 2) {
                            System.out.println("кошка: " +
                                    catsarr[icur2].toString());
                        } else if (icur == 3) {
                            System.out.println("хомяк: " +
                                    hamstersarr[icur2].toString());
                        }

                        if (icur == 1) {
                            String[] saComDog = new String[0];
                            saComDog = commDogAll.split(" ");
                            String sComDogCur = dogsarr[icur2].getExecutedCommands();
                            String sStr3 = "";
                            for (int i = 0; i < saComDog.length; i++) {
                                int index1 = sComDogCur.indexOf(saComDog[i]);
                                if (index1 == -1) {
                                    sStr3 += Integer.toString(i + 1) + " - " + saComDog[i] + "  ";
                                }
                            }
                            System.out.println();
                            if (sStr3 != "") {
                                System.out.println("Можно обучить командам: " + sStr3);
                                imax = 9;
                                n5 = iNumber("Выбор команды: 1-" + imax + " : ", imax);
                                if (n5 == -1) {
                                    n5 = 1;
                                }
                                sComDogCur = dogsarr[icur2].getExecutedCommands();
                                int index1 = sComDogCur.indexOf(saComDog[n5 - 1]);
                                if (index1 == -1) {
                                    if (sComDogCur == "нет") {
                                        sComDogCur = saComDog[n5 - 1];
                                    } else {
                                        sComDogCur += " " + saComDog[n5 - 1];
                                    }
                                    dogsarr[icur2].setExecutedCommands(sComDogCur);
                                } else {
                                    System.out.println();
                                    System.out.println(" *** Этой команде собака уже обучена! *** ");
                                    System.out.println();
                                }
                            } else {
                                System.out.println(" *** Собака обучена всем 9 базовым командам! ***");
                                System.out.println();
                            }
                        } else if (icur == 2) {
                            String[] saComCat = new String[0];
                            saComCat = commCatAll.split(" ");
                            String sComCatCur = catsarr[icur2].getExecutedCommands();
                            String sStr3 = "";
                            for (int i = 0; i < saComCat.length; i++) {
                                int index1 = sComCatCur.indexOf(saComCat[i]);
                                if (index1 == -1) {
                                    sStr3 += Integer.toString(i + 1) + " - " + saComCat[i] + "  ";
                                }
                            }
                            System.out.println();
                            if (sStr3 != "") {
                                System.out.println("Можно обучить командам: " + sStr3);
                                imax = 7;
                                n5 = iNumber("Выбор команды: 1-" + imax + " : ", imax);
                                if (n5 == -1) {
                                    n5 = 1;
                                }
                                sComCatCur = catsarr[icur2].getExecutedCommands();
                                int index1 = sComCatCur.indexOf(saComCat[n5 - 1]);
                                if (index1 == -1) {
                                    if (sComCatCur == "нет") {
                                        sComCatCur = saComCat[n5 - 1];
                                    } else {
                                        sComCatCur += " " + saComCat[n5 - 1];
                                    }
                                    catsarr[icur2].setExecutedCommands(sComCatCur);
                                } else {
                                    System.out.println();
                                    System.out.println(" *** Этой команде кошка уже обучена! *** ");
                                    System.out.println();
                                }
                            } else {
                                System.out.println(" *** Кошка обучена всем 7 базовым командам! ***");
                                System.out.println();
                            }
                        } else if (icur == 3) {
                            String[] saComHamster = new String[0];
                            saComHamster = commHamsterAll.split(" ");
                            String sComHamsterCur = hamstersarr[icur2].getExecutedCommands();
                            String sStr3 = "";
                            for (int i = 0; i < saComHamster.length; i++) {
                                int index1 = sComHamsterCur.indexOf(saComHamster[i]);
                                if (index1 == -1) {
                                    sStr3 += Integer.toString(i + 1) + " - " + saComHamster[i] + "  ";
                                }
                            }
                            System.out.println();
                            if (sStr3 != "") {
                                System.out.println("Можно обучить командам: " + sStr3);
                                imax = 5;
                                n5 = iNumber("Выбор команды: 1-" + imax + " : ", imax);
                                if (n5 == -1) {
                                    n5 = 1;
                                }
                                sComHamsterCur = hamstersarr[icur2].getExecutedCommands();
                                int index1 = sComHamsterCur.indexOf(saComHamster[n5 - 1]);
                                if (index1 == -1) {
                                    if (sComHamsterCur == "нет") {
                                        sComHamsterCur = saComHamster[n5 - 1];
                                    } else {
                                        sComHamsterCur += " " + saComHamster[n5 - 1];
                                    }
                                    hamstersarr[icur2].setExecutedCommands(sComHamsterCur);
                                } else {
                                    System.out.println();
                                    System.out.println(" *** Этой команде хомяк уже обучен! *** ");
                                    System.out.println();
                                }
                            } else {
                                System.out.println(" *** Хомяк обучен всем 5 базовым командам! ***");
                                System.out.println();
                            }
                        }
                    }
                }
            } else if ((n == 4) || (n == -1)) {
                System.out.println("Выход из прогрвммы.");
                System.out.println();
                break;
            }
            System.out.println();
        }
    }
}
