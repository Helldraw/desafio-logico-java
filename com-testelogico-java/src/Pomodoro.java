import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {
    static int h=0, m=0, s=0, delay=1000, interval=1000, horasTrabalho, minutosTrabalho, segundosTrabalho, horasDescanso, minutosDescanso,segundosDescanso;
    
    public static void main(String[] args) {
        Relogio();
        tempoTrabalhoDescanso();
    }
    public static void Relogio() {
        System.out.println("---------------FOCO------------------");
        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                formataTime();
                if (s == segundosTrabalho && m == minutosTrabalho && h == horasTrabalho) {
                    timer1.cancel();
                    resetTime();
                    RelogioDescanso();
                }

            }
        }, delay, interval);
    }
    public static void RelogioDescanso() {
        System.out.println("--------------Descanso----------------");

        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                formataTime();
                if (s == segundosDescanso && m == minutosDescanso && h == horasDescanso) {
                    timer2.cancel();
                    resetTime();
                    Relogio();
                }
            }
        }, delay, interval);
    }

    public static void tempoTrabalhoDescanso(){
    horasTrabalho = 0;
    minutosTrabalho = 0;
    segundosTrabalho = 20;
    horasDescanso = 0;
    minutosDescanso = 0;
    segundosDescanso = 10;
    }
    public static void resetTime() {
        h = 0;
        m = 0;
        s = 0;
    }
    public static void formataTime(){
                        s++;
                if (s == 60) {
                    s = 0;
                    m++;
                    if (m == 60) {
                        m = 0;
                        h++;
                    }
                }
                System.out.println(h + ":" + m + ":" + s);
    }
}
