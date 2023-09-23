package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	int randomNumber;
	private EditText inputNumber;
	private Button guessButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		inputNumber = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random random = new Random();
		randomNumber = random.nextInt(100) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String inputText = inputNumber.getText().toString();

		if (TextUtils.isEmpty(inputText)){
			Toast.makeText(this, "Silahkan masukkan angka yang ingin anda tebak!", Toast.LENGTH_SHORT).show();
		}else{
			int getNumber = Integer.parseInt(inputText);

			if (getNumber == randomNumber){
				Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
			} else if (getNumber > randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
			}else if (getNumber < randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		inputNumber.setText("");
		guessButton.setEnabled(true);
	}
}
