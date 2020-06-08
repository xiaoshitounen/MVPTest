package swu.xl.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PresenterActivity extends AppCompatActivity implements IView {

    private TextView textView;
    private Button button;
    private NumModel numModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_show);
        button = findViewById(R.id.btn_add);

        final NumPresenter numPresenter = new NumPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //交给Present去处理
                numPresenter.add();
            }
        });
    }

    //更新UI
    @Override
    public void updateUI(String text) {
        textView.setText(text);
    }
}