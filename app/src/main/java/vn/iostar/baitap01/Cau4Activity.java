package vn.iostar.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau4Activity extends AppCompatActivity {
    private EditText editTextArray;
    private Button buttonProcess;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        editTextArray = findViewById(R.id.editTextArray);
        buttonProcess = findViewById(R.id.buttonProcess);
        textViewResult = findViewById(R.id.textViewResult);

        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextArray.getText().toString();
                if (!input.isEmpty()) {
                    // Chuyển chuỗi nhập vào thành mảng số
                    String[] stringArray = input.split(",");
                    ArrayList<Integer> numberList = new ArrayList<>();
                    for (String str : stringArray) {
                        try {
                            numberList.add(Integer.parseInt(str.trim()));
                        } catch (NumberFormatException e) {
                            // Nếu không phải số thì bỏ qua
                        }
                    }

                    // Tìm các số nguyên tố trong mảng
                    ArrayList<Integer> primeNumbers = new ArrayList<>();
                    for (int number : numberList) {
                        if (isPrime(number)) {
                            primeNumbers.add(number);
                        }
                    }

                    // In ra kết quả trên log (console) bằng Log.d
                    String result = "Số nguyên tố: " + primeNumbers.toString();
                    textViewResult.setText(result);
                    Log.d("PrimeNumbers", result); // In ra console Logcat
                }
            }
        });
    }

    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
