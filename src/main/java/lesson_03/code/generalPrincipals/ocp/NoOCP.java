package lesson_03.code.generalPrincipals.ocp;

public class NoOCP {
    public boolean sumBadPractice() {
        int x = 10;
        int y = 30;

        if ((x + y) < 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sumBadPractice2(int x, int y) {
        if ((x + y) < 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sumOCP(int x, int y, int criteria) {
        if ((x + y) < criteria) {
            return true;
        } else {
            return false;
        }
    }
}
