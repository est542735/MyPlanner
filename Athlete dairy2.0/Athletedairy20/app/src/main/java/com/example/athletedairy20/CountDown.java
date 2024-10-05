package com.example.athletedairy20;
import android.os.CountDownTimer;

class MyCountDownTimer extends CountDownTimer{
    private final long totalMillis;
    private final long intervalMillis;
    private final OnCountDownListener listener;

    public MyCountDownTimer(long millisInFuture, long countDownInterval, OnCountDownListener listener) {
        super(millisInFuture, countDownInterval);
        this.totalMillis = millisInFuture;
        this.intervalMillis = countDownInterval;
        this.listener = listener;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (listener != null) {
            listener.onTick(millisUntilFinished);
        }
    }

    @Override
    public void onFinish() {
        if (listener != null) {
            listener.onFinish();
        }
    }

    public interface OnCountDownListener {
        void onTick(long millisUntilFinished);
        void onFinish();
    }
}

