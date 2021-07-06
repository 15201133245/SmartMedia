package com.gilbarco.pojo;

import java.io.Serializable;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2021-07-05 15:21
 */
public class SpeakInfo implements Serializable {
    private String TTSState;

    public SpeakInfo(String TTSState) {
        this.TTSState = TTSState;
    }

    public String getTTSState() {
        return TTSState;
    }

    public void setTTSState(String TTSState) {
        this.TTSState = TTSState;
    }

    @Override
    public String toString() {
        return "SpeakInfo{" +
                "TTSState='" + TTSState + '\'' +
                '}';
    }
}
