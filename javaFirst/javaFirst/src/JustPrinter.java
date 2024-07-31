import java.util.Scanner;

public class JustPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 연도와 월을 입력받음
        System.out.print("연도를 입력하세요: ");
        int year = scanner.nextInt();
        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        // 달력 출력
        printCalendar(year, month);
        scanner.close();
    }

    public static void printCalendar(int year, int month) {
        // 각 월의 마지막 날짜
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 윤년인지 확인
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // 2월의 일수를 29로 변경
        }

        // 해당 연도와 월의 첫 번째 요일 계산
        int firstDayOfWeek = getFirstDayOfWeek(year, month);

        // 달력 헤더 출력
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // 첫 번째 주의 공백 출력
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        // 달력 날짜 출력
        int lastDay = daysInMonth[month - 1];
        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%4d", day);

            // 한 주가 끝나면 줄 바꿈
            if ((day + firstDayOfWeek) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // 윤년인지 확인하는 메서드
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // 해당 연도와 월의 첫 번째 요일 계산하는 메서드 (자체 구현)
    public static int getFirstDayOfWeek(int year, int month) {
        int[] monthTable = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        if (month < 3) {
            year -= 1;
        }
        return (year + year / 4 - year / 100 + year / 400 + monthTable[month - 1] + 1) % 7;
    }
}
