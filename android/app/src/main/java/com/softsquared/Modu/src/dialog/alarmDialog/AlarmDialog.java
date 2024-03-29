package com.softsquared.Modu.src.dialog.alarmDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.softsquared.Modu.R;

public class AlarmDialog extends Dialog {

    private AlarmListener mListener;
    private Context mContext;

    public AlarmDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_alarm);

        TextView TvDurationComplete;
        final NumberPicker PickerNumber;

        TvDurationComplete = findViewById(R.id.tv_dialog_alarm_complete);
        PickerNumber = findViewById(R.id.picker_alarm_number);

        //Number Picker Value 설정
        String[] arrayString = mContext.getResources().getStringArray(R.array.alarm_num);

        PickerNumber.setMinValue(0);
        PickerNumber.setMaxValue(mContext.getResources().getStringArray(R.array.alarm_num).length - 1);

        PickerNumber.setDisplayedValues(arrayString);

        TvDurationComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.tv_dialog_alarm_complete) {
                    mListener.onAlarmComplete(PickerNumber.getValue());
                }
            }
        });

    }

    public void setDialogListener(AlarmListener listener) {
        this.mListener = listener;
    }


}