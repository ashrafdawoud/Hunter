package com.indrul.hunter;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.NoticationAdapter;
import com.indrul.hunter.Adapter.TransactionAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.transRecy)
    RecyclerView transRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.blue));
        window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        ///////////////////////////////////////////////
        transRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        TransactionAdapter transactionAdapter = new TransactionAdapter();
        transRecy.setAdapter(transactionAdapter);
        transRecy.setHasFixedSize(true);

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}