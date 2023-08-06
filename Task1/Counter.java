
public class Counter {
    static int count = 0;
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;

    static void Add(int iType) {
        if (iType == 1) {
            count1 += 1;
        } else if (iType == 2) {
            count2 += 1;
        } else if (iType == 3) {
            count3 += 1;
        }
        count += 1;
    }

    static String sCount() {
        return "  Количество животных - " + count +
                ":  кол. собак - " + count1 +
                ", кол. кошек - " + count2 +
                ", кол. хомяков - " + count3;
    }
}
