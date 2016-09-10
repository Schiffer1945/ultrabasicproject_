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
        if (isValid()) {
            String nama = etNama.getText().toString();
            int nope = Integer.parseInt(etNo.getText().toString());
            tvHasil.setText("\n---------------------------\nNama : " + nama + "\nNomor HP : " + nope);
        }

        String hasil = null;

        if (rgJurusan.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgJurusan.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        /*if (rbRPL.isChecked()) {
            radiohasil = rbRPL.getText().toString();
        } else if (rbTKJ.isChecked()) {
            radiohasil = rbTKJ.getText().toString();
        }*/
        if (hasil == null) {
            tvHasil2.setText("Belum memilih jurusan");
        } else {
            tvHasil2.setText("\nKelas : " + spKelas.getSelectedItem().toString() + "\nJurusan :" + hasil);
        }

        String cbHasil = "Suborganisasi:\n";
        int startlen = cbHasil.length();
        if (cbPaski.isChecked()) cbHasil += cbPaski.getText() + "\n";
        if (cbMetic.isChecked()) cbHasil += cbMetic.getText() + "\n";
        if (cbBDI.isChecked()) cbHasil += cbBDI.getText() + "\n";
        if (cbPA.isChecked()) cbHasil += cbPA.getText() + "\n";
        if (cbPMR.isChecked()) cbHasil += cbPMR.getText() + "\n";
        if (cbMedsan.isChecked()) cbHasil += cbMedsan.getText() + "\n";
        if (cbMAC.isChecked()) cbHasil += cbMAC.getText() + "\n";
        if (cbFC.isChecked()) cbHasil += cbFC.getText() + "\n";
        if (cbBasket.isChecked()) cbHasil += cbBasket.getText() + "\n";
        if (cbVolly.isChecked()) cbHasil += cbVolly.getText() + "\n";

        if (cbHasil.length() == startlen) cbHasil += "Tidak ada pada pilihan";

        tvHasil3.setText(cbHasil);
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String nope = etNo.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 4) {
            etNama.setError("Tolong isi nama anda dengan benar");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (nope.isEmpty()) {
            etNo.setError("Nomor handphone belum diisi");
            valid = false;
        } else {
            etNo.setError(null);
        }
        return valid;
    }
}

