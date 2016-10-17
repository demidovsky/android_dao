package pro.dimmy.daotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity
{
    public static final String NAME_EXTRA = "NAME_EXTRA";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    public void okClicked(View view)
    {
        EditText editText = (EditText) findViewById(R.id.edit_text);

        // Формируем Intent, который будет возвращен в вызвавшую нас Activity
        Intent intent = new Intent();
        // Добавляем в Intent нужные параметры
        intent.putExtra(AddActivity.NAME_EXTRA, editText.getText().toString());

        // Устанавливаем результат
        setResult(RESULT_OK, intent);

        finish();
    }
}
