package sistemas.unc.edu.pe.appcilindro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtRadio, txtAltura;
    TextView lbVolumen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtRadio=findViewById(R.id.txtRadio);
        txtAltura=findViewById(R.id.txtAltura);
        lbVolumen=findViewById(R.id.lbVolumen);
    }
    public void Calcularvolumen(View boton) {
        if (validar())
            return;
            double radio = Double.valueOf(txtRadio.getText().toString());
            double altura = Double.valueOf(txtAltura.getText().toString());
            double volumen=Math.PI*Math.pow(radio,2)*altura;
            lbVolumen.setText(volumen+"");
    }

    private boolean validar() {
        if (txtRadio.getText().toString().trim().isEmpty()) {
            txtRadio.setError("Campo obligatorio");
            txtRadio.requestFocus();
            return true;
        }
        if (txtAltura.getText().toString().trim().isEmpty()) {
            txtAltura.setError("Campo obligatorio");
            txtAltura.requestFocus();
            return true;
        }
        return false;
    }
}