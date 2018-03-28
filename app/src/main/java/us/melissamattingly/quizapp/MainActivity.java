package us.melissamattingly.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks the answer for the first question
     *
     * @return If the answer is correct (true), false otherwise
     */
    private Boolean validateQuestion1() {
        RadioButton honeyRadio = findViewById(R.id.honey_radio_button);
        return honeyRadio.isChecked();
    }

    /**
     * Checks the answer for the second question
     *
     * @return If the answer is correct (true), false otherwise
     */
    private Boolean validateQuestion2() {
        EditText yearEditText = findViewById(R.id.year_text);
        String year = yearEditText.getText().toString();
        return year.equals("1777");
    }

    /**
     * Checks the answer for the third question
     *
     * @return If the answer is correct (true), false otherwise
     */
    private Boolean validateQuestion3() {
        RadioButton jacobRadio = findViewById(R.id.jacob_radio_button);
        return jacobRadio.isChecked();
    }

    /**
     * Checks the answer for the fourth question
     *
     * @return If the answer is correct (true), false otherwise
     */
    private Boolean validateQuestion4() {
        CheckBox edysBox = findViewById(R.id.edys_checkbox);
        CheckBox dairyBox = findViewById(R.id.dairy_checkbox);
        CheckBox breyersBox = findViewById(R.id.breyers_checkbox);
        return edysBox.isChecked() && !dairyBox.isChecked() && breyersBox.isChecked();
    }

    /**
     * Checks the answer for the fifth question
     *
     * @return If the answer is correct (true), false otherwise
     */
    private Boolean validateQuestion5() {
        RadioButton vanillaRadio = findViewById(R.id.vanilla_button);
        return vanillaRadio.isChecked();
    }

    /**
     * Calculates the user's score and displays it in a Toast.
     */
    public void submitAnswers(View view) {
        int numCorrect = 0;

        if (validateQuestion1()) {
            numCorrect++;
        }

        if (validateQuestion2()) {
            numCorrect++;
        }

        if (validateQuestion3()) {
            numCorrect++;
        }

        if (validateQuestion4()) {
            numCorrect++;
        }

        if (validateQuestion5()) {
            numCorrect++;
        }

        if (numCorrect == 5) {
            Toast.makeText(this, getString(R.string.wow), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.almost_there), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, getString(R.string.quiz_results, numCorrect), Toast.LENGTH_SHORT).show();
    }
}
