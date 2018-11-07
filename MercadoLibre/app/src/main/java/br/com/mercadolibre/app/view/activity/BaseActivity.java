package br.com.mercadolibre.app.view.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EBean;

import br.com.mercadolibre.app.R;

@EBean
public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }
    }

    public void showLoading(@NonNull String men) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, "", men);
        }
    }

    public void hiddenLoading() {
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void showDialogMessage(String men) {
        showDialogMessage(men, null);
    }

    public void showDialogMessage(String men, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("")
                .setMessage(men)
                .setPositiveButton(android.R.string.ok, onClickListener)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}