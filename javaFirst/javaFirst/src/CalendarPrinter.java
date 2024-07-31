import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrinter {
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
        // Calendar 객체 생성 및 설정
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Calendar 클래스에서 월은 0부터 시작함
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 첫 번째 요일 및 마지막 날짜 계산
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 달력 헤더 출력
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // 첫 번째 주의 공백 출력
        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        // 달력 날짜 출력
        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%4d", day);

            // 한 주가 끝나면 줄 바꿈
            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
