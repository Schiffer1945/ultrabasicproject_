package id.sch.smktelkom_mlg.tugas01.xirpl6012.pendataansuborganisasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNo;
    RadioGroup rgJurusan;
    RadioButton rbRPL, rbTKJ;
    CheckBox cbPaski, cbMetic, cbBDI, cbPA, cbPMR, cbMedsan, cbMAC, cbFC, cbBasket, cbVolly;
    Button bOK;
    TextView tvHasil, tvHasil2, tvHasil3;
    Spinner spKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNo = (EditText) findViewById(R.id.editTextNo);
        rgJurusan = (RadioGroup) findViewById(R.id.radioGroupJurusan);
        rbRPL = (RadioButton) findViewById(R.id.radioButtonRPL);
        rbTKJ = (RadioButton) findViewById(R.id.radioButtonTKJ);
        cbPaski = (CheckBox) findViewById(R.id.checkBoxPaski);
        cbMetic = (CheckBox) findViewById(R.id.checkBoxMetic);
        cbBDI = (CheckBox) findViewById(R.id.checkBoxBDI);
        cbPA = (CheckBox) findViewById(R.id.checkBoxPalwaga);
        cbPMR = (CheckBox) findViewById(R.id.checkBoxPMR);
        cbMedsan = (CheckBox) findViewById(R.id.checkBoxMedsan);
        cbMAC = (CheckBox) findViewById(R.id.checkBoxArt);
        cbFC = (CheckBox) findViewById(R.id.checkBoxFutsal);
        cbBasket = (CheckBox) findViewById(R.id.checkBoxBasket);
        cbVolly = (CheckBox) findViewById(R.id.checkBoxVolly);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        bOK = (Button) findViewById(R.id.buttonOK);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        String nama = etNama.getText().toString();
        int nope = Integer.parseInt(etNo.getText().toString());
        tvHasil.setText("\n---------------------------\nNama : " + nama + "\nNomor HP : " + nope);

        String radiohasil = null;

        if (rbRPL.isChecked()) {
            radiohasil = rbRPL.getText().toString();
        } else if (rbTKJ.isChecked()) {
            radiohasil = rbTKJ.getText().toString();
        } else if (radiohasil == null) {
            tvHasil2.setText("\nKelas : " + spKelas.getSelectedItem().toString() + "\nJurusan : Belum dipilih");
        } else {
            tvHasil2.setText("\nKelas : " + spKelas.getSelectedItem().toString() + "\nJurusan :" + radiohasil);
        }
    }
}
