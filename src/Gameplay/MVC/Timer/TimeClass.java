/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC.Timer;

/**
 *
 * @author TheANARXIST
 */
public class TimeClass {

    private int minute;
    private int second;
    private int millisecond;

    public TimeClass(int minute, int second, int millisecond) {
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public boolean isTimeUp() {
        return this.minute <= 0 && this.second == 0;
    }

    public void decreaseTime() {
        this.millisecond--;

        if (this.millisecond <= 0) {
            this.millisecond = 4;
            this.second--;
        }

        if (this.second <= 0) {
            if (this.minute != 0) {
                this.minute--;
                this.second = 59;
            }
        }
    }

    public void increaseTime() {
        this.millisecond++;

        if (this.millisecond == 4) {
            this.millisecond = 0;
            this.second++;
        }

        if (this.second == 60) {
            this.second = 0;
            this.minute++;
        }
    }
}
